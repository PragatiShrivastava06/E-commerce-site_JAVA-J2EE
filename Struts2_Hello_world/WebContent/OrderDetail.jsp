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
		<table border="1">
			<tr>
				<th>Order Id</th>
				<th>Order Date</th>
				<th>Show details</th>
			</tr>
			<s:if test="%{getOrderList().isEmpty()}">
				<tr>
					<td colspan="3" align="center">No data to display</td>
				</tr>
			</s:if>
			<s:else>
				<s:iterator value="orderList">
					<tr>
						<td><s:property value="orderID" /></td>
						<td><s:property value="orderDate" /></td>
						<td><a
							href='showOrderDetails.action?orderId=<s:property value="orderID" />&userId=<s:property value="userId" />&shippingId=<s:property value="shippingId" />'>Show
								Detail</a></td>
					</tr>
				</s:iterator>
			</s:else>
		</table>

	</s:form>
</body>
</html>
