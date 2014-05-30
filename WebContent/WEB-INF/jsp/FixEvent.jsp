<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
        <link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css" rel="stylesheet" />
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
        rel="stylesheet">
        <script type="text/javascript">
            $(function(){
                $("#datepicker").datepicker({
                    numberOfMonths: 1,
                    showButtonPanel: true
                });
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>予定変更画面</title>
    </head>
    <body>
        <h1>予定を修正</h1>
        <br>
        <form action="FixResult?id=${schedule.id}" method="post" class="form-inline">
            <input type="text" id="datepicker" name="date" size="10"
                   value="${schedule.year}/${schedule.month}/${schedule.day}" class="form-control" />
            <input type="text" name="schedule" size="50"
                   value="${schedule.sche}" class="form-control" />
            <input type="number" name="money" size="10"
                   value="${schedule.money}" class="form-control"><br>
            <br>
            <p class="text-center"><input type="submit" value="予定を修正"></p><br>
        </form>
        <hr>
    </body>
</html>