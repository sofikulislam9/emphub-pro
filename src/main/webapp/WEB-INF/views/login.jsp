<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form method="post" action="login">
    Username: <input name="username"/><br/><br/>
    Password: <input type="password" name="password"/><br/><br/>
    <button type="submit">Login</button>
</form>

<p style="color:red">${error}</p>

</body>
</html>
