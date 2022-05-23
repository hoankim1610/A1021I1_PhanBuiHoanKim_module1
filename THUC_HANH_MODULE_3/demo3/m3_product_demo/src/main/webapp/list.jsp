<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="assets/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<%--    <script src="webjars/jquery/3.6.0/dist/jquery.min.js"></script>--%>
</head>
<body>
<div class="row">
        <h2 class="col-10 pt-2 ps-2">Product List</h2>

    <div class="col-2 pt-4">
        Search <input name="search"/>
    </div>
</div>
<div class="row float-end mt-2">
    <a class="me-5 pe-3" href="/form.jsp">Add new</a>
</div>

<table>
    <thead>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${result}">
        <tr>
            <td>${e.name}</td>
            <td>${e.price}</td>
            <td>${e.quantity}</td>
            <td>${e.color}</td>
            <td>${e.description}</td>
            <td>${e.categoryName}</td>
            <td>
                <a href="?id=${e.id}">Edit</a>
                <a href="#" onclick="openDeleteModal(${e.id})">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post">
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

<script>
    function openDeleteModal(id){
        document.getElementById("hdId").value = id;
        const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'), {
            keyboard: false
        })
        deleteModal.show();
    }
</script>

</body>
</html>
