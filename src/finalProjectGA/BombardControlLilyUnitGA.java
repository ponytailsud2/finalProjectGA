package finalProjectGA;

import java.util.Random;

public class BombardControlLilyUnitGA {

	Population population = new Population();
	Individual fittest;
	Individual secondFittest;
	int generationCount = 0;

	public static void main(String[] args) {

	}

	void selection() {

		// select the fittest
		fittest = population.getFittest();

		// select the second fittest
		secondFittest = population.getSecondFittest();
	}

	void crossover() {
		Random rn = new Random();

		// crossover point
		int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);

		// swap values
		for (int i = 0; i < crossOverPoint; i++) {
			int temp = fittest.genes[i];
			fittest.genes[i] = secondFittest.genes[i];
			secondFittest.genes[i] = temp;
		}

	}

	void mutation() {
		Random rn = new Random();

		// mutation point
		int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

		// Flip values at the mutation point
		if (fittest.genes[mutationPoint] == 0) {
			fittest.genes[mutationPoint] = 1;
		} else {
			fittest.genes[mutationPoint] = 0;
		}

		mutationPoint = rn.nextInt(population.individuals[0].geneLength);

		if (secondFittest.genes[mutationPoint] == 0) {
			secondFittest.genes[mutationPoint] = 1;
		} else {
			secondFittest.genes[mutationPoint] = 0;
		}
	}
}

class Individual {
	// array size
	int geneLength;
	int fitness = 0;
	int[] genes = new int[geneLength];

	//constructor
	public Individual() {

	}

	// fittest function
	public void calcFitness() {

	}
}

class Population {

	int populationLength = 0;
	Individual[] individuals = new Individual[populationLength];
	int fittest = 0;

	public Individual getFittest() {
		int maxFit = Integer.MIN_VALUE;
		int maxFitIndex = 0;
		for (int i = 0; i < individuals.length; i++) {
			if (maxFit <= individuals[i].fitness) {
				maxFit = individuals[i].fitness;
				maxFitIndex = i;
			}
		}
		fittest = individuals[maxFitIndex].fitness;
		return individuals[maxFitIndex];
	}

	public Individual getSecondFittest() {
		int maxFit1 = 0;
		int maxFit2 = 0;
		for (int i = 0; i < individuals.length; i++) {
			if (individuals[i].fitness > individuals[maxFit1].fitness) {
				maxFit2 = maxFit1;
				maxFit1 = i;
			} else if (individuals[i].fitness > individuals[maxFit2].fitness) {
				maxFit2 = i;
			}
		}
		return individuals[maxFit2];
	}
}
