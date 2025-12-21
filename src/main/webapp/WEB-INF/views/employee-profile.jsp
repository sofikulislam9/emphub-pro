<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Profile</title>

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
            width: 600px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 25px;
            color: #333;
        }

        .profile-row {
            display: flex;
            justify-content: space-between;
            padding: 12px 0;
            border-bottom: 1px solid #ddd;
            font-size: 16px;
        }

        .profile-row span {
            font-weight: bold;
            color: #555;
        }

        .profile-row:last-child {
            border-bottom: none;
        }

        .back-btn {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 22px;
            border-radius: 20px;
            text-decoration: none;
            background: #2980b9;
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
    <h1>My Profile</h1>

    <div class="profile-row">
        <span>ID</span>
        <div>${employee.id}</div>
    </div>

    <div class="profile-row">
        <span>Name</span>
        <div>${employee.name}</div>
    </div>

     <div class="profile-row">
            <span>Username</span>
            <div>${employee.username}</div>
        </div>

    <div class="profile-row">
        <span>Email</span>
        <div>${employee.email}</div>
    </div>

    <div class="profile-row">
        <span>Department</span>
        <div>${employee.department}</div>
    </div>

    <div class="profile-row">
        <span>Designation</span>
        <div>${employee.designation}</div>
    </div>

    <div class="profile-row">
        <span>Join Date</span>
        <div>${employee.joinDate}</div>
    </div>

    <a href="${pageContext.request.contextPath}/employee/dashboard" class="back-btn">
        Back to Dashboard
    </a>
</div>

</body>
</html>
