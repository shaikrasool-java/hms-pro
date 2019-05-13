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
<title>Hospital List</title>
<jsp:include page="hospital/hospBodyHeader.jsp"></jsp:include>

<script>

function myFunction(){
  var c=confirm("Do You Really want to delete! ");

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

<body>

	<%-- <section>
		<div class="jumbotron">
			<div class="container">
				<h1>Hospitals</h1>
				<p>All the available Hospitals</p>
				<a href="${pageContext.request.contextPath}/hospital/addHospitalPage" class="btn btn-primary">Add Hospital</a> | 
    <a href="#" class="btn btn-primary">Search Hospital</a>
			</div>
		</div>
	</section>
 --%>
	<!-- <div class="card">
  <h5 class="card-header">Hospitals List</h5>
  <div class="card-body">
    <h5 class="card-title">Hospitals</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Add Hospital</a> | 
    <a href="#" class="btn btn-primary">Search Hospital</a>
  </div>
</div> -->

	<%-- <section class="container">
	    
		<div class="row">
		<c:forEach items="${hospList}" var="hospBean">
			<div class="col-sm-6 col-md-3" style="paddingbottom: 15px">
				<div class="thumbnail-primary">
					<div class="caption">
						<p>Name:</p><h1>${hospBean.name}</h1>
						<p>Email:</p><h6>${hospBean.email}</h6>
						<p>Fax:</p><h6>${hospBean.fax}</h6>
						<p>Phone:</p><h6>${hospBean.phone}</h6>
						<p>Status:</p><h6>${hospBean.status}</h6>
						
						<p><a href="${pageContext.request.contextPath}/hospital/editHosp/${hospBean.hospId}" class="btn btn-primary" role="button">Edit</a>
							<a href="${pageContext.request.contextPath}/hospital/deleteHosp/${hospBean.hospId}" class="btn btn-danger" role="button" onclick="myFunction()">Delete</a></p> 
						 <a href=""  onclick="deleteHosp(${hospBean.hospId})" class="delete_link" role="button">Delete</a></p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		
	</section>
	 --%>

	<section class="container">
	<div class="row">
		
	<table  class="table table-striped table-hover">

		<div>
		<tr class="success">
		<th>S.No</th>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Fax</th>
		<th>Status</th>
		<th colspan="2">Operations</th>
		</tr>
		 <c:forEach items="${hospList}" var="hospBean">
	 <tr>
	 
		 <td><c:out value="${hospBean.hospId}"></c:out></td>
		 <td><c:out value="${hospBean.name}"></c:out></td>
		 <td><c:out value="${hospBean.email}"></c:out></td>
		 <td><c:out value="${hospBean.phone}"></c:out></td>
		 <td><c:out value="${hospBean.fax}"></c:out></td>
		 <td><c:out value="${hospBean.status}"></c:out></td>
		 <td><a href="${pageContext.request.contextPath}/hospital/editHosp/${hospBean.hospId}" class="btn btn-primary" role="button" data-toggle="tooltip" title="Edit!"><i class="fa fa-edit"> Edit</a></td>
	 	<td><a href="${pageContext.request.contextPath}/hospital/deleteHosp/${hospBean.hospId}" class="btn btn-danger" role="button" onclick="myFunction()" data-toggle="tooltip" title="Delete!"><i class="fa fa-trash"> Delete</a></td>
	 
	</tr>
			</c:forEach>
		</table>
	</div>
</section>
</body>
</html>