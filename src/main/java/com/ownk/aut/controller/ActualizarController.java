package com.ownk.aut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ActualizarController {


	@Controller
	@RequestMapping("/actualizar")
	public class IndexController {

		  @RequestMapping(method = RequestMethod.GET)
		    public String getIndexPage() {
		        return "actualizar";
		    }

	}
}