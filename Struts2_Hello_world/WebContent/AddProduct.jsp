<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scu Shopping Portal</title>
</head>
<body>
<h2>Add Product Page</h2>
<s:actionerror />
<s:form action="addProduct.action" method="post">
<s:textfield name="addTransport.productName" key="label.productName" size="20" maxlength="254" />
    <s:textfield name="addProductTransport.price" key="label.price" size="20" maxlength="254" />
    <s:textfield name="addProductTransport.productCategories" key="label.productCategories" size="20" maxlength="254" />
    <s:textfield name="addProductTransport.brand" key="label.brand" size="20" maxlength="254" />
    <s:textfield name="addProductTransport.categoryID" key="label.categoryID" size="20" maxlength="254" />
    
    <s:submit method="execute" key="label.addProduct" align="center" />
</s:form>
<s:if test="%{getResultList().isEmpty()}">
   No data to display
</s:if>
<s:else>

	<s:iterator value=“resultList">
   
            <s:property value="productName"/><br />
            <s:property value="productCategories"/><br />
            <s:property value="brand"/><br />
            <s:property value="price"/><br />
            <s:property value="popularity"/><br />
                    
       
    </s:iterator> 
  </s:else>
</body>
</html>

