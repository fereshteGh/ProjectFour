<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <style>
        h1 {
            color: #998eff
        }
    </style>
    <title>individualCustomer</title>
</head>
<body>
<form dir="rtl" action="/updateIndividualCustomer" method="post">
    First name :
    <input type="text" class="text" name="firstName" value="${formValues.whatever}" >
    <br><br>
    Last name :

    <input type="text" class="text" name="lastName" value="${formValues.}">
    <br><br>
    Birth date :

    <input type="text" class="text" name="birthDate" value="${formValues.whatever}">
    <br><br>
    National code :

    <input type="text" class="text" name="nationalCode" value="${formValues.whatever}" >
    <br><br>
    <input type="submit" class="button" name="update" value="update">

</form>

</body>
</html>