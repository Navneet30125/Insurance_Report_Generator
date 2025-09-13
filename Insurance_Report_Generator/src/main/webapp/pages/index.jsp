<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Insurance Report Generation Application</title>
</head>
<body>

	<div class="container">
		<h1>Report Application</h1>
		<form:form action="search" modelAttribute="search" method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-select-</form:option>
							<form:options items="${names}"></form:options>
						</form:select></td>

					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-select-</form:option>
							<form:options items="${status }"></form:options>
						</form:select></td>
					<td>Gender:</td>
					<%-- <td><form:radiobutton path="gender" value="Male" /> Male
					<form:radiobutton path="gender" value="Fe-Male" /> Fe-Male
					</td> --%>
					<td><form:select path="gender">
							<form:option value="">-select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>StartDate:</td>
					<td><form:input type="date" path="startDate" /></td>
					<td>EndDate:</td>
					<td><form:input type="date" path="endDate" /></td>
				</tr>
				<tr>
				<td><a href="/" class="btn btn-secondary">Reset</a></td>
					<td><input type="submit" value="Search"
						class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>
		<hr />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.gender}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benefitAmount}</td>
					</tr>
				</c:forEach>
				<tr>
				<c:if test="${empty plans}">
				<td colspan="8" style="text-align:center">No Records Found</td>
				</c:if>
				</tr>
			</tbody>
		</table>
		<hr />
		<p class="text-success">${msg}</p>
		Export: <a href="excel">Excel</a>&nbsp; &nbsp; &nbsp;  <a href="pdf">Pdf</a>
		
	</div>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>