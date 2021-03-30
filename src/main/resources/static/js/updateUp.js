function up(){
    var file=$("#file");
    var formData=new FormData();
    formData.append("file",file[0].files[0]);
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/file/fileup",
        async:false,
        data:formData,
        processData: false,
        contentType:false,
        success:function(data){
            alert(data.fileup);
        }
    })
}