package com.ownk.aut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ownk.aut.model.IngresoUsuarios;
@RestController
public class IngresoRestController {
	
	 @RequestMapping(value = "/ing/", method = RequestMethod.POST)
	    public ResponseEntity<List<IngresoUsuarios>> listAllUsers(@RequestBody IngresoUsuarios ingresoUsuario) {
	        List<IngresoUsuarios> ingresoUsuarios = new ArrayList<IngresoUsuarios>();
	        IngresoUsuarios metodo  = null;
	        GestionIngresoControllerDB gestionIngresoControllerDB = new GestionIngresoControllerDB();
	        	metodo = gestionIngresoControllerDB.ingresar(ingresoUsuario.getNickname(),ingresoUsuario.getContrasena());
				if (metodo!= null) {
					ingresoUsuarios.add(metodo);
				}
	        if(ingresoUsuarios.isEmpty()){
	            return new ResponseEntity<List<IngresoUsuarios>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<IngresoUsuarios>>(ingresoUsuarios, HttpStatus.OK);
	    }
	 

}
