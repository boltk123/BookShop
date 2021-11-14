package database;

import business.Books;
import business.Products;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;

public class ProductsDB {
    public static void insertProduct(int user_id, int product_id) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Products products = new Products(user_id, product_id, 1);
        trans.begin();
        em.persist(products);
        trans.commit();
    }
}
