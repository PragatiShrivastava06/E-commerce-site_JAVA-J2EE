$(document).ready(function() {
	$("#saveUser").click(function(){
		var isValid = validate();
		commonSubmit("saveUser");
	});
	$("#logout").click(function(){
		commonSubmit("logout");
	});
	$("#home").click(function(){
		commonSubmit("search");
	});
});
function commonSubmit(x){
	$('form').attr('action',x + ".action");
	$('form').submit();
}
function validate(){
	var userName = $("#userName").val();
	var msg = "";
	var isValid = true;
	if(userName.length == "" || userName.length <= 0 || userName.length == null)
		{
			msg = "User Name is required. </br>";
		}
	
	
}
