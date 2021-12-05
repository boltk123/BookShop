package database;

import business.Books;
import business.Products;
import business.Purchases;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.util.List;

public class PurchasesDB {
    public static void insertInvoice(int user_id, List<Products> productsList) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        for(Products product: productsList) {
            Purchases invoice = new Purchases(user_id, product.getProduct_id());
            em.persist(invoice);
        }
        trans.commit();
    }
}
