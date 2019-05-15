package counterOp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CounterOp {

	PopulationCounterOp population = new PopulationCounterOp();
	int generationCount = 0;

	public static void main(String[] args) throws IOException {
		Random rn = new Random();

		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/operation.txt"));

		IndividualCounterOp gateWay = new IndividualCounterOp(0, 0, 1, "", "EffectDestroySelfEffectDrawCard", 1,
				"EffectRampEffectPutToHand", 1, "PSI");
		IndividualCounterOp mindControl = new IndividualCounterOp(2, 1, 1, "", "EffectDestroyManual", 1, "", 0, "PSI");
		IndividualCounterOp focus = new IndividualCounterOp(0, 0, 1, "", "EffectRamp", 1, "EffectPutToHand", 1, "PSI");
		IndividualCounterOp mindFray = new IndividualCounterOp(1, 0, 1, "", "EffectFatigueManual", 2, "EffectPutToHand",
				1, "PSI");
		IndividualCounterOp carpetBomb = new IndividualCounterOp(2, 2, 2, "", "EffectBombardAutoAll", 10, "", 0, "BAL");
		IndividualCounterOp secretP = new IndividualCounterOp(0, 2, 1, "", "EffectReduceTurnCountAuto", 2, "", 0,
				"BAL");
		IndividualCounterOp flare = new IndividualCounterOp(0, 0, 1, "", "EffectBombardManual", 2, "", 0, "BAL");
		IndividualCounterOp rPreparation = new IndividualCounterOp(0, 0, 1, "", "EffectDrawCard", 2, "", 0, "SHA");
		IndividualCounterOp callOfW = new IndividualCounterOp(1, 0, 1, "", "EffectGiveConstSTRManualCost", 6, "", 0,
				"SHA");
		IndividualCounterOp LODR = new IndividualCounterOp(0, 1, 3, "", "EffectMillDeck", 4, "", 0, "SHA");

		IndividualCounterOp fatalPulse = new IndividualCounterOp(1, 3, 1, "EffectCondition_EnemyAttack",
				"EffectFatigueRandom", 5, "", 0, "PSI");
		IndividualCounterOp overWatch = new IndividualCounterOp(0, 0, 1, "EffectCondition_EnemyAttack",
				"EffectBombardRandom", 2, "", 0, "BAL");
		IndividualCounterOp itsATrap = new IndividualCounterOp(2, 0, 1, "EffectCondition_IsTargeted",
				"EffectBombardAutoSource", 10, "", 0, "BAL");
		IndividualCounterOp fSplash = new IndividualCounterOp(1, 1, 1, "EffectCondition_AlliedTargeted",
				"EffectBombardRandomDefender", 10, "EffectBombardRandom", 10, "BAL");
		IndividualCounterOp sCombine = new IndividualCounterOp(1, 1, 1, "EffectCondition_EnemyAttack",
				"EffectGiveConstSTRManualOversoul", 5, "", 0, "SHA");
		IndividualCounterOp eSoul = new IndividualCounterOp(2, 0, 1, "EffectCondition_EnemyAttack",
				"EffectGiveConstSTRManualCost", 5, "", 0, "SHA");

		CounterOp ga = new CounterOp();

		ga.population.addIndividual(gateWay);
		ga.population.addIndividual(mindControl);
		ga.population.addIndividual(focus);
		ga.population.addIndividual(mindFray);
		ga.population.addIndividual(carpetBomb);
		ga.population.addIndividual(secretP);
		ga.population.addIndividual(flare);
		ga.population.addIndividual(rPreparation);
		ga.population.addIndividual(callOfW);
		ga.population.addIndividual(LODR);
		ga.population.addIndividual(fatalPulse);
		ga.population.addIndividual(overWatch);
		ga.population.addIndividual(itsATrap);
		ga.population.addIndividual(fSplash);
		ga.population.addIndividual(sCombine);
		ga.population.addIndividual(eSoul);

		// ga.population.calFitness();

		ga.population.makeFirstGen();
		ga.population.initialCrossover();

		int cardCount = 0;

		while (cardCount < 200 || ga.generationCount < 10000) {

			cardCount = 0;

			++ga.generationCount;

			ga.population.getFitArray();

			ga.crossover();

			if (rn.nextInt() % 5 < 4) {
				ga.mutation();
			}
			System.out.println(ga.generationCount);
			
			ga.population.calFitness();
			
			int populationIsFit = 288;

			String represent = "{";

			for (int i = 0; i < ga.population.individuals.size(); i++) {
				String populationIndiv = "[";
				// System.out.println(ga.population.individuals.get(i));
				if (ga.population.individuals.get(i).fitness < 2) {
					populationIsFit--;
					// break;
				} else {
					cardCount++;
					for (int j = 0; j < ga.population.individuals.get(i).gene.size(); j++) {
						populationIndiv += ga.population.individuals.get(i).gene.get(j);
						if (j != ga.population.individuals.get(i).gene.size() - 1) {
							populationIndiv += ", ";
						}
					}
					populationIndiv += "] fitness: ";
					populationIndiv += ga.population.individuals.get(i).fitness;
					represent += populationIndiv + "\n";
				}
				
			}
			represent += "}\n";

			if (populationIsFit > 16) {
				writer.write(" Generation: " + ga.generationCount + represent);
			} else {
				String check = "[";
				for (int i = 0; i < ga.population.getFitArray().get(i).gene.size(); i++) {
					check += ga.population.getFitArray().get(i).gene.get(i);
					check += ", ";
				}
				System.out.println(" Generation: " + ga.generationCount + " check :" + check
						+ "] fitness: " + ga.population.getFitArray().get(0).fitness);
			}
		}
		writer.close();

	}

	public void crossover() {
		Random rn = new Random();

		ArrayList<IndividualCounterOp> populationFitClone = new ArrayList<IndividualCounterOp>(population.fitArray);

		for (int x = 0; x < populationFitClone.size(); x++) {
			for (int y = x+1; y < populationFitClone.size(); y++) {
				ArrayList<String> fittestGeneTemp = new ArrayList<String>(populationFitClone.get(x).gene);
				ArrayList<String> secondFittestGeneTemp = new ArrayList<String>(populationFitClone.get(y).gene);
				// uniform crossover
				for (int i = 0; i < fittestGeneTemp.size(); i++) {
					int crossover = rn.nextInt();
					if (i > 3 && i < 8) {
						if (crossover % 3 == 0) {
							int j = 8;
							while (i < j) {
								if (i < 6) {
									String temp = fittestGeneTemp.get(i);
									fittestGeneTemp.set(i, secondFittestGeneTemp.get(i + 2));
									secondFittestGeneTemp.set(i + 2, temp);
								}
								if (i >= 6) {
									String temp = fittestGeneTemp.get(i);
									fittestGeneTemp.set(i, secondFittestGeneTemp.get(i - 2));
									secondFittestGeneTemp.set(i - 2, temp);
								}
								i++;
							}
							i--;
						} else if (crossover % 3 == 1) {
							String temp = fittestGeneTemp.get(i);
							fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
							secondFittestGeneTemp.set(i, temp);
						}
					} else {
						if (crossover % 2 == 1) {
							String temp = fittestGeneTemp.get(i);
							fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
							secondFittestGeneTemp.set(i, temp);
						}
					}
				}
				population.addIndividual(new IndividualCounterOp(fittestGeneTemp));
				population.addIndividual(new IndividualCounterOp(secondFittestGeneTemp));

				int leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
				leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
			}
		}
	}

	public void mutation() {
		Random rn = new Random();
		int mutatablePoint = 4;
		int mutationPoint = rn.nextInt(mutatablePoint);
		int mutateShift = rn.nextInt(6);
		int mutatingIndividual = rn.nextInt(population.fitArray.size());
		ArrayList<String> fittestGeneTemp = new ArrayList<String>(population.fitArray.get(mutatingIndividual).gene);

		if (mutationPoint == 2) {
			mutationPoint += 3;
		} else if (mutationPoint == 3) {
			mutationPoint += 4;
		}

		// shift -3
		if (mutateShift == 0) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp -= 3;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		// shift -2
		if (mutateShift == 1) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp -= 2;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		// shift -1
		if (mutateShift == 2) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp -= 1;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		// shift +1
		if (mutateShift == 3) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp += 1;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		// shift +2
		if (mutateShift == 4) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp += 2;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		// shift +3
		if (mutateShift == 5) {
			int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
			temp += 3;
			fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
		}
		population.addIndividual(new IndividualCounterOp(fittestGeneTemp));

		int leastFittestIndex = population.getLeastFittestIndex();
		population.individuals.remove(leastFittestIndex);
	}
}
