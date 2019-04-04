package com.inheritance;

public class Truck extends FuelAuto{
	private int cargoWeight;
	

	public Truck(String producer, String model, EngineType engineType, int cargoWeight) {
		super(producer, model, engineType);
		this.cargoWeight = cargoWeight;
		System.out.println("Class truck initialized");
	}


	public int getCargoWeight() {
		return cargoWeight;
	}


	public void setCargoWeight(int cargoWeight) {
		this.cargoWeight = cargoWeight;
	}

	
	public void load(){
		System.out.println("Cargo is loading ...");
	}
	
	public void unload(){
		System.out.println("Cargo is unloading ...");
	}


	@Override
	public void energize() {
		fuelUp(getTankVolume() - getGasAvailable());
    }
}
