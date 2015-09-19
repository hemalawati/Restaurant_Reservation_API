/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').service('LoginService', LoginService);

	LoginService.$inject=['$q', '$http', '$window'];

	function LoginService($q, $http, $window) {
		var self = this;
		
		//get employee
		self.getEmployee = function(id){
			var defer = $q.defer();

			var url = $window.location.origin
					+ '/hema-restaurant-api/api/owners/' + id;

			$http.get(url).then(function(response) {
				defer.resolve(response.data);

			}, function(error) {
				defer.reject(error.status);
			});

			return defer.promise;
		};
		//end of get employee
		
		// get a reservation
		this.getReservation = function(id) {
			var defer = $q.defer();
			var url = "http://localhost:8080/hema-restaurant-api/api/customers/" + id;

			$http.get(url).then(function(response) {
				defer.resolve(response.data);
			}, function(error) {
				defer.reject(error.status);
			});
			return defer.promise;
		}
		// end of get a reservation
	}
})();