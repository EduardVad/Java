package com.inheritance;

public class ElectricCar extends Auto{
	private int batteryVolume; 
	private int passengersCapacity;


	public ElectricCar(String producer, String model, EngineType engineType, int batteryVolume, int passengersCapacity) {
		super(producer, model, EngineType.ELECTRIC);
		this.batteryVolume = batteryVolume;
		this.passengersCapacity = passengersCapacity;
	}
	
	public void charge(){
		System.out.println("Battary is charging ...");
	}

	public int getBatteryVolume() {
		return batteryVolume;
	}

	public void setBatteryVolume(int batteryVolume) {
		this.batteryVolume = batteryVolume;
	}

	public int getPassengersCapacity() {
		return passengersCapacity;
	}

	public void setPassengersCapacity(int passengersCapacity) {
		this.passengersCapacity = passengersCapacity;
	}

	@Override
	public void energize() {
		charge();
	}
	
	

}
