/**
 * 
 */
(function() {

	"use strict";

	angular.module('hemaApp').service('DataService', DataFn);

	DataFn.$inject = ['$window' ];

	
	
	function DataFn($window) {
		var custVm = this;
		custVm.reservation = {};
		
		
		custVm.getReservation = function() {
			return custVm.reservation;
		}

		custVm.setReservation = function(reservation) {
			custVm.reservation = reservation;
			$window.location.href = "http://localhost:8080/hema-restaurant-api/customer-main.html#/create";
		}
	}

})();
