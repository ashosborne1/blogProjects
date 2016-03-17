package com.ashosborne.algorithm;

import java.util.Random;

import com.ashosborne.model.DNA;
import com.ashosborne.model.Gene;
import com.ashosborne.utils.Utils;

/**
 * Mutates a child DNA
 * @author Ashley Osborne
 *
 */
public class Mutator {

	private DNA individualToMutate;
	
	public Mutator(){
		
	}
	
	/**
	 * Construct a mutator for an individual
	 * @param individual The individual to mutate
	 */
	public Mutator(DNA individual){
		this.individualToMutate = individual;
	}
	
	/**
	 * Takes a particular gene and mutates it
	 * @param geneToMutate The gene to mutate
	 */
	private void mutateAGene(Gene geneToMutate){
		
		String binaryForm = geneToMutate.getBinaryForm();
		Random generator = new Random();
		int indexToFlip = generator.nextInt(binaryForm.length());
		
		if(binaryForm.charAt(indexToFlip) == '0'){
			StringBuilder mutation = new StringBuilder(binaryForm);
			mutation.setCharAt(indexToFlip, '1');
			geneToMutate.setBinaryForm(mutation.toString());
		}else{
			StringBuilder mutation = new StringBuilder(binaryForm);
			mutation.setCharAt(indexToFlip, '0');
			geneToMutate.setBinaryForm(mutation.toString());
		}
	}
	
	/**
	 * Mutate the individual
	 */
	public void mutate(){
		
			if(Utils.fiftyPercentSpin()){
				//mutate left gene
				mutateAGene(individualToMutate.getLeftGene());
			}else{
				//mutate right gene
				mutateAGene(individualToMutate.getRightGene());
			}
		
	}
	
}