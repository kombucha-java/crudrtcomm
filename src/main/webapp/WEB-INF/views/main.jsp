<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.15/media/css/dataTables.bootstrap.min.css">

    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.15/media/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/noty/2.4.1/js/noty/packaged/jquery.noty.packaged.min.js" defer></script>

</head>
<body>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <table class="table table-striped display" id="datatable">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${todos}" var="todo">
                    <jsp:useBean id="todo" scope="page" type="ru.testprojects.crudrtcomm.model.ToDo"/>
                    <tr>
                        <td><c:out value="${todo.description}"/></td>
                        <td><fmt:formatDate value="${todo.startDate}" pattern="dd-MM-yyyy HH:mm"/></td>
                        <td><fmt:formatDate value="${todo.endDate}" pattern="dd-MM-yyyy HH:mm"/></td>
                        <td><a class="btn btn-xs btn-primary">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                        </a></td>
                        <td><a class="btn btn-xs btn-danger delete" id="${todo.id}">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
