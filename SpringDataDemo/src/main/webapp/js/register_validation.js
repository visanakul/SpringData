$( function() {
    $( "#datepicker" ).datepicker(
    							  { 
    							    changeYear: true, 
    					            changeMonth: true,
    							    yearRange:'-60:+0'
    							  }
    							);
  } );
function regFormValidate(){
debugger;
	console.log('Hello');
	var validator=$('#regForm').validate({
		rules:{
			"fname" : {
                required: true,
                minlength: 3,
                maxlength: 40
            },
			"lname" : {
                required: true,
                minlength: 3,
                maxlength: 40
            },
			"email" : {
                required: true,
                email: true,
                minlength: 6,
                maxlength: 40
            },
			"pass" : {
                required: true,
                minlength: 6,
                maxlength: 10
            },
            "cpass" : {
                required: true,
                equalTo: "#pass"
            },
			"gen" : {
                required: true
            },
			"mobile" : {
                required: true,
                number:true,
                minlength: 10,
                maxlength: 10
            },
			"role":{
                required: true
            },
            "dob":{
                required: true
            }
		},
		errorElement:"span",
		messages:{
			"fname" :{
                required: "first name is required!",
                minlength: "first name must be at least 3 characters long"
            },
			"lname" :{
                required: "last name is required!",
                minlength: "last name must be at least 3 characters long"
            },
			"email" :{
                required: "email is required!",
                minlength: "email must be at least 6 characters long"
            },
			"pass" :{
                required: "password is required!",
                minlength: "password must be at least 6 characters long"
            },
            "cpass" :{
                required: "Re-enter password!",
                equalTo: "Password must match"
            },
			"gen" :{
                required: "select gender!"
            },
			"mobile" :{
                required: "mobile is required!",
                minlength: "mobile must be 10 digit long"
            },
			"role":{
                required: "Role is required!"
            },
            "dob":{
                required: "Date of birth is required!"
            }
		},
		 errorPlacement: function(error, element) 
      {
        if (element.is(":radio")) 
        {
            error.appendTo(element.parents('.gen'));
        }
        else if(element.is(":checkbox")){
            error.appendTo(element.parents('.hobbies'));
        }
        else 
        { 
            error.insertAfter( element );
        }
        }
	});
	
	
}