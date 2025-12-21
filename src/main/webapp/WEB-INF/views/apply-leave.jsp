<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Apply Leave</title>

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
            width: 450px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 25px;
            color: #333;
        }

        input, textarea {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        textarea {
            resize: none;
            height: 90px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #27ae60;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }

        button:hover {
            background: #219150;
        }

        .back-btn {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #2980b9;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Apply Leave</h1>

    <form action="${pageContext.request.contextPath}/employee/leave/apply-page" method="post">

        <input type="date" name="fromDate" required>
        <input type="date" name="toDate" required>

        <textarea name="reason" placeholder="Reason for leave" required></textarea>

        <!-- status will be set as PENDING in backend -->
        <button type="submit">Submit Request</button>
    </form>

    <a href="${pageContext.request.contextPath}/employee/dashboard" class="back-btn">
        Back to Dashboard
    </a>
</div>

</body>
</html>
