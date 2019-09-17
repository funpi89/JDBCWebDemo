<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>DataBase</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<center><h1>資料庫設計</h1></center>
		<center><h2>刪除資料</h2></center>
		<center>
			<div class="form-group col-md-6">
				<h3>其他功能</h3>
				<a href="/JDBCWeb/Employee"><button type="button">INSERT</button></a>
				<a href="/JDBCWeb/EmployeeUpdate"><button type="button">UPDATE</button></a>
				<a href="/JDBCWeb/EmployeeQuery"><button type="button">QUERY</button></a>
		</div>
		</center>
		<form method="post" action="EmployeeRemove">
			<div class="form-group col-md-6">
				<label for="example-text-input" class="col-2 col-form-label">Last name</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="lastname" placeholder="Last name">
				</div>
				
				<label for="example-text-input" class="col-2 col-form-label">First name</label>
				<div class="col-10">
					<input class="form-control" type="text" value="" name="firstname" placeholder="First name">
				</div>
				
				
				
				<div class="col-sm-">
					<button type="submit" class="btn btn-primary">刪除</button>
				</div>
			</div>
		</form>
		
		<table class="table table-hover table-responsive-sm">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Last Name</th>
					<th scope="col">First Name</th>
					<th scope="col">Birth Date</th>
				</tr>
			</thead>
			
			<tbody>
				<C:forEach var="employee" items="${requestScope.list}">
					<tr>
						<td scope="row">${employee[0]}</td>
						<td>${employee[1]}</td>
						<td>${employee[2]}</td>
						<td>${employee[3]}</td>
					</tr>
				</C:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>