package com.ownk.aut.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IngresoController {
	
	
	@Controller
	@RequestMapping("/ingreso")
	public class IndexController {

		  @RequestMapping(method = RequestMethod.GET)
		    public String getIndexPage() {
		        return "ingreso";
		    }

	}
	
}