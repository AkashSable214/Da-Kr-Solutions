<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Styled Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f6;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            height: 100vh;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 15px;
        }

        thead {
            background-color: #009879;
            color: #ffffff;
            text-align: center;
            font-weight: bold;
        }

        tbody tr {
            border-bottom: 1px solid #dddddd;
        }

        tbody tr:nth-of-type(even) {
            background-color: #f3f3f3;
        }

        tbody tr:last-of-type {
            border-bottom: 2px solid #009879;
        }

        tbody tr:hover {
            background-color: #f1f1f1;
            cursor: pointer;
        }
    </style>
</head>

<body>

    <div>
        <table>
            <thead>
                <tr>
                    <th>Student Id</th>
                    <th>Student Name</th>
                    <th>Student Email</th>
                    <th>Student Mobile No.</th>
                    <th>Student Address</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${collegeStudent}">
                    <tr>
                        <td>${student.studentId}</td>
                        <td>${student.studentName}</td>
                        <td>${student.email}</td>
                        <td>${student.contactNo}</td>
                        <td>${student.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>

</html>
