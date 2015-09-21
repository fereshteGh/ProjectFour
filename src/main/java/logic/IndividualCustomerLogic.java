package logic;

import crud.IndividualCustomerCrud;
import entity.*;
import exceptions.ExistenceException;
import exceptions.NationalCodeException;
import exceptions.ValidationException;
import org.apache.log4j.Logger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IndividualCustomerLogic {
    static Logger logger = Logger.getLogger(IndividualCustomer.class);
    static Logger loggerLoanType = Logger.getLogger(LoanType.class);
    static Logger loggerLoanFile = Logger.getLogger(LoanFile.class);
    private IndividualCustomer individualCustomers;

    public void checkFields(IndividualCustomer individualCustomer) throws ValidationException, ExistenceException, NationalCodeException {
        if (individualCustomer.getFirstName() == null || individualCustomer.getFirstName().length() == 0) {
            logger.error("Logic : first name is empty");
            throw new ValidationException("first name could not be empty");
        }
        if (individualCustomer.getLastName() == null || individualCustomer.getLastName().length() == 0) {
            throw new ValidationException("last name could not be empty");
        }
        if (individualCustomer.getBirthDate() == null || individualCustomer.getBirthDate().length() == 0) {
            logger.error("Logic : last name is empty");
            throw new ValidationException("birth date could not be empty");
        }
        if (individualCustomer.getNationalCode() == null || individualCustomer.getNationalCode().length() == 0) {
            logger.error("Logic : national code is empty");
            throw new ValidationException("national code could not be empty");
        }
  if (IndividualCustomerCrud.checkNationalCodeExistence(individualCustomer.getNationalCode())) {
      logger.error("Logic : national code exists!");
            throw new ExistenceException("This national code exists....");
        }
    }

    public IndividualCustomer addCustomer(String fName, String lName, String bDate, String nationalCode) throws ValidationException, ExistenceException, NationalCodeException {
        individualCustomers = new IndividualCustomer();
        individualCustomers.setFirstName(fName);
        individualCustomers.setLastName(lName);
        individualCustomers.setBirthDate(bDate);
        individualCustomers.setNationalCode(nationalCode);
        String customerNumber = CustomerLogic.generateCustomerNumber();
        individualCustomers.setCustomerNumber(customerNumber);
        checkFields(individualCustomers);
        logger.info("Logic : individual customer added successfully!");
        return IndividualCustomerCrud.addCustomer(individualCustomers);
    }

    public IndividualCustomer updateCustomer(String fName, String lName, String bDate, String nationalCode,String customerId) throws ValidationException, ExistenceException, NationalCodeException {
        individualCustomers = new IndividualCustomer();
        individualCustomers.setFirstName(fName);
        individualCustomers.setLastName(lName);
        individualCustomers.setBirthDate(bDate);
        individualCustomers.setNationalCode(nationalCode);
        individualCustomers.setCustomerId(Integer.parseInt(customerId));
        //checkFields(individualCustomers);
        logger.info("Logic : individual customer updated successfully!");
       return IndividualCustomerCrud.updateCustomer(individualCustomers);
    }

    public void deleteCustomer(String customerNumber) throws ValidationException {
        logger.info("Logic : individual customer deleted successfully!");
        IndividualCustomerCrud.deleteCustomer(customerNumber);
    }

    public List searchCustomer(String fName, String lName, String bDate, String nationalCode, String customerNumber) throws ValidationException {
        List individualCustomer;
        individualCustomers = new IndividualCustomer();
        individualCustomers.setFirstName(fName);
        individualCustomers.setLastName(lName);
        individualCustomers.setBirthDate(bDate);
        individualCustomers.setNationalCode(nationalCode);
        individualCustomers.setCustomerNumber(customerNumber);
        individualCustomer = IndividualCustomerCrud.searchCustomer(individualCustomers);
        logger.info("Logic : individual customer found successfully!");
        return individualCustomer;
    }

    public IndividualCustomer retrieveCustomer(String customerId) throws ValidationException {
        logger.info("Logic : individual customer retrieved successfully!");
        return IndividualCustomerCrud.retrieveCustomer(customerId);
    }

    public LoanType saveLoanType( String loanTypeName, String interestRate, String[] grantConditionName, String[] minContractAmount, String[] maxContractAmount, String[] minContractDuration, String[] maxContractDuration) throws ValidationException {
        LoanType loanType = new LoanType();
        loanType.setLoanTypeName(loanTypeName);
        loanType.setInterestRate(Double.parseDouble(interestRate));
        List<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();
        for(int i = 0; i<grantConditionName.length; i++ ) {
            GrantCondition grantConditionEntities = new GrantCondition();
            grantConditionEntities.setGrantConditionName(grantConditionName[i]);
            grantConditionEntities.setMinContractAmount(new BigDecimal(minContractAmount[i]));
            grantConditionEntities.setMaxContractAmount(new BigDecimal(maxContractAmount[i]));
            grantConditionEntities.setMinContractDuration(Integer.parseInt(minContractDuration[i]));
            grantConditionEntities.setMaxContractDuration(Integer.parseInt(maxContractDuration[i]));
            grantConditionList.add(grantConditionEntities);
        }
        loanType.setGrantConditionList(grantConditionList);
        validateLoanType(loanType);
       loggerLoanType.info("Logic : loan type for individual customer added successfully!");
        return IndividualCustomerCrud.saveLoanType(loanType);
    }

    public void validateLoanType(LoanType loanTypeEntities) throws ValidationException {
        if (loanTypeEntities.getLoanTypeName() == null || loanTypeEntities.getLoanTypeName().length() == 0) {
            loggerLoanType.error("Logic : loan type name is empty!");
            throw new ValidationException("loan type name could not be empty!");
        }
        if (loanTypeEntities.getInterestRate() == null || loanTypeEntities.getInterestRate() == 0) {
            loggerLoanType.error("Logic : interest rate name is empty!");
            throw new ValidationException("interest rate could not be empty!");
        }
        if (loanTypeEntities.getGrantConditionList() == null || loanTypeEntities.getGrantConditionList().size() == 0) {
            loggerLoanType.error("Logic : grant condition list is empty!");
            throw new ValidationException("grant condition list could not be empty!");
        }
        for (GrantCondition grantConditionEntities : loanTypeEntities.getGrantConditionList()) {
            if (grantConditionEntities.getGrantConditionName() == null || grantConditionEntities.getGrantConditionName().length() == 0) {
                loggerLoanType.error("Logic : grant condition name is empty!");
                throw new ValidationException("grant condition name could not be empty!");
            }
            if (grantConditionEntities.getMinContractAmount() == null || grantConditionEntities.getMinContractAmount().equals(BigDecimal.ZERO)) {
                loggerLoanType.error("Logic : grant condition minimum amount is empty!");
                throw new ValidationException("grant condition minimum amount could not be empty!");
            }
            if (grantConditionEntities.getMaxContractAmount() == null || grantConditionEntities.getMaxContractAmount().equals(BigDecimal.ZERO)) {
                loggerLoanType.error("Logic : grant condition maximum amount is empty!");
                throw new ValidationException("grant condition maximum amount could not be empty!");
            }
            if (grantConditionEntities.getMinContractDuration() <=0) {
                loggerLoanType.error("Logic : grant condition minimum duration is empty!");
                throw new ValidationException("grant condition minimum duration could not be negative!");
            }
            if (grantConditionEntities.getMaxContractDuration() <=0) {
                loggerLoanType.error("Logic : grant condition maximum duration is empty!");
                throw new ValidationException("grant condition maximum duration could not be negative!");
            }
            if (grantConditionEntities.getMinContractAmount().compareTo(grantConditionEntities.getMaxContractAmount()) == 1) {
                loggerLoanType.error("Logic : grant condition minimum amount is greater than maximum amount!");
                throw new ValidationException("grant condition minimum amount could not be greater than grant condition amount!");
            }
            if (grantConditionEntities.getMinContractDuration()>=grantConditionEntities.getMaxContractDuration())  {
                loggerLoanType.error("Logic : grant condition minimum duration is greater than maximum duration!");
                throw new ValidationException("grant condition minimum duration could not be greater than grant condition duration!");
            }
        }
    }
    public LoanFile saveLoanFile(int loanTypeId,int contractDuration,BigDecimal contractValue, String customerNumber) throws ValidationException {
        IndividualCustomer individualCustomer = findCustomer(customerNumber);
        LoanFile loanFile = new LoanFile();
        loanFile.setIndividualCustomer(individualCustomer);
        loanFile.setContractDuration(contractDuration);
        loanFile.setContractValue(contractValue);
        LoanType loanType;
        loanType = IndividualCustomerCrud.retrieveLoanType(loanTypeId);
        loanFile.setLoanType(loanType);
        List<GrantCondition> grantConditionList = loanType.getGrantConditionList();
        for(GrantCondition grantCondition : grantConditionList)
        if (contractDuration <= grantCondition.getMaxContractDuration()&&
                contractDuration >= grantCondition.getMinContractDuration() &&
                contractValue.compareTo(grantCondition.getMaxContractAmount())== -1 &&
                contractValue.compareTo(grantCondition.getMinContractAmount())== 1){
            loanFile.setContractDuration(contractDuration);
            loanFile.setContractValue(contractValue);
        }else {
            loggerLoanFile.error("Logic : loan type is invalid");
            throw new ValidationException("invalid entry for loan type "+loanType.getLoanTypeId());
        }
        loggerLoanFile.info("Logic : loan file for individual customer created successfully!");
        return IndividualCustomerCrud.saveLoanFile(loanFile);
    }
    public IndividualCustomer findCustomer(String customerNumber) throws ValidationException {
        IndividualCustomer individualCustomer = IndividualCustomerCrud.findCustomer(customerNumber);
        if(individualCustomer == null){
            loggerLoanFile.error("Logic : customer number is invalid!");
            throw new ValidationException("Invalid Customer Number " + customerNumber);
        }
        return  individualCustomer;
    }
    public List retrieveAllLoanTypes(){
        List loanTypeList = IndividualCustomerCrud.retrieveLoanTypeName();
        loggerLoanFile.info("Logic : loan type for individual customer retrieved successfully!");
        return loanTypeList;

    }
}

