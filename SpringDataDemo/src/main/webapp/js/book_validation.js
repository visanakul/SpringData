function bookFormValidate() {
	//debugger;
	console.log('Hello');
	var validator = $('#bookForm').validate({
		rules : {

			"name" : {
				required : true,
				minlength : 3,
			},
			"price" : {
				required : true,
				number:true
			},
			"author" : {
				required : true,
				minlength : 3
			}
		},
		errorElement : "span",
		messages : {
			"name" : {
				required : "Book name is required!",
				minlength : "Book name must be at least 3 characters long"
			},
			"price": {
				required : "Book price is required!",
				number : "Please enter only digits"
			},
			"author" : {
				required : "Author name is required!",
				minlength : "Author name must be at least 3 characters long"
			}
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element);
		}
	});

}

