package database;

import business.Books;
import business.Samples;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class SamplesDB {
    public static void insertSample(int book_id,  byte[] bFile) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Samples sample = new Samples(book_id, bFile);
        trans.begin();
        em.persist(sample);
        trans.commit();
    }
    public static List<Samples> selectAllSamples(int book_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT s FROM Books s WHERE s.book_id = :book_id";
        trans.begin();

        TypedQuery<Samples> q = em.createQuery(qString, Samples.class);
        q.setParameter("book_id", book_id);
        List<Samples> samples;
        try{
            samples = q.getResultList();
            if(samples == null || samples.isEmpty())
                samples = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return samples;
    }
}
