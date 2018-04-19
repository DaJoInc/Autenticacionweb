package com.ownk.aut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "registro";
	    }
}
