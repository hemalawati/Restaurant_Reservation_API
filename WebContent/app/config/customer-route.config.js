/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp', [ 'ui.bootstrap', 'ngRoute', 'ngMessages' ])
			.config(routeConfig);

	routeConfig.$inject = [ '$routeProvider' ];

	// route function
	function routeConfig($routeProvider) {

		$routeProvider
				.when(
						'/viewSeats',
						{
							templateUrl : 'app/templates/view-seating-customer.tmpl.html',
							controller : 'CustTableController',
							controllerAs : 'custVm'
						})
				.when(
						'/create',
						{
							templateUrl : 'app/templates/create-reservation-customer.tmpl.html',
							controller : 'CustReservationController',
							controllerAs : 'custVm'
						})
						.when('/reservation',{
							templateUrl : 'app/templates/view-reservation-customer.tmpl.html',
							controller : 'CustViewResController',
							controllerAs : 'custVm'
						})
						.otherwise({
					redirectTo : '/viewSeats'
				});

	}

})();