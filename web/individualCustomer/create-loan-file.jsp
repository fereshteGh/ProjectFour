<%@ page import="entity.IndividualCustomer" %>
<%@ page import="entity.LoanType" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<script>
    function changeActionForm(){
        document.forms[0].action="/retrieveCustomer"
        document.forms[0].submit();
    }
</script>
<%--<script>--%>
    <%--function myFun() {--%>
        <%--var myTable = document.getElementsByName("myTable")[0];--%>
        <%--<%IndividualCustomer individualCustomer = (IndividualCustomer)request.getAttribute("individualCustomer");%>--%>
        <%--<%if(individualCustomer != null){ %>--%>
        <%--var firstName =--%>
        <%--<%= individualCustomer.getFirstName()%>--%>
        <%--var lastName =--%>
        <%--<%= individualCustomer.getLastName()%>--%>
        <%--<%}%>--%>
        <%--var rowCount = myTable.rows.length;--%>
        <%--var row = myTable.insertRow(rowCount);--%>
        <%--var cell1 = row.insertCell(0);--%>
        <%--var cell2 = row.insertCell(1);--%>
        <%--cell1.innerHTML = '<input type="text" name="firstName " value="' + firstName + '">';--%>
        <%--cell2.innerHTML = '<input type="text" name="lastName " value="' + lastName + '">';--%>
        <%--firstName = "";--%>
        <%--lastName = "";--%>
    <%--}--%>
<%--</script>--%>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>createLoanFile</title>
</head>
<body>
<form action="/registerLoanFile" method="post">
    Customer number:
    <input type="text" class="text" name="customerNumber">
    <input type="submit" class="button" name="retrieve" value="retrieve"  onclick="changeActionForm()" style="width: 200px">
    <input type="hidden" name="operation" value="retrieve">
    <br><br>
    <table name="myTable" style="margin-left: 10px">
        <tr>
            <th>first name</th>
            <th>last name</th>
        </tr>
        <%IndividualCustomer individualCustomer = (IndividualCustomer) request.getSession().getAttribute("individualCustomer"); %>
        <tr>
            <%if(individualCustomer != null){ %>
            <td><%=individualCustomer.getFirstName().toString()%>
            </td>
            <td><%=individualCustomer.getLastName().toString()%>
            </td>
            <%}%>
        </tr>
    </table>
    <br><br>
    </form>

    <select name="loanTypeId">
                <%for (LoanType loanType : (List<LoanType>) request.getAttribute("loanType")) {%>
        <%if(loanType != null){%>
        <option value="<%=loanType.getLoanTypeId()%>"><%=loanType.getLoanTypeName()%>
        </option>
        <%}%>
        <%}%>
    </select>
    <label> Duration of Contract : </label>
    <input type="text" name="durationOfContract">
    <label> Amount of Contract : </label>
    <input type="text" name="amountOfContract">
    <input type="submit" class="button" name="create" value="create" style="width: 200px">

</body>
</html>