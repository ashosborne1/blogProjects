package com.ashosborne.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a generation of DNA's which are individual solutions to the problem
 * @author Ashley Osborne
 *
 */
public class Population {
	
	private int averagePopulationFitness;
	private ArrayList<DNA> population;
	private boolean solutionFound = false;
	private DNA winningSolution = null;
	
	/**
	 * Create a population of individual DNA solutions
	 * @param population
	 */
	public Population(ArrayList<DNA> population){
		Collections.sort(population);
		
		this.population = population;
		int totalFitness = 0;
		
		//Loop over the population and check the fitness of them all
		for(DNA dna : population){
			totalFitness = totalFitness + dna.fitness();
			if(dna.fitness() == 0){
				solutionFound = true;
				winningSolution = dna;
			}
		}
		//Tally the average population fitness
		int popsize = population.size();
		averagePopulationFitness = totalFitness / popsize;
		System.out.println("Average fitness: " + averagePopulationFitness);
		System.out.println("Fittest of population is: " + this.population.get(0));
	}
	
	/**
	 * Get the current generation
	 * @return
	 */
	public ArrayList<DNA> getPopulation(){
		return this.population;
	}
	
	/**
	 * Get the average population fitness for this generation
	 * @return
	 */
	public int getAveragePopulationFitness(){
		return this.averagePopulationFitness;
	}
	
	/**
	 * Return if a solution to the problem has been found
	 * @return True if a solution exists in this generation
	 */
	public boolean getSolutionFound(){
		return solutionFound;
	}
	
	public DNA getWinningSolution(){
		return this.winningSolution;
	}

}