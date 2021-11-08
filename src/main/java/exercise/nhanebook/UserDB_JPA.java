package exercise.nhanebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class UserDB_JPA {
    public static void insert(User_JPA user) {
        EntityManager em = DBUtil_JPA.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User_JPA user) {
        EntityManager em = DBUtil_JPA.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User_JPA user) {
        EntityManager em = DBUtil_JPA.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User_JPA selectUser(String email) {
        EntityManager em = DBUtil_JPA.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User_JPA u " +
                "WHERE u.email = :email";
        TypedQuery<User_JPA> q = em.createQuery(qString, User_JPA.class);
        q.setParameter("email", email);
        try {
            User_JPA user= q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        User_JPA u = selectUser(email);
        return u != null;
    }
}
