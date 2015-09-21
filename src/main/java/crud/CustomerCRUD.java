package crud;

import entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.apache.log4j.Logger;

public class CustomerCRUD {
    static Logger logger = Logger.getLogger(Customer.class);

    public static String readLastCustomerNumber() {
        SessionFactory sessionFactory = HibernateConfiguration.getInstance().getSessionFactory();
        Session session = sessionFactory.openSession();
        String lastCustomerNumber;
        try {
            String queryString;
            queryString = "SELECT c.customerNumber FROM  Customer c WHERE c.customerId = (SELECT max(c1.customerId) FROM Customer c1)";
            Query query = session.createQuery(queryString);
            lastCustomerNumber = String.valueOf(query.uniqueResult());
            logger.info("Database : last customer number found successfully!");

        } finally {
            session.close();
        }
        return lastCustomerNumber;
    }
}
