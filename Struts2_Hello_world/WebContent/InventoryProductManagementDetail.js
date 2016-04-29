$(document).ready(function() {
	$("#insertInvPro").click(function(){
		commonSubmit("insertInvPro");
	});
	$("#updateInvPro").click(function(){
		commonSubmit("updateInvPro");
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
