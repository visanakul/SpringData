function logFormValidate() {
	debugger;
	console.log('Hello');
	var validator = $('#logForm').validate({
		rules : {

			"email" : {
				required : true,
				email : true,
				minlength : 6,
				maxlength : 40
			},
			"pass" : {
				required : true,
				minlength : 6,
				maxlength : 10
			}
		},
		errorElement : "span",
		messages : {
			"email" : {
				required : "email is required!",
				minlength : "email must be at least 6 characters long"
			},
			"pass" : {
				required : "password is required!",
				minlength : "password must be at least 6 characters long"
			}
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element);
		}
	});

}