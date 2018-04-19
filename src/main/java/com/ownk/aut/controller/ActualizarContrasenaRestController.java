package com.ownk.aut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ownk.aut.model.ActualizarContrasena;

@RestController
public class ActualizarContrasenaRestController {
	 @RequestMapping(value = "/act/", method = RequestMethod.POST)
	    public ResponseEntity<List<ActualizarContrasena>> listAllUsers(@RequestBody ActualizarContrasena actualizarUsuario) {
	        List<ActualizarContrasena> actualizarUsuarios = new ArrayList<ActualizarContrasena>();
	        ActualizarContrasena metodo  = null;
	        GestionActualizarContrasenaControllerDB gestionActualizarControllerDB = new GestionActualizarContrasenaControllerDB();
	        	metodo = gestionActualizarControllerDB.actualizar(actualizarUsuario.getNickname(),actualizarUsuario.getContrasena(),actualizarUsuario.getContrasenaNueva());
				if (metodo!= null) {
					actualizarUsuarios.add(metodo);
				}

	        if(actualizarUsuarios.isEmpty()){
	            return new ResponseEntity<List<ActualizarContrasena>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<ActualizarContrasena>>(actualizarUsuarios, HttpStatus.OK);
	    }
	 
}
