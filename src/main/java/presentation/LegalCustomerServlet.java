package presentation;

import exceptions.ValidationException;
import logic.LegalCustomerLogic;
//import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LegalCustomerServlet extends HttpServlet {
    //static Logger logger = Logger.getLogger(LegalCustomer.class);
    LegalCustomerLogic legalCustomerProcess;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName;
        String registerDate;
        String economyCode;
        try {
            companyName = request.getParameter("companyName");
            registerDate = request.getParameter("birthDate");
            economyCode = request.getParameter("customerId");
            if (request.getRequestURL().toString().endsWith("/addIndividualCustomer")) {
                legalCustomerProcess.addCustomer(companyName, registerDate, economyCode);
            } else if (request.getRequestURL().toString().endsWith("/deleteIndividualCustomer")) {
                legalCustomerProcess.deleteCustomer(economyCode);
            } else if (request.getRequestURL().toString().endsWith("/updateIndividualCustomer")) {
                legalCustomerProcess.updateCustomer(companyName, registerDate, economyCode);
            } else if (request.getRequestURL().toString().endsWith("/searchIndividualCustomer")) {
                legalCustomerProcess.searchCustomer(companyName, registerDate, economyCode);
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}
