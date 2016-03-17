package com.ashosborne.algorithm;

import java.util.ArrayList;
import java.util.Random;

import com.ashosborne.model.DNA;
import com.ashosborne.model.Gene;
import com.ashosborne.model.Population;
import com.ashosborne.utils.Utils;

/**
 * The Breeder will take a population and from it create a new generation
 * of individuals.
 * @author Ashley Osborne
 *
 */
public class Breeder {
	
	private ArrayList<DNA> oldPopulation;
	private int oldPopulationAverageFitness;

	/**
	 * Creates a breeder from an old population to use to create a new generation
	 * @param population The old population to create a new generation from
	 */
	public Breeder(Population population){		
		this.oldPopulation = population.getPopulation();
		this.oldPopulationAverageFitness = population.getAveragePopulationFitness();
	}
	
	/**
	 * Breed the old population and create a new population with better characteristics
	 * @return The new population
	 */
	public ArrayList<DNA> breed(){
		
		ArrayList<DNA> newPopulation = new ArrayList<DNA>();

				
		for(int i=0; i<500; i++){
			
			boolean dnaOneAcceptable= false;
			boolean dnaTwoAcceptable = false;
			
			DNA dnaOne = null;
			DNA dnaTwo = null;
			
			//Find one DNA that has a better fitness than the group average
			while(!dnaOneAcceptable){
				Random rand = new Random();
				int indexToUse = rand.nextInt(oldPopulation.size());
				if(oldPopulation.get(indexToUse).fitness() < oldPopulationAverageFitness){
					dnaOne = oldPopulation.get(indexToUse);
					dnaOneAcceptable = true;
				}
			}
			//Find a second DNA that has a better fitness than the group average
			while(!dnaTwoAcceptable){
				Random rand = new Random();
				int indexToUse = rand.nextInt(oldPopulation.size());
			    if(oldPopulation.get(indexToUse).fitness() < oldPopulationAverageFitness){
					dnaTwo = oldPopulation.get(indexToUse);
					dnaTwoAcceptable = true;
				}
			}
			//Produce a new DNA from two parents
			DNA newDna = mate(dnaOne, dnaTwo);
			newPopulation.add(newDna);
		}
		
		return newPopulation;
	
	}
	
	/**
	 * Mate two old DNA solutions to the problem to create a new one with characteristics
	 * from the both of them
	 * @param dnaOne The father DNA
	 * @param dnaTwo The mother DNA
	 * @return The child DNA
	 */
	public DNA mate(DNA dnaOne, DNA dnaTwo){
		
		Gene dnaOneLeftGene = dnaOne.getLeftGene();
		Gene dnaOneRightGene = dnaOne.getRightGene();
		
		Gene dnaTwoLeftGene = dnaTwo.getLeftGene();
		Gene dnaTwoRightGene = dnaTwo.getRightGene();
	
		DNA newDna = new DNA();
		newDna.setLeftGene(crossGenes(dnaOneLeftGene, dnaTwoLeftGene));
		newDna.setRightGene(crossGenes(dnaOneRightGene, dnaTwoRightGene));
		
		//Do a spin on the wheel to see if there should be a mutation if so
		//mutate this new individual
		if(Utils.fivePercentSpin()){
			Mutator mutator = new Mutator(newDna);
			mutator.mutate();
		}
		
		return newDna;
	}

	/**
	 * Cross two Genes
	 * @param geneOne An individuals gene
	 * @param geneTwo Another individuals gene
	 * @return A new crossed Gene
	 */
	public Gene crossGenes(Gene geneOne, Gene geneTwo){
		
		String firstGeneSequence = geneOne.getBinaryForm();
		String secondGeneSequence = geneTwo.getBinaryForm();
		
		StringBuffer newGeneSequence = new StringBuffer();
		for (int i=0; i<firstGeneSequence.length(); i++){			
			if (Utils.fiftyPercentSpin()){
				newGeneSequence.append(firstGeneSequence.charAt(i));
			}else{
				newGeneSequence.append(secondGeneSequence.charAt(i));
			}
			
		}	
		Gene newGene = new Gene();
		newGene.setBinaryForm(newGeneSequence.toString());
		return newGene;
	}
}