<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>

    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #1d2671, #c33764);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-card {
            background: #fff;
            width: 450px;
            padding: 30px;
            border-radius: 12px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
        }

        .error {
            color: red;
            font-size: 13px;
            margin-top: -8px;
            margin-bottom: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #27ae60;
            color: #fff;
            border: none;
            border-radius: 20px;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="form-card">

   <h2>
       <c:choose>
           <c:when test="${mode == 'edit'}">
               Modify Employee
           </c:when>
           <c:otherwise>
               Add New Employee
           </c:otherwise>
       </c:choose>
   </h2>

    <form action="${pageContext.request.contextPath}/admin/employee/save" method="post">

        <input type="hidden" name="id" value="${employee.id}"/>

        <input type="text" name="name" placeholder="Name"
               value="${employee.name}" required/>

        <input type="text" name="username" placeholder="Username"
               value="${employee.username}" required/>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <input type="email" name="email" placeholder="Email"
               value="${employee.email}" required/>

        <input type="text" name="department" placeholder="Department"
               value="${employee.department}" required/>

        <input type="text" name="designation" placeholder="Designation"
               value="${employee.designation}" required/>

        <input type="date" name="joinDate"
               value="${employee.joinDate}" required/>

        <button type="submit">Save</button>
    </form>

</div>

</body>
</html>
