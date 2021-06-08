package com.example.gestionfacturation.enumeration;

public enum FactureStatut {
	Non_payée("Non payée"),
	Partiellement_payée("Partiellement payée"),
	Payée("Payée"),
	En_litige("En litige");
	
	private String name;
	FactureStatut(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
