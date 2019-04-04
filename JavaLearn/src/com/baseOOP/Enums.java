package com.baseOOP;



public enum Enums {
	
	HUGE("XL"), BIG("L"), MIDDLE("M"), VERY_SMALL("XS");
	
	Enums(String abbriviation){
		this.abbreviation = abbriviation;
	}
	
	private String abbreviation;
	
	public String getAbbreviation() {
		return abbreviation;
	}

	
	
	
}

