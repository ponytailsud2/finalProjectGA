package counterOp;

import java.util.ArrayList;
import java.util.Random;

public class PopulationCounterOp {

	ArrayList<IndividualCounterOp> firstGen = new ArrayList<IndividualCounterOp>();
	ArrayList<IndividualCounterOp> individuals = new ArrayList<IndividualCounterOp>();
	ArrayList<IndividualCounterOp> fitArray = new ArrayList<IndividualCounterOp>();

	public void addIndividual(IndividualCounterOp individual) {
		individuals.add(individual);
	}

	public void makeFirstGen() {
		for (int i = 0; i < individuals.size(); i++) {
			IndividualCounterOp temp = new IndividualCounterOp(individuals.get(i).gene);
			firstGen.add(temp);
		}
	}

	public ArrayList<IndividualCounterOp> getFitArray() {
		ArrayList<IndividualCounterOp> fitList = new ArrayList<IndividualCounterOp>();
		for (int i = 0; i < individuals.size(); i++) {
			if (0 <= individuals.get(i).fitness) {
				fitList.add(individuals.get(i));
			}
		}

		fitArray = new ArrayList<IndividualCounterOp>(fitList);
		return fitList;
	}

	public void initialCrossover() {
		Random rn = new Random();

		for (int i = 0; i < firstGen.size(); i++) {
			for (int j = i+1; j < firstGen.size(); j++) {
				ArrayList<String> parent1 = new ArrayList<String>(firstGen.get(i).gene);
				ArrayList<String> parent2 = new ArrayList<String>(firstGen.get(j).gene);

				for (int k = 0; k < parent1.size(); k++) {
					int crossover = rn.nextInt();
					if (k > 3 && k < 8) {
						if (crossover % 3 == 0) {
							int x = 8;
							while (k < x) {
								if (k < 6) {
									String temp = parent1.get(k);
									parent1.set(k, parent2.get(k + 2));
									parent2.set(k + 2, temp);
								}
								if (k >= 6) {
									String temp = parent1.get(k);
									parent1.set(k, parent2.get(k - 2));
									parent2.set(k - 2, temp);
								}
								k++;
							}
							k--;
						} else if (crossover % 3 == 1) {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k));
							parent2.set(k, temp);
						}
					} else {
						if (crossover % 2 == 1) {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k));
							parent2.set(k, temp);
						}
					}
				}
				individuals.add(new IndividualCounterOp(parent1));
				individuals.add(new IndividualCounterOp(parent2));
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
			individuals.get(i).fitness = individuals.get(i).calcFitness();
		}
	}
}
