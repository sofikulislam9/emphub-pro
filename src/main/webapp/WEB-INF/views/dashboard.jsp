<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.emphub.pro.model.User" %>

<%
    User user = (User) session.getAttribute("loggedUser");
%>

<h2>Welcome, <%= user.getUsername() %> (<%= user.getRole() %>)</h2>

<% if ("ADMIN".equals(user.getRole())) { %>
    <a href="employees">Manage Employees</a> |
    <a href="leave/admin">Approve Leaves</a>
<% } %>

<% if ("EMPLOYEE".equals(user.getRole())) { %>
    <a href="attendance/1">My Attendance</a> |
    <a href="leave">My Leaves</a>
<% } %>

<br/><br/>
<a href="logout">Logout</a>
