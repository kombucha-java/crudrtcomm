var restUrl = 'rest/';
var datatableApi;
var form;

$(function () {
    datatableApi = $('#datatable').DataTable({
        "ajax": {
            "url": restUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "description"
            },
            {
                "data": "startDate",
                "render": function (date, type, row) {
                    if (type === 'display') {
                        return '<span>' + date.substring(0, 10) + ' ' + date.substring(11, 16) + ' </span>';
                    }
                    return date;
                }
            },
            {
                "data": "endDate",
                "render": function (date, type, row) {
                    if (type === 'display') {
                        return '<span>' + date.substring(0, 10) + ' ' + date.substring(11, 16) + ' </span>';
                    }
                    return date;
                }
            },
            {
                "defaultContent": "Edit",
                "orderable": false,
                "render": function (data, type, row) {
                    if (type === 'display') {
                        return '<a onclick="updateRow(' + row.id + ');">' +
                            '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>';
                    }
                }
            },
            {
                "defaultContent": "Delete",
                "orderable": false,
                "render": function (data, type, row) {
                    if (type === 'display') {
                        return '<a onclick="deleteRow(' + row.id + ');">' +
                            '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>';
                    }
                }
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": makeEditable
    });
});

function makeEditable() {
    form = $("#detailsForm");

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
}

function add() {
    form.find(":input").val("");
    $('#editRow').modal();
}

function deleteRow(id) {
    $.ajax({
        url: restUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function updateRow(id) {
    $.get(restUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function updateTable() {
    $.get(restUrl, function (data) {
        datatableApi.clear();
        $.each(data, function (key, item) {
            datatableApi.row.add(item);
        });
        datatableApi.draw();
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: restUrl,
        //contentType :   'application/json',
        data: form.serialize(),
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: 1500
    });
}

function failNoty(jqXHR) {
    closeNoty();
    failedNote = noty({
        text: 'Error status: ' + jqXHR.status + (jqXHR.responseJSON ? '<br>' + jqXHR.responseJSON : ''),
        type: 'error',
        layout: 'bottomRight'
    });
}