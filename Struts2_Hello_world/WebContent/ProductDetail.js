$(document).ready(function() {
	$("#giveFeedback").click(function(){
		commonSubmit("giveFeedback");
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
function isNumericValue(inevent){
    var charCode = (inevent.which) ? inevent.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}