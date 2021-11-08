package exercise.nhanebook;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil_JPA {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("emailListPU");

    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}