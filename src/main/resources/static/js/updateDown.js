$(function () {
    $.ajax({
        method:"GET",
        url:"http://localhost:8080/file/showfiles",
        dataType:"json",
        success:function(data){
            var rows=data;
            addRows(rows);
        }
    })
})
function addRows(rows){
    for (var i=0;i<rows.length;i++){
        var tr=$("<tr></tr>");
        var td3=$("<td>"+rows[i].fid+"</td>");
        var td=$("<td>"+rows[i].fname+"</td>");
        var td2=$("<td><a href='../img/"+rows[i].fname+"' download="+rows[i].fname+" >下载</a>" +
            "<a href='javascript:void(0);' onclick='del("+rows[i].fid+")'>删除</a></td>");
        tr.append(td3);
        tr.append(td);
        tr.append(td2);
        $("#fileUpdate").append(tr);
    }
}
function del(fid) {
    $.ajax({
        url:"http://localhost:8080/file/delfile/"+fid,
        async: false,
        success:function (data) {
            if(data.del=="yes") {
                alert("删除成功");
                window.location.href = "http://localhost:8080/html/updateDown.html"
            }else{
                alert("删除失败");
            }
        }
    })
}