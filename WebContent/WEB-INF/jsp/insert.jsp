<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予定入力画面</title>
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript"
    src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<link type="text/css"
    href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css"
    rel="stylesheet" />
<link
    href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
    rel="stylesheet">
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			numberOfMonths : 1,
			showButtonPanel : true
		});
	});
</script>
</head>
<body>
    <H1>予定を追加</H1>
    <br>
    <form method="post" action="InsertResult" class="form-inline">
        <input type="text" id="datepicker" placeholder="日付" name="date"
            size="10" class="form-control" /> <input type="text"
            name="schedule" placeholder="予定を入力してください" size="50"
            class="form-control" /> <input type="number" name="money"
            placeholder="金額" size="10" class="form-control"><br>
        <br>
        <p class="text-center">
            <input type="submit" value="予定を追加">
        </p>
        <br>
    </form>
    <hr>
</body>
</html>