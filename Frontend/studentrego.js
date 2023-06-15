$(document).ready(function(){
    $("button#getcontacts").click(function(){
        $.ajax({
            type: 'GET',
            url: 'http://localhost:9999/users',
            success: function(contactArray) {
                var contactsDiv = $('div#allContacts');
                //$("div#allContacts").html(result);
                //alert("result:" + contactArray);

                $.each(contactArray, function(index, contact) {
                    var contactInfo = '<p>';
                   
                    contactInfo += 'Id: ' + contact.id +'<br>'
                    contactInfo += 'Name: ' + contact.name +'<br>';
                    contactInfo += 'Age: ' + contact.age+'<br>';
                    contactInfo += 'Mobileno: ' + contact.mobileno+'<br>';
                    contactInfo += 'Address: ' + contact.address+'<br>';
                    contactInfo += '<button type="delete" id="deletebutton" class="btn btn-danger">Delete</button>' ;
                    contactInfo += '<button type="update" id="update" class="btn btn-success">Update</button>' ;
                    contactInfo += '</p><hr>';
                
                    contactsDiv.append(contactInfo);
                })
            },
            error: function() {
                alert('FAILURE!');
            }
        })
    });    

})