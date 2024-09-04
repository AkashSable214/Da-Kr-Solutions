<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #0056b3;
            font-size: 24px;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }

        input[type="text"],
        input[type="email"],
        textarea {
            width: calc(100% - 20px);
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        button {
            background-color: #0056b3;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #004494;
        }

        .centered {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Update Student Information</h1>

    <!-- Form to input student ID -->
    <form action="${pageContext.request.contextPath}/student/updateId" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required/>
        <div class="centered">
            <button type="submit">Get Student Info</button>
        </div>
    </form>

    <!-- Check if a student object is available and display the update form -->
    <c:if test="${not empty student}">
        <form action="${pageContext.request.contextPath}/student/update" method="post">
            <input type="hidden" name="studentId" value="${student.studentId}"/>
            
            <label for="studentName">Name:</label>
            <input type="text" id="studentName" name="studentName" value="${student.studentName}" required/><br/>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${student.email}" required/><br/>
            
            <label for="contactNo">Contact Number:</label>
            <input type="text" id="contactNo" name="contactNo" value="${student.contactNo}" required/><br/>
            
            <label for="address">Address:</label>
            <textarea id="address" name="address" required>${student.address}</textarea><br/>
            
            <div class="centered">
                <button type="submit">Update</button>
            </div>
        </form>
    </c:if>
</body>
</html>
