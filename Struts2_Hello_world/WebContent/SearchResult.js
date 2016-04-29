$(document).ready(function() {
	$("#search").click(function() {
		commonSubmit("searchProduct");
	});
	$("#add").click(function(){
		commonSubmit("addProduct");
	});
	$("#delete").click(function(){
		commonSubmit("deleteProduct");
	});
	$("#addToCart").click(function(){
		commonSubmit("addProductToCart");
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
	var fname = $("#uFirstName").val();
	if(fname.length == "" || fname.length <= 5 || fname.length == null)
		{
			alert("enter fname > 5");
		}
}
function isNumericValue(inevent){
    var charCode = (inevent.which) ? inevent.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}
