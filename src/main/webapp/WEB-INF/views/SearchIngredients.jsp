<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function search1() {
		var data = document.form.search.value;
		console.log(data);

		var http = new XMLHttpRequest();
		var url = 'searchingredientsbynamejson';
		var params = 'search='+data;
		http.open('POST', url, true);

		//Send the proper header information along with the request
		http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

		http.onreadystatechange = function() {//Call a function when the state changes.
		    if(http.readyState == 4 && http.status == 200) {
		        console.log(http.responseText);
		        console.log(http.responseText[0]);
		        //json 
		        //loop 
		        //
		        
		    	
		    }
		}
		http.send(params);

	}
</script>
</head>
<body>
	<jsp:include page="adminLayout/AdminMenu.jsp"></jsp:include>

	<div class="container">


		<div class="row">
			<div class="col-md-6">
				<form action="searchingredientsbyname" name="form" method="post">
					Search : <input type="text" name="search" onkeyup="search1()" /> <input
						type="submit" value="search" />
				</form>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">

				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Source</th>
							<th>Active</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach items="${allIngredients}" var="in">
							<tr>
								<td>${in.ingredientsId}</td>
								<td>${in.name }</td>
								<td>${in.source }</td>
								<td>${in.active }</td>
								<td>Edit | <a href="deleteingredients/${in.ingredientsId}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>