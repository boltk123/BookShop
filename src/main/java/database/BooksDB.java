package database;

import business.Books;
import business.Products;
import utility.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class BooksDB {
    public static void insertBook(int book_id, String title, int total_pages, double rating, double cost,
                                  String author, String genre, String description, byte[] bFile, byte[] book_pdf) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        Books book = new Books();
        if(BookExists(book_id)){
            book = selectBooksByBookID(book_id);
            if(!title.isEmpty()){
                book.setTitle(title);
            }
            if(total_pages != 0){
                book.setTotal_pages(total_pages);
            }
            if(rating != 0){
                book.setRating(rating);
            }
            if(cost != 0){
                book.setCost(cost);
            }
            if(!author.isEmpty()){
                book.setAuthor(author);
            }
            if(!genre.isEmpty()){
                book.setGenre(genre);
            }
            if(!description.isEmpty()){
                book.setDescription(description);
            }
            if(bFile != null){
                book.setBook_cover(bFile);
            }
        }
        else {
            book = new Books(book_id, title, total_pages, rating, cost, author, genre, description, bFile, book_pdf);
        }

        trans.begin();
        em.persist(book);
        trans.commit();
    }
    public static boolean BookExists(int book_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b"
                + " WHERE b.book_id = :book_id";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("book_id", book_id);
        List<Books> books = q.getResultList();
        if(books.size() > 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void UpdateBook(Books book){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(book);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static List<Books> selectBooksByGenre(String genre_name){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        String qString = "SELECT b FROM Books b WHERE b.genre = :genre_name";
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("genre_name", genre_name);
        List<Books> books;
        try{
            books = q.getResultList();
            if(books == null || books.isEmpty())
                books = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return books;
    }
    public static List<Books> selectAllBooks(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b";
        trans.begin();
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        List<Books> books;
        try{
            books = q.getResultList();
            if(books == null || books.isEmpty())
                books = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return books;
    }

    public static List<Books> selectBooksByUserID(int user_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b, Products p WHERE b.book_id = p.product_id AND p.user_id = :user_id";
        trans.begin();
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("user_id", user_id);
        List<Books> books;
        try{
            books = q.getResultList();
            if(books == null || books.isEmpty())
                books = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return books;
    }
    public static Books selectBooksByBookID(int book_id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b WHERE b.book_id = :book_id";
        trans.begin();
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        q.setParameter("book_id", book_id);
        Books book = null;
        try{
            book = q.getSingleResult();
            if(book == null)
                book = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return book;
    }
    public static List<Books> SearchBooks(String qString){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        List<Books> book = null;
        try{
            book = q.getResultList();
            if(book == null)
                book = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        return book;

    }

    public static int countBooks(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Books b";
        trans.begin();
        TypedQuery<Books> q = em.createQuery(qString, Books.class);
        List<Books> books;
        try{
            books = q.getResultList();
            if(books == null)
                books = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        int count = books.size();
        return count;
    }
}
