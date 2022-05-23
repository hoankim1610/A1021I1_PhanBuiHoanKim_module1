<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="assets/style.css">
</head>
<body>
<h2>Product Form</h2>
<form method="post" action="/">
<input type="hidden" name="id" value="${product.id}">
<div>
  <label>Name: </label>
  <input name="name" value="${product.name}">
</div>
<div>
  <label>Price: </label>
  <input name="price" value="${product.price}">
</div>
<div>
  <label>Quantity: </label>
  <input name="quantity" value="${product.quantity}">
</div>
<div>
  <label>Color: </label>
  <input name="color" value="${product.color}">
</div>
<div>
  <label>Description: </label>
  <input name="description" value="${product.description}">
</div>
<div>
  <label>Category: </label>
  <select name="category">
    <option ${product.categoryId == 1 ? 'selected' : ''} value="1">phone</option>
    <option ${product.categoryId == 2 ? 'selected' : ''} value="2">tv</option>
  </select>
</div>
  <button>Submit</button>
</form>
</body>
</html>
