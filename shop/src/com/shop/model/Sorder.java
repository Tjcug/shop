package com.shop.model;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */

public class Sorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Forder forder;
	private Product product;
	private String name;
	private Double price;
	private Integer number;

	// Constructors

	/** default constructor */
	public Sorder() {
	}

	/** minimal constructor */
	public Sorder(Integer number) {
		this.number = number;
	}

	/** full constructor */
	public Sorder(Forder forder, Product product, String name, Double price,
			Integer number) {
		this.forder = forder;
		this.product = product;
		this.name = name;
		this.price = price;
		this.number = number;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Forder getForder() {
		return this.forder;
	}

	public void setForder(Forder forder) {
		this.forder = forder;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Sorder [id=" + id + ", name=" + name + ", price=" + price
				+ ", number=" + number + "]";
	}

}