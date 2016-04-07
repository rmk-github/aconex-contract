'use strict';

app.controller('ContractController', ['$scope', 'ContractService', function($scope, ContractService) {

          var self = this;

          $scope.contract = {
                          contractId : null,
                          contractCode : '',
                          contractDescription :'',
                          startDate :'',
                          endDate :'',
                          vendor :'',
                          projectId :'',
                          percentComplete :'',
                          contractStatus :'',
                          budget :'',
                          payment :'',
                          forecast :'',
                          committed :'',
                         };

          $scope.contracts=[];
              
          self.fetchAllContracts = function(){
              console.log("calling fetchAllContracts");
              ContractService.fetchAllContracts()
                  .then(
                       function(d) {
                            console.log("success");
                            console.log(d);
                            $scope.contracts = d;
                       },
                        function(errResponse){
                            console.error('Error while fetching Contracts');
                        }
      			    );
          };

          self.fetchAllContracts();

         self.updateContract = function(user, id){
              ContractService.updateContract(user, id)
		              .then(
                          $scope.fetchAllContracts,
                          function(errResponse){
                               console.error('Error while updating User.');
                          }
                        );
          };

          self.submit = function() {
              if ( $scope.contract.contractId == null){
                  console.log('No New Contract', $scope.contract);
              } else {
                  self.updateContract($scope.contract, $scope.contract.contractId);
                  console.log('Contract updated with id ', $scope.contract.contractId);
              }
              $scope.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < $scope.contracts.length; i++){
                  if($scope.contracts[i].contractId == id) {
                     $scope.contract = angular.copy($scope.contracts[i]);
                     break;
                  }
              }
          };
          
          self.reset = function() {
            $scope.contract={
                            contractId : null,
                            contractCode : '',
                            contractDescription :'',
                            startDate :'',
                            endDate :'',
                            vendor :'',
                            projectId :'',
                            percentComplete :'',
                            contractStatus :'',
                            budget :'',
                            payment :'',
                            forecast :'',
                            committed :'',
                            status :'',
                           };
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
