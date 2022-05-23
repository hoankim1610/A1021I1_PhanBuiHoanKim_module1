<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Room List</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<h2 style="text-align: center; color: darkcyan">Management Room List</h2>
<br>
<button style="color: lightgreen"><a href="form.jsp">Add new customer</a></button>
<br>
<form action="customer?action=search" method="post">
    <input name="name">
    <button>Search</button>
</form>

<table>
    <thead>
    <th>Name</th>
    <th>Phone</th>
    <th>Date</th>
    <th>Payment</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${result}">
        <tr>
            <td>${e.name}</td>
            <td>${e.phone}</td>
            <td>${e.date}</td>
<%--            <td>${e.payment}</td>--%>
            <td>${e.paymentName}</td>
            <td>
                <button style="color: lightgreen"><a href="?id=${e.id}">Edit</a></button>
                <button style="color: lightgreen"><a href="#" onclick="openDeleteModal(${e.id})">Delete</a></button>
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
                    Are you sure you want to delete this customer?
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
        const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'),  {
            keyboard: false
        })
        deleteModal.show();
    }
</script>
</html>


