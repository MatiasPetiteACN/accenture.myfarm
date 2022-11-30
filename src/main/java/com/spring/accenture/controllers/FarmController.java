package com.spring.accenture.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.accenture.entities.Farm;
import com.spring.accenture.service.FarmService;


@Controller
@RequestMapping("")
public class FarmController {
	
	@Autowired
	private FarmService farmService;
	

	//mapeo la pagina de bienvenida, donde se logeara el usuario a su cuenta
	//HTML: home
    @GetMapping(value="/")
    public String homePage(Model model) {
    	
        return "home";
    }
    
    //mapeo el menu principal de la granja seleccionada por el usuario, donde puede ver su billetera y acceder a sus datos y al servicio del mercado
    //HTML:farm
    @GetMapping(value="/farm")
    public String farmView(@RequestParam String farmID, Model model) {
    	//Falta:armar la logica para que los datos que aparezacn sean dependientes de la cuenta del usuario
    	     
        int nbrFarmID = Integer.valueOf(farmID);
        
		Farm theFarm = farmService.getFarmByID(nbrFarmID);
		
		String farmLocationName = theFarm.getStatus().getLocationID();
		String farmLocationSize = theFarm.getStatus().getSize();
		double farmLocationMoney = theFarm.getStatus().getMoney();
		int farmChickenCount = theFarm.getChickenList(1).size();
		int farmEggCount = theFarm.getChickenList(2).size();
		int farmCattleCount = theFarm.getStatus().getCattleCount();
        
		
		model.addAttribute("farmLocationName", farmLocationName);
		model.addAttribute("farmLocationSize", farmLocationSize);
		model.addAttribute("farmLocationMoney", farmLocationMoney);
		model.addAttribute("farmChickenCount", farmChickenCount);
		model.addAttribute("farmEggCount", farmEggCount);
		model.addAttribute("farmCattleCount", farmCattleCount);
    		
    	return "farm";
    	}
    
}

