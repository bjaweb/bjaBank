package com.bja.bapps.bjaBank.controllers;

import javax.validation.Valid;

import org.apache.taglibs.standard.tag.common.xml.JSTLXPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bja.bapps.bjaBank.entities.Compte;
import com.bja.bapps.bjaBank.metier.IBanqueMetier;
import com.bja.bapps.bjaBank.models.BanqueForm;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value="/index") // quand on tape url/index
	public String index(Model model){
		model.addAttribute("banqueForm",new BanqueForm()); /// quand je cree la vue va etre stockée dnas banqueForm
		// retour du nom de la vue
		return "banque";
	}
	

//	@RequestMapping(value="/chargerCompte") // quand on tape url/index
//	public String chargerCompte(BanqueForm bf,  Model model){ // les infos sont stocké dans bf
//		
//		try{
//		Compte cp = metier.consulterCompte(bf.getCode());
//		bf.setTypeCompte(cp.getClass().getSimpleName());
//		bf.setCompte(cp);
//		model.addAttribute("banqueForm",bf); /// quand je cree la vue va etre stockée dnas banqueForm
//		}catch(Exception e){
//			bf.setException(e.getMessage());
//		}
//		// retour du nom de la vue
//		return "banque";
//	}

	
	// 
	/**
	 * avec @valid on demande à spring de valider
	 * @param bf
	 * @param bindingResult : les erreurs seront chargées ds le binding : possibilité de les interpreter
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/chargerCompte") // quand on tape url/index
	public String chargerCompte(@Valid BanqueForm bf, BindingResult bindingResult,  Model model){ // les infos sont stocké dans bf
		
		// si il existe des erreurs on ne fait pas appel au couches inf
		if(bindingResult.hasErrors()){
			return "banque";
		}
		
		try{
		Compte cp = metier.consulterCompte(bf.getCode());
		bf.setTypeCompte(cp.getClass().getSimpleName());
		bf.setCompte(cp);
		model.addAttribute("banqueForm",bf); /// quand je cree la vue va etre stockée dnas banqueForm
		}catch(Exception e){
			bf.setException(e.getMessage());
		}
		// retour du nom de la vue
		return "banque";
	}
	
	
}
