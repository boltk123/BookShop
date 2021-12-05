package database;

import business.Products;
import business.Purchases;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;

public class PurchasesDB {
    public static void insertInvoice(int user_id, int product_id) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Purchases invoice = new Purchases(user_id, product_id);
        trans.begin();
        em.persist(invoice);
        trans.commit();
    }
}
