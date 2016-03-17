package com.ashosborne.algorithm;

import java.util.ArrayList;

import com.ashosborne.model.DNA;
import com.ashosborne.model.Gene;
import com.ashosborne.model.Population;

/**
 * Runs a genetic algorithm simulation to solve the problem
 * A * B = 190087
 * @author ashleyosbourne
 *
 */
public class GeneticAlgorithm {

	private ArrayList<DNA> initialPopulation = new ArrayList<DNA>();
	private Population currentPopulation;
	
	//Create populations of the size 100
	private final int initialPopulationSize = 500;
	//Create Genes with a bit string length of 9 (max A and B can be are: 512 using this length)
	private final int bitStringLength = 9;
	
	/**
	 * Seed the initial population
	 */
	public void seedPopulation(){
		Seeder seeder = new Seeder();		
		for(int i=0; i<initialPopulationSize; i++){
			Gene leftGene = seeder.createGene(bitStringLength);
			Gene rightGene = seeder.createGene(bitStringLength);
			DNA individual = new DNA(leftGene, rightGene);
			initialPopulation.add(individual);		
		}
		currentPopulation = new Population(initialPopulation);
	}
	
	/**
	 * Create a new generation of population
	 */
	public void evolve(){
		Breeder b = new Breeder(currentPopulation);
		currentPopulation = new Population(b.breed());
	}
	
	/**
	 * Begin the life of the genetic algorithm
	 */
	public void beginLife(){		
		for(int i=0; i<10000; i++){
			if (!currentPopulation.getSolutionFound()){
				this.evolve();
			}
			else{
				System.out.println("Found in: " + i + " cycles solutions are:" + currentPopulation.getWinningSolution().toString());
				break;
			}		
		}
	}
	
	public static void main(String args[]){
		GeneticAlgorithm g = new GeneticAlgorithm();
		g.seedPopulation();
		g.beginLife();

	}
	
}