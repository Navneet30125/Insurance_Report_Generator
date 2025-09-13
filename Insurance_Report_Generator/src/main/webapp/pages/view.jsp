<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Insurance Report Generator</title>

    <!-- Bootstrap 4 CSS -->
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
        crossorigin="anonymous">

    <style>
        body {
            background-color: #f0f2f5;
        }
        .card {
            margin-top: 30px;
        }
        .form-title {
            font-size: 1.4rem;
            font-weight: bold;
        }
        .no-records {
            text-align: center;
            font-weight: bold;
            color: #dc3545;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Filter Form Card -->
    <div class="card">
        <div class="card-header bg-primary text-white">
            <div class="form-title">Search Insurance Plans</div>
        </div>
        <div class="card-body">
            <form:form action="search" modelAttribute="search" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="planName">Plan Name</label>
                        <form:select path="planName" cssClass="form-control" id="planName">
                            <form:option value="">- Select -</form:option>
                            <form:options items="${names}"/>
                        </form:select>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="planStatus">Plan Status</label>
                        <form:select path="planStatus" cssClass="form-control" id="planStatus">
                            <form:option value="">- Select -</form:option>
                            <form:options items="${status}"/>
                        </form:select>
                    </div>

                    <div class="form-group col-md-4">
                        <label for="gender">Gender</label>
                        <form:select path="gender" cssClass="form-control" id="gender">
                            <form:option value="">- Select -</form:option>
                            <form:option value="Male">Male</form:option>
                            <form:option value="Female">Female</form:option>
                        </form:select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="startDate">Start Date</label>
                        <form:input type="date" path="startDate" cssClass="form-control" id="startDate"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="endDate">End Date</label>
                        <form:input type="date" path="endDate" cssClass="form-control" id="endDate"/>
                    </div>
                </div>

                <div class="form-group text-right">
                    <a href="/" class="btn btn-secondary">Reset</a>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form:form>
        </div>
    </div>

    <!-- Results Card -->
    <div class="card mt-4">
        <div class="card-header bg-dark text-white">
            <h5 class="mb-0">Search Results</h5>
        </div>
        <div class="card-body p-0">
            <table class="table table-striped table-hover mb-0">
                <thead class="thead-light">
                    <tr>
                        <th>#</th>
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

                    <c:if test="${empty plans}">
                        <tr>
                            <td colspan="8" class="no-records">No Records Found</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Export and Message Section -->
    <div class="row mt-4">
        <div class="col-md-6">
            <strong>Export:</strong>
            <a href="excel" class="btn btn-outline-success btn-sm">Excel</a>
            <a href="pdf" class="btn btn-outline-danger btn-sm">PDF</a>
        </div>
        <div class="col-md-6 text-right">
            <p class="text-success font-weight-bold">${msg}</p>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
</body>
</html>
