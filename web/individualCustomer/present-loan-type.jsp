<%@ page import="entity.IndividualCustomer" %>
<%@ page import="entity.LoanType" %>
<%@ page import="entity.GrantCondition" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="myStyle.css" rel="stylesheet"/>
</head>
<body> Loan Type Information
<ul>
    <li>
        <label>Loan Type Name :</label>
        <input type="text" value="<%=((LoanType)request.getAttribute("loanType")).getLoanTypeName()%>"/>
   </li>
<li>
<label>Interest Rate : </label>
 <input type="text" value="<%=((LoanType)request.getAttribute("loanType")).getInterestRate()%>"/>
</li>
</ul>
<table>
    <tr>
        <td>Grant Name</td>
        <td>Minimum Contract Duration</td>
        <td>Maximum Contract Duration</td>
        <td>Minimum Contract Amount</td>
        <td>Maximum Contract Amount</td>
    </tr>
    <%LoanType loanTypeEntities =(LoanType) request.getAttribute("loanType");%>
    <%for(GrantCondition grantConditionEntities:loanTypeEntities.getGrantConditionList()){%>
    <tr>
        <td> <%=grantConditionEntities.getGrantConditionName()%></td>
        <td> <%=grantConditionEntities.getMinContractDuration()%></td>
        <td> <%=grantConditionEntities.getMaxContractDuration()%></td>
        <td> <%=grantConditionEntities.getMinContractAmount()%></td>
        <td> <%=grantConditionEntities.getMaxContractAmount()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>