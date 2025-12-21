<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>

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
            width: 800px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 10px;
            color: #333;
        }

        p {
            color: #666;
            margin-bottom: 40px;
            font-size: 18px;
        }

        .card-wrapper {
            display: flex;
            justify-content: space-around;
        }

        .card {
            width: 280px;
            padding: 30px;
            border-radius: 10px;
            background: #f5f5f5;
            transition: 0.3s;
        }

        .card:hover {
            transform: translateY(-8px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        .card h2 {
            color: #222;
            margin-bottom: 15px;
        }

        .card p {
            font-size: 15px;
            margin-bottom: 25px;
        }

        .btn {
            display: inline-block;
            padding: 12px 25px;
            border-radius: 25px;
            text-decoration: none;
            color: #fff;
            font-weight: bold;
        }

        .admin-btn {
            background: #e74c3c;
        }

        .employee-btn {
            background: #3498db;
        }

        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Welcome To Employee Management System</h1>
    <p>Please select your role to continue</p>

    <div class="card-wrapper">

        <!-- Admin Section -->
        <div class="card">
            <h2>Admin</h2>
            <p>Manage employees, attendance, and reports.</p>
            <a href="${pageContext.request.contextPath}/admin/login" class="btn admin-btn">
                Admin Login
            </a>
        </div>

        <!-- Employee Section -->
        <div class="card">
            <h2>Employee</h2>
            <p>View attendance, apply leave, and manage profile.</p>
            <a href="${pageContext.request.contextPath}/employee/login" class="btn employee-btn">
                Employee Login
            </a>
        </div>

    </div>
</div>

</body>
</html>
