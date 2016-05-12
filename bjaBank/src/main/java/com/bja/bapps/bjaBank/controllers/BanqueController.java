package com.bja.bapps.bjaBank.controllers;

import org.apache.taglibs.standard.tag.common.xml.JSTLXPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bja.bapps.bjaBank.metier.IBanqueMetier;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "banque";
	}
}
