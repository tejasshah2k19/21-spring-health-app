<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<div class="container">
		<div class="row">    
			<div class="col-md-4 mx-auto h-100">
				<s:form action="authenticate"  cssClass="align-center" method="post" modelAttribute="login">
					<div class="form-group">
						<label for="email">Email:</label>
						<s:input path="email" cssClass="form-control" id="email" />
						<s:errors path="email" cssClass="text-danger"></s:errors>
					</div>

					<div class="form-group">
						<label for="password">Password</label>
						<s:password path="password"  cssClass="form-control"/>
						<s:errors path="password" cssClass="text-danger">
						</s:errors>
					</div>

					<button type="submit" class="btn btn-primary" >Login</button>
				</s:form>
				<br> ${msg}

			</div>
		</div>
	</div>

</body>
</html>