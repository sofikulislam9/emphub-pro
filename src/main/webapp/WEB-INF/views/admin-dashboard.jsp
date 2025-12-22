<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #8e44ad, #c0392b);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background: #ffffff;
            width: 700px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
            position: relative; /* for logout button positioning */
        }

        h1 {
            color: #333;
            margin-bottom: 10px;
        }

        h1 span {
            color: #c0392b;
        }

        p {
            color: #666;
            margin-bottom: 30px;
            font-size: 18px;
        }

        .card-wrapper {
            display: flex;
            justify-content: space-between;
        }

        .card {
            width: 200px;
            padding: 25px;
            border-radius: 10px;
            background: #f5f5f5;
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        .card h3 {
            margin-bottom: 10px;
            color: #333;
        }

        .card p {
            font-size: 14px;
            margin-bottom: 15px;
        }

        .btn {
            display: inline-block;
            padding: 10px 20px;
            border-radius: 20px;
            text-decoration: none;
            color: #fff;
            font-size: 14px;
            font-weight: bold;
        }

        .employee-btn {
            background: #3498db;
        }

        .attendance-btn {
            background: #27ae60;
        }

        .leave-btn {
            background: #e67e22;
        }

        .btn:hover {
            opacity: 0.9;
        }

        /* Logout button styling */
        .logout-btn {
            position: absolute;
            top: 20px;
            right: 20px;
            background: #e74c3c;
        }

    </style>
</head>

<body>

<div class="container">
    <!-- Logout Button -->
    <a href="${pageContext.request.contextPath}/admin/logout" class="btn logout-btn">Logout</a>

    <h1>Hi, <span>${admin.name}</span></h1>
    <p>Welcome to Admin Dashboard</p>

    <div class="card-wrapper">

        <!-- Manage Employees -->
        <div class="card">
            <h3>Employees</h3>
            <p>Manage employee details and records.</p>
            <a href="${pageContext.request.contextPath}/admin/employee/list" class="btn employee-btn">
                Manage
            </a>
        </div>

        <!-- Attendance -->
        <div class="card">
            <h3>Attendance</h3>
            <p>View and track daily attendance.</p>
            <a href="${pageContext.request.contextPath}/admin/attendance" class="btn attendance-btn">
                View
            </a>
        </div>

        <!-- Leave Requests -->
        <div class="card">
            <h3>Leave Requests</h3>
            <p>Approve or reject leave requests.</p>
            <a href="${pageContext.request.contextPath}/admin/leaves" class="btn leave-btn">
                Review
            </a>
        </div>

    </div>
</div>

</body>
</html>
