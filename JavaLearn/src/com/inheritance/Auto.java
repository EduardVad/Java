package com.inheritance;

public abstract class Auto {
	private String producer = "Mercedes";
	private String model = "A180";
	private EngineType engineType;
	private int currentSpeed;
	protected boolean isRunning;
	
	
	public Auto(String producer, String model, EngineType engineType) {
		this.producer = producer;
		this.model = model;
		this.engineType = engineType;
		System.out.println("class Auto has been initialized");
	}
	
	public abstract void energize();
	public static void doSmth() {   // Cannot override static method
		
	}

	public void start(){
		isRunning = true;
		currentSpeed = 10;
		System.out.println("Auto is starting ...");
			}
	
	public void stop(){
		isRunning = false;
		currentSpeed= 0;
		System.out.println("Auto is breaking ...");
			}
	
	public void accelerate(int kmPerHour){
		currentSpeed +=kmPerHour;
		System.out.println("Auto is accelerating ..." + currentSpeed + "km/h");
			}
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	
}
