/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp')
			.controller('EmpViewCustController', EmpViewCustFn);

	EmpViewCustFn.$inject = ['ReservationService'];

	function EmpViewCustFn(ReservationService) {

		var empVm = this;

		// get list of customers
		ReservationService.getAllCustomers().then(function(data) {
			empVm.allCustomers = data;
		}, function(error) {
			console.log(error.status);
		});
		//end of get list of customers
	}

})();