package com.interfaces;

/**
 * @author Eduard Kutsenco
 *
 */
public class Pizza implements IPriceable {
	private String name;
	private int quantity;
	private int price;
	private Size size;

	public Pizza(String name, int quantity, int price, Size size) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.size = size;
	}

	@Override
	public int calcDeliverPrice() {
		if (size == Size.XL || quantity > 1)
			return 0;
		else
			return 7;
	}

	@Override
	public int calcOrderPrice() {
		IPriceable.doSmth(); //cannot override
		return (quantity * price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}