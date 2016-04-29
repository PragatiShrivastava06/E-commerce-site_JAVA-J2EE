<!DOCTYPE html>
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#button1').click(function() {
			var row = ($('#mySelect1 option:selected').val());
			var column = ($('#mySelect2 option:selected').val());
			var container = $("container");
			// Clear previous contents of the container
			$("#container").empty();
			for (i = 0; i < row; i++) {
				for (j = 0; j < column; j++) {
					// Create an <input> element, set its type and name attributes

					var textbox = document.createElement("input");
					textbox.type = "text";
					textbox.id = "cell" + i + j;
					//alert(textbox.id);
					$("#container").append(textbox);
				}
				// Append a line break 
				$("#container").append(document.createElement("br"));
			}
			$("#container").append(document.createElement("br"));

			var btn = $('<input/>').attr({
				type : "button",
				id : "button2",
				value : 'Create Table'
			//backgroundColor:'red'
			});
			$("#container").append(btn);

			$('#button2').click(function() {
				$('#outPutContainer').empty()
				mytable = $('<table border="1" bordercolor="red"></table>');

				var row = ($('#mySelect1 option:selected').val());
				var column = ($('#mySelect2 option:selected').val());
				for (var i = 0; i < row; i++) {
					var tablerow = $('<tr></tr>').appendTo(mytable);
					for (var j = 0; j < column; j++) {
						var tempId = "cell" + i + j;
						var tempValue = $('#cell' + i + j).val();
						$('<td></td>').text(tempValue).appendTo(tablerow);
					}
				}
				mytable.appendTo("#outPutContainer");
			});

		});
	});
</script>
</head>
<body>

	How many rows would you like?
	<select id="mySelect1">
		<option value="1">One</option>
		<option value="2">Two</option>
		<option value="3">Three</option>
		<option value="4">Four</option>
		<option value="5">Five</option>
		<option value="6">Six</option>
	</select>
	<br>
	<br> How many columns would you like?
	<select id="mySelect2">
		<option value="1">One</option>
		<option value="2">Two</option>
		<option value="3">Three</option>
		<option value="4">Four</option>
		<option value="5">Five</option>
		<option value="6">Six</option>
	</select>
	<br>
	<br>
	<input id="button1" type="button" value="Create" />

	<div id="container"></div>
	<div id="outPutContainer"></div>
</body>
</html>