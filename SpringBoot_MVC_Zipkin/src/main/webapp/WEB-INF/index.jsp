<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Zipkin Project-Welcome</title>
        <style>
            /* Body Styling */
            body {
                height: 100vh;
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                font-family: 'Open Sans', sans-serif;
                background: linear-gradient(135deg, #74ebd5, #acb6e5);
                color: #333;
            }

            /* Container Styling */
            .container {
                background-color: #fff;
                padding: 40px;
                border-radius: 15px;
                box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);
                width: 100%;
                max-width: 400px;
                text-align: center;
            }

            /* Heading Styling */
            #heading h1 {
                color: #444;
                font-size: 28px;
                margin-bottom: 25px;
            }

            /* Radio Button Styling */
            .radio-button {
                text-align: left;
                margin-bottom: 25px;
            }

            .radio-button input[type="radio"] {
                margin-right: 12px;
                accent-color: #007bff;
            }

            .radio-button label {
                font-size: 18px;
                color: #555;
                cursor: pointer;
            }

            /* Submit Button Styling */
            input[type="submit"] {
                padding: 15px 30px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                font-size: 18px;
                font-weight: bold;
                transition: all 0.3s ease;
            }

            input[type="submit"]:hover {
                background-color: #0056b3;
                transform: translateY(-2px);
            }

            /* Responsive Design */
            @media (max-width: 400px) {
                .container {
                    padding: 30px;
                }

                #heading h1 {
                    font-size: 24px;
                }

                input[type="submit"] {
                    width: 100%;
                    font-size: 16px;
                    padding: 12px;
                }
            }
        </style>
    </head>

    <body>

        <div class="container">
            <div id="heading">
                <h1>SKC Student</h1>
            </div>
            <form action="/student" method="post">
                <div class="radio-button">
                    <input type="radio" id="all" name="student" value="all">
                    <label for="all">All Student</label><br>

                    <input type="radio" id="add" name="student" value="add">
                    <label for="add">Add Student</label><br>

                    <input type="radio" id="update" name="student" value="update">
                    <label for="update">Update Student</label><br>

                    <input type="radio" id="delete" name="student" value="delete">
                    <label for="delete">Delete Student</label><br>
                </div>
                <div>
                    <input type="submit" value="Submit">
                </div>
            </form>
        </div>

    </body>

    </html>