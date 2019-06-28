var app = angular.module("app",[]);

app.controller("controlador",function($scope, seleccionService){
	
	
	
	$scope.apellido = "Rivas";
	$scope.apellido = seleccionService.getAllDog();
	
	
	
});