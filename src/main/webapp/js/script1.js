
function checkUsername() {
	$.ajax({
		url: 'checkusername.html',
		data: ({username : $('#username').val()}),
		success: function(data) {
			$('#errorusername').text(data);
		}
	});
}

function checkEmail() {
	$.ajax({
		url: 'checkemail.html',
		data: ({email : $('#email').val()}),
		success: function(data) {
			$('#erroremail').text(data);
		}
	});
	
}