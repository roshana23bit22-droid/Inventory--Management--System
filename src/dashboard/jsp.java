package dashboard;

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Inventory Management System</title>
</head>
<body>
    <h1>Welcome, <%= request.getSession().getAttribute("username") %>!</h1>
    <p><a href="viewProducts.jsp">View Products</a></p>
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>