package database;

import business.Accounts;
import business.Authors;
import business.Book_contents;
import business.Books;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class Book_contentsDB {
    public static void InsertPDF(Book_contents book_content) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(book_content);
        trans.commit();
    }
    public static Book_contents SelectBookPDF(int book_id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT bc FROM Book_contents bc WHERE bc.book_id = :book_id";

        TypedQuery<Book_contents> q = em.createQuery(qString, Book_contents.class);
        q.setParameter("book_id", book_id);
        try {
            Book_contents book_content = q.getSingleResult();
            return book_content;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static void UpdateBookPDF(Book_contents book_content){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(book_content);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
