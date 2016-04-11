<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="contractApp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Aconex Project Dashboard</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/static/css/dashboard.css' />" rel="stylesheet">
    <style>
        /* set row data font size */
        * {
           font-size: 12px;
           line-height: 1;
        }
        .row-data-margin {
            margin: 10px;
        }
    </style>
  </head>

  <body ng-app="contractApp" ng-controller="ContractController as ctrl">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project Venetian</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Contracts</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Contracts </span></div>

    <div  class="row-data-margin">
      <div class="row">
        <div class="col-sm-12">
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                  <tr>
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
                      <td>{{ c.contractCode }}</td>
                      <td>{{ c.contractDescription }}</td>
                      <td>{{ c.startDate | date:'fullDate' }}</td>
                      <td>{{ c.endDate }}</td>
                      <td>{{ c.vendor }}</td>
                      <td>{{ c.projectId }}</td>
                      <td>{{ c.percentComplete | number:2 }}</td>
                      <td>{{ c.contractStatus }}</td>
                      <td>{{ c.budget | currency }}</td>
                      <td>{{ c.payment | currency }}</td>
                      <td>{{ c.forecast | currency }}</td>
                      <td>{{ c.committed | currency }}</td>
                      <td>
                        <button type="button" ng-click="editContract(c)" class="btn btn-primary">Edit</button>
                      </td>
                  </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    </div>
    </div>


    <div class="panel panel-default">
         <div class="panel-heading"><span class="lead">Edit Contract</span></div>
          <div class="formcontainer">
              <form name="contractForm" class="form-horizontal">
                  <input type="hidden" ng-model="contract.contractId" />
                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="ccode">Name</label>
                          <div class="col-md-7">
                              <input type="text" ng-model="contract.contractCode" id="ccode" class="ccode form-control input-sm" placeholder="contract.contractCode" required ng-minlength="3"/>
                              <div class="has-error" ng-show="contractForm.$dirty">
                                  <span ng-show="contractForm.ccode.$error.required">This is a required field</span>
                                  <span ng-show="contractForm.ccode.$error.minlength">Minimum length required is 3</span>
                                  <span ng-show="contractForm.ccode.$invalid">This field is invalid </span>
                              </div>
                          </div>
                      </div>
                  </div>


                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="desc">Description</label>
                          <div class="col-md-7">
                              <input type="text" ng-model="contract.contractDescription" id="desc" class="form-control input-sm" placeholder="Description"/>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="status">Email</label>
                          <div class="col-md-7">
                              <input type="text" ng-model="contract.contractStatus" id="status" class="form-control input-sm" placeholder="Status" required/>
                              <div class="has-error" ng-show="contractForm.$dirty">
                                  <span ng-show="contractForm.email.$error.required">This is a required field</span>
                                  <span ng-show="contractForm.email.$invalid">This field is invalid </span>
                              </div>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="budget">Budget Amount</label>
                          <div class="col-md-7">
                              <input type="number" ng-model="contract.budget" id="budget" class="form-control input-sm" placeholder="Budget"/>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="payment">Payment Amount</label>
                          <div class="col-md-7">
                              <input type="number" ng-model="contract.payment" id="payment" class="form-control input-sm" placeholder="Payment"/>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="forecast">Budget Amount</label>
                          <div class="col-md-7">
                              <input type="number" ng-model="contract.forecast" id="budget" class="form-control input-sm" placeholder="Forecast"/>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-group col-md-12">
                          <label class="col-md-2 control-lable" for="committed">Committed Amount</label>
                          <div class="col-md-7">
                              <input type="number" ng-model="contract.committed" id="budget" class="form-control input-sm" placeholder="Committed"/>
                          </div>
                      </div>
                  </div>

                  <div class="row">
                      <div class="form-actions floatRight">
                          <button type="button" ng-click="updateContract(contract)" class="btn btn-primary">Update</button>
                          <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="contractForm.$pristine">Reset</button>
                      </div>
                  </div>
              </form>
          </div>
      </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/contract_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/contract_controller.js' />"></script>
  </body>
</html>
