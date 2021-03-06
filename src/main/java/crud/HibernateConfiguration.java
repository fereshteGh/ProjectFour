package crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory = null;
    private static HibernateConfiguration instance = null;

    public static HibernateConfiguration getInstance() {
        if (instance == null) {
            instance = new HibernateConfiguration();
        }
        return instance;
    }

    private HibernateConfiguration() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}



