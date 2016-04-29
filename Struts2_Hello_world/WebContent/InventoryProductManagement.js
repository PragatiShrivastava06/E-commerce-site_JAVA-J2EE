$(document).ready(function() {
	$("#deleteProduct").click(function(){
		commonSubmit("deleteProductFromInv");
	});
	$("#addNewProductQuant").click(function(){
		commonSubmit("addNewProductQuant");
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
