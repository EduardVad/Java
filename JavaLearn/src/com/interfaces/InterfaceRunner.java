package com.interfaces;

public class InterfaceRunner {

	public static void main(String[] args) {

		IPriceable pizza = new Pizza("Neapolitana", 1, 20, Size.S);
		IPriceable phone = new CellPhone("Nokia", "3310", 5, 35);
		IPriceable fridge = new Fridge("LG", "LUX", 3, 1000);

		printDeliverablePrice(pizza);
		printDeliverablePrice(phone);
		printDeliverablePrice(fridge);

	}

	private static void printDeliverablePrice(IPriceable deliverPrice) {
		System.out.println("Deliver price is " + deliverPrice.calcDeliverPrice());
		System.out.println("Order price is " + deliverPrice.calcOrderPrice());
	}

}
