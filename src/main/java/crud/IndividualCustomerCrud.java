package crud;

import entity.IndividualCustomer;
import entity.LoanFile;
import entity.LoanType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import org.apache.log4j.Logger;

public class IndividualCustomerCrud {
    static Logger logger = Logger.getLogger(IndividualCustomer.class);

    public static boolean checkNationalCodeExistence(String nationalCode) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String queryString;
            queryString = "SELECT individualCustomer FROM IndividualCustomer individualCustomer  WHERE individualCustomer.nationalCode = :nationalCode";
            Query query = session.createQuery(queryString);
            query.setParameter("nationalCode", nationalCode);
            if (!query.list().isEmpty()) {
                return true;
            }
        } finally {
            session.close();
        }
        return false;
    }

    public static IndividualCustomer addCustomer(IndividualCustomer individualCustomer) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(individualCustomer);
            logger.info("Database : individual customer added to database successfully!");
            session.getTransaction().commit();
            return individualCustomer;
        } finally {
            session.close();
        }
    }

    public static IndividualCustomer updateCustomer(IndividualCustomer individualCustomer) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            IndividualCustomer individualCustomer1 = (IndividualCustomer) session.get(IndividualCustomer.class, individualCustomer.getCustomerId());
            individualCustomer1.setFirstName(individualCustomer.getFirstName());
            individualCustomer1.setLastName(individualCustomer.getLastName());
            individualCustomer1.setBirthDate(individualCustomer.getBirthDate());
            individualCustomer1.setNationalCode(individualCustomer.getNationalCode());
            session.update(individualCustomer1);
            logger.info("Database : individual customer updated successfully!");
            session.getTransaction().commit();
            return individualCustomer;
        } finally {
            session.close();
        }
    }

    public static IndividualCustomer retrieveCustomer(String customerId) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            return (IndividualCustomer) session.get(IndividualCustomer.class, Integer.parseInt(customerId));
        } finally {
            session.close();
        }
    }

    public static void deleteCustomer(String customerNumber) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            IndividualCustomer individualCustomer = (IndividualCustomer) session.get(IndividualCustomer.class, customerNumber);
            session.delete(individualCustomer);
            logger.info("Database : individual customer deleted successfully!");
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static List searchCustomer(IndividualCustomer individualCustomer) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        List individualCustomers;
        try {
            String queryString;
            queryString = "SELECT individualCustomer FROM IndividualCustomer individualCustomer" +
                    " WHERE 1=1" +
                    (individualCustomer.getFirstName().length() > 0 ? " AND individualCustomer.firstName = :firstName" : "") +
                    (individualCustomer.getLastName().length() > 0 ? " AND individualCustomer.lastName = :lastName" : "") +
                    (individualCustomer.getBirthDate().length() > 0 ? " AND individualCustomer.birthDate = :birthDate" : "") +
                    (individualCustomer.getNationalCode().length() > 0 ? " AND individualCustomer.nationalCode = :nationalCode" : "");
            Query query = session.createQuery(queryString);
            if (individualCustomer.getFirstName().length() > 0) {
                query.setParameter("firstName", individualCustomer.getFirstName());
            }
            if (individualCustomer.getLastName().length() > 0) {
                query.setParameter("firstName", individualCustomer.getLastName());
            }
            if (individualCustomer.getBirthDate().length() > 0) {
                query.setParameter("firstName", individualCustomer.getBirthDate());
            }
            if (individualCustomer.getNationalCode().length() > 0) {
                query.setParameter("firstName", individualCustomer.getNationalCode());
            }
            individualCustomers = query.list();
            logger.info("Database : individual customer found successfully!");
            return individualCustomers;
        } finally {
            session.close();
        }
    }

    public static IndividualCustomer findCustomer(String customerNumber) {
        String queryString;
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            queryString = "SELECT individualCustomer FROM IndividualCustomer individualCustomer  WHERE individualCustomer.customerNumber = :customerNumber";
            Query query = session.createQuery(queryString);
            query.setParameter("customerNumber", customerNumber);
            logger.info("Database : individual customer found successfully!");
            return (IndividualCustomer) query.uniqueResult();
        } finally {
            session.close();
        }
    }

    public static LoanType saveLoanType(LoanType loanType) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(loanType);
            session.getTransaction().commit();
            logger.info("Database : loan type for individual customer  added successfully!");
            return loanType;
        } finally {
            session.close();
        }
    }

    public static LoanType retrieveLoanType(int loanTypeId) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            LoanType loanTypeEntities = (LoanType) session.get(LoanType.class, loanTypeId);
            logger.info("Database : loan type for individual customer retrieved successfully!");
            return loanTypeEntities;
        } finally {
            session.close();
        }
    }

    public static List retrieveLoanTypeName() {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            String queryString = "SELECT loanType FROM LoanType loanType ";
            Query query = session.createQuery(queryString);
            List loanTypeList = query.list();
            logger.info("Database : loan type name for individual customer retrieved successfully!");
            return loanTypeList;
        } finally {
            session.close();
        }
    }

    public static LoanFile saveLoanFile(LoanFile loanFileEntities) {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(loanFileEntities);
            session.getTransaction().commit();
            logger.info("Database : loan file for individual customer created successfully!");
            return loanFileEntities;
        } finally {
            session.close();
        }
    }
}
