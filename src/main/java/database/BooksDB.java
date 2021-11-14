package database;

import business.Books;
import utility.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class BooksDB {
    /*
    public void insertBookCover(Book_contents bc, File file) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        //File file = new File("");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();
        bc.setBook_cover(picInBytes);
        em.persist(bc);
        trans.commit();
    }
     */
    public static void insertBook(Books bc) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        em.persist(bc);
        trans.commit();
    }
    public static List<Books> selectBooks(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b from Books b";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);

        List<Books> books;
        try{
            books = q.getResultList();
            if (books == null || books.isEmpty())
                books = null;
        }
        finally {
            em.close();
        }
        return books;
    }
    public static List<Books> selectBooksByGenre(String genre) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b from Books b, Book_genres bg, Genres g"
                + " WHERE b.book_id = bg.book_id AND bg.genre_id = g.genre_id"
                + " AND g.genre = :genre";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("genre", genre);

        List<Books> books;
        books = q.getResultList();
        return books;
    }
}
