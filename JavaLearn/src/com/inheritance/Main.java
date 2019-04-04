package com.inheritance;

public class Main {
	public static void main(String[] args) {
		//Bus bus = new Bus("PAZ", "BUS", EngineType.GAS, 10);
		Auto busAuto = new Bus("PAZ", "AUTO", EngineType.GAS, 10);
		//Auto auto = new Auto("PAZ", "PAZ", EngineType.GAS, 10);
		Auto truck = new Truck("KAMAZ", "4320", EngineType.DIESEL, 10);
		Auto electric = new ElectricCar("TESLA", "3", EngineType.ELECTRIC, 3500, 5);

	//	runCar(bus);
		runCar(busAuto);
		runCar(truck);
		runCar(electric);
		
		//auto. We have an acces only to class Auto fields, not to Bus class
	//	auto1. Have an acces to methods of classe Auto, FuelAuto, Bus
		
		}

	private static void runCar(Auto auto){
		System.out.println(auto.getProducer() + " " + auto.getModel());
		auto.start();
		auto.stop();
//		if(auto instanceof Bus){
//			FuelAuto fAuto = (FuelAuto) auto; 
//			fAuto.fuelUp(50);}
//		
		auto.energize();
	
	}

}
