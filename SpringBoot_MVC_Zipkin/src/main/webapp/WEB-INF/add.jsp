<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .info {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .info > div {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        label {
            flex: 1;
            color: #333;
            font-weight: bold;
        }

        input[type="text"] {
            flex: 2;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
            color: #333;
        }

        input[type="text"]:focus {
            border-color: #007bff;
            background-color: #e6f7ff;
            outline: none;
        }

        .submit-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            border-radius: 20px;
            border: none;
            background-color: transparent;
            color: #007bff;
            font-weight: bold;
            cursor: pointer;
            transition: color 0.3s, background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>

<body>
    <div class="container">
        <form action="${pageContext.request.contextPath}/student/add" method="post">

            <div class="info">
                <div>
                    <label for="studentName">Student Name</label>
                    <input type="text" id="studentName" name="studentName" value="${student.studentName}">
                </div>

                <div>
                    <label for="email">Student Email</label>
                    <input type="text" id="email" name="email" value="${student.email}">
                </div>

                <div>
                    <label for="contactNo">Student Mobile No.</label>
                    <input type="text" id="contactNo" name="contactNo" value="${student.contactNo}">
                </div>

                <div>
                    <label for="address">Student Address</label>
                    <input type="text" id="address" name="address" value="${student.address}">
                </div>
            </div>

            <div class="submit-container">
                <input type="submit" name="Submit" value="Submit">
            </div>

        </form>
    </div>
</body>
</html>
