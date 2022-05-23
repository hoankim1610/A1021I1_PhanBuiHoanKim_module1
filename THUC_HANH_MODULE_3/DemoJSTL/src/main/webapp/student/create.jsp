<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Ceate new Sudent</h1>
    <a href="${pageContext.request.contextPath}/student?action=list">Back to list</a>
    <form action="${pageContext.request.contextPath}/student" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" ></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" ></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday" ></td>
        </tr>
        <tr>
            <td>Sex</td>
            <td>
                <input type="radio" name="sex" value="Nam"> Nam
                <input type="radio" name="sex" value="Nu"> Nu
            </td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type="submit" value="Register">
            </td>
        </tr>
    </table>
        <input type="hidden" name="action" value="create"/>
    </form>
</body>
</html>
