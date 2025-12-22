<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #c0392b, #8e44ad);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-box {
            background: #fff;
            padding: 40px;
            width: 350px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.3);
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #c0392b;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #c0392b;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #a93226;
        }

        /* Home button at bottom */
        .home-btn {
            display: inline-block;
            margin-top: 18px;
            padding: 8px 16px;
            background: #2980b9;
            color: #fff;
            border-radius: 20px;
            text-decoration: none;
            font-size: 14px;
            font-weight: bold;
        }

        .home-btn:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

<div class="login-box">
    <h2>Admin Login</h2>

    <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <input type="text" name="username" placeholder="Admin Username" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Login</button>
    </form>

    <!-- Home Button at Bottom -->
    <a href="${pageContext.request.contextPath}/home" class="home-btn">Home</a>
</div>

</body>
</html>
