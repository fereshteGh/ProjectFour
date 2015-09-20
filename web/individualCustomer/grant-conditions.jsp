<!DOCTYPE html>
<html>
<script type="text/javascript">
    function addToTable() {
        var myTable = document.getElementsByName("myTable")[0];
        var grantConditionName = document.getElementsByName("grantConditionName")[0].value;
        var minContractDuration = document.getElementsByName("minContractDuration")[0].value;
        var maxContractDuration = document.getElementsByName("maxContractDuration")[0].value;
        var minContractAmount = document.getElementsByName("minContractAmount")[0].value;
        var maxContractAmount = document.getElementsByName("maxContractAmount")[0].value;
        var rowCount = myTable.rows.length;
        var row = myTable.insertRow(rowCount);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        cell1.innerHTML = '<input type="text" name="grantConditionName " value="' + grantConditionName + '">';
        cell2.innerHTML = '<input type="text" name="minContractDuration " value="' + minContractDuration + '">';
        cell3.innerHTML = '<input type="text" name="maxContractDuration " value="' + maxContractDuration + '">';
        cell4.innerHTML = '<input type="text" name="minContractAmount " value="' + minContractAmount + '">';
        cell5.innerHTML = '<input type="text" name="maxContractAmount " value="' + maxContractAmount + '">';
        grantConditionName = "";
        minContractDuration = "";
        maxContractDuration = "";
        minContractAmount = "";
        maxContractAmount = "";
    }
</script>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>grantConditions</title>
</head>
<body>
<form action="/registerLoanIndividualCustomer" method="post">
    Grant condition name:
    <input type="text" class="text" name="grantConditionName">
    Minimum duration:
    <input type="text" class="text" name="minContractDuration">
    <br><br>
    Maximum duration :
    <input type="text" class="text" name="maxContractDuration">

    Minimum amount :
    <input type="text" class="text" name="minContractAmount">
    <br><br>
    Maximum amount :
    <input type="text" class="text" name="maxContractAmount">
    <br><br>
    <input type="submit" class="button" name="registerLoan" value="register" style="width: 200px">
    <input type="button" class="button" name="addLoan" value="add to list" onclick="addToTable()" style="width: 200px">
    <br><br>
    <table name="myTable">
        <tr>
            <td>Grant condition name</td>
            <td>Minimum duration</td>
            <td>Maximum duration</td>
            <td>Minimum amount</td>
            <td>Maximum amount</td>
        </tr>
    </table>
</form>
</body>
</html>