<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Patient List</title>
<jsp:include page="patient/patBodyHeader.jsp"></jsp:include>

<script>

function myFunction(){
  var c=confirm("Do You Really want to delete!");

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
<body><%-- 
<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Patients</h1>
				<p>All Patiens</p>
				<a href="${pageContext.request.contextPath}/patient/addPatientPage" class="btn btn-primary">Add Patient</a> | 
    <a href="#" class="btn btn-primary">Search Patient</a>
			</div>
		</div>
	</section>
 --%>	
	<section class="container">
	    
		<div class="row">
		<c:forEach items="${patientList}" var="p">
			<div class="col-sm-6 col-md-3" style="paddingbottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<p>First Name:</p><h3>${p.fname}</h3>
						<p>Last Name:</p><h3>${p.lname}</h3>
						<p>Email:</p><h6>${p.email}</h6>
					 	<p>Mobile:</p><h6>${p.mobile}</h6>
						<p>Status:</p><h6>${p.status}</h6>
						<p><a href="${pageContext.request.contextPath}/patient/editPt/${p.id}" class="btn btn-primary" role="button">Edit</a>
						 
						<a href="${pageContext.request.contextPath}/patient/deletePt/${p.id}" class="btn btn-danger" role="button" onclick="myFunction()">Delete</a></p>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		
	</section>
	
</body>
</html>