package com.ownk.aut.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ownk.aut.model.RegistroPersona;

@RestController
public class RegistroRestController {
	
	
    @RequestMapping(value = "/prueba/", method = RequestMethod.GET)
    public ResponseEntity<List<RegistroPersona>> listAllUsers(RegistroPersona registroPersona, UriComponentsBuilder ucBuilder) {
        List<RegistroPersona> registroPersonas = new ArrayList<RegistroPersona>();
        RegistroPersona metodo  = null;
        GestionRegistroControllerDB gestionRegistroControllerDB = new GestionRegistroControllerDB();
        //for (int i = 500; i < 600; i++) {
        	metodo = gestionRegistroControllerDB.registrar("Joan","Torres",new BigInteger("1236386"),"cc","correo@correo.com", null,new BigInteger("123638655554"),"zaqwsss" , "qwerty");
			if (metodo!= null) {
				registroPersonas.add(metodo);
			}
		//}

        if(registroPersonas.isEmpty()){
            return new ResponseEntity<List<RegistroPersona>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegistroPersona>>(registroPersonas,HttpStatus.OK);
    }


}
