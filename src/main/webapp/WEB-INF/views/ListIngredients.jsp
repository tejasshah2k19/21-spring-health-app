<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.statustrue {
	color: white;
	display: inline;
	width: auto;
	background-color: green;
	border-radius: 5px;
	padding: 5px
}
.statusfalse{
	color: white;
	display: inline;
	width: auto;
	background-color: red;
	border-radius: 5px;
	padding: 5px

}

</style>
</head>
<body>
	<jsp:include page="adminLayout/AdminHeader.jsp"></jsp:include>
	<jsp:include page="adminLayout/AdminSideBar.jsp"></jsp:include>
	<div class="page-content">


		<div class="page-header">
			<div class="container-fluid">
				<h2 class="h5 no-margin-bottom">Ingredients</h2>
			</div>
		</div>

		<div class="container-fluid">
			<ul class="breadcrumb">
				<li class="breadcrumb-item"><a href="">Home</a></li>
				<li class="breadcrumb-item active">List</li>
			</ul>
		</div>


		<section class="no-padding-top no-padding-bottom">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8">
					<div class="block margin-bottom-sm">
						<div class="title">
							<strong>All Ingredients</strong> <span class=""
								style="float: right;"><a href="newingredient">NewIngredient</a></span>

						</div>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Source</th>
										<th>Description</th>
										<th>NotConsumeBy</th>
										<th>IsActive</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${allIngredients}" var="ig">

										<tr>
											<th scope="row">${ig.ingredientsId }</th>
											<td>${ig.name }</td>
											<td>${ig.source }</td>
											<td>${ig.description }</td>
											<td>${ig.notConsumeBy }</td>
											<td><span class="status${ig.active==1 }">${ig.active==1 }</span></td>
										</tr>




									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>
		</section>



		<jsp:include page="adminLayout/AdminFooter.jsp"></jsp:include>
</body>
</html>