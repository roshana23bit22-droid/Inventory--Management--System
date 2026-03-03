package login;

<!DOCTYPE html>
<html>
<head>
    <title>Login - Inventory Management System</title>
</head>
<body>
    <h1>Login</h1>

    <% String error = request.getParameter("error"); %>
    <div style="color: red;"><%= error != null ? error : "" %></div>

    <form action="Login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
