
function saveStudent() {

    let id = $('#student_id').val();
    let name = $('#student_name').val();
    let email = $('#student_email').val();
    let phone = $('#student_phone').val();

    $.ajax({
        type: "POST",
        url: "/students/saveStudent",
        dataType: "json",
        data: {id: id, name: name, email: email, phone: phone},
        success: function (response) {
            console.log(response);
            let finalResponse = JSON.stringify(response);

            $('#responseDiv').html("Your response is: " + finalResponse);
        },
        error: function (response) {
            console.log(response);
        }
    });
}

function showStudents() {

    $.ajax({
        type: "GET",
        url: "/students/showStudents",
        dataType: "json",
        success: function (response) {
            console.log(response);
            let finalResponse = JSON.stringify(response);

            $('#responseDiv').html("Your response is: " + finalResponse);
        },
        error: function (response) {
            console.log(response);
        }
    });
}