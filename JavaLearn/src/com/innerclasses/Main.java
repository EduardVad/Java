package com.innerclasses;

import com.innerclasses.Display.Color;


public class Main {

	public static void main(String[] args) {
		CellPhone phone = new CellPhone("Nokia", "3310");
		phone.turnOn();
		Display display = phone.getDisplay();
		//Pixel pixel = display.new Pixel(11, 1111, Color.YELLOW);  ------NON Static  Class
	//	Pixel pixel = new Pixel(11, 1111, Color.YELLOW);  

	}

}
