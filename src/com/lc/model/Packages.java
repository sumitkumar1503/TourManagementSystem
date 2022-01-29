package com.lc.model;



import org.springframework.web.multipart.MultipartFile;

public class Packages {

	String packageName;
	String description;
	Integer numberOfDays;
	String food;
	String transportation;
	Double totalPrice;
	MultipartFile posterImage;
	
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public MultipartFile getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(MultipartFile posterImage) {
		this.posterImage = posterImage;
	}
	
	
}
