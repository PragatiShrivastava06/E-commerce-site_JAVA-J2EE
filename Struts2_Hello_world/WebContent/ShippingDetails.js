$(document).ready(function() {

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