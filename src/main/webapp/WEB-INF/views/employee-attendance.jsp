<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Attendance</title>

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
            width: 420px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 30px;
            color: #333;
        }

        form {
            margin-bottom: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }

        .checkin-btn {
            background: #27ae60;
            color: #fff;
        }

        .checkin-btn:hover {
            background: #219150;
        }

        .checkout-btn {
            background: #e67e22;
            color: #fff;
        }

        .checkout-btn:hover {
            background: #cf711f;
        }

        .view-btn {
            background: #2980b9;
            color: #fff;
            text-decoration: none;
            display: block;
            padding: 12px;
            border-radius: 6px;
            margin-top: 10px;
            font-weight: bold;
        }

        .view-btn:hover {
            background: #1f6391;
        }

        .back-btn {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 22px;
            border-radius: 20px;
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
    <h1>Attendance</h1>

    <!-- Check In -->
    <form action="${pageContext.request.contextPath}/employee/attendance/checkin"
          method="post">
        <button type="submit" class="checkin-btn">
            Check In
        </button>
    </form>

    <!-- Check Out -->
    <form action="${pageContext.request.contextPath}/employee/attendance/checkout"
          method="post">
        <button type="submit" class="checkout-btn">
            Check Out
        </button>
    </form>

    <!-- View Attendance -->
    <a href="${pageContext.request.contextPath}/employee/attendance/view"
       class="view-btn">
        View My Attendance
    </a>

    <!-- Back -->
    <a href="${pageContext.request.contextPath}/employee/dashboard"
       class="back-btn">
        Back to Dashboard
    </a>
</div>

</body>
</html>
