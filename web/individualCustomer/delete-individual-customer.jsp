<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>individualCustomer</title>
</head>
<body>
<form dir="rtl" action="/deleteIndividualCustomer" method="post">
    نام :
    <input type="text" class="text" name="firstName" >
    <br><br>
    نام خانوادگی :

    <input type="text" class="text" name="lastName">
    <br><br>
    تاریخ تولد :

    <input type="text" class="text" name="birthDate" >
    <br><br>
    کد ملی :

    <input type="text" class="text" name="nationalCode" >
    <br><br>
    <input type="submit" class="button" name="delete" value="حذف" >
    <input type="hidden" name="action" value="delete">
</form>

</body>
</html>