<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Employees</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #2c3e50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<h2>Add Employee</h2>
<form action="employee/add" method="post">
    Name: <input name="name"/><br/>
    Email: <input name="email"/><br/>
    Department: <input name="department"/><br/>
    Designation: <input name="designation"/><br/>
    <button type="submit">Save</button>
</form>

<h2>Employee List</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Designation</th>
        <th>Join Date</th>
        <th>Status</th>
    </tr>

    <c:forEach var="emp" items="${employee}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.department}</td>
            <td>${emp.designation}</td>
            <td>${emp.joinDate}</td>
            <td>${emp.status}</td>
        </tr>
    </c:forEach>

    <c:if test="${empty employee}">
        <tr>
            <td colspan="7">No Employees Found</td>
        </tr>
    </c:if>
</table>

</body>
</html>
