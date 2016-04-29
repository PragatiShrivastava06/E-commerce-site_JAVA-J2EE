$(document).ready(function() {
	$("#checkout").click(function(){
		commonSubmit("checkout");
	});
	$("#removeFromCart").click(function(){
		commonSubmit("removeFromCart");
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