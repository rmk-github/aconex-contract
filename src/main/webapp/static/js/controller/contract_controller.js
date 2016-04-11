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
                          committed :''
                         };

          $scope.contracts=[];
              
          $scope.fetchAllContracts = function(){
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

          $scope.fetchAllContracts();

         $scope.updateContract = function(contract) {
              console.log("Contract getting updated --> " + contract);
              ContractService.updateContract(contract, contract.contractId)
                  .then(
                     function(d) {
                          console.log("success");
                          console.log(d);
                          $scope.fetchAllContracts();
                     },
                      function(errResponse){
                           console.error('Error while updating Contract');
                      }
                    );
          };

          $scope.editContract = function(contract) {
            console.log('contract received ' + contract);

            $scope.contract={
                            contractId : contract.contractId,
                            contractCode : contract.contractCode,
                            contractDescription : contract.contractDescription,
                            startDate : contract.startDate,
                            endDate : contract.endDate,
                            vendor : contract.vendor,
                            projectId : contract.projectId,
                            percentComplete : contract.percentComplete,
                            contractStatus : contract.contractStatus,
                            budget : contract.budget,
                            payment : contract.payment,
                            forecast : contract.forecast,
                            committed : contract.committed
                           };
          };
          
          $scope.reset = function() {
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
                            committed :''
                           };
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
