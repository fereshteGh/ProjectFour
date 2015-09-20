<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
</head>
<body >
Determine operation
<br><br>
<form action="add-individual-customer.jsp" method="post">
    <input type="submit" class="button" name="addButton" value="Add customer" >
</form>
<br>
<form action="search-individual-customer.jsp" method="post">
    <input type="submit"  class="button" name="searchButton" value="Search customer">
</form>
<br>
<form action="loan-type-individual-customer.jsp" method="post">
    <input type="submit"  class="button" name="grantButton" value="Grant">
</form>
<br>
<form action="/createLoanFile" method="post">
    <input type="submit"  class="button" name="loanButton" value="Loan file">
</form>
</body>
</html>