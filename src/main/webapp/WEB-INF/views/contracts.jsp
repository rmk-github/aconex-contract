<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="contractApp">
  <head>  
    <title>ACONEX CONTRACT MANAGEMENT</title>

     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body class="ng-cloak">
      <div class="panel panel-primary generic-container" ng-controller="ContractController as ctrl">
          <div class="panel-heading"><h3 class="panel-title">List of Contracts</h3></div>
            <div class="panel panel-body">
                  <table class="table">
                      <thead>
                          <tr>
                              <th>Contract ID</th>
                              <th>Contract Code</th>
                              <th>Description</th>
                              <th>Start Date</th>
                              <th>End Date</th>
                              <th>Vendor</th>
                              <th>Project</th>
                              <th>Percent Completed</th>
                              <th>Contract Status</th>
                              <th>Budget</th>
                              <th>Payment</th>
                              <th>Forecast</th>
                              <th>Committed</th>
                          </tr>
                      </thead>

                      <tbody>
                          <tr ng-repeat="c in contracts">
                              <td>{{ c.contractId }}</td>
                              <td>{{ c.contractCode }}</td>
                              <td>{{ c.contractDescription }}</td>
                              <td>{{ c.startDate }}</td>
                              <td>{{ c.endDate }}</td>
                              <td>{{ c.vendor }}</td>
                              <td>{{ c.projectId }}</td>
                              <td>{{ c.percentComplete }}</td>
                              <td>{{ c.contractStatus }}</td>
                              <td>{{ c.budget | currency }}</td>
                              <td>{{ c.payment | currency }}</td>
                              <td>{{ c.forecast | currency }}</td>
                              <td>{{ c.committed | currency }}</td>
                          </tr>
                      </tbody>
                  </table>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/contract_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/contract_controller.js' />"></script>
  </body>
</html>
