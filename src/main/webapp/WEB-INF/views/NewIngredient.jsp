<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
				<li class="breadcrumb-item"><a href="dashboard">Home</a></li>
				<li class="breadcrumb-item active">New</li>
			</ul>
		</div>


		<section class="no-padding-top no-padding-bottom">
		<div class="container-fluid">
			<div class="row">


				<div class="col-lg-6">
					<div class="block">
						<div class="title">
							<strong class="d-block">New Ingredient</strong>
							<!-- <span class="d-block">Lorem
								ipsum dolor sit amet consectetur.</span> -->
						</div>
						<div class="block-body">
							<s:form action="saveingredient" modelAttribute="ingredient">

								<div class="form-group">
									<label class="form-control-label">Name</label>
									<s:input path="name" placeholder="name" class="form-control" />
									<s:errors path="name"></s:errors>

								</div>

								<div class="form-group">
									<label class="form-control-label">Description</label>
									<s:textarea path="description" placeholder="description"
										class="form-control" />
									<s:errors path="description"></s:errors>
								</div>

								<div class="form-group">
									<label class="form-control-label">Effects</label>
									<s:input path="effects" placeholder="effects"
										class="form-control" />
									<s:errors path="effects"></s:errors>

								</div>


								<div class="form-group">
									<label class="form-control-label">Source</label>
									<s:input path="source" placeholder="source" class="form-control" />
									<s:errors path="source"></s:errors>

								</div>

								<div class="form-group">
									<label class="form-control-label">NotConsumeBy</label>
									<s:textarea path="notConsumeBy" placeholder="notConsumeBy"
										class="form-control" />
									<s:errors path="notConsumeBy"></s:errors>
								</div>




								<div class="form-group">
									<input type="submit" value="Save Item" class="btn btn-primary">
								</div>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>



		<jsp:include page="adminLayout/AdminFooter.jsp"></jsp:include>
</body>
</html>