
function locationTo(link) {
	window.location = link;
}

function clickCtrlEnter() {
	if ((event.keyCode == 10 || event.keyCode == 13) && event.ctrlKey) {
		$('form').submit();
	}
}

function confirmDialog() {
	event.preventDefault();
	
	var currentId = event.target.id;
	
	$('<div>' + areYouSure + '</div>').dialog({
		modal: true,
		buttons: {
			"OK": function() {
				window.location = $('#' + currentId).attr('href');
			},
			"Cancel": function() {
                $(this).dialog("close");
            }
		}
	});
}

function checkUsername() {
	$.ajax({
		url: 'check_username.html',
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
		url: 'check_email.html',
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
		url: 'check_old_password.html',
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

function liveSearchByHalfUsername() {
	var arrayUsers = [];
	
	$.ajax({
		url: 'get_users_by_half_username.html',
        contentType: "application/json",
        dataType: "json",
		data: ({username : $('#halfUsername').val()}),
		success: function(data) {
			for (var i = 0; i < data.length; i ++) {
				arrayUsers[arrayUsers.length] = data[i];
			}
		}
	});

	$("#halfUsername").autocomplete({
		source: arrayUsers,
		select: function(event, ui) {
			$.ajax({
				url: 'select_user_by_half_username.html',
		        contentType: "application/json",
		        dataType: "json",
				data: ({username : ui.item.value}),
				success: function(data) {
					$('#users').empty();
					$('#users').append('<tr>'
							+ '<td width="15%">' + data.username + '</td>'
							+ '<td width="15%">' + data.email + '</td>'
							+ '<td width="10%">' + data.role + '</td>'
							+ '<td width="5%">' + data.enabled + '</td>'
							+ '<td width="10%"> <a onclick="confirmDialog()" id="setasadminuser' + data.id + '" href="set_as_admin_user.html?username=' + data.username + '&role=' + data.role + '">' + setAsAdminUser + '</a> </td>'
							+ '<td width="10%"> <a onclick="confirmDialog()" id="lockunlockaccount' + data.id + '" href="lock_account_by_username.html?username=' + data.username + '&enabled=' + data.enabled + '">' + lockUnlockAccount + '</a> </td>'
							+ '<td width="10%"> <a onclick="confirmDialog()" id="deleteaccount' + data.id + '" href="delete_account_by_username.html?username=' + data.username + '">' + deleteAccount + '</a> </td>'
							+ '</tr>');
				}
			});
		}
	});
}
