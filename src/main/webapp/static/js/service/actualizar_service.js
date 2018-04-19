/**
 * 
 */
'use strict';

angular.module('myApp').factory('ActualizarService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8089/JodaAutenticacion/act/';//end point.
//referencia todos los servicios en una variable
    var factory = {
    		actualizarUsuarios: actualizarUsuarios,
            
    };

    return factory;

    function actualizarUsuarios(userDto) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI,userDto)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error no se puede actualizar');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
    
   


}]);