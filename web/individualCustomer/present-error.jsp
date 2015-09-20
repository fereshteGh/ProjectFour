<%@ page import="entity.IndividualCustomer" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="myStyle.css" rel="stylesheet"/>
</head>
<p id="message">
    <%=((Exception)request.getAttribute("error")).getMessage()%>
</p>
<body>
</body>
</html>