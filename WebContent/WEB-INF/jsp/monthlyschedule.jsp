<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月間予定</title>
<link
    href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
    <form method="post" action="MonthlySchedule">
        <select name="year">
            <%
                int year = (Integer) request.getAttribute("year");
                for (int i = 2000; i <= 2050; i++) {
                    if (year != i) {
                        out.println("<option value=\"" + i + "\">" + i
                                + "年</option>");
                    } else {
                        out.println("<option value=\"" + i
                                + "\" selected=\"selected\">" + i + "年</option>");
                    }
                }
            %>
        </select> <select name="month">
            <%
                int month = (Integer) request.getAttribute("month");
                for (int i = 1; i <= 12; i++) {
                    if (month != i) {
                        out.println("<option value=\"" + i + "\">" + i
                                + "月</option>");
                    } else {
                        out.println("<option value=\"" + i
                                + "\" selected=\"selected\">" + i + "月</option>");
                    }
                }
            %>
        </select> <input type="submit" value="予定を表示"><br>
    </form>
    <table class="table" align="center" border="2">
        <tr>
            <th width="15"><p class="text-center">日付</p></th>
            <th width="600"><p class="text-center">予定</p></th>
            <th width="25"><p class="text-center">金額</p></th>
            <th width="40"><br></th>
            <th width="40"><br></th>
        </tr>
        <c:forEach var="schedule" items="${scheduleList}">
            <tr>
                <td><p class="text-center">${schedule.day}</p></td>
                <td>${schedule.sche}</td>
                <td><p class="text-right">${schedule.money}</p></td>
                <td><a href="Fix?id=${schedule.id}"><button>修正</button></a></td>
                <td><a href="Delete?id=${schedule.id}"><button>削除</button></a></td>
            </tr>
        </c:forEach>
        <caption>
            <b>${year}年${month}月の予定</b>
        </caption>
    </table>
    <hr>
    <br>
    <p class="text-center">
        <b>${year}年${month}月の合計${money}円</b>
    </p>
    <br>
    <p class="text-center">
        <a href="Insert"><button>予定を追加</button></a>
    </p>
</body>
</html>