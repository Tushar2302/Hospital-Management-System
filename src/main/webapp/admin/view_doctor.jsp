<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.SpecialistDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/AllCSS.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">

			
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
					<p class="fs-2 text-center">Doctor Details</p>
					<table class="table">
					<thead>
					<tr>
					<th scope="col">Doctor Id</th>
					<th scope="col">DOB</th>
					<th scope="col">Qualification</th>
					<th scope="col">Specialist</th>
					<th scope="col">Email</th>
					<th scope="col">MobNo</th>
					</tr>
					</thead>
					<tbody>
					<% 
					DoctorDao dao2=new DoctorDao(DBConnect.getConn());
					List<Doctor> ls=dao2.getAllDoctor();
					for(Doctor d: ls)
					{%>
					<tr>
					<td><%=d.getId() %></td>
					<td><%=d.getDob() %></td>
					<td><%=d.getQualification() %></td>
					<td><%=d.getSpecialist() %></td>
					<td><%=d.getEmail() %></td>
					<td><%=d.getMobno() %></td>
					<td>
					<a href="edit_Doctor.jsp?id=<%=d.getId() %>" 
					class="btn btn-sm btn-primary">Edit</a>
					<a href="../deleteDoctor?id=<%=d.getId() %>"
					 class="btn btn-sm btn-danger">Delete</a>
					</td>
					</tr>
					<%}
					%>
					</tbody>
					
					</table>
					</div>
				</div>
			</div>

			
		</div>
	</div>
</body>
</html>