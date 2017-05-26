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
    <script type="text/javascript" src="resources/js/datatableUtil.js" defer></script>
    <script type="text/javascript" src="resources/js/todoUtil.js" defer></script>

</head>
<body>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <a class="btn btn-primary" onclick="add()">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                Add ToDo
            </a>
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
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Add ToDo</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="description" class="control-label col-xs-3">Description</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="description" name="description" placeholder="Description">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="startDate" class="control-label col-xs-3">Start date</label>

                        <div class="col-xs-9">
                            <input type="datetime-local" class="form-control" id="startDate" name="startDate" placeholder="Start date">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="endDate" class="control-label col-xs-3">End date</label>

                        <div class="col-xs-9">
                            <input type="datetime-local" class="form-control" id="endDate" name="endDate" placeholder="End date">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="button" onclick="save()" class="btn btn-primary">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
