package SquadSara;

import java.util.ArrayList;

class PopulationSquadSara {

	int populationLength;
	ArrayList<IndividualSquadSara> firstGen;
	ArrayList<IndividualSquadSara> individuals = new ArrayList<IndividualSquadSara>();
	int fittest = 0;

	public void setFirstGen(ArrayList<IndividualSquadSara> firstgen) {
		this.firstGen = firstgen;
	}
	
	public IndividualSquadSara getFittest() {
		int maxFit = Integer.MIN_VALUE;
		int maxFitIndex = 0;
		for (int i = 0; i < populationLength; i++) {
			if (maxFit <= individuals.get(i).fitness) {
				maxFit = individuals.get(i).fitness;
				maxFitIndex = i;
			}
		}
		fittest = individuals.get(maxFitIndex).fitness;
		return individuals.get(maxFitIndex);
	}

	public void checkOldcard() {

		for(int k =0;k<populationLength;k++) {
			boolean sameAsOldCard = true;
			
			for(int i =0;i<firstGen.size();i++) {
				sameAsOldCard = true; 
				for(int j=0;j<individuals.get(k).geneLength;j++) {
					if(firstGen.get(i).genes[j]!=individuals.get(k).genes[j]) {
						sameAsOldCard = false;
						break;
					}
				}
				if(sameAsOldCard)break;
			}
			
			if(sameAsOldCard) {
				individuals.get(k).setFitness(-10);
			}
		}
		
		
	}
	
	public IndividualSquadSara getSecondFittest() {
		int maxFit1 = 0;
		int maxFit2 = 0;
		for (int i = 0; i < populationLength; i++) {
			if (individuals.get(i).fitness > individuals.get(maxFit1).fitness) {
				maxFit2 = maxFit1;
				maxFit1 = i;
			} else if (individuals.get(i).fitness > individuals.get(maxFit2).fitness) {
				maxFit2 = i;
			}
		}
		return individuals.get(maxFit2);
	}
	
	public void addIndividual(IndividualSquadSara individual) {
		individuals.add(individual);
	}
	
	public int getLeastFittestIndex() {
		int minFitVal = Integer.MAX_VALUE;
		int minFitIndex = 0;
		for (int i = 0; i < populationLength; i++) {
			if (minFitVal >= individuals.get(i).fitness) {
				minFitVal = individuals.get(i).fitness;
				minFitIndex = i;
			}
		}
		return minFitIndex;
	}
}
