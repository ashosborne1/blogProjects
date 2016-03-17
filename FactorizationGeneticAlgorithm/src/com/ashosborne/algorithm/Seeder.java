package com.ashosborne.algorithm;

import com.ashosborne.model.Gene;
import com.ashosborne.utils.Utils;

/**
 * Used to seed the initial population
 * @author ashleyosbourne
 *
 */
public class Seeder {

	public Seeder(){
		
	}
	
	/**
	 * Create a random Gene
	 * @param bitSize The length of the bitstring
	 * @return A random Gene
	 */
	public Gene createGene(int bitStringLength){
		Gene gene = new Gene();
		StringBuffer geneSequenceBuffer = new StringBuffer();
		for(int i=0; i<bitStringLength; i++){
			
			if(Utils.fiftyPercentSpin()){
				geneSequenceBuffer.append('0');
			}else{
				geneSequenceBuffer.append('1');
			}
			
		}
		gene.setBinaryForm(geneSequenceBuffer.toString());
		return gene;
	}
	
}
