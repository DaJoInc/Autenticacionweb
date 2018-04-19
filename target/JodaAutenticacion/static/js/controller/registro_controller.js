/**
 * 
 */
'use strict';

angular.module('myApp').controller('RegistroController', ['$scope', 'RegistroService', function($scope, RegistroService) {
    var variableGlobalJs = this;
    
    
    variableGlobalJs.userDto={idUsuario:null,nombre:null,apellidos:null,documento:null,tipoDocumento:null,correo:null,anoNacimiento:null,telefono:null,nickname:null,contrasena:null,idUsuarios:null,estado:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function registrarUsuario(userDto) {
        RegistroService.registrarUsuarios(userDto)
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
    	RegistroService.fetchAllUsers()
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
    		
    		registrarUsuario(variableGlobalJs.userDto);
    	}
    }
    
    function loadImage() {
    	alert("Hola prueba");
    }
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
