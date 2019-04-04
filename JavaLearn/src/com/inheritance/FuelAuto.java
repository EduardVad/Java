package com.inheritance;

public abstract class FuelAuto extends Auto {

	private int gasAvailable;
	private int tankVolume = 10;
	
	public FuelAuto(String producer, String model, EngineType engineType ) {
		super(producer, model, engineType);
		this.gasAvailable = gasAvailable;
		System.out.println("Class FuelAuto initialized");

	}

	public int getGasAvailable() {
		return gasAvailable;
	}

	public void setGasAvailable(int gasAvailable) {
		this.gasAvailable = gasAvailable;
	}

	public int getTankVolume() {
		return tankVolume;
	}

	public void setTankVolume(int tankVolume) {
		this.tankVolume = tankVolume;
	}
	
	
	public void fuelUp(int gasVolume) {
		gasAvailable+=gasVolume;
		System.out.println("Adding fuel " + gasAvailable);
	}
}
