<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #1d2671, #c33764);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            background: #fff;
            width: 500px;
            padding: 30px;
            border-radius: 12px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        p {
            font-size: 15px;
            margin: 8px 0;
        }

        .btn {
            display: inline-block;
            margin: 15px 10px 0;
            padding: 10px 20px;
            border-radius: 20px;
            text-decoration: none;
            font-weight: bold;
            color: #fff;
        }

        .edit-btn {
            background: #2980b9;
        }

        .delete-btn {
            background: #e74c3c;
        }
    </style>
</head>

<body>

<div class="card">
    <h2>Employee Details</h2>

    <p><b>ID:</b> ${employee.id}</p>
    <p><b>Name:</b> ${employee.name}</p>
    <p><b>Username:</b> ${employee.username}</p>
    <p><b>Email:</b> ${employee.email}</p>
    <p><b>Department:</b> ${employee.department}</p>
    <p><b>Designation:</b> ${employee.designation}</p>
    <p><b>Join Date:</b> ${employee.joinDate}</p>

    <a href="${pageContext.request.contextPath}/admin/employee/edit?id=${employee.id}"
       class="btn edit-btn">Modify</a>

    <a href="${pageContext.request.contextPath}/admin/employee/delete?id=${employee.id}"
       class="btn delete-btn"
       onclick="return confirm('Are you sure you want to delete this employee?');">
       Delete
    </a>
</div>

</body>
</html>
