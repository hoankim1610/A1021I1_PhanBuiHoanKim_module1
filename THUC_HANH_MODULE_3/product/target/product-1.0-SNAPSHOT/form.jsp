<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body  style="text-align: center">
<h2>Customer</h2>
<form method="post" action="/customer">

    <input type="hidden" name="id" value="${customer.id}">

    <div>
        <label>Name </label>
        <input name="name" value="${customer.name}">
    </div>
    <div>
        <label>Phone </label>
        <input name="price" value="${customer.phone}">
    </div>
    <div>
        <label>Date </label>
        <input name="date" value="${customer.date}">
    </div>

<%--    <div>--%>
<%--        <label>Payment </label>--%>
<%--        <input name="payment" value="${customer.payment}">--%>
<%--    </div>--%>

    <div>
        <label>Payment </label>
        <select name="payment">
            <option ${customer.customerId == 1 ? 'selected' : ''} value="1">Theo tháng</option>
            <option ${customer.customerId == 2 ? 'selected' : ''} value="2">Theo quý</option>
            <option ${customer.customerId == 3 ? 'selected' : ''} value="3">Theo năm</option>
        </select>
    </div>
    <br>
    <button>Submit</button>
</form>
</body>
</html>
