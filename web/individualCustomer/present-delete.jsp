<%@ page import="entity.IndividualCustomer" %>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<link href="myStyle.css"  rel="stylesheet" />
</head>
<body >
customer with customer number :
<input type="text" value="<%=((IndividualCustomer)request.getAttribute("customerNumber")).getCustomerNumber()%>">
deleted successfully!
</body>
</html>