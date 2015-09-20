package logic;

import crud.LegalCustomerCrud;
import entity.LegalCustomer;
import exceptions.ExistenceException;
import exceptions.ValidationException;
import org.apache.log4j.Logger;

import java.util.List;

public class LegalCustomerLogic {
    static Logger logger = Logger.getLogger(LegalCustomer.class);
    private LegalCustomer legalCustomer;

    public void checkFields(LegalCustomer legalCustomer) throws ValidationException {
        if (legalCustomer.getCompanyName() == null || legalCustomer.getCompanyName().length() == 0) {
            logger.error("Logic : company name is empty!");
            throw new ValidationException("company name could not be empty!");
        }
        if (legalCustomer.getRegisterDate() == null) {
            logger.error("Logic : registry date is empty!");
            throw new ValidationException("registry date could not be empty!");
        }
        if (legalCustomer.getEconomyId() == null || legalCustomer.getEconomyId().length() == 0) {
            logger.error("Logic : economy code is empty!");
            throw new ValidationException("economy code could not be empty!");
        }
        if (LegalCustomerCrud.checkEconomyExistence(legalCustomer.getEconomyId())) {
            try {
                logger.error("Logic : economy code exists!");
                throw new ExistenceException("This economy code exists....");
            } catch (ExistenceException e) {
                e.printStackTrace();
            }
        }
    }

    public void addCustomer(String companyName, String registerDate, String economyId) throws ValidationException {
        String customerNumber = CustomerLogic.generateCustomerNumber();
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setRegisterDate(registerDate);
        legalCustomer.setEconomyId(economyId);
        legalCustomer.setCustomerNumber(customerNumber);
        checkFields(legalCustomer);
        LegalCustomerCrud.addCustomer(legalCustomer);
        logger.info("Logic : legal customer added successfully!");
    }

    public void updateCustomer(String companyName, String registerDate, String economyId) {
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setRegisterDate(registerDate);
        legalCustomer.setEconomyId(economyId);
        LegalCustomerCrud.updateCustomer(legalCustomer);
        logger.info("Logic : legal customer updated successfully!");
    }

    public void deleteCustomer(String economyId) {
        logger.info("Logic : legal customer deleted successfully!");
        LegalCustomerCrud.deleteCustomer(economyId);
    }

    public List<LegalCustomer> searchCustomer(String companyName, String registerDate, String economyId) {
        List<LegalCustomer> legalCustomerList;
        legalCustomer.setCompanyName(companyName);
        legalCustomer.setRegisterDate(registerDate);
        legalCustomer.setEconomyId(economyId);
        legalCustomerList = LegalCustomerCrud.searchCustomer(legalCustomer);
        logger.info("Logic : legal customer found successfully!");
        return legalCustomerList;
    }
}
