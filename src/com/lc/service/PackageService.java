package com.lc.service;
import java.util.List;

import com.lc.entity.Packages;
public interface PackageService {

	public List<Packages> getAllPackages();
	public String addPackages(com.lc.model.Packages packages);
	public String deletePackage(Integer id);
	public com.lc.model.Packages getPackage(Integer id);
	public String editPackage(com.lc.model.Packages packages,Integer id);
}
