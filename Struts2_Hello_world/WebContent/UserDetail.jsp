<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scu Shopping Portal</title>

<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="UserDetail.js"></script>

<script>
	function goBack() {
		window.history.back();
	}
</script>
<head>
<!-- Add css file -->
<style type="text/css">
@import url("UserDetail.css");
</style>
<body background="img/books.jpg">

	<s:form id="userDetail-form" action="userDetail.action" method="post">
		<h2>User Detail Page</h2>
		<s:actionerror />
		<table>
			<s:if test="%{isAdmin()}">
				<td>
					<button type="button" id="logout">Logout</button>
				</td>
				<td>
					<button type="button" id="home">Home</button>
				</td>
				<tr class="feildgroup">
					<td><s:checkbox name="user.admin" fieldValue="true"
							key="label.isAdmin" />
				</tr>
			</s:if>
			<tr class="feildgroup">
				<td><s:textfield name="user.userID" maxLength="50" id="userID"
						key="label.userID" size="20" /></td>
				<td><s:textfield name="user.userName" maxLength="50"
						id="userName" key="label.userName" size="20" /></td>
			</tr>
			<tr class="feildgroup">
				<td><s:password name="user.password" maxLength="50"
						id="password" key="label.password" size="20" /></td>
				<td><s:textfield name="user.emailID" maxLength="50"
						id="emailID" key="label.emailID" size="20" /></td>
			</tr>
			<tr class="feildgroup">
				<td><s:textfield name="user.phoneNumber"
						key="label.phoneNumber" id="phoneNumber" maxLength="10" size="20" /></td>
				<td><s:textfield name="user.mobileNumber"
						key="label.mobileNumber" id="mobileNumber" maxLength="10"
						size="20" /></td>
			</tr>
			<tr class="feildgroup">
				<td><s:textfield name="user.street" key="label.street"
						size="20" /></td>
				<td><s:textfield name="user.city" key="label.city"
						maxLength="50" size="20" /></td>
				<td><s:textfield name="user.state" key="label.state"
						maxLength="50" size="20" /></td>
			</tr>
			<tr class="feildgroup">
				<td colspan="2" align="center"><button type="button"
						id="saveUser" key="label.save">Save</button></td>
		</table>
	</s:form>
</body>
</html>

