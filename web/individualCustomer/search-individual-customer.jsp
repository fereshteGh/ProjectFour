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
    <meta charset="UTF-8">
    <title>individualCustomer</title>
</head>
<body>
<form  action="/searchIndividualCustomer" method="post">
    First name  :
    <input type="text" class="text" name="firstName" >
    <br><br>
    Last name  :

    <input type="text" class="text" name="lastName" >
    <br><br>
    Birth date  :

    <input type="text" class="text" name="birthDate" >
    <br><br>
    National code :

    <input type="text" class="text" name="nationalCode" >
    <br><br>
    <input type="submit" class="button" name="search" value="search"style="width: 200px" >
</form>

</body>
</html>