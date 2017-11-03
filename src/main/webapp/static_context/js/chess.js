
function colorizeBoard() {
	
	var table = $('#board');
	for (var i = 0; i < table.rows.length; i++) {
	  for (var j = 0; j < table.rows[i].cells.length; j = j + 2) {
	    table.rows[i].cells[((i + 1) % 2) + j].style.backgroundColor = 'black';
	  }
	}
	
}