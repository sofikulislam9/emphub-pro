<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<h2>Leave Approvals</h2>

<table border="1">
<tr>
    <th>Employee ID</th>
    <th>From</th>
    <th>To</th>
    <th>Reason</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<c:forEach var="l" items="${leaves}">
<tr>
    <td>${l.employeeId}</td>
    <td>${l.fromDate}</td>
    <td>${l.toDate}</td>
    <td>${l.reason}</td>
    <td>${l.status}</td>
    <td>
        <form action="/leave/update" method="post">
            <input type="hidden" name="leaveId" value="${l.id}"/>
            <button name="status" value="APPROVED">Approve</button>
            <button name="status" value="REJECTED">Reject</button>
        </form>
    </td>
</tr>
</c:forEach>

</table>