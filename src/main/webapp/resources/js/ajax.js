/**
 * Created by Carlos on 3/3/2016.
 */

function addFormReady() {
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var address = $('#address').val();
    if (firstName === "" || lastName === "" || address === "") {
        return false;
    }
    else {
        return true;
    }
}

$(document).ready(function () {

    $('#addBtn').click(function () {
        if (addFormReady()) {
            //var firstName = $('#addFirstName').val();
            //var lastName = $('#addLastName').val();
            //var address = $('#address').val();
            //$.ajax({
            //    type: 'POST',
            //    data: {
            //        firstName: firstName,
            //        lastName: lastName,
            //        address: address
            //    },
            //    url: 'Add',
            //    success: function (result) {
            //        $('#addMsg').html(result);
            //    }
            //})

            var details = $('#addEmployeeForm').serialize();

            $.post('Add', details)
                .done(function(data){
                    $('#addMsg').html(data);
                })
                .fail(function(){
                    alert("There was an error!");
                });
        }
    })

    $('#getBtn').click(function(){
        if(addFormReady()){

            var details = $('#getEmployeeForm').serialize();

            $.post('Get', details)
                .done(function(data){
                    alert("data = " + data);
                })
                .fail(function(){
                    alert("There was an error!");
                });
        }
    })
});