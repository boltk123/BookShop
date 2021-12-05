package database;

import business.Authors;
import business.Products;
import business.Purchases;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
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

    public static int countPurchases(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Purchases b";
        trans.begin();
        TypedQuery<Purchases> q = em.createQuery(qString, Purchases.class);
        List<Purchases> purchases;
        try{
            purchases = q.getResultList();
            if(purchases == null)
                purchases = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        int count = purchases.size();
        return count;
    }
}
