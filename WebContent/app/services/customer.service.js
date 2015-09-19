/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').service('CustomerService', CustomerFn);

	CustomerFn.$inject = [ '$q', '$http' ];

	function CustomerFn($q, $http) {

		// get tables
		this.getTables = function() {

			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/seating";

			$http.get(url).then(function(response) {
				defer.resolve(response.data);
			}, function(error) {
				defer.reject(error.status);
			});
			return defer.promise;
		}
		// end of get tables

		// create reservation
		this.createReservation = function(reservation) {

			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/reservations";

			$http.post(url, reservation).then(function(data) {
				defer.resolve(data);
			}, function(error) {
				defer.reject(error.status);
			});
			return defer.promise;
		}
		// end create reservation

		// get a reservation
		this.getReservation = function() {
			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/reservations";

			$http.get(url).then(function(response) {
				defer.resolve(response.data);
				console.log('Hello from getReservation');
			}, function(error) {
				defer.reject(error.status);
			});

			return defer.promise;
		}
		// end of get a reservation
	}
})();