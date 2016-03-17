package com.ashosborne.model;

/**
 * Models a complete attempt at a solution to the target problem
 * @author Ashley Osborne
 *
 */
public class DNA implements Comparable<DNA> {

	private final int target = 190087;
	private Gene leftGene;
	private Gene rightGene;

	public DNA(){

	}

	/**
	 * Create a new attempt at a solution
	 * @param leftGene The left Gene Model of an answer
	 * @param rightGene The right Gene Model of an answer
	 */
	public DNA(Gene leftGene, Gene rightGene){
		this.leftGene = leftGene;
		this.rightGene = rightGene;
	}

	/**
	 * Get the left Gene
	 * @return The left gene
	 */
	public Gene getLeftGene() {
		return leftGene;
	}

	/**
	 * Set the left Gene
	 * @param leftGene The left gene for this solution
	 */
	public void setLeftGene(Gene leftGene) {
		this.leftGene = leftGene;
	}

	/**
	 * Get the right Gene
	 * @return The right gene
	 */
	public Gene getRightGene() {
		return rightGene;
	}

	/**
	 * Set the right Gene
	 * @param rightGene The right gene for this solution
	 */
	public void setRightGene(Gene rightGene) {
		this.rightGene = rightGene;
	}

	/**
	 * Calculate the fitness of this individual
	 * @return The difference between this solution and the target value
	 */
	public int fitness(){

		int leftGeneValue = leftGene.getNumber();
	    int rightGeneValue = rightGene.getNumber();
		
		int total = leftGeneValue * rightGeneValue;
		
		//Turn the fitness positive
		int fitness = target - total;
		if(fitness <0 ){
			fitness = fitness * -1;
		}
		
		return fitness;
		
	}

	@Override
	public int compareTo(DNA o) {
		if(this.fitness() < o.fitness()){
			return -1;
		}else if (this.fitness() > o.fitness()){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public String toString() {
		String s = "Fitness is: "+ this.fitness() + " Left gene is: " + this.leftGene.getNumber() + " Right gene is: " + this.rightGene.getNumber();
		return s;
	}

}
