package com.lc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Packages")
@DynamicUpdate
public class Packages {
	@Column(name="id")
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator = "gen1")
	Integer id;
	String packageName;
	String description;
	Integer numberOfDays;
	String food;
	String transportation;
	Double totalPrice;
	String posterImagePath;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getPosterImagePath() {
		return posterImagePath;
	}
	public void setPosterImagePath(String posterImagePath) {
		this.posterImagePath = posterImagePath;
	}
	@Override
	public String toString() {
		return "Packages [id=" + id + ", packageName=" + packageName + ", description=" + description
				+ ", numberOfDays=" + numberOfDays + ", food=" + food + ", transportation=" + transportation
				+ ", totalPrice=" + totalPrice + ", posterImagePath=" + posterImagePath + "]";
	}
	
	
	
	
}
