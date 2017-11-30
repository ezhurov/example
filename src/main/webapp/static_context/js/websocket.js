var ping; 
var websocket;

jQuery(function ($) {
	
	function writeMessage(message) { 
		$('#chat').append(message + '\n');
	}
	
	$('#connect')
		.click(function doConnect() {
			websocket = new WebSocket("ws://localhost:8080/example/echoHandler");
			
			websocket.onopen = function(evt) {
				writeMessage("INFO: CONNECTED");
			};	

			websocket.onclose = function(evt) {
				writeMessage("INFO: DISCONNECTED"); 
			}; 
			
			websocket.onmessage = function(evt) {
				writeMessage('' + evt.data);	
			}; 
			
			websocket.onerror = function(evt) { 
				writeMessage('ERROR: ' + evt.data); 
			}
		}); 
	
	$('#disconnect')
		.click(function() { 
			if (typeof websocket != 'undefined') {
				websocket.close();
				window.location = "index.html";
			}
	}); 

	$('#send')
		.click(function() { 
			if(typeof websocket != 'undefined') { 
				websocket.send($('#message').val()); 
			} else {
				alert('Not connection');
			}	
		});
	
}) ; 
