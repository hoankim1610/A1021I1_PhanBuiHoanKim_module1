<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action = "/sandwich" method = "post">
    <h1>Sandwich</h1>
    <table>
        <tr>
            <th>Lettuce</th>
            <th><input type = "checkbox" name = "sandwich" value="lettuce"></th>
        </tr>
        <tr>
            <th>Tomato</th>
            <th><input type = "checkbox" name = "sandwich" value="tomato"></th>
        </tr>
        <tr>
            <th>Cheese</th>
            <th><input type = "checkbox" name = "sandwich" value="cheese"></th>
        </tr>
        <button>Click</button>
    </table>
</form>
<div>Your choice: ${res}</div>
</body>
</html>
