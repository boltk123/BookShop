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
    public static void insertProduct(int user_id, int product_id) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Products products = new Products(user_id, product_id, 1);
        trans.begin();
        em.persist(products);
        trans.commit();
    }
    public static void removeProduct(int user_id, int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Accounts a, Products p"
                + " WHERE p.user_id = a.user_id"
                + " AND p.user_id = :user_id AND p.product_id = :product_id";
        trans.begin();
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("user_id", user_id);
        q.setParameter("product_id", product_id);
        Products product = q.getSingleResult();
        em.remove(em.merge(product));
        trans.commit();
    }
    public static int getProductQuantity(int user_id, int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p FROM Accounts a, Products p"
                + " WHERE p.user_id = a.user_id"
                + " AND p.user_id = :user_id AND p.product_id = :product_id";
        TypedQuery<Products> q = em.createQuery(qString, Products.class);
        q.setParameter("user_id", user_id);
        q.setParameter("product_id", product_id);
        Products product = q.getSingleResult();
        int quantity = product.getQuantity();
        return quantity;
    }
    public static void getProductName(int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p.quantity FROM Accounts a, Products p"
                + " WHERE p.user_id = a.user_id"
                + " AND p.user_id = :user_id AND p.product_id = :product_id";
    }
}
