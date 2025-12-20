<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Apply Leave</h2>

<form action="leave/apply" method="post">
    From: <input type="date" name="fromDate"/><br/>
    To: <input type="date" name="toDate"/><br/>
    Reason: <input name="reason"/><br/>
    <button type="submit">Apply</button>
</form>

<h2>My Leaves</h2>

<table border="1">
<tr>
    <th>From</th>
    <th>To</th>
    <th>Reason</th>
    <th>Status</th>
</tr>

<c:forEach var="l" items="${leaves}">
<tr>
    <td>${l.fromDate}</td>
    <td>${l.toDate}</td>
    <td>${l.reason}</td>
    <td>${l.status}</td>
</tr>
</c:forEach>

</table>
