<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>

body {
            font-family: Arial, sans-serif;
            background-color: #64dfdf;
            margin: 0;
            
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 300px;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
            background-color: #E0E0E0;
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
<body>
    <div class="container">

        <form action="${pageContext.request.contextPath}/student/delete" method="post">
            <div>
                <label for="studentId">Student ID</label>
                <input type="text" id="studentId" name="studentId">
            </div>
            <div class="submit-container">
                <input type="submit" name="Submit" value="Submit">
            </div>
        </form>
        

    </div>

</body>

</html>