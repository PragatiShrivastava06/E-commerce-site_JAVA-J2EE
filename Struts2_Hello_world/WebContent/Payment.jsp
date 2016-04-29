<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="Payment.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head></head>
<!-- Add css file -->
<style type="text/css">
@import url("Payment.css");
</style>
<body>
	<s:form id="payment-form" action="payment.action" method="post">
		<h2>Scu Shopping Portal : My College My Book Store!!</h2>
		<h2>
			Its Your Credit card '
			<s:property value="userId" />
			' Happy Shopping!
			<s:hidden name="admin"></s:hidden>
			<s:hidden name="userId"></s:hidden>
			<s:hidden name="shippingId" />

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
				<td><s:textfield name="creditDetail.creditCardNumber"
						key="label.cardNumber" size="16" /></td>
				<td><s:textfield name="creditDetail.expiryDate"
						key="label.expiryDate" size="16" /></td>
				<td><s:textfield name="creditDetail.cvv" key="label.cardCVV"
						size="16" /></td>
				<td><s:textfield name="creditDetail.creditUserName"
						key="label.creditUserName" size="16" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><button type="button" id="payAmount">Pay</button></td>
				<td><button type="button" id="cancelTransection">Cancel</button></td>

			</tr>
		</table>
	</s:form>
</body>
</html>
