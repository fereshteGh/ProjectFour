<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link href="../myStyle.css" rel="stylesheet">

    <meta charset="UTF-8">
    <title>individualCustomer</title>
</head>
<body>
<form dir="rtl" action="/deleteLegalCustomer" method="post">
    نام شرکت :
    <input type="text" class="text" name="companyName" >
    <br><br>
    تاریخ ثبت :
    <input type="text" class="text" name="registerDate" >
    <br><br>
    کد اقتصادی :

    <input type="text" class="text" name="companyId">
    <br><br>
    <input type="submit" class="button" name="delete" value="حذف"  >
    <input type="hidden" name="action" value="delete">
</form>

</body>
</html>