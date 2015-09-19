/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').controller('CustReservationController',
			CustReservationFn);

	CustReservationFn.$inject = [ 'CustomerService', 'DataService' ];

	function CustReservationFn(CustomerService, DataService) {

		var custVm = this;
		custVm.reservation = {};
		custVm.table = DataService.getReservation();

		custVm.reservation.t_id = custVm.table;

		// creating a reservation
		this.addReservation = function() {

			CustomerService.createReservation(custVm.reservation).then(
					function(data) {

					}, function(error) {

					});
		}
		// end of creating a reservation

	}

})();