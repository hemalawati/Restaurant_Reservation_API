/**
 * 
 */

(function() {
	"use strict";

	angular.module('hemaApp', [ 'ui.bootstrap', 'ngRoute', 'ngMessages','ngAnimate' ])
			.config(routeConfig);

	routeConfig.$inject = [ '$routeProvider' ];

	// route function
	function routeConfig($routeProvider) {

		$routeProvider
				.when(
						'/view',
						{
							templateUrl : 'app/templates/view-reservation-employee.tmpl.html',
							controller : 'EmpShowResController',
							controllerAs : 'empVm'
						})
				.when(
						'/create',
						{
							templateUrl : 'app/templates/create-reservation-employee.tmpl.html',
							controller : 'EmpCreateResController',
							controllerAs : 'empVm'
						})
						.when('/customersList',{
							templateUrl : 'app/templates/view-customer-employee.tmpl.html',
							controller : 'EmpViewCustController',
							controllerAs : 'empVm'
						})
						.otherwise({
					redirectTo : '/view'
				});

	}

})();