<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


<s:form action="saveingredient" modelAttribute="ingredient">

	Name: <s:input path="name"/><s:errors path="name"></s:errors><br>
	Description: <s:textarea path="description"/><s:errors path="description"></s:errors>
	<Br>
	Effects:<s:textarea path="effects"/><s:errors path="effects"></s:errors>
	<br>
	Source:<s:textarea path="source"/><br>
	NotConsumeBy: <s:textarea path="notConsumeBy"/><br>
	
	<input type="submit" value="Save">
</s:form>
</body>
</html>