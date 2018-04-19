/**
 * 
 */
'use strict';

angular.module('myApp').controller('IngresoController', ['$scope', 'IngresoService', function($scope, IngresoService) {
    var variableGlobalJs = this;
    
    
    variableGlobalJs.userDto={idUsuario:null,nickname:null,contrasena:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function ingresoUsuario(userDto) {
    	IngresoService.ingresoUsuarios(userDto)
            .then(
                function (respuestaServicio) {
                    variableGlobalJs.userDto = respuestaServicio;
                },
                function(errResponse){
                console.log('log while fetching Profile');
                }
            );
        
    }
    
    function fetchAllUsers(){
    	IngresoService.fetchAllUsers()
            .then(
            function(d) {
            	variableGlobalJs.userDto = d;
              	//window.alert(variableGlobalJs.userDto);
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    
    
    function submit(){
    	if(variableGlobalJs.userDto!=null){
    		
    		ingresoUsuario(variableGlobalJs.userDto);
    	}
    }
    
    function loadImage() {
    	alert("Hola prueba");
    }
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
