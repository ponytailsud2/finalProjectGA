package unit;

import java.util.ArrayList;
import java.util.Random;


public class PopulationUnit {
	ArrayList<IndividualUnit> firstGen = new ArrayList<IndividualUnit>();
	ArrayList<IndividualUnit> fitArray = new ArrayList<IndividualUnit>();
	ArrayList<IndividualUnit> individuals = new ArrayList<IndividualUnit>();

	public void addIndividual(IndividualUnit individual) {
		individuals.add(individual);
	}

	public void makeFirstGen() {
		for (int i = 0; i < individuals.size(); i++) {
			IndividualUnit temp = new IndividualUnit(individuals.get(i).gene);
			firstGen.add(temp);
		}
	}

	public ArrayList<IndividualUnit> getFitArray() {
		ArrayList<IndividualUnit> fitList = new ArrayList<IndividualUnit>();
		for (int i = 0; i < individuals.size(); i++) {
			if (0 <= individuals.get(i).fitness) {
				fitList.add(individuals.get(i));
			}
		}

		fitArray = new ArrayList<IndividualUnit>(fitList);
		return fitList;
	}

	public void initialCrossover() {
		Random rn = new Random();

		for (int i = 0; i < firstGen.size(); i++) {
			for (int j = i + 1; j < firstGen.size(); j++) {
				ArrayList<String> parent1 = new ArrayList<String>(firstGen.get(i).gene);
				ArrayList<String> parent2 = new ArrayList<String>(firstGen.get(j).gene);
				for (int k = 0; k < parent1.size(); k++) {
					int crossover = rn.nextInt();
					if (k < 4) {
						if (crossover % 2 == 1) {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k));
							parent2.set(k, temp);
						}
					} else if (k == 4 || k == 8) {
						if (crossover % 2 == 1) {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k + 4));
							parent2.set(k + 4, temp);
						}
					} else if (k == 12) {
						if (crossover % 2 == 1) {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k - 8));
							parent2.set(k - 8, temp);
						}
					} else if (k == 5 || k == 9) {
						int x = k + 3;
						if (crossover % 2 == 1) {
							while (k < x) {
								String temp = parent1.get(k);
								parent1.set(k, parent2.get(k + 4));
								parent2.set(k + 4, temp);
								k++;
							}
						}
						k--;
					} else if (k == 13) {
						int x = k + 3;
						if (crossover % 2 == 1) {
							while (k < x) {
								String temp = parent1.get(k);
								parent1.set(k, parent2.get(k - 8));
								parent2.set(k - 8, temp);
								k++;
							}
						}
						k--;
					}
				}

				individuals.add(new IndividualUnit(parent1));
				individuals.add(new IndividualUnit(parent2));
			}
		}
	}

	public int getLeastFittestIndex() {
		double minFitVal = Integer.MAX_VALUE;
		int minFitIndex = 0;
		calFitness();
		for (int i = 0; i < individuals.size(); i++) {
			if (minFitVal >= individuals.get(i).fitness) {
				minFitVal = individuals.get(i).fitness;
				minFitIndex = i;
			}
		}
		return minFitIndex;
	}

	public void calFitness() {
		for (int i = 0; i < individuals.size(); i++) {
			individuals.get(i).fitness = individuals.get(i).calFitness();
		}
	}

}
