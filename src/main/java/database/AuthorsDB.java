package database;

import business.Authors;
import business.Books;
import utility.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorsDB {
    public static List<Authors> selectAuthorsByBookID(int book_id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Authors a, Books b"
                + " WHERE a.name = b.authors"
                + " AND b.book_id = :book_id";
        TypedQuery<Authors> q = em.createQuery(qString, Authors.class);
        q.setParameter("book_id", book_id);

        List<Authors> authors;
        authors = q.getResultList();
        return authors;
    }
    public static String selectAuthorName(int author) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a.name FROM Authors a, Books b"
                + " WHERE b.authors = a.author_id"
                + " AND b.authors = :author";
        TypedQuery<Authors> q = em.createQuery(qString, Authors.class);
        q.setParameter("author", author);
        String author_name = q.getSingleResult().getName();
        return author_name;
    }
}
