<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Leave Requests</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #8e44ad, #c0392b);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .container {
            background: #ffffff;
            width: 950px;
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
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            font-size: 14px;
        }

        th {
            background: #c0392b;
            color: #fff;
        }

        tr:nth-child(even) {
            background: #f9f9f9;
        }

        tr:hover {
            background: #f1f1f1;
        }

        .status {
            font-weight: bold;
        }

        .PENDING {
            color: #e67e22;
        }

        .APPROVED {
            color: #27ae60;
        }

        .REJECTED {
            color: #c0392b;
        }

        .action-btn {
            padding: 6px 14px;
            border-radius: 15px;
            text-decoration: none;
            color: #fff;
            font-size: 12px;
            font-weight: bold;
            margin: 0 3px;
        }

        .approve-btn {
            background: #27ae60;
        }

        .reject-btn {
            background: #c0392b;
        }

        .disabled-btn {
            background: #bdc3c7;
            cursor: not-allowed;
            pointer-events: none;
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
    <h1>Manage Leave Requests</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Employee ID</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Reason</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="leave" items="${leaves}">
                <tr>
                    <td>${leave.id}</td>
                    <td>${leave.employeeId}</td>
                    <td>${leave.fromDate}</td>
                    <td>${leave.toDate}</td>
                    <td>${leave.reason}</td>
                    <td class="status ${leave.status}">
                        ${leave.status}
                    </td>
                    <td>
                        <c:if test="${leave.status == 'PENDING'}">
                            <form action="${pageContext.request.contextPath}/admin/leaves/approve"
                                  method="post"
                                  style="display:inline;">
                                <input type="hidden" name="id" value="${leave.id}">
                                <button type="submit" class="action-btn approve-btn">
                                    Approve
                                </button>
                            </form>

                            <form action="${pageContext.request.contextPath}/admin/leaves/reject"
                                  method="post"
                                  style="display:inline;">
                                <input type="hidden" name="id" value="${leave.id}">
                                <button type="submit" class="action-btn reject-btn">
                                    Reject
                                </button>
                            </form>
                        </c:if>

                        <c:if test="${leave.status != 'PENDING'}">
                            <span class="action-btn disabled-btn">No Action</span>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/admin/dashboard" class="back-btn">
        Back to Dashboard
    </a>
</div>

</body>
</html>
