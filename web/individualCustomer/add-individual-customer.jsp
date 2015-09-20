<!DOCTYPE html>
<html>
<script>
    function nationalCodeValidation(input) {
        var nationalCode = input;
        var expression = /^\d{10}$/;
        var isValid = false;
        if (nationalCode.match(expression)) {
            isValid = true;
        }
        var multiplyResult = 0;
        for (var i = 0; i < nationalCode.length; i++) {
            var n = 0;
            multiplyResult += nationalCode.charAt(9 - i) * Math.pow(10, n);
            n++;
        }

        var remainder = multiplyResult % 11;
        if (isValid && ( remainder == nationalCode.charAt(9) || remainder == 11 -(nationalCode.charAt(9) ) ) ) {
            document.forms[0].submit();
        }
        else {
            alert("national code is invalid!");
        }
    }
</script>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>individualCustomer</title>
</head>
<body>
<form action="/addIndividualCustomer" method="post">

    <label> First name:</label>
    <input type="text" class="text" name="firstName"/>
    <br><br>

    <label> Last name:</label>
    <input type="text" class="text" name="lastName"/>
    <br><br>
    <label> Birth date :</label>
    <input type="text" class="text" name="birthDate"/>
    <br><br>
    <label> National code :</label>
    <input type="text" class="text" name="nationalCode"/>
    <br><br>
    <input type="button" class="button" name="add" value="add"
           onclick="nationalCodeValidation(document.getElementsByName('nationalCode')[0].value)" style="width: 200px"/>
</form>
</body>
</html>