<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal : My college Book Stor!!!</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="SearchResult.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head></head>
<!-- Add css file -->
<style type="text/css">
@import url("Login.css");
</style>
<body background="img/books.jpg">
	<s:form id="login-form" action="login.action" method="post">
		<h2>Scu Shopping Portal : My College My Book Store!!</h2>
		<s:actionerror />
		<table>
			<tr>
				<td><s:textfield name="userId" key="label.userID" size="20" />
				</td>
			</tr>
			<tr>
				<td><s:password name="password" key="label.password" size="20" /></td>
			</tr>
			<tr>
				<td><s:submit method="execute" key="label.login" align="center" /></td>
			</tr>
			<tr>
				<td><a href='<s:url action="registration.action"></s:url>'>
						Register here </a></td>
			</tr>
			<tr>
				<td><a href='<s:url action="guestlogin.action"></s:url>'>
						Guest login </a></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
