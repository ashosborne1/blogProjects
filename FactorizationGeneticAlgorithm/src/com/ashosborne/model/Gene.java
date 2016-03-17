package com.ashosborne.model;

/**
 * Models an integer solution to the problem
 * @author Ashley Osborne
 *
 */
public class Gene {

	private String binaryForm;

	/**
	 * Return the binary form String in an int format
	 * @return The binary form string in int format
	 */
	public int getNumber(){
	    return Integer.parseInt(binaryForm,2);
	    
	}
	
	/**
	 * Gets the binary string representation of the number
	 * @return The binary form String
	 */
	public String getBinaryForm(){
		return this.binaryForm;
	}
	
	/**
	 * Set the binary string representation of the number
	 * @param binaryForm The binary form String
	 */
	public void setBinaryForm(String binaryForm){
		this.binaryForm = binaryForm;
	}
	
	public Gene(){
		
	}
	
	/**
	 * Create a Gene from a given binary form String
	 * @param binaryForm
	 */
	public Gene(String binaryForm){
		this.binaryForm = binaryForm;
	}

}