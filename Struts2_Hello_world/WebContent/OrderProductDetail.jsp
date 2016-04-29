<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="OrderDetail.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head></head>
<!-- Add css file -->
<style type="text/css">
@import url("Cart.css");
</style>
<body>
	<s:form id="cart-form" action="cart.action" method="post">
		<h2>Scu Shopping Portal : My College My Book Store!!</h2>
		<h2>
			Its Your Order '
			<s:property value="userId" />
			' Happy Shopping!
			<s:hidden name="userId"></s:hidden>
			<s:hidden name="admin"></s:hidden>
		</h2>

		<td>
			<button type="button" id="logout">Logout</button>
		</td>
		<td>
			<button type="button" id="home">Home</button>
		</td>

		<s:actionerror />
		
		<table>
			<tr>

				<td> Delivery Details below:</td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.deliverCity"
						key="label.deliverCity"  disabled='true' /></td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.deliverStreet"
						key="label.deliverStreet"  disabled='true' /></td>
			</tr>
			<tr>
				<td><s:textfield name="shippingbean.deliverState"
						key="label.deliverState"  disabled='true' /></td>
			</tr>
		</table>
		
		<table border="1">
			<tr>
				<th>Order Id</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Total Price</th>
			</tr>
			<s:if test="%{getOrderproductmapping().isEmpty()}">
				<tr>
					<td colspan="3" align="center">No data to display</td>
				</tr>
			</s:if>
			<s:else>
				<s:set var="total" value="0"></s:set>

				<s:iterator value="orderproductmapping">
					<tr>
						<td><s:property value="orderId" /></td>
						<td><a
							href='editProduct.action?ProductID=<s:property value="productId" />&userId=<s:property value="userId" />&orderId=<s:property value="orderId" />'><s:property
									value="productName" /></a></td>
						<td><s:property value="quntity" /></td>
						<td><s:property value="totalPrice" /></td>
					</tr>
					<s:set var="total" value="%{#total+getTotalPrice()}" />
				</s:iterator>
				<s:label name="total" value="%{#total}" label="Total" />
			</s:else>
		</table>
	</s:form>
</body>
</html>
