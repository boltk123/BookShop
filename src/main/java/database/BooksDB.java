package database;

import business.Books;
import utility.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.Date;
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
    public static void insertBook(int book_id, String title, int total_pages, double rating, double cost,
                                  Date published_date, int published_id, String description, byte[] bFile) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Books book = new Books(book_id, title, total_pages, rating, cost, published_date, published_id, description, bFile);
        trans.begin();
        em.persist(book);
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
    public static List<Books> selectBooksByUserID(int user_id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b from Books b, Products p, Accounts a"
                + " WHERE b.book_id = p.product_id AND p.user_id = a.user_id"
                + " AND a.user_id = :user_id";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("user_id", user_id);

        List<Books> books;
        books = q.getResultList();
        return books;
    }
}
