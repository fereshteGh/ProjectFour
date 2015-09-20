<%@ page import="java.util.List" %>
<%@ page import="entity.IndividualCustomer" %>
<!DOCTYPE html>
<html>
<head lang="en">
   <meta charset="UTF-8">
    <link href="myStyle.css"  rel="stylesheet" />
</head>
<body >
<table  >
<tr>
<th >first name</th>
<th >last name</th>
<th >birth date</th>
<th >national code</th>
<th >customer number</th>
</tr>
<%List<IndividualCustomer> individualCustomerList = (List<IndividualCustomer>)request.getAttribute("individualCustomer"); %>
<%for (IndividualCustomer individualCustomer : individualCustomerList) {%>
<tr>
<td> <%=individualCustomer.getFirstName()%></td>
<td><%=individualCustomer.getLastName()%></td>
<td><%=individualCustomer.getBirthDate()%></td>
<td> <%= individualCustomer.getNationalCode() %></td>
<td> <%= individualCustomer.getCustomerNumber() %></td>
<td>
   <form action="/editIndividualCustomer" method="post">
<input type="submit" name="editButton" value="edit">
<input type="hidden" name="customerId" value="<%=individualCustomer.getCustomerNumber()%>"/>
</form>
</td>
<td>
<form action="/deleteIndividualCustomer" method="post">
<input type="submit" name="deleteButton" value="delete">
<input type="hidden" name="customerId" value="<%=individualCustomer.getCustomerNumber()%>"/>
</form>
</td>
</tr>
    <%}%>
</table>
</body>
</html>