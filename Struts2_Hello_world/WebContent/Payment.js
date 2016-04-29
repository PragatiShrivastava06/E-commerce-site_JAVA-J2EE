$(document).ready(function() {
	$("#payAmount").click(function(){
		commonSubmit("payAmount");
	});
	$("#cancelTransection").click(function(){
		commonSubmit("cancelTransection");
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