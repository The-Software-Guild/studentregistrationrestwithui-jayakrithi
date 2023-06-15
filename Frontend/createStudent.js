$(document).ready(function(){
    $("button#submitButton").click(function(){
        $.ajax({
            type: 'POST',
            url: 'http://localhost:9999/users',
            data: JSON.stringify({
                id:$("#id").val(),
                name:$("#name").val(),
                age:$("#age").val(),
                mobileno:$("#mobileno").val(),
                address:$("#address").val()
            }),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success:function(data){
                // Process with the response data
            },
            error: function() {
                alert('FAILURE!');
            }
        })
    }); 

})
