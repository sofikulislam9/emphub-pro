<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Attendance</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2c3e50, #4ca1af);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            padding-top: 40px;
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background: #34495e;
            color: #fff;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        .back-btn {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 24px;
            border-radius: 25px;
            text-decoration: none;
            background: #2c3e50;
            color: #fff;
            font-weight: bold;
        }

        .back-btn:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Employee Attendance Records</h1>

    <!-- Attendance Table -->
    <table>
        <thead>
        <tr>
            <th>Employee ID</th>
            <th>Attendance Date</th>
            <th>Check In</th>
            <th>Check Out</th>
            <th>Total Hours</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="a" items="${attendanceList}">
            <tr>
                <td>${a.employeeId}</td>
                <td>${a.attendanceDate}</td>
                <td>${a.checkIn}</td>
                <td>${a.checkOut}</td>
                <td>${a.totalHours}</td>
            </tr>
        </c:forEach>

        <c:if test="${empty attendanceList}">
            <tr>
                <td colspan="5">No attendance records found</td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/dashboard"
       class="back-btn">
        Back to Dashboard
    </a>
</div>

</body>
</html>
