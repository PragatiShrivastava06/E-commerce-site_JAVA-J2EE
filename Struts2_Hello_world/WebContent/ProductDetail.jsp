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
<script type="text/javascript" src="ProductDetail.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head>
<!-- Add css file -->
<style type="text/css">
@import url("ProductDetail.css");
</style>
<body background="img/books.jpg">
	<s:form id="product-form" action="productDetail.action" method="post">

		<s:if test="%{product.productID>0}">
			<h2>Book Detail Page</h2>
		</s:if>
		<s:elseif test="%{product.productID<=0}">
			<h2>Add Book Detail Page</h2>
		</s:elseif>
		<s:hidden name="userId"></s:hidden>
		<s:hidden name="admin"></s:hidden>
		<s:hidden name="product.productID"></s:hidden>
		<td>
			<button type="button" id="logout">Logout</button>
		</td>
		<td>
			<button type="button" id="home">Home</button>
		</td>
		<s:actionerror />
		<s:if test="%{isAdmin()}">
			<table>
				<tr>
					<td><s:textfield name="product.productName"
							key="label.productName" size="30" /></td>
				</tr>
				<tr>
					<td><s:textfield name="product.productID" disabled='true'
							key="label.productID" size="20" /></td>
				</tr>
				<tr>
					<td><s:textfield name="product.price" onkeypress="return isNumericValue(event)" key="label.price"
							size="20" /></td>
				</tr>
				<tr>
					<td><s:textfield name="product.author" key="label.author"
							size="20" /></td>
				</tr>
				<tr>
					<td><s:file name="destPath" label="Select a File to upload"
							size="40" /></td>
				</tr>



				<s:if test="%{product.productID<=0}">
					<s:submit method="execute" key="label.addProdcut" align="center" />
				</s:if>
				<s:elseif test="%{product.productID>0}">
				<img src="img/book<s:property value="productID" />.jpg">
					<s:submit method="updateProduct" key="label.updateProduct"
						align="center" />
				</s:elseif>
			</table>
		</s:if>
		<s:else>
			<table>
				<tr>
					<td><s:textfield name="product.productName"
							key="label.productName" disabled='true' size="20" /></td>
				</tr>
				<tr>
					<td><s:textfield name="product.productID" disabled='true'
							key="label.productID" size="20" /></td>

				</tr>
				<tr>
					<td><s:textfield name="product.price" key="label.price"
							size="20" disabled='true' /></td>
				</tr>
				<tr>
					<td><s:textfield name="product.author" key="label.author"
							size="20" disabled='true' /></td>
				</tr>
				<img src="img/book<s:property value="productID" />.jpg">
			</table>
		</s:else>
		<s:if test="%{product.productID>0}">
			<s:if test="%{getOrderId()>0 }">

				<table>
					<tr>
						<td><b>Please provide Product Feedback below:</b></td>
						<td width="100px"><s:textarea name="productFeedback.review"
								key="label.review" cols="40" rows="10" /></td>
						<s:select label="What's your Rating for this product"
							headerKey="-1" headerValue="Select Rating" list="ratingList"
							name="productFeedback.rating" />
					</tr>
					<tr>
						<td><button type="button" id="giveFeedback">Submit
								your feedback</button></td>
					</tr>
				</table>
			</s:if>
			<s:if test="%{getFeedbackList().isEmpty()}">
			</s:if>
			<s:else>
				<table border="1">
					<tr>
						<td colspan="6">Product feedback</td>
					</tr>
					<tr>
						<th>Rating</th>
						<th>Review</th>
					</tr>
					<s:iterator value="feedbackList">
						<tr>
							<td><s:property value="rating" /></td>
							<td><s:property value="review" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:else>
		</s:if>
	</s:form>
</body>
</html>
