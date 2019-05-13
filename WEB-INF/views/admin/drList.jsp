<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Dotcor List</title>
<jsp:include page="./docBodyHeader.jsp"></jsp:include>
</head>
<script>
	function myFunction() {
		var c = confirm("Are you Really want to delete! ");

		if (c == true) {
			return;
		} else {
			event.preventDefault();
		}
	}
</script>
<body>

	<%-- 
<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Doctors</h1>
				<p>All the available Doctors</p>
				<a href="${pageContext.request.contextPath}/doctor/addDoctorPage" class="btn btn-primary">Add Doctor</a> | 
    <a href="#" class="btn btn-primary">Search Doctor</a>
			</div>
		</div>
	</section>
	
 --%>
	<%-- <section class="container">
	    
		<div class="row">
		<c:forEach items="${drList}" var="dr">
			<div class="col-sm-6 col-md-3" style="paddingbottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<p>First Name:</p><h1>${dr.fname}</h1>
						<p>Last Name:</p><h1>${dr.lname}</h1>
						<p>Specialist:</p><h6>${dr.specialist}</h6>
						<p>Email:</p><h6>${dr.email}</h6>
						<p>Mobile:</p><h6>${dr.mobile}</h6>
						<p>Status:</p><h6>${dr.status}</h6>
						
						<p><a href="${pageContext.request.contextPath}/doctor/editDr/${dr.id}" class="btn btn-primary" role="button">Edit</a>
						 
						<a href="${pageContext.request.contextPath}/doctor/deleteDr/${dr.id}" class="btn btn-danger" role="button" onclick="myFunction()">Delete</a></p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		
	</section>
 --%>


	<section class="container">
	<div class="row">

		<table class="table table-striped table-hover">

			<div>
				<tr class="success">
					<th>S.No</th>
					<th>Name</th>
					<th>Specialist</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Status</th>
					<th colspan="2">Operations</th>
				</tr>
				</div>
				<c:forEach items="${drList}" var="dr">
				<tr>
					<td><c:out value="${dr.id}"></c:out></td>				
					<td><c:out value="${dr.lname} ${dr.fname}"></c:out></td>				
					<td><c:out value="${dr.specialist}"></c:out></td>				
					<td><c:out value="${dr.email}"></c:out></td>				
					<td><c:out value="${dr.mobile}"></c:out></td>				
					<td><c:out value="${dr.status}"></c:out></td>				
					<td><a href="${pageContext.request.contextPath}/admin/doctorMgmt/editDoctor/${dr.id}" class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
					<td><a href="${pageContext.request.contextPath}/admin/doctorMgmt/deleteDocotor/${dr.id}" class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
				</tr>
				
				
				</c:forEach>
				</table>
				</div>
			
			</section>
				
</body>
</html>