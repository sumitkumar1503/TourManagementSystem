package com.lc.service;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lc.dao.PackageDAO;
import com.lc.entity.Packages;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	PackageDAO packageDAO;
	@Autowired
	ServletContext sc;
	
	@Override
	public List<Packages> getAllPackages() {
		return packageDAO.getAllPackages();
	}

	@Override
	public String addPackages(com.lc.model.Packages packages) {
		String filename= packages.getPosterImage().getOriginalFilename();
		String path="/resources/images/"+filename;
		
		Packages pack= new Packages();
		pack.setPackageName(packages.getPackageName());
		pack.setDescription(packages.getDescription());
		pack.setFood(packages.getFood());
		pack.setNumberOfDays(packages.getNumberOfDays());
		pack.setTotalPrice(packages.getTotalPrice());
		pack.setTransportation(packages.getTransportation());
		pack.setPosterImagePath(path);
		
		int result = packageDAO.addPackage(pack);
		if(result==1) {
			return "Package Added successfully ! Add Another ";
		}else {
			return "Package Not Added";
		}
		
	}

	@Override
	public String deletePackage(Integer id) {
		int result = packageDAO.deletePackage(id);
		if(result==1) {
			return "Package Deleted successfully";
		}else {
			return "Package Not Deleted";
		}
	}

	

	@Override
	public com.lc.model.Packages getPackage(Integer id) {
		Packages entitypack=packageDAO.getPackage(id);
		com.lc.model.Packages modelPack=null;
		if(entitypack != null) {
			//converting entity to model
			modelPack = new com.lc.model.Packages();
			modelPack.setPackageName(entitypack.getPackageName());
			modelPack.setDescription(entitypack.getDescription());
			modelPack.setFood(entitypack.getFood());
			modelPack.setNumberOfDays(entitypack.getNumberOfDays());
			modelPack.setTotalPrice(entitypack.getTotalPrice());
			modelPack.setTransportation(entitypack.getTransportation());
			
			return modelPack;
		}else {
			System.out.println("no package found with this id");
			return modelPack;
		}
		
		
	}

	@Override
	public String editPackage(com.lc.model.Packages packages, Integer id) {
		Packages pack= new Packages();
		
		// required is equal to false for image while editing.. so if someone does not choosen any pic then we will not update image
		//we will use existing one
		MultipartFile file= packages.getPosterImage();
		if(file.getSize() > 0) {
		String filename= packages.getPosterImage().getOriginalFilename();
		String path="/resources/images/"+filename;
		pack.setPosterImagePath(path);
		}
		
		pack.setId(id);
		pack.setPackageName(packages.getPackageName());
		pack.setDescription(packages.getDescription());
		pack.setFood(packages.getFood());
		pack.setNumberOfDays(packages.getNumberOfDays());
		pack.setTotalPrice(packages.getTotalPrice());
		pack.setTransportation(packages.getTransportation());
		
		
		
		
		int result = packageDAO.editPackage(pack,id);
		if(result==1) {
			return "Package updated successfully ! ";
		}else {
			return "Package Not Found";
		}
	}
	
}
