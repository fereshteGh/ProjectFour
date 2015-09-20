package logic;

import crud.CustomerCRUD;

public class CustomerLogic {
    static final Boolean lock = true;
    //generate customer number
    public static String generateCustomerNumber() {
        String customerNumber;
        synchronized (lock) {
            String lastCustomerNumber = CustomerCRUD.readLastCustomerNumber();
            if (lastCustomerNumber.compareTo("null") == 0) {
                customerNumber = "1";
            } else {
                customerNumber = String.valueOf(Integer.parseInt(lastCustomerNumber) + 1);
            }
            return customerNumber;
        }
    }
}
