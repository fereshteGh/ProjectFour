<%@ page import="entity.IndividualCustomer" %>
<%@ page import="entity.LoanType" %>
<%@ page import="entity.GrantCondition" %>
<%@ page import="entity.LoanFile" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="myStyle.css" rel="stylesheet"/>
</head>
<body> Loan File Information
<ul>
    <li>
        <label>Customer Number :</label>
        <input type="text" value="<%=((LoanFile)request.getAttribute("loanFile")).getIndividualCustomerEntities().getCustomerNumber()%>"/>
   </li>
<li>
<label>First Name : </label>
 <input type="text" value="<%=((LoanFile)request.getAttribute("loanFile")).getIndividualCustomerEntities().getFirstName()%>"/>
</li>
    <li>
        <label>Last Name : </label>
        <input type="text" value="<%=((LoanFile)request.getAttribute("loanFile")).getIndividualCustomerEntities().getLastName()%>"/>
    </li>
    <li>
        <label>Loan Type Name : </label>
        <input type="text" value="<%=((LoanFile)request.getAttribute("loanFile")).getLoanTypeEntities().getLoanTypeName()%>"/>
    </li>
</ul>
</body>
</html>