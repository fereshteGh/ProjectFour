package presentation;

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

public class LoanTypeServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(LoanType.class);
    IndividualCustomerLogic individualCustomerLogic = new IndividualCustomerLogic();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String interestRate ;
        String loanTypeName ;
        String url = "";
        try {
            response.setContentType("text/html;UTF-8");
            request.setCharacterEncoding("UTF-8");
            String[] grantConditionName;
            String[] minDuration;
            String[] maxDuration;
            String[] minAmount;
            String[] maxAmount;
            if (request.getRequestURL().toString().endsWith("/loanGrantIndividualCustomer")) {
                interestRate = request.getParameter("interestRate");
                loanTypeName = request.getParameter("loanTypeName");
                request.getSession().setAttribute("loanTypeName", loanTypeName);
                request.getSession().setAttribute("interestRate", interestRate);
                url ="/individualCustomer/grant-conditions.jsp";
            } else if (request.getRequestURL().toString().endsWith("/registerLoanIndividualCustomer")) {
                grantConditionName = request.getParameterValues("grantConditionName");
                minDuration = request.getParameterValues("minContractDuration");
                maxDuration = request.getParameterValues("maxContractDuration");
                minAmount = request.getParameterValues("minContractAmount");
                maxAmount = request.getParameterValues("maxContractAmount");
                LoanType loanTypeEntities = individualCustomerLogic.saveLoanType(
                        ( request.getSession().getAttribute("loanTypeName")).toString(),
                        ( request.getSession().getAttribute("interestRate")).toString(),
                        grantConditionName,
                        minAmount,
                        maxAmount,
                        minDuration,
                        maxDuration);
                request.setAttribute("loanType", loanTypeEntities);
                url = "/individualCustomer/present-loan-type.jsp";
                logger.debug("go to "+url);
            }
        } catch (ValidationException e) {
            request.setAttribute("error",e);
            url="/individualCustomer/present-error";
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }


}


