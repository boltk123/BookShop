package database;

import business.Accounts;
import business.Books;
import business.Products;
import business.Purchases;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class PurchasesDB {
    public static void insertInvoice(int user_id, List<Products> productsList) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        for(Products product: productsList) {
            Purchases invoice = new Purchases(user_id, product.getProduct_id(), product.getQuantity(), (float) product.getTotal());
            em.persist(invoice);
        }
        trans.commit();
    }
    public static boolean purchased(int user_id, int product_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        String qString = "SELECT pu FROM Purchases pu"
                + " WHERE pu.product_id = :product_id AND pu.user_id = :user_id";
        TypedQuery<Purchases> q = em.createQuery(qString, Purchases.class);
        q.setParameter("product_id", product_id);
        q.setParameter("user_id", user_id);
        trans.commit();
        List<Purchases> purchasesList = q.getResultList();
        if(purchasesList.size() > 0){
            return true;
        }
        else{
            return false;
        }

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
    public static List<Purchases> selectAllInvoices(int user_id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p from Purchases p " +
                "WHERE p.user_id = :user_id";
        trans.begin();
        TypedQuery<Purchases> q = em.createQuery(qString, Purchases.class);
        q.setParameter("user_id", user_id);
        List<Purchases> results = null;
        try {
            results = q.getResultList();
            if(results == null)
                results = null;
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        trans.commit();
        return results;
    }
    public static List<Purchases> updateDeliveredStatus(int user_id, int product_id, boolean delivered) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT p from Purchases p " +
                "WHERE p.user_id = :user_id AND p.product_id = :product_id ";
        trans.begin();
        TypedQuery<Purchases> q = em.createQuery(qString, Purchases.class);
        q.setParameter("user_id", user_id);
        q.setParameter("product_id", product_id);
        List<Purchases> results = null;
        try {
            results = q.getResultList();
            for(Purchases item: results){
                item.setDelivered(delivered);
                em.merge(item);
            }
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        trans.commit();
        return results;
    }
}
