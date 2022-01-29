package com.lc.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.lc.entity.Packages;
import com.lc.service.PackageService;



@Controller
public class PackageController {

	@Autowired
	PackageService packageService;
	@GetMapping("packages")
	public String show_package(Model model) {
		System.out.println(packageService.getAllPackages());
		
		/*
		 * List<Packages> packages= new ArrayList<Packages>();
		 * 
		 * for(Packages pack:packageService.getAllPackages()) { Packages p = new
		 * Packages(); p.setPackageName(pack.getPackageName()); packages.add(p); }
		 * for(Packages pack1:packages) { System.out.println(pack1); }
		 */
		
		//packageService.getAllPackages().forEach(pack-> packages.add(pack));
		
		model.addAttribute("packages",packageService.getAllPackages());
		return "packages";
	}
}
