package com.interfaces;

public abstract class Electronics implements IPriceable {
	private String make;
	private String model;
	private int quantity;
	private int price;

	public Electronics(String make, String model, int quantity, int price) {
		super();
		this.make = make;
		this.model = model;
		this.quantity = quantity;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int calcOrderPrice() {
		return getQuantity() * getPrice();
	}
}
