'use strict';

app.factory('ContractService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllContracts: function() {
					return $http.get('http://localhost:8080/aconex/api/contracts/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching Contracts');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    updateContract: function(contract, contractId){
					return $http.put('http://localhost:8080/aconex/api/contracts/' + contractId, contract)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating Contract');
										return $q.reject(errResponse);
									}
							);
			},
		
	};

}]);
