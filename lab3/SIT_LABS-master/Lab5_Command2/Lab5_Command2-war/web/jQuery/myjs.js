function appender(key, value) {
    var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td> <td><button></button></td></tr>");

    rowNew.children().eq(0).text(value['name']);
    rowNew.children().eq(1).text(value['circulation']);
    rowNew.children().eq(2).text(value['publishdate']);
    rowNew.children().eq(3).text(value['region']);
    rowNew.children().eq(4).text(value['authorName']);
    rowNew.children().eq(5).children().addClass("deleter").attr("id", value['idNews']).text("Delete");
    $('#myTable').append(rowNew);

}


function refreshNews() {

    var $methodname = "read_ajax";

    $.get('http://localhost:8080/Lab5_Command2-war/AjaxServlet', {
        method: $methodname
    }, function (responseJson) {

        $("#myTable").find("tr:gt(0)").remove();

        $.each(responseJson, appender);
    });
}


function addNews() {

    var $newsname = $("#News_name").val();
    var $circulation = $("#circ").val();
    var $publishdate = $("#pub_date").val();
    var $country = $("#country").val();
    var $author = $("#author").val();
    var methodname = "add_ajax";

    $.get('http://localhost:8080/Lab5_Command2-war/AjaxServlet', {
        name: $newsname,
        circulation: $circulation,
        publishDate: $publishdate,
        region: $country,
        authorName: $author,
        method: methodname
    }, refreshNews);
}

function deleteNews(id_del) {
    
    var methodname = "delete_ajax";
    
    $.get('http://localhost:8080/Lab5_Command2-war/AjaxServlet', {
        id: id_del,
        method: methodname
    }, refreshNews);
}


$(document).ready(function () {
    $('#myButton').on("click", refreshNews);
});

$(document).ready(function () {
    $('#myButtonAdd').on("click", addNews);
});


$(document).on('click', '.deleter', function() {deleteNews(this.id)});

$(document).ready(refreshNews)
