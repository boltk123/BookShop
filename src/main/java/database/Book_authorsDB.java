package database;

import business.Authors;
import business.Book_authors;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Book_authorsDB {
    public static List<Book_authors> selectBookAuthorsByBookID(int book_id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT ba FROM Authors a, Books b, Book_authors ba"
                + " WHERE a.author_id = ba.author_id AND ba.book_id = b.book_id"
                + " AND b.book_id = :book_id";
        TypedQuery<Book_authors> q = em.createQuery(qString, Book_authors.class);
        q.setParameter("book_id", book_id);

        List<Book_authors> book_authors;
        book_authors = q.getResultList();
        return book_authors;
    }
}
