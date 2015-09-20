<%@ page import="entity.IndividualCustomer" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="myStyle.css" rel="stylesheet"/>
</head>
<p>Update customer successfully!</p>

<body> with these information :
<ul>
    <li>
        <label>First name :</label>
        <input type="text" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getFirstName()%>"/>
   </li>
<li>
<label>Last name : </label>
 <input type="text" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getLastName()%>"/>
</li>
<li>
<label> Birth date : </label>
    <input type="text" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getBirthDate()%>"/>
</li>
<li>
<label> National code :  </label>"
    <input type="text" value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getNationalCode()%>"/>
</li>
<li>
    <label>Customer number :  </label>
    <input type="text"  value="<%=((IndividualCustomer)request.getAttribute("individualCustomer")).getCustomerId()%>"/>
</li>
</ul>
</body>
</html>