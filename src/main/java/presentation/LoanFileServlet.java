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
        if (request.getRequestURI().endsWith("/retrieveCustomer")) {
            try {
                List<LoanType> loanTypeEntitiesList = individualCustomerLogic.retrieveAllLoanTypes();
                request.setAttribute("loanType", loanTypeEntitiesList);
                request.getSession().setAttribute("customerNumber", customerNumber);
                individualCustomer = individualCustomerLogic.findCustomer(customerNumber);
                request.setAttribute("individualCustomer", individualCustomer);

                url = "/individualCustomer/create-loan-file.jsp";
                logger.debug("go to " + url);
            } catch (ValidationException e) {
                request.setAttribute("error", e);
                url = "/individualCustomer/present-error.jsp";
                e.printStackTrace();
            }
        }
        if (request.getRequestURI().endsWith("/createLoanFile")) {

            List<LoanType> loanTypeEntitiesList = individualCustomerLogic.retrieveAllLoanTypes();
            request.setAttribute("loanType", loanTypeEntitiesList);
            String loadTimes = "firstLoad";
            request.setAttribute("loadTimes", loadTimes);
            url = "/individualCustomer/create-loan-file.jsp";
            logger.debug("go to " + url);
        }
        if (request.getRequestURI().endsWith("/registerLoanFile")) {
            int loanTypeId = Integer.parseInt(request.getParameter("loanTypeId"));
            int contractDuration = Integer.parseInt(request.getParameter("contractDuration"));
            BigDecimal contractValue = new BigDecimal(request.getParameter("contractValue"));
            LoanFile loanFile;
            try {
                System.out.println("customerNumber : "+request.getSession().getAttribute("customerNumber").toString());
                loanFile = individualCustomerLogic.saveLoanFile(loanTypeId, contractDuration, contractValue, request.getSession().getAttribute("customerNumber").toString());
                request.setAttribute("loanFile", loanFile);
                url = "/individualCustomer/present-loan-information.jsp";
                logger.debug("go to " + url);
            } catch (ValidationException e) {
                request.setAttribute("error", e);
                url = "/individualCustomer/present-error.jsp";
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}


