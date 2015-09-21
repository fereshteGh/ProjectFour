package presentation;

import entity.IndividualCustomer;
import exceptions.ExistenceException;
import exceptions.NationalCodeException;
import exceptions.ValidationException;
import logic.IndividualCustomerLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

public class IndividualCustomerServlet extends HttpServlet {
    static Logger logger = Logger.getLogger(IndividualCustomer.class);
    IndividualCustomerLogic individualCustomerLogic = new IndividualCustomerLogic();
    IndividualCustomer individualCustomer;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName;
        String lastName;
        String birthDate;
        String nationalCode;
        String customerNumber;
        String customerId;
        String url = "";
        List<IndividualCustomer> individualCustomerList;
        try {
            response.setContentType("text/html;UTF-8");
            request.setCharacterEncoding("UTF-8");
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            birthDate = request.getParameter("birthDate");
            nationalCode = request.getParameter("nationalCode");
            customerNumber = request.getParameter("customerNumber");
            if (request.getRequestURL().toString().endsWith("/addIndividualCustomer")) {
                individualCustomer = individualCustomerLogic.addCustomer(firstName, lastName, birthDate, nationalCode);
                request.setAttribute("individualCustomer", individualCustomer);
                url = "/individualCustomer/present-customer.jsp";
                logger.debug("go to " + url);

            } else if (request.getRequestURL().toString().endsWith("/deleteIndividualCustomer")) {
                customerId = request.getParameter("customerId");
                individualCustomerLogic.deleteCustomer(customerId);
                request.setAttribute("customerNumber", customerId);
                url = "/individualCustomer/present-delete.jsp";
                logger.debug("go to " + url);

            } else if (request.getRequestURL().toString().endsWith("/editIndividualCustomer")) {
                customerId = request.getParameter("customerId");
                individualCustomer = individualCustomerLogic.retrieveCustomer(customerId);
                request.setAttribute("individualCustomer", individualCustomer);
                url = "/individualCustomer/present-edit.jsp";
                logger.debug("go to " + url);

            } else if (request.getRequestURL().toString().endsWith("/updateIndividualCustomer")) {
                customerId = request.getParameter("customerId");
                individualCustomer = individualCustomerLogic.updateCustomer(firstName, lastName, birthDate, nationalCode, customerId);
                request.setAttribute("individualCustomer", individualCustomer);
                url = "/individualCustomer/present-update.jsp";
                logger.debug("go to " + url);

            } else if (request.getRequestURL().toString().endsWith("/searchIndividualCustomer")) {
                individualCustomerList = individualCustomerLogic.searchCustomer(firstName, lastName, birthDate, nationalCode, customerNumber);
                request.setAttribute("individualCustomer", individualCustomerList);
                url = "/individualCustomer/present-search.jsp";
                logger.debug("go to " + url);
            }
        } catch (ValidationException e) {
            request.setAttribute("error", e);
            url = "/individualCustomer/present-error";
        } catch (ExistenceException e) {
            request.setAttribute("error", e);
            url = "/individualCustomer/present-error";
        } catch (NationalCodeException e) {
            request.setAttribute("error", e);
            url = "/individualCustomer/present-error";
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }

}


