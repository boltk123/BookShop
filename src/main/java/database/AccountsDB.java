package database;


import business.Accounts;
import business.Books;
import utility.DBUtil;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.util.List;

public class AccountsDB {
    public static void insert(Accounts account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void update(Accounts account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static void delete(Accounts account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(account));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static Accounts selectAccountByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Accounts a " +
                "WHERE a.email = :email";
        TypedQuery<Accounts> q = em.createQuery(qString, Accounts.class);
        q.setParameter("email", email);
        try {
            Accounts account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Accounts selectAccountByUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Accounts a " +
                "WHERE a.username = :username";
        TypedQuery<Accounts> q = em.createQuery(qString, Accounts.class);
        q.setParameter("username", username);
        try {
            Accounts account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public static Accounts selectAccount(String username,String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Accounts a " +
                "WHERE a.username = :username AND a.password = :password";
        TypedQuery<Accounts> q = em.createQuery(qString, Accounts.class);
        q.setParameter("username", username);
        q.setParameter("password", password);
        try {
            Accounts account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean usernameExists(String username) {
        Accounts a = selectAccountByUsername(username);
        return a != null;
    }
    public static boolean emailExists(String email) {
        Accounts a = selectAccountByEmail(email);
        return a != null;
    }
    public static boolean accountExists(String username,String password) {
        Accounts a = selectAccount(username,password);
        return a != null;
    }

    public static int countAccount(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        String qString = "SELECT b FROM Accounts b";
        trans.begin();
        TypedQuery<Accounts> q = em.createQuery(qString, Accounts.class);
        List<Accounts> accounts;
        try{
            accounts = q.getResultList();
            if(accounts == null)
                accounts = null;
        }
        finally {
            em.close();
        }
        trans.commit();
        int count = accounts.size();
        return count;
    }
    public static List<Accounts> selectAllAccount() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Accounts a";
        TypedQuery<Accounts> q = em.createQuery(qString, Accounts.class);
        try {
            List<Accounts> accountsList = q.getResultList();
            return accountsList;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
