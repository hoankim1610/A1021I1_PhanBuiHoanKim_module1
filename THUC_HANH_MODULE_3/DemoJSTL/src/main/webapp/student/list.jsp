<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student</title>
</head>
<body>
    <h1>Student list</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Sex</th>
        </tr>
        <% List<Student> list = (List<Student>)request.getAttribute("list");
        for (Student st: list) { %>
        <tr>
            <td><%=st.getId()%></td>
            <td><%=st.getName()%></td>
            <td><%=st.getBirthDay()%></td>
            <td><%=st.isSex()?"Male" : "Female"%></td>
        </tr>
        <% } %>

    </table>
</body>
</html>
