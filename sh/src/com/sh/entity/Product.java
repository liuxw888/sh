package com.sh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private String listimg;
	private Integer price;
	private Integer producttypeid;
	private String color;
	private Integer hhot;
	private Integer nnew;
	public Integer getNnew() {
		return nnew;
	}
	public void setNnew(Integer nnew) {
		this.nnew = nnew;
	}
	public Integer getHhot() {
		return hhot;
	}
	public void setHhot(Integer hhot) {
		this.hhot = hhot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getListimg() {
		return listimg;
	}
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getProducttypeid() {
		return producttypeid;
	}
	public void setProducttypeid(Integer producttypeid) {
		this.producttypeid = producttypeid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
