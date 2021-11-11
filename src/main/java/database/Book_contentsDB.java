package database;

import business.Book_contents;
import sun.misc.IOUtils;
import sun.nio.ch.IOUtil;
import utility.DBUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.io.InputStream;

public class Book_contentsDB {
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
    public void insertBookCover(Book_contents bc, InputStream inputStream) throws IOException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        //File file = new File("");
        byte[] bytes = IOUtils.readAllBytes(inputStream);
        bc.setBook_cover(bytes);
        em.persist(bc);
        trans.commit();
    }
}
