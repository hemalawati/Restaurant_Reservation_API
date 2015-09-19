/**
 * 
 */
(function() {
	"use strict";

	angular.module('hemaApp').controller('CustTableController', CustTableFn);

	CustTableFn.$inject = ['CustomerService', 'DataService'];
	
	function CustTableFn(CustomerService, DataService){
		
		
		var custVm = this;
		
		custVm.userObject = JSON.parse(localStorage.getItem('user'));
		
		
		console.dir(custVm.userObject);
		
		//get a reservation
		CustomerService.getTables().then(function(data){
			custVm.allTables = data;
		},function(error){
			
		});
		
		//reservation button condition
		this.tableStatus = function(){
			if(custVm.allTables.t_status == "Reserved"){
				return true;
			}
			else {
				return false;
			}
		}
		//end of reservation button condition
		
		this.reserveTable = function(table){
			
			DataService.setReservation(table);
		}
		
	}
})();