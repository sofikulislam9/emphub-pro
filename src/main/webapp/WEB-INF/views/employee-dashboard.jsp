<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2980b9, #2ecc71);
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
        }

        h1 {
            color: #333;
            margin-bottom: 10px;
        }

        h1 span {
            color: #2980b9;
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

        .attendance-btn {
            background: #3498db;
        }

        .leave-btn {
            background: #e67e22;
        }

        .profile-btn {
            background: #27ae60;
        }

        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Hi, <span>${employee.name}</span></h1>
    <p>Welcome to Employee Dashboard</p>

    <div class="card-wrapper">

        <!-- Attendance -->
        <div class="card">
            <h3>Attendance</h3>
            <p>View your daily attendance records.</p>
            <a href="${pageContext.request.contextPath}/employee/attendance" class="btn attendance-btn">
                View
            </a>
        </div>

        <!-- Apply Leave -->
        <div class="card">
            <h3>Leave</h3>
            <p>Apply for leave and track status.</p>
            <a href="${pageContext.request.contextPath}/employee/leave" class="btn leave-btn">
                Apply
            </a>
        </div>

        <!-- Profile -->
        <div class="card">
            <h3>Profile</h3>
            <p>View and update your profile.</p>
            <a href="${pageContext.request.contextPath}/employee/profile" class="btn profile-btn">
                Open
            </a>
        </div>

    </div>
</div>

</body>
</html>
