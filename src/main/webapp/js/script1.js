
function checkUsername() {
	$.ajax({
		url: 'checkusername.html',
		data: ({username : $('#username').val()}),
		success: function(data) {
			$('#errorusername').text(data);
			if (data.trim() != "") {
				$("#ok").attr('disabled', true);
			} else {
				$("#ok").attr('disabled', false);
			}
		}
	});
}

function checkEmail() {
	$.ajax({
		url: 'checkemail.html',
		data: ({email : $('#email').val()}),
		success: function(data) {
			$('#erroremail').text(data);
			if (data.trim() != "") {
				$("#ok").attr('disabled', true);
			} else {
				$("#ok").attr('disabled', false);
			}
		}
	});
}

function checkOldPassword() {
	$.ajax({
		url: 'checkoldpassword.html',
		data: ({oldpassword : $('#oldpassword').val()}),
		success: function(data) {
			$('#erroroldpassword').text(data);
			if (data.trim() != "") {
				$("#ok").attr('disabled', true);
			} else {
				$("#ok").attr('disabled', false);
			}
		}
	});	
}

function clickCtrlEnter() {
	if ((event.keyCode == 10 || event.keyCode == 13) && event.ctrlKey) {
		$('form').submit();
	}
}

function confirmDeleting() {
	event.preventDefault();
	
	$('<div>Are you sure?</div>').dialog({
		modal: true,
		buttons: {
			"OK": function() {
				window.location = $('a[onclick]').attr('href');
			},
			"Cancel": function() {
                $(this).dialog("close");
            }
		}
	});
}
