<%@ page import="entity.IndividualCustomer" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
<link href="myStyle.css"  rel="stylesheet" />
</head>
<body >
<form  action="/updateIndividualCustomer" method="post">
   <label> First name :</label>
     <input type="text" class="text" name="firstName" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getFirstName()%>"/>
        <br><br>
    <label> Last name :</label>
    <input type="text" class="text" name="lastName" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getLastName()%>"/>
    <br><br>
    <label> Birth Date :</label>
    <input type="text" class="text" name="birthDate" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getBirthDate()%>"/>
    <br><br>
    <label>  National Code :</label>
    <input type="text" class="text" name="nationalCode" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getNationalCode()%>"/>
    <br><br>
    <label>  Customer Id :</label>
    <input type="hidden"  name="customerId" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getCustomerId()%>"/>
    <br><br>
     <input type="submit" class="button" name="update" value="update">
    </form>
</body>
</html>