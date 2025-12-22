<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Leave</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #2980b9, #2ecc71);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            padding-top: 40px;
        }

        .container {
            background: #ffffff;
            width: 900px;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
            text-align: center;
        }

        h1 {
            margin-bottom: 25px;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background: #2980b9;
            color: #fff;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        .status {
            font-weight: bold;
        }

        .PENDING { color: #e67e22; }
        .APPROVED { color: #27ae60; }
        .REJECTED { color: #c0392b; }

        .actions {
            margin-top: 30px;
        }

        .btn {
            padding: 12px 24px;
            border-radius: 25px;
            text-decoration: none;
            font-weight: bold;
            color: #fff;
            margin: 0 10px;
            display: inline-block;
        }

        .apply-btn {
            background: #27ae60;
        }

        .apply-btn:hover {
            background: #219150;
        }

        .back-btn {
            background: #2c3e50;
        }

        .back-btn:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>My Leave Requests</h1>

    <c:if test="${not empty error}">
        <div style="
            background:#fdecea;
            color:#c0392b;
            padding:12px;
            border-radius:6px;
            margin-bottom:15px;
            font-weight:bold;">
            ${error}
        </div>
    </c:if>


    <!-- Leave List -->
    <table>
        <thead>
            <tr>
                <th>From Date</th>
                <th>To Date</th>
                <th>Reason</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="leave" items="${myLeaves}">
                <tr>
                    <td>${leave.fromDate}</td>
                    <td>${leave.toDate}</td>
                    <td>${leave.reason}</td>
                    <td class="status ${leave.status}">
                        ${leave.status}
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty myLeaves}">
                <tr>
                    <td colspan="4">No leave requests found</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <!-- Bottom Buttons -->
    <div class="actions">
        <a href="${pageContext.request.contextPath}/employee/leave/apply"
           class="btn apply-btn">
            Apply Leave
        </a>

        <a href="${pageContext.request.contextPath}/employee/dashboard"
           class="btn back-btn">
            Back to Dashboard
        </a>
    </div>
</div>

</body>
</html>
