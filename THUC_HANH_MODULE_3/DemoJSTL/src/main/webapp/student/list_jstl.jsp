<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student</title>
</head>
<body>
<h1>Student list</h1>
<a href="${pageContext.request.contextPath}/student?action=create">Create new student</a>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Sex</th>
        </tr>
        <c:forEach items="${list}" var="student" varStatus="item">
            <tr>
                <c:set var="name" value="${student.name}"></c:set>
                <td>${item.index}</td>
                <td>${student.id}</td>
                <td>${name}</td>
                <td>
                    <fmt:formatDate value="${student.birthDay}" pattern="yyyy/MM/dd" />
                <td>
                    <c:if test="${student.sex}">Male</c:if>
                    <c:if test="${!student.sex}">Female</c:if>
                </td>
                <td>
                    <a href="/student?action=create">Create new student</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
