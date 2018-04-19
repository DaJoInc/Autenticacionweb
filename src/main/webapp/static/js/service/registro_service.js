/**
 * 
 */
'use strict';

angular.module('myApp').factory('RegistroService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8089/JodaAutenticacion/registro/';//end point.
//referencia todos los servicios en una variable
    var factory = {
    		registrarUsuarios: registrarUsuarios,
            fetchAllUsers: fetchAllUsers
    };

    return factory;

    function registrarUsuarios(userDto) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI,userDto)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error no se puede registrar');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
    
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


}]);
