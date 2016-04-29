<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="InventoryProductManagement.js"></script>

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
	<s:form id="cart-form" action="inventoryproductmanagementaction.action"
		method="post">
		<h2>Scu Shopping Portal : My College My Book Store!!</h2>
		<h2>
			Its Your Inventory Detail '
			<s:property value="userId" />
			' Happy Admin!
			<s:hidden name="userId"></s:hidden>
			<s:hidden name="inventoryId"></s:hidden>
			<s:hidden name="admin"></s:hidden>
		</h2>
		<td>
			<button type="button" id="logout">Logout</button>
		</td>
		<td>
			<button type="button" id="home">Home</button>
		</td>
		<s:actionerror />
		<table border="0">
			<tr>
				<th>Select</th>
				<th>Product Id</th>
				<th>Quantity</th>

			</tr>
			<s:if test="%{getInvProList().isEmpty()}">
				<tr>
					<td colspan="3" align="center">No data to display</td>
				</tr>
			</s:if>
			<s:else>

				<s:iterator value="invProList">
					<tr class="feildgroup">
						<td><input type="checkbox" id="selectedIDs"
							name="selectedIDs" value='<s:property value="productId" />'></td>
						<td><a
							href='editQuantity.action?inventoryId=<s:property value="inventoryId"/>&productId=<s:property value="productId" />&userId=<s:property value="userId" />'><s:property
									value="productId" /></a></td>


						<td><s:property value="productQuantity" /></td>

					</tr>
				</s:iterator>

			</s:else>

			<tr>
				<td><button type="button" id="deleteProduct">Delete</button></td>
				<td><button type="button" id="addNewProductQuant">Add
						New</button></td>
			</tr>
		</table>

	</s:form>
</body>
</html>
