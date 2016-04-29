<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scu Shopping Portal</title>
</head>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="ShippingDetails.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head>
<!-- Add css file -->
<style type="text/css">
@import url("ShippingDetails.css");
</style>
<body background="img/books.jpg">
<body>
	<h2>Add Shipping Details</h2>
	<s:actionerror />

	<td>
		<button type="button" id="logout">Logout</button>
	</td>
	<td>
		<button type="button" id="home">Home</button>
	</td>
	<s:form id="shipping-form" action="shippingAction.action" method="post">
		<table>
			<tr>
				<td><s:textfield name="shippingbean.deliverCity"
						key="label.deliverCity" size="20" /></td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.deliverStreet"
						key="label.deliverStreet" size="20" /></td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.deliverState"
						key="label.deliverState" size="20" /></td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.shippingId"
						key="label.shippingId" size="20" disabled='true' /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="button" id="add">Add</button></td>

			</tr>
		</table>

	</s:form>
</body>
</html>

