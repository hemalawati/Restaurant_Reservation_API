/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').controller('EmpShowResController', EmpShowResFn);

	EmpShowResFn.$inject = [ '$scope', 'ReservationService', '$modal',
			'$window' ];

	function EmpShowResFn($scope, ReservationService, $modal, $window) {

		
		// get list of reservation
		$scope.getReservations = function() {

			ReservationService.getAllReservations().then(function(data) {
				$scope.allReservations = data;
				console.dir($scope.allReservations);
			}, function(error) {
				console.log(error.status);
			});
		};
		$scope.getReservations();
		// end of list of reservation

		// edit reservation
		$scope.editReservation = function(r_id) {

		}
		// end of edit reservation

		// modal
		$scope.open = function(r_id) {
			$scope.r_id = r_id;
			var modalInstance = $modal.open({

				animation : $scope.animationsEnabled,
				templateUrl : 'myModalContent.html',
				controller : 'EmpShowResController',
				scope : $scope,
				size : 'md'

			});

		};
		// end of modal

		// delete reservation
		$scope.remove = function(r_id) {
			ReservationService
					.deleteOneReservation(r_id)
					.then(
							function() {
								var url = "http://localhost:8080/hema-restaurant-api/employee-menu.html";
								$window.location.href = url;
							}, function() {

							});
		}
		// end of delete reservation
	}
})();