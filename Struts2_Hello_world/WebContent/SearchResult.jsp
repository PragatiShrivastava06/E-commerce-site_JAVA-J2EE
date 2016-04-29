<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="SearchResult.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head>
<!-- Add css file -->
<style type="text/css">
@import url("SearchResult.css");
</style>
<body background="img/books.jpg">

	<s:form id="search-form" action="search.action" method="post">
		<table border="0" width="100%">
			<tr>
				<td>
					<h2>Search Page</h2>
				</td>
				<td>
					<button type="button" id="logout">Logout</button>

				</td>
			</tr>
		</table>


		<s:actionerror />
		<h2>
			Welcome
			<s:property value="userId" />
			...!
			<s:hidden name="userId"></s:hidden>
			<s:hidden name="admin"></s:hidden>

		</h2>

		<table>
			<tr class="feildgroup">
				<td><s:textfield name="searchTransport.productName"
						key="label.productName" size="20" /></td>
				<s:if test="%{isAdmin()}">
					<td><s:textfield name="searchTransport.productID"
							key="label.productID" type="number"
							onkeypress="return isNumericValue(event)" size="20" /></td>
				</s:if>
			</tr>
			<tr class="feildgroup">
				<td><s:textfield name="searchTransport.priceFrom"
						key="label.priceFrom" type="number"
						onkeypress="return isNumericValue(event)" size="20" /></td>
				<td><s:textfield type="number"
						onkeypress="return isNumericValue(event)"
						name="searchTransport.priceTo" key="label.priceTo" size="20" /></td>
			</tr>
			<tr class="feildgroup">
				<td><s:textfield name="searchTransport.author"
						key="label.author" size="20" /></td>
			</tr>
		</table>
		<table border="0">
			<tr class="feildgroup">

				<td><button type="button" id="search">Search</button></td>
				<td><button type="button" id="addToCart">Add to Cart</button></td>
			</tr>
			<tr>
				<td><a
					href='showCart.action?userId=<s:property value="userId" />'>Show
						My Cart</a></td>
				<td><a
					href='showOrder.action?userId=<s:property value="userId" />'>Show
						My Orders</a></td>
			</tr>
			<tr>
				<s:if test="%{isAdmin()}">
					<td><a
						href='showInventory.action?userId=<s:property value="userId" />'>Show
							All Inventories</a></td>
					<td><a
						href='addUserByAdmin.action?userId=<s:property value="userId" />'>
							Register New User </a></td>
					<td><a
						href='showReport.action?userId=<s:property value="userId" />'>
							Show Report </a></td>
				</s:if>
			</tr>
			<tr>
				<s:if test="%{isAdmin()}">
					<td><button type="button" id="add">Add</button></td>
					<td><button type="button" id="delete">Delete</button></td>
				</s:if>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<table border="1">
						<tr>
							<td colspan="6">Search Results</td>
						</tr>
						<tr>
							<th>Select</th>
							<s:if test="%{isAdmin()}">
								<th>Id</th>
							</s:if>
							<th>Name</th>
							<th>Price</th>
							<th>Author</th>
						</tr>
						<s:if test="%{getResultList().isEmpty()}">
							<tr>
								<td colspan="6" align="center">No data to display</td>
							</tr>
						</s:if>
						<s:else>

							<s:iterator value="resultList">
								<tr>
									<td><input type="checkbox" id="selectID" name="productIds"
										value='<s:property value="productID" />'></td>
									<s:if test="%{isAdmin()}">
										<td><a
											href='editProduct.action?ProductID=<s:property value="productID" />&userId=<s:property value="userId" />'><s:property
													value="productID" /></a></td>
									</s:if>
									<td><a
										href='editProduct.action?ProductID=<s:property value="productID" />&userId=<s:property value="userId" />'><s:property
												value="productName" /></a></td>
									<td><s:property value="price" /></td>
									<td><s:property value="Author" /></td>
								</tr>
							</s:iterator>

						</s:else>
					</table>
				</td>
			</tr>

			<tr>
				<td><s:if test="%{isAdmin()}">
					</s:if> <s:else>
						<s:if test="%{getViewdList().isEmpty()}">
						</s:if>
						<s:else>
							<table border="1">
								<tr>
									<td colspan="6">Recently Viewed Products</td>
								</tr>
								<tr>
									<th>Select</th>
									<th>Name</th>
									<th>Price</th>
									<th>Author</th>
								</tr>
								<s:iterator value="viewedList">
									<tr>
										<td><input type="checkbox" id="selectID"
											name="productIds" value='<s:property value="productID" />'></td>
										<td><a
											href='editProduct.action?ProductID=<s:property value="productID" />&userId=<s:property value="userId" />'><s:property
													value="productName" /></a></td>
										<td><s:property value="price" /></td>
										<td><s:property value="Author" /></td>

									</tr>
								</s:iterator>
							</table>
						</s:else>
					</s:else></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
