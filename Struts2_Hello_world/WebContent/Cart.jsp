<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>
</head>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="Cart.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<!-- Add css file -->
<style type="text/css">
@import url("Cart.css");
</style>
<body>
	<s:form id="cart-form" action="cart.action" method="post">
		<h2>Scu Shopping Portal : My College My Book Store!!</h2>
		<h2>
			Its Your Cart '
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
		<table border="1">
			<tr>
				<th>Select</th>
				<th>Name</th>
				<th>Product ID</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Total Price</th>


			</tr>
 			<s:if test="%{getCartList().isEmpty()}">
				<tr>
					<td colspan="3" align="center">No data to display</td>
				</tr>
			</s:if>
			<s:else>

				<s:set var="total" value="0"></s:set>

				<s:iterator value="cartList">
					<tr>
						<td><input type="checkbox" id="selectedIDs"
							name="selectedIDs" value='<s:property value="productId" />'></td>
						<td><s:property value="productName" /></td>
						<td><s:property value="productId" /></td>
						<td><s:property value="quantity" /></td>
						<td><s:property value="price" /></td>
						<td><s:property value="totalPrice" /></td>
					</tr>
					<s:set var="total" value="%{#total+getTotalPrice()}" />
				</s:iterator>
				<s:label name="total" value="%{#total}" label="Total" />
			</s:else>
		</table>

		<table>
			<tr>
				<td><button type="button" id="removeFromCart">Remove
						From Cart</button></td>

			</tr>
		</table>


		<table>
			<tr>

				<td>Add Delivery Details below:</td>
			</tr>
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
				<td><button type="button" id="checkout">Add Details
						and Check Out</button></td>

			</tr>
		</table>

	</s:form>
</body>
</html>
