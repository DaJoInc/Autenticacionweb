/**
 * 
 */
'use strict';

angular.module('myApp').controller('ActualizarController', ['$scope', 'ActualizarService', function($scope, ActualizarService) {
    var variableGlobalJs = this;
    
    
    variableGlobalJs.userDto={nickname:null,contrasena:null,contrasenaNueva:null,codRespuesta:null,msgRespuesta:null};

    variableGlobalJs.submit = submit;
    variableGlobalJs.reset = reset;
    //registrarUsuario();
    //fetchAllUsers();
   
    function actualizarUsuario(userDto) {
    	ActualizarService.actualizarUsuarios(userDto)
            .then(
                function (respuestaServicio) {
                    variableGlobalJs.userDto = respuestaServicio;
                },
                function(errResponse){
                console.log('log while fetching Profile');
                }
            );
        
    }
  
    
    function submit(){
    	if(variableGlobalJs.userDto!=null){
    		
    		actualizarUsuario(variableGlobalJs.userDto);
    	}
    }
    
    function loadImage() {
    	alert("Hola prueba");
    }
    function reset(){
        $scope.myForm.$setPristine(); //reset Form
    }

}]);