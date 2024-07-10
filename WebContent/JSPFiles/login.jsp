<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #fff;
            text-align: center;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.15);
            backdrop-filter: blur(10px);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .login-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 40px 0 rgba(31, 38, 135, 0.5);
        }
        .login-container h2 {
            margin-bottom: 30px;
            color: #f0f0f0;
        }
        .login-container input[type="text"], 
        .login-container input[type="password"] {
            width: calc(100% - 20px);
            padding: 12px 10px;
            margin: 10px 0;
            display: block;
            border: none;
            border-radius: 25px;
            box-sizing: border-box;
            background: rgba(255, 255, 255, 0.2);
            color: #fff;
            outline: none;
            font-size: 16px;
            letter-spacing: 1px;
        }
        .login-container input::placeholder {
            color: rgba(255, 255, 255, 0.8);
        }
        .login-container input[type="submit"] {
            background: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 16px 0;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            width: 100%;
            transition: background 0.3s ease;
        }
        .login-container input[type="submit"]:hover {
            background: #45a049;
        }
        .login-container .error-message {
            color: #ff3333;
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="loginServlet" method="post">
            <input type="text" id="username" name="username" placeholder="Username" required><br>
            <input type="password" id="password" name="password" placeholder="Password" required><br>
            <input type="submit" value="Login">
            <% 
                String error = request.getParameter("error");
                if ("true".equals(error)) {
            %>
                <div class="error-message">Invalid username or password.</div>
            <% 
                }
            %>
        </form>
    </div>
</body>
</html>
