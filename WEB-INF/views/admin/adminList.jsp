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
<title>Admins List</title>
<jsp:include page="./adminBodyHeader.jsp"></jsp:include>
<script>

function myFunction(){
  var c=confirm("Are you Really want to delete! ");

  if(c==true){
	  return;
  }
  else
	  {
	  event.preventDefault();
	  }
 }

</script>
</head>
<%-- 
	<div class="jumbotron">
			<div class="container">
				<h1>Hospitals</h1>
				<p>All the available Admins</p>
				<a href="${pageContext.request.contextPath}/admin/addAdminPage" class="btn btn-primary">Add Admin</a> | 
    <a href="#" class="btn btn-primary">Search Admin</a>
			</div>
		</div>
	</section>
 --%>	
 <body>

	<%-- <section class="container">
	    
		<div class="row">
		<c:forEach items="${adminList}" var="ad">
			<div class="col-sm-6 col-md-3" style="paddingbottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<p>Name:</p><h1>${ad.fname}</h1>
						<p>Name:</p><h1>${ad.lname}</h1>
						<p>Email:<h6>${ad.email}</h6></p>
						<p>Mobile:<h6>${ad.mobile }</h6></p>
						<p>Status:<h6>${ad.status}</h6></p>
						
						<p>
							<a href="${pageContext.request.contextPath}/admin/editAdmin/${ad.id}" class="btn btn-primary" role="button">Edit</a>
							<a href="${pageContext.request.contextPath}/admin/deleteAdmin/${ad.id}" class="btn btn-danger" role="button" onclick="myFunction()">Delete</a>
						</p>
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
					<th>Email</th>
					<th>Mobile</th>
					<th>Status</th>
					<th colspan="2">Operations</th>
				</tr>
				<c:forEach items="${adminList}" var="ad">
				<tr>
					<td><c:out value="${ad.id}"></c:out></td>				
					<td><c:out value="${ad.lname} ${ad.fname}"></c:out></td>				
					<td><c:out value="${ad.email}"></c:out></td>				
					<td><c:out value="${ad.mobile}"></c:out></td>				
					<td><c:out value="${dad.status}"></c:out></td>				
					<td><a href="${pageContext.request.contextPath}/admin/editAdmin/${ad.id}" class="btn btn-primary" role="button"data-toggle="tooltip" title="Edit!"><i class="fa fa-edit">  Edit</a></td>
					<td><a href="${pageContext.request.contextPath}/admin/deleteAdmin/${ad.id}" class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash">  Delete</a></td>
					
				
				
				
				
				</tr>
				
				
				</c:forEach>
				</table>
				</div>
		
</body>
</html>