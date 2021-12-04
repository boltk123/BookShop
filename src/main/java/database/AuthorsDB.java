package database;

import business.Authors;
import business.Books;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class AuthorsDB {
    public static void insertAuthor(int author_id, String name, String description, byte[] bFile) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Authors author = new Authors(author_id, name, description);
        trans.begin();
        em.persist(author);
        trans.commit();
    }


    public static List<Authors> selectAllAuthors(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Authors b";
        trans.begin();
        TypedQuery<Authors> q = em.createQuery(qString, Authors.class);
        List<Authors> authors;
        try{
            authors = q.getResultList();
            if(authors == null || authors.isEmpty())
                authors = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return authors;
    }

}
