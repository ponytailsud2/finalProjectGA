package squadSaraSquad;

import java.util.ArrayList;
import java.util.Random;

public class PopulationSquadSaraSquad {
	ArrayList<IndividualSquadSaraSquad> firstGen = new ArrayList<IndividualSquadSaraSquad>();
	ArrayList<IndividualSquadSaraSquad> individuals = new ArrayList<IndividualSquadSaraSquad>();
	ArrayList<IndividualSquadSaraSquad> fitArray = new ArrayList<IndividualSquadSaraSquad>();

	double fittest;

	public ArrayList<IndividualSquadSaraSquad> getFittest() {
		ArrayList<IndividualSquadSaraSquad> fitList = new ArrayList<IndividualSquadSaraSquad>();
		calFitness();
		//int maxFitIndex = 0;
		for (int i = 0; i < individuals.size(); i++) {
			if (0 <= individuals.get(i).fitness) {
				fitList.add(individuals.get(i));
			}
		}
		fitArray = new ArrayList<IndividualSquadSaraSquad>(fitList);
		return fitList;
	}

	public void initialCrossover() {

		// Random rn = new Random();

		for (int i = 0; i < firstGen.size(); i++) {
			for (int j = i; j < firstGen.size(); j++) {
				ArrayList<String> parent1 = new ArrayList<String>(firstGen.get(i).gene);
				ArrayList<String> parent2 = new ArrayList<String>(firstGen.get(j).gene);
				Random rn = new Random();

				for (int k = 0; k < parent1.size(); k++) {
					int crossoverPoint = rn.nextInt();

					if (crossoverPoint % 2 == 1) {
						if ((k > 11 && k < 16) || (k > 16 && k < 22) || (k > 22 && k < 27)) {
							continue;
						}
						else if (k == 11) {
							int x = k + 5;
							while (x > k) {
								String temp = parent1.get(k);
								parent1.set(k, parent2.get(k));
								parent2.set(k, temp);
								k++;
							}
							k--;
						} else if (k == 16) {
							int x = k + 6;
							while (x > k) {
								String temp = parent1.get(k);
								parent1.set(k, parent2.get(k));
								parent2.set(k, temp);
								k++;
							}
							k--;
						}

						else if (k == 22) {
							int x = k + 5;
							while (x > k) {
								String temp = parent1.get(k);
								parent1.set(k, parent2.get(k));
								parent2.set(k, temp);
								k++;
							}
							k--;
						} else {
							String temp = parent1.get(k);
							parent1.set(k, parent2.get(k));
							parent2.set(k, temp);
						}
					}

				}
				individuals.add(new IndividualSquadSaraSquad(parent1));
				individuals.add(new IndividualSquadSaraSquad(parent2));
			}
		}
	}

	public void setFittest(IndividualSquadSaraSquad fittest) {
		double maxFit = Integer.MIN_VALUE;
		int maxFitIndex = 0;
		calFitness();
		for (int i = 0; i < individuals.size(); i++) {
			if (maxFit <= individuals.get(i).fitness) {
				maxFit = individuals.get(i).fitness;
				maxFitIndex = i;
			}
		}
		individuals.set(maxFitIndex, fittest);
	}

	public IndividualSquadSaraSquad getSecondFittest() {
		int maxFit1 = 0;
		int maxFit2 = 0;
		calFitness();
		for (int i = 0; i < individuals.size(); i++) {
			if (individuals.get(i).fitness > individuals.get(maxFit1).fitness) {
				maxFit2 = maxFit1;
				maxFit1 = i;
			} else if (individuals.get(i).fitness > individuals.get(maxFit2).fitness) {
				maxFit2 = i;
			}
		}
		return individuals.get(maxFit2);
	}

	public void setSecondFittest(IndividualSquadSaraSquad secondFittest) {
		int maxFit1 = 0;
		int maxFit2 = 0;
		calFitness();
		for (int i = 0; i < individuals.size(); i++) {
			if (individuals.get(i).fitness > individuals.get(maxFit1).fitness) {
				maxFit2 = maxFit1;
				maxFit1 = i;
			} else if (individuals.get(i).fitness > individuals.get(maxFit2).fitness) {
				maxFit2 = i;
			}
		}
		individuals.set(maxFit2, secondFittest);
	}

	public void addIndividual(IndividualSquadSaraSquad individual) {
		individuals.add(individual);
	}

	public void makeFirstGen() {
		for (int i = 0; i < individuals.size(); i++) {
			IndividualSquadSaraSquad temp = new IndividualSquadSaraSquad(individuals.get(i).gene);
			firstGen.add(temp);
		}
	}

	public int getLeastFittestIndex() {
		double minFitVal = Integer.MAX_VALUE;
		int minFitIndex = 0;
		calFitness();
		for (int i = 0; i < individuals.size(); i++) {
			for (int j = 0; j < firstGen.size(); j++) {
				if (individuals.get(i) == firstGen.get(j)) {
					return i;
				}
			}
			if (minFitVal >= individuals.get(i).fitness) {
				minFitVal = individuals.get(i).fitness;
				minFitIndex = i;
			}
		}
		return minFitIndex;
	}

	public void calFitness() {
		
		for (int i = 0; i < individuals.size(); i++) {
			for (int j = 0; j < firstGen.size(); j++) {
				/*
				if (individuals.get(i).geneEqual(firstGen.get(j))) {
					individuals.get(i).fitness -= 1000;
				} else {
				*/
					// System.out.println("check1");
					individuals.get(i).fitness = individuals.get(i).calcFitness();
				
			}
		}
	}
}
