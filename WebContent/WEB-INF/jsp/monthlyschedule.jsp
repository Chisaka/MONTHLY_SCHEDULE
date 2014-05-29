<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月間予定</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
<form method="post" action="MonthlySchedule">
<select name="year">
<option value="2013">2013年</option>
<option value="2014" selected="selected">2014年</option>
<option value="2015">2015年</option>
<option value="2016">2016年</option>
<option value="2017">2017年</option>
<option value="2018">2018年</option>
<option value="2019">2019年</option>
<option value="2020">2020年</option>
<option value="2021">2021年</option>
<option value="2022">2022年</option>
<option value="2023">2023年</option>
</select>
<select name="month">
<option value="1">1月</option>
<option value="2">2月</option>
<option value="3">3月</option>
<option value="4">4月</option>
<option value="5" selected="selected">5月</option>
<option value="6">6月</option>
<option value="7">7月</option>
<option value="8">8月</option>
<option value="9">9月</option>
<option value="10">10月</option>
<option value="11">11月</option>
<option value="12">12月</option>
</select>
<input type="submit" value="予定を表示"><br>
</form>
<table class="table" align="center" border="2">
<tr>
<th width="15">日付</th>
<th width="600">予定</th>
<th width="25">金額</th>
<th width="40"><br></th>
<th width="40"><br></th>
</tr>
<c:forEach var="schedule" items="${scheduleList}">
<tr>
<td>${schedule.day}</td>
<td>${schedule.sche}</td>
<td>${schedule.money}</td>
<td><button>修正</button></td>
<td><a href="Delete?id=${schedule.id}"><button>削除</button></a></td>
</tr>
</c:forEach>
</table>
<hr>
<br><br>
<p class="text-center"><button onclick=location.href='Insert'>予定を追加</button>

</body>
</html>