/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').controller('LoginController', LoginControllerFn);

	LoginControllerFn.$inject = [ 'LoginService', '$window' ];

	// employee login controller function
	function LoginControllerFn(LoginService, $window) {
		var loginVm = this;

		// employee login function
		loginVm.employeeLogin = function() {

			LoginService
					.getEmployee(loginVm.employeeID)
					.then(
							function(data) {

								if (loginVm.employeePsw == data.o_title) {

									localStorage.setItem("user", JSON
											.stringify(data));

									var url = $window.location.origin
											+ '/hema-restaurant-api/employee-main.html';

									$window.location.href = url;

								}
							}, function(error) {
								console.log(error.status);
							});

			console.log(loginVm.employeeID);
		}
		// end of employee login

		// customer login
		loginVm.custLogin = function() {
			LoginService
					.getReservation(loginVm.customerID)
					.then(
							function(data) {

								if (loginVm.customerPsw == data.c_name) {

									localStorage.setItem("user", JSON
											.stringify(data));

									var url = $window.location.origin
											+ '/hema-restaurant-api/customer-main.html';

									$window.location.href = url;

								}
							}, function(error) {

							});

			console.log(loginVm.customerID);
		}
		// end of customer login
	}

})();