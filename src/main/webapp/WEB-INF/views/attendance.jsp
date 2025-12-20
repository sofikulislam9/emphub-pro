<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Attendance</title>
</head>
<body>

<h2>Attendance</h2>

<form action="/attendance/checkin" method="post">
    <input type="hidden" name="employeeId" value="${employeeId}">
    <button type="submit">Check In</button>
</form>

<form action="/attendance/checkout" method="post">
    <input type="hidden" name="employeeId" value="${employeeId}">
    <button type="submit">Check Out</button>
</form>

<br/>

<table border="1">
<tr>
    <th>Date</th>
    <th>Check In</th>
    <th>Check Out</th>
    <th>Total Hours</th>
</tr>

<c:forEach var="a" items="${records}">
<tr>
    <td>${a.date}</td>
    <td>${a.checkIn}</td>
    <td>${a.checkOut}</td>
    <td>${a.totalHours}</td>
</tr>
</c:forEach>

</table>

</body>
</html>