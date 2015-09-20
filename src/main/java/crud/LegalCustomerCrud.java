package crud;

import entity.LegalCustomer;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LegalCustomerCrud {
    static Logger logger = Logger.getLogger(LegalCustomer.class);

    public static boolean checkEconomyExistence(String economyCode) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            String queryString;
            queryString = "SELECT legalCustomer FROM LegalCustomer legalCustomer  WHERE legalCustomer.economyCode = :economyCode";
            Query query = session.createQuery(queryString);
            query.setParameter("economyCode", economyCode);
            if (!query.list().isEmpty()) {
                return true;
            }
        } finally {
            session.close();
        }
        return false;
    }

    public static LegalCustomer addCustomer(LegalCustomer legalCustomer) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(legalCustomer);
            logger.info("Database : legal customer added to database successfully!");
            session.getTransaction().commit();
            return legalCustomer;
        } finally {
            session.close();
        }
    }

    public static LegalCustomer updateCustomer(LegalCustomer legalCustomer) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            LegalCustomer legalCustomerEntities = (LegalCustomer) session.get(legalCustomer.getClass(), legalCustomer.getCustomerNumber());
            legalCustomerEntities.setCompanyName(legalCustomer.getCompanyName());
            legalCustomerEntities.setRegisterDate(legalCustomer.getRegisterDate());
            legalCustomerEntities.setEconomyId(legalCustomer.getEconomyId());
            legalCustomerEntities.setCustomerNumber(legalCustomer.getCustomerNumber());
            session.update(legalCustomerEntities);
            logger.info("Database : legal customer updated successfully!");
            session.getTransaction().commit();
            return legalCustomerEntities;
        } finally {
            session.close();
        }
    }

    public static void deleteCustomer(String customerNumber) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            LegalCustomer legalCustomerEntities = (LegalCustomer) session.get(LegalCustomer.class, customerNumber);
            session.delete(legalCustomerEntities);
            logger.info("Database : legal customer deleted successfully!");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static List searchCustomer(LegalCustomer legalCustomer) {
        String queryString;
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            queryString = "SELECT legalCustomer FROM LegalCustomer legalCustomer  WHERE 1=1" +
                    (legalCustomer.getCompanyName().length() > 0 ? " AND legalCustomer.companyName = :companyName" : "") +
                    (legalCustomer.getRegisterDate().length() > 0 ? " AND legalCustomer.registerDate = :registerDate" : "") +
                    (legalCustomer.getEconomyId().length() > 0 ? " AND legalCustomer.economyCode = :economyCode" : "");
            Query query = session.createQuery(queryString);
            if (legalCustomer.getCompanyName().length() > 0) {
                query.setParameter("companyName", legalCustomer.getCompanyName());
            }
            if (legalCustomer.getRegisterDate().length() > 0) {
                query.setParameter("registerDate", legalCustomer.getRegisterDate());
            }
            if (legalCustomer.getEconomyId().length() > 0) {
                query.setParameter("economyCode", legalCustomer.getEconomyId());
            }
            logger.info("Database : legal customer found successfully!");
            return query.list();
        } finally {
            session.close();
        }
    }

    public static LegalCustomer retrieveCustomer(String customerNumber) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            LegalCustomer legalCustomer = (LegalCustomer) session.get(LegalCustomer.class, customerNumber);
            logger.info("Database : legal customer retrieved successfully!");
            return legalCustomer;
        } finally {
            session.close();
        }
    }
}
