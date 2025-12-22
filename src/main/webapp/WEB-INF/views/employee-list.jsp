<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1d2671, #c33764);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background: #ffffff;
            width: 1000px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 25px;
            color: #333;
        }

        .top-actions {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .btn {
            padding: 10px 20px;
            border-radius: 20px;
            text-decoration: none;
            font-weight: bold;
            color: #fff;
        }

        .add-btn {
            background: #27ae60;
        }

        .back-btn {
            background: #2c3e50;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        tr:hover {
            background: #f1f1f1;
        }

        a.id-link {
            color: #2980b9;
            font-weight: bold;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Employee List</h1>

    <div class="top-actions">
        <a href="${pageContext.request.contextPath}/admin/employee/add" class="btn add-btn">
            Add New Employee
        </a>

        <a href="${pageContext.request.contextPath}/admin/dashboard" class="btn back-btn">
            Back to Dashboard
        </a>
    </div>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Department</th>
                <th>Designation</th>
                <th>Join Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="emp" items="${employees}">
                <tr>
                    <td>
                        <a class="id-link"
                           href="${pageContext.request.contextPath}/admin/employee/view?id=${emp.id}">
                            ${emp.id}
                        </a>
                    </td>
                    <td>${emp.name}</td>
                    <td>${emp.username}</td>
                    <td>${emp.email}</td>
                    <td>${emp.department}</td>
                    <td>${emp.designation}</td>
                    <td>${emp.joinDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
