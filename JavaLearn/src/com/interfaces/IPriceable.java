package com.interfaces;

public interface IPriceable extends IDeliverable, IOrderable {   // We can extend multiple interfaces

	default int calcPrice() { // no need to implement default this method in each class
		return calcOrderPrice() + calcDeliverPrice();
	}
	
	static void doSmth() {
		
	}
}
