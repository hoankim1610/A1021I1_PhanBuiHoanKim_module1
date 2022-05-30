<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich condiments</h1>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <button>Save</button>
</form>

Result: ${condiment}

<form:form action="submit" method="post">
    <form:label path="c">Test</form:label>
    <form:checkboxes  items="${condiments}" delimiter="|" path="c"></form:checkboxes>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
