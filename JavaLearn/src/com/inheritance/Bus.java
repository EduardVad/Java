package com.inheritance;

public class Bus extends FuelAuto {

	

	public Bus(String producer, String model, EngineType engineType, int passegerNumber) {
		super(producer, model, engineType);
		this.passegerNumber = passegerNumber;
		System.out.println("Class Bus initialized");
	}

	private int passegerNumber;

	public int getPassegerNumber() {
		return passegerNumber;
	} 

	public void setPassegerNumber(int passegerNumber) {
		this.passegerNumber = passegerNumber;
	}
	
public void pickPassengers(int passenger){
	this.passegerNumber+=passenger;
	System.out.println("Picking Up passengers");
}
	
public void dropPassengers(){
	if(isRunning)
		stop();
	  this.passegerNumber = 0;
	  System.out.println("Droping passengers ...");
    }


public void fuelUp(){ // overloading
	int volume = getTankVolume() - getGasAvailable();
	fuelUp(volume); 
	System.out.println("Adding a bus fuel...");
   }



@Override
public void energize() {
		fuelUp(getTankVolume() - getGasAvailable());
		}
	
    
}
