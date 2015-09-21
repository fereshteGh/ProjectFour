<%@ page import="entity.IndividualCustomer" %>
<%@ page import="entity.LoanType" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<%
    String firstName="";
    String lastName="";
if("firstLoad".equals(request.getAttribute("loadTimes"))==false) {
    firstName = ((IndividualCustomer) request.getAttribute("individualCustomer")).getFirstName();
    lastName = ((IndividualCustomer) request.getAttribute("individualCustomer")).getLastName();
}
%>
<script>
    function myFun() {
        document.forms[0].submit();
    }
</script>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <title>createLoanFile</title>
</head>
<body>
<form action="/retrieveCustomer" method="post">
    Customer number:
    <input type="text" class="text" name="customerNumber">
    <input type="submit" class="button" name="retrieve" value="retrieve"  onclick="myFun()" style="width: 200px">
    <br><br>
    <table name="myTable" style="margin-left: 10px">
        <tr>
            <th id="test">first name</th>
            <th>last name</th>
        </tr>
      <td><%=firstName%>
        </td>
        <td><%=lastName%>
        </td>

    </table>
    <br><br>
</form>
<form action="/registerLoanFile" method="post">
    <select name="loanTypeId">
        <%for (LoanType loanType : (List<LoanType>) request.getAttribute("loanType")) {%>
        <%if (loanType != null) {%>
        <option value="<%=loanType.getLoanTypeId()%>"><%=loanType.getLoanTypeName()%>
        </option>
        <%}%>
        <%}%>
    </select>
    <label> Duration of Contract : </label>
    <input type="text" name="contractDuration">
    <label> Amount of Contract : </label>
    <input type="text" name="contractValue">
    <input type="submit" class="button" name="create" value="create" style="width: 200px">
</form>

</body>
</html>
