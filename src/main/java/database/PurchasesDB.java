package database;

import business.Books;
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
}
