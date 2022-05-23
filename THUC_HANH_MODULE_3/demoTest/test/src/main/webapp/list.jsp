<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<h2>List Product</h2>
<a href="form.jsp">Add new</a>
<form action="product?action=adfdfdfedfdf" method="post">
    <input name="name">
    <button>Search</button>
</form>

<table>
    <thead>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Color</th>
    <th>Category</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.color}</td>
            <td>${p.categoryName}</td>
            <td>
                <a href="product?id=${p.id}">Edit</a>
                <a href="#" onclick="openDeleteModal(${p.id})">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="product" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete this record?
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="id" id="hdId" />
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    function openDeleteModal(id){
        document.getElementById("hdId").value = id;
        const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'), {
            keyboard: false
        })
        deleteModal.show();
    }
</script>
</html>
