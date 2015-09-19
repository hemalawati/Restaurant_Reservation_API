/**
 * 
 */
(function() {
	"use strict"
	angular.module('hemaApp')
			.controller('CustViewResController', CustViewResFn);

	CustViewResFn.$inject = [ 'CustomerService' ];

	function CustViewResFn(CustomerService) {
console.log('Hello from CustViewResController');
		var custVm = this;
		 custVm.reservations = {};
		 custVm.userObject = JSON.parse(localStorage.getItem("user"));
		 
		// get a reservation
		CustomerService.getReservation().then(function(data) {
			custVm.allReservations = data;
			console.dir(custVm.allReservations);
			for(custVm.reservation in custVm.allReservations){
				
				if(custVm.reservation.c_id == custVm.userObject.c_id){
					custVm.reservations.push(custVm.reservation);
				}
			}
			console.dir(custVm.reservations);
		}, function(error) {
			console.log(error.status);
		});
	}

})();