package presentation;

import entity.IndividualCustomer;
import entity.LoanFile;
import entity.LoanType;
import exceptions.ValidationException;
import logic.IndividualCustomerLogic;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class LoanFileServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(LoanFile.class);
    IndividualCustomerLogic individualCustomerLogic = new IndividualCustomerLogic();
    IndividualCustomer individualCustomer;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerNumber;
        String url = "";
        response.setContentType("text/html;UTF-8");
        request.setCharacterEncoding("UTF-8");
        customerNumber = request.getParameter("customerNumber");
        if (request.getRequestURI().endsWith("/createLoanFile")) {
            List<LoanType> loanTypeEntitiesList = individualCustomerLogic.retrieveAllLoanTypes();
            url = "/individualCustomer/create-loan-file.jsp";
            request.setAttribute("loanType", loanTypeEntitiesList);
            logger.debug("go to "+url);
        }
       else if (request.getRequestURI().endsWith("/registerLoanFile")) {
            int loanTypeId = Integer.parseInt(request.getParameter("loanTypeId"));
            int contractDuration = Integer.parseInt(request.getParameter("contractDuration"));
            BigDecimal contractValue = new BigDecimal(request.getParameter("contractValue"));
            LoanFile loanFile ;
            try {
                loanFile = individualCustomerLogic.saveLoanFile(loanTypeId, contractDuration, contractValue, customerNumber);
                url = "/individualCustomer/present-loan-information.jsp";
                request.setAttribute("loanFile", loanFile);
                logger.debug("go to "+url);
            } catch (ValidationException e) {
                request.setAttribute("error",e);
                url="/individualCustomer/present-error.jsp";
                e.printStackTrace();
            }
        }
        else if (request.getRequestURI().endsWith("/retrieveCustomer")) {
            try {
                individualCustomer = individualCustomerLogic.findCustomer(customerNumber);
                System.out.println("individualCustomer = " + individualCustomer);
                request.setAttribute("individualCustomer", individualCustomer);
                url = "/individualCustomer/create-loan-file.jsp";
            } catch (ValidationException e) {
                request.setAttribute("error",e);
                url="/individualCustomer/present-error.jsp";
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}


