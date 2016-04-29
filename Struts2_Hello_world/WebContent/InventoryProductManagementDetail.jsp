<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="InventoryProductManagementDetail.js"></script>

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

		<table>
			<tr>

			</tr>

			<s:if test="%{selectedMap.productId<=0}">
				<td><s:textfield name="selectedMap.productId"
						key="label.productId" size="20" /></td>
			</s:if>
			<s:elseif test="%{selectedMap.productId>0}">
				<td><s:textfield name="selectedMap.productId"
						key="label.productId" size="20" disabled='true' /></td>
				<s:hidden name="selectedMap.productId"></s:hidden>

			</s:elseif>


			<tr>
				<td><s:textfield name="selectedMap.inventoryId" disabled='true'
						key="label.inventoryId" size="20" /></td>
				<s:hidden name="selectedMap.inventoryId"></s:hidden>

			</tr>
			<tr>
				<td><s:textfield name="selectedMap.productQuantity"
						key="label.productQuantity" size="20" /></td>
			</tr>



			<s:if test="%{selectedMap.productId<=0}">
				<td align="center" colspan="2"><button type="button"
						id="insertInvPro">Add Product</button></td>
			</s:if>
			<s:elseif test="%{selectedMap.productId>0}">
				<td align="center" colspan="2"><button type="button"
						id="updateInvPro">Update Quantity</button></td>

			</s:elseif>
		</table>

	</s:form>
</body>
</html>
