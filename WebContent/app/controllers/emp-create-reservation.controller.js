/**
 * 
 */
(function(){
	"use strict";
	
	angular.module('hemaApp').controller('EmpCreateResController', EmpCreateResFn);
	
	EmpCreateResFn.$inject = ['ReservationService', '$window'];
	
	function EmpCreateResFn(ReservationService, $window){
		
		var empVm = this;
		
		empVm.reservation = {};
		empVm.message = "";
		
		empVm.addReservation = function(){
			
			
			ReservationService.createReservation(empVm.reservation).then(function(response){
				
				var url = "http://localhost:8080/hema-restaurant-api/employee-menu.html";
				$window.location.href = url;
			},function(error){
				console.dir(error);
			});
		}
	}
	
	
})();