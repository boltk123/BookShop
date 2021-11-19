package database;

import business.Books;
import business.Products;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class ProductsDB {
    private static final double tax = 3;
    private static final double shipping = 10;

    public static void insertProduct(int user_id, int product_id) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Products products = new Products(user_id, product_id, 1, shipping, tax);
        trans.begin();
        em.persist(products);
        trans.commit();
    }
    public static void removeProduct(int user_id, int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Products as p"
                + " WHERE p.user_id = :user_id AND p.product_id = :product_id";
        trans.begin();
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("user_id", user_id);
        q.setParameter("product_id", product_id);
        Products products = q.getSingleResult();
        em.remove(products);
        trans.commit();
    }

    public static List<Products> getProductList(int user_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Products p"
                + " WHERE p.user_id = :user_id";
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("user_id", user_id);
        List<Products> products = q.getResultList();
        return products;
    }

    public static String getProductName(int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b"
                + " WHERE b.book_id = :product_id";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("product_id", product_id);
        Books book = q.getSingleResult();
        return book.getTitle();
    }
    public static double getProductSubtotal(int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b"
                + " WHERE b.book_id = :product_id";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("product_id", product_id);
        Books book = q.getSingleResult();
        return book.getCost();
    }
    public static boolean productExists(int product_id, int user_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Products p"
                + " WHERE p.product_id = :product_id AND p.user_id = :user_id";
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("product_id", product_id);
        q.setParameter("user_id", user_id);
        List<Products> products = q.getResultList();
        if(products.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void setQuantity(int quantity, int user_id, int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Products p"
                + " WHERE p.user_id = :user_id AND p.product_id = :product_id";
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("user_id", user_id);
        q.setParameter("product_id", product_id);
        Products product = q.getSingleResult();
        product.setQuantity(product_id);
        trans.begin();
        em.persist(product);
        trans.commit();
    }
}
