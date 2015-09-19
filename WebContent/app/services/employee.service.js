/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').service('ReservationService', RSFn);

	RSFn.$inject = [ '$q', '$http', '$window' ];

	function RSFn($q, $http, $window) {
		// Get list of reservations
		this.getAllReservations = function() {

			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/reservations";

			$http.get(url).then(function(response) {
				defer.resolve(response.data);

			}, function(error) {
				defer.reject(error.status);
			});

			return defer.promise;
		}
		// end of get list of reservations
		

		// delete a reservation
		this.deleteOneReservation = function(r_id) {

			var defer = $q.defer();
			var url = $window.location.origin
					+ '/hema-restaurant-api/api/reservations/' + r_id;

			$http.delete(url).then(function(response) {
				defer.resolve(response);
			}, function(error) {
				defer.reject(error);
			});
			return defer.promise;
		}
		// end of delete a reservation
		
		// create a reservation
		this.createReservation = function(reservation){
			
			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/reservations";
			
			$http.post(url,reservation).then(function(response){
				defer.resolve(response);
			},function(error){
				defer.reject(error);
			});
			return defer.promise;
			
		}
		// end of create a reservation
		
		// get list of customers
		this.getAllCustomers = function(){
			
			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/customers";
			
			$http.get(url).then(function(response){
				defer.resolve(response.data);
			}, function(error){
				defer.reject(error.status);
			});
			return defer.promise;
		}
		// end of list of customers
	}

})();