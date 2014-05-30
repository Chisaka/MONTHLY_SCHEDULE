<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
    rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>予定削除画面</title>
    </head>
    <body>
    <H1>予定を削除</H1>
    <br>
    <input type="text" id="datepicker" value="${schedule.day}" disabled="disabled"
           name="date" size="10" class="form-control" />
    <input type="text" name="schedule" value="${schedule.sche}" disabled="disabled"
           size="50" class="form-control" />
    <input type="text" name="money" value="${schedule.money}" disabled="disabled"
           size="10" class="form-control" /><br>
    <br>
    <p class="text-center"><a href="DeleteResult?id=${schedule.id}"><button>予定を削除する</button></a></p><br>
    <hr>
    </body>
</html>