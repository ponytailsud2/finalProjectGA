package squadSaraSquad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SquadSaraSquad {

	PopulationSquadSaraSquad population = new PopulationSquadSaraSquad();
	IndividualSquadSaraSquad fittest = new IndividualSquadSaraSquad();
	IndividualSquadSaraSquad secondFittest = new IndividualSquadSaraSquad();
	int generationCount = 0;

	public static void main(String[] args) throws IOException {

		Random rn = new Random();

		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/SquadSaraSquad.txt"));

		ArrayList<String> seekerParameter = new ArrayList<String>();
		ArrayList<String> seekerPosition = new ArrayList<String>();
		seekerParameter.add("2");
		seekerPosition.add("3");
		seekerPosition.add("4");
		IndividualSquadSaraSquad seeker = new IndividualSquadSaraSquad(1, 1, 3, 1, 0, seekerPosition, "Inspired_Right",
				"EffectSelfSTRTillEnemyEnd", seekerParameter, "", "", new ArrayList<String>(), "", "",
				new ArrayList<String>(), "PSI");

		ArrayList<String> hunterParameter = new ArrayList<String>();
		ArrayList<String> hunterPosition = new ArrayList<String>();
		hunterParameter.add("2");
		hunterParameter.add("Squadmate");
		hunterParameter.add("Any");
		hunterParameter.add("End_EnemyTurn");
		hunterPosition.add("1");
		hunterPosition.add("2");
		IndividualSquadSaraSquad hunter = new IndividualSquadSaraSquad(2, 2, 1, 3, 5, hunterPosition, "Inspired_Left",
				"EffectBuffAllySTR", hunterParameter, "", "", new ArrayList<String>(), "", "", new ArrayList<String>(),
				"PSI");

		/*
		ArrayList<String> spectralArmyParameter = new ArrayList<String>();
		ArrayList<String> spectralArmyPosition = new ArrayList<String>();
		spectralArmyParameter.add("3");
		spectralArmyPosition.add("0");
		spectralArmyPosition.add("2");
		spectralArmyPosition.add("3");
		spectralArmyPosition.add("5");
		IndividualSquadSaraSquad spectralArmy = new IndividualSquadSaraSquad(2, 2, 5, 1, 1, spectralArmyPosition,
				"Inspired_Full", "EffectSelfSTRTillEnemyEnd", spectralArmyParameter, "", "", new ArrayList<String>(),
				"", "", new ArrayList<String>(), "PSI");
		*/
		ArrayList<String> solaceParameter = new ArrayList<String>();
		ArrayList<String> solacePosition = new ArrayList<String>();
		solaceParameter.add("2");
		solaceParameter.add("Allied");
		solaceParameter.add("Any");
		solaceParameter.add("End_EnemyTurn");
		solacePosition.add("1");
		IndividualSquadSaraSquad solace = new IndividualSquadSaraSquad(2, 2, 1, 4, 4, solacePosition, "Inspired_Full",
				"EffectBuffAllySTR", solaceParameter, "", "", new ArrayList<String>(), "", "", new ArrayList<String>(),
				"PSI");

		ArrayList<String> psiShielderParameter = new ArrayList<String>();
		ArrayList<String> psiShielderPosition = new ArrayList<String>();
		psiShielderParameter.add("6");
		psiShielderParameter.add("Squadmate");
		psiShielderParameter.add("Enemy");
		psiShielderParameter.add("End_EnemyTurn");
		psiShielderPosition.add("0");
		psiShielderPosition.add("1");
		psiShielderPosition.add("2");
		IndividualSquadSaraSquad psiShielder = new IndividualSquadSaraSquad(0, 3, 1, 2, 4, psiShielderPosition,
				"Inspired_Full", "EffectBuffAllySTR", psiShielderParameter, "", "", new ArrayList<String>(), "", "",
				new ArrayList<String>(), "PSI");

		ArrayList<String> puppeteerParameter1 = new ArrayList<String>();
		ArrayList<String> puppeteerParameter2 = new ArrayList<String>();
		ArrayList<String> puppeteerPosition = new ArrayList<String>();
		puppeteerParameter1.add("2");
		puppeteerParameter2.add("2");
		puppeteerParameter2.add("Squadmate");
		puppeteerParameter2.add("Any");
		puppeteerParameter2.add("End_EnemyTurn");
		puppeteerPosition.add("2");
		IndividualSquadSaraSquad puppeteer = new IndividualSquadSaraSquad(1, 2, 2, 2, 1, puppeteerPosition,
				"Inspired_Front", "EffectSelfSTRTillEnemyEnd", puppeteerParameter1, "Inspired_Front",
				"EffectBuffAllySTR", puppeteerParameter2, "", "", new ArrayList<String>(), "PSI");

		ArrayList<String> rocketLauncherParameter = new ArrayList<String>();
		ArrayList<String> rocketLauncherMateParameter = new ArrayList<String>();
		ArrayList<String> rocketLauncherPosition = new ArrayList<String>();
		rocketLauncherParameter.add("2");
		rocketLauncherParameter.add("1");
		rocketLauncherParameter.add("Condition_Strongest");
		rocketLauncherMateParameter.add("Front");
		rocketLauncherMateParameter.add("Source");
		rocketLauncherMateParameter.add("2");
		rocketLauncherPosition.add("0");
		rocketLauncherPosition.add("1");
		IndividualSquadSaraSquad rocketLauncher = new IndividualSquadSaraSquad(1, 2, 2, 1, 3, rocketLauncherPosition,
				"Begin_Turn", "EffectBombardRandom", rocketLauncherParameter, "", "", new ArrayList<String>(), "Legacy",
				"EffectBombardAuto", rocketLauncherMateParameter, "BAL");

		ArrayList<String> conscriptParameter = new ArrayList<String>();
		ArrayList<String> conscriptMateParameter = new ArrayList<String>();
		ArrayList<String> conscriptPosition = new ArrayList<String>();
		conscriptParameter.add("1");
		conscriptMateParameter.add("1");
		conscriptPosition.add("0");
		conscriptPosition.add("2");
		IndividualSquadSaraSquad conscript = new IndividualSquadSaraSquad(1, 2, 2, 1, 1, conscriptPosition, "Legacy",
				"EffectDrawCard", conscriptParameter, "", "", new ArrayList<String>(), "Legacy", "EffectDrawCard",
				conscriptMateParameter, "BAL");

		ArrayList<String> clusterBomberParameter = new ArrayList<String>();
		ArrayList<String> clusterBomberPosition = new ArrayList<String>();
		clusterBomberParameter.add("Both");
		clusterBomberParameter.add("All");
		clusterBomberParameter.add("2");
		clusterBomberPosition.add("1");
		clusterBomberPosition.add("2");
		IndividualSquadSaraSquad clusterBomber = new IndividualSquadSaraSquad(2, 3, 2, 1, 5, clusterBomberPosition,
				"Begin_Turn", "EffectBombardAuto", clusterBomberParameter, "", "", new ArrayList<String>(), "", "",
				new ArrayList<String>(), "BAL");

		ArrayList<String> tEldersParameter = new ArrayList<String>();
		ArrayList<String> tEldersPosition = new ArrayList<String>();
		tEldersParameter.add("2");
		tEldersParameter.add("Allied");
		tEldersPosition.add("0");
		tEldersPosition.add("2");
		IndividualSquadSaraSquad tElders = new IndividualSquadSaraSquad(1, 3, 3, 2, 1, tEldersPosition, "Once_On_Board",
				"EffectSelfSTRPermanent", tEldersParameter, "", "", new ArrayList<String>(), "", "",
				new ArrayList<String>(), "SHA");

		ArrayList<String> sSummonnerPosition = new ArrayList<String>();
		sSummonnerPosition.add("0");
		IndividualSquadSaraSquad sSummonner = new IndividualSquadSaraSquad(1, 1, 3, 2, 1, sSummonnerPosition, "", "",
				new ArrayList<String>(), "", "", new ArrayList<String>(), "", "", new ArrayList<String>(), "SHA");

		SquadSaraSquad squadSaraSquadGA = new SquadSaraSquad();

		squadSaraSquadGA.population.addIndividual(seeker);
		squadSaraSquadGA.population.addIndividual(hunter);
		//squadSaraSquadGA.population.addIndividual(spectralArmy);
		squadSaraSquadGA.population.addIndividual(solace);
		squadSaraSquadGA.population.addIndividual(psiShielder);
		squadSaraSquadGA.population.addIndividual(puppeteer);
		squadSaraSquadGA.population.addIndividual(rocketLauncher);
		squadSaraSquadGA.population.addIndividual(conscript);
		squadSaraSquadGA.population.addIndividual(clusterBomber);
		squadSaraSquadGA.population.addIndividual(tElders);
		squadSaraSquadGA.population.addIndividual(sSummonner);

		squadSaraSquadGA.population.makeFirstGen();

		squadSaraSquadGA.population.initialCrossover();

		// System.out.println(squadSaraSquadGA.population.individuals.size());

		/*
		 * for(int i =0;i<squadSaraSquadGA.population.individuals.size();i++) {
		 * System.out.println(squadSaraSquadGA.population.individuals.get(i)); }
		 */
		/*
		 * for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
		 * //System.out.println(squadSaraSquadGA.population.individuals.get(i)); String
		 * temp = "["; for(int j
		 * =0;j<squadSaraSquadGA.population.individuals.get(i).gene.size();j++) { temp
		 * += squadSaraSquadGA.population.individuals.get(i).gene.get(j); temp += ", ";
		 * } temp += "]"; System.out.println(temp); }
		 */
		
		//System.out.println(psiShielder.calcFitness());

		int count = 0;
		
		ArrayList<IndividualSquadSaraSquad> chk = new ArrayList<IndividualSquadSaraSquad>();
		// System.out.println(squadSaraSquadGA.population.fittest);

		while (count < 50 && squadSaraSquadGA.generationCount < 40000) {
			// System.out.println(squadSaraSquadGA.population.individuals.size());
			// while (squadSaraSquadGA.population.fittest <= 0) {
			
			count = 0;
			
			if (squadSaraSquadGA.population.individuals.get(0) == squadSaraSquadGA.population.individuals.get(1)
					|| squadSaraSquadGA.population.individuals.get(0) == squadSaraSquadGA.population.individuals
							.get(2)) {
				System.out.println("Oh no!");
			}

			++squadSaraSquadGA.generationCount;

			squadSaraSquadGA.population.getFittest();
			
			//squadSaraSquadGA.selection();

			squadSaraSquadGA.crossover();

			/*
			squadSaraSquadGA.addFittestOffspring();
			squadSaraSquadGA.addFittestOffspring();
			*/
			
			if (rn.nextInt() % 5 < 4) {
				squadSaraSquadGA.mutation();
				//squadSaraSquadGA.addFittestOffspring();
			}
			System.out.println(squadSaraSquadGA.generationCount);
			/*
			if(squadSaraSquadGA.generationCount==2) {
				for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
					chk.add(squadSaraSquadGA.population.individuals.get(i));
				}
			}
			else if(squadSaraSquadGA.generationCount==4){
				int same = 0;
				for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
					for(int j=0;j<chk.size();j++) {
						if(!chk.get(j).geneEqual(squadSaraSquadGA.population.individuals.get(i))) {
							same++;
						}
					}
					
				}
					int hot =  squadSaraSquadGA.population.individuals.size()*chk.size(); 
					System.out.println(same + "/"+hot);
					//squadSaraSquadGA.generationCount += 10000000;
			}
			else if(squadSaraSquadGA.generationCount==5){
				int same = 0;
				for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
					for(int j=0;j<chk.size();j++) {
						if(!chk.get(j).geneEqual(squadSaraSquadGA.population.individuals.get(i))) {
							same++;
						}
					}
					
				}
					int hot =  squadSaraSquadGA.population.individuals.size()*chk.size(); 
					System.out.println(same + "/"+hot);
					//squadSaraSquadGA.generationCount += 10000000;
			}
			else if(squadSaraSquadGA.generationCount==6){
				int same = 0;
				for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
					for(int j=0;j<chk.size();j++) {
						if(!chk.get(j).geneEqual(squadSaraSquadGA.population.individuals.get(i))) {
							same++;
						}
					}
					
				}
					int hot =  squadSaraSquadGA.population.individuals.size()*chk.size(); 
					System.out.println(same + "/"+hot);
					//squadSaraSquadGA.generationCount += 10000000;
			}
			*/
			squadSaraSquadGA.population.calFitness();

			int populationIsFit = 143;

			String represent = "{";

			for (int i = 0; i < squadSaraSquadGA.population.individuals.size(); i++) {
				String populationIndiv = "[";
				// System.out.println(squadSaraSquadGA.population.individuals.get(i));
				if (squadSaraSquadGA.population.individuals.get(i).fitness < 2) {
					populationIsFit--;
					// break;
				} else {
					count++;
					for (int j = 0; j < squadSaraSquadGA.population.individuals.get(i).gene.size(); j++) {
						populationIndiv += squadSaraSquadGA.population.individuals.get(i).gene.get(j);
						if (j != squadSaraSquadGA.population.individuals.get(i).gene.size() - 1) {
							populationIndiv += ", ";
						}
					}
					populationIndiv += "] fitness: ";
					populationIndiv += squadSaraSquadGA.population.individuals.get(i).fitness;
					represent += populationIndiv + "\n";
				}

			}

			represent += "}\n";

			if (populationIsFit > 3) {
				writer.write(" Generation: " + squadSaraSquadGA.generationCount + represent);
				/*
				String check = "[";
				for (int i = 0; i < squadSaraSquadGA.population.getFittest().gene.size(); i++) {
					check += squadSaraSquadGA.population.getFittest().gene.get(i);
					check += ", ";
				}
				
				System.out.println(" Generation: " + squadSaraSquadGA.generationCount + " check :" + check
						+ "] fitness: " + squadSaraSquadGA.population.getFittest().fitness);
						*/
			} else {
				String check = "[";
				for (int i = 0; i < squadSaraSquadGA.population.getFittest().get(i).gene.size(); i++) {
					check += squadSaraSquadGA.population.getFittest().get(i).gene.get(i);
					check += ", ";
				}
				System.out.println(" Generation: " + squadSaraSquadGA.generationCount + " check :" + check
						+ "] fitness: " + squadSaraSquadGA.population.getFittest().get(0).fitness);
			}
		}

		writer.close();
	}
	/*
	public void selection() {
		// select fittest and the second one.
		if (generationCount == 1) {
			Random rn = new Random();
			this.fittest = population.individuals.get(rn.nextInt(population.individuals.size()));
			this.secondFittest = population.individuals.get(rn.nextInt(population.individuals.size()));
		} else {
			this.fittest = population.getFittest();
			this.secondFittest = population.getSecondFittest();
		}

	}
	*/

	public void crossover() {
		Random rn = new Random();
		
		ArrayList<IndividualSquadSaraSquad> populationFitClone = new ArrayList<IndividualSquadSaraSquad>(population.getFittest());
		
		for(int x = 0;x<populationFitClone.size();x++) {
			for(int y = x;y<populationFitClone.size();y++) {
				ArrayList<String> fittestGeneTemp = new ArrayList<String>(populationFitClone.get(x).gene);
				ArrayList<String> secondFittestGeneTemp = new ArrayList<String>(populationFitClone.get(y).gene);
				// uniform crossover
				for (int i = 0; i < fittestGeneTemp.size(); i++) {
					int crossoverPoint = rn.nextInt();

					if (crossoverPoint % 2 == 1) {
						if ((i > 11 && i < 16) || (i > 16 && i < 22) || (i > 22 && i < 27)) {
							continue;
						} else if (i == 11) {
							int j = i + 5;
							while (j > i) {
								String temp = fittestGeneTemp.get(i);
								fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
								secondFittestGeneTemp.set(i, temp);
								i++;
							}
							i--;
						} else if (i == 16) {
							int j = i + 6;
							while (j > i) {
								String temp = fittestGeneTemp.get(i);
								fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
								secondFittestGeneTemp.set(i, temp);
								i++;
							}
							i--;
						}

						else if (i == 22) {
							int j = i + 5;
							while (j > i) {
								String temp = fittestGeneTemp.get(i);
								fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
								secondFittestGeneTemp.set(i, temp);
								i++;
							}
							i--;
						} else {
							String temp = fittestGeneTemp.get(i);
							fittestGeneTemp.set(i, secondFittestGeneTemp.get(i));
							secondFittestGeneTemp.set(i, temp);
						}
					}
				}

				population.addIndividual(new IndividualSquadSaraSquad(fittestGeneTemp));
				population.addIndividual(new IndividualSquadSaraSquad(secondFittestGeneTemp));
				
				int leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
				leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
			}
			
		}

	}

	public void mutation() {
		Random rn = new Random();
		int mutatablePoint = 7;
		int mutationPoint = rn.nextInt(mutatablePoint);
		int mutateShift = rn.nextInt(4);
		int mutatingIndividual = rn.nextInt(population.fitArray.size());
		ArrayList<String> fittestGeneTemp = new ArrayList<String>(population.fitArray.get(mutatingIndividual).gene);

		// mutate text 1 parameter
		if (mutationPoint == 4) {
			int textParameterIndex = 12;
			if (fittestGeneTemp.get(11) == "EffectSelfSTRTillEnemyEnd" || fittestGeneTemp.get(11) == "EffectBuffAllySTR"
					|| fittestGeneTemp.get(11) == "EffectBombardRandom" || fittestGeneTemp.get(11) == "EffectDrawCard") {
				// shift -2
				if (mutateShift == 0) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex));
					temp -= 2;
					fittestGeneTemp.set(textParameterIndex, Integer.toString(temp));
				}

				// shift -1
				if (mutateShift == 1) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex));
					temp -= 1;
					fittestGeneTemp.set(textParameterIndex, Integer.toString(temp));
				}

				// shift +1
				if (mutateShift == 2) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex));
					temp += 1;
					fittestGeneTemp.set(textParameterIndex, Integer.toString(temp));
				}

				// shift +2
				if (mutateShift == 3) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex));
					temp += 2;
					fittestGeneTemp.set(textParameterIndex, Integer.toString(temp));
				}
			} else if (fittestGeneTemp.get(11) == "EffectBombardAuto") {
				// shift -2
				if (mutateShift == 0) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex + 2));
					temp -= 2;
					fittestGeneTemp.set(textParameterIndex + 2, Integer.toString(temp));
				}

				// shift -1
				if (mutateShift == 1) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex + 2));
					temp -= 1;
					fittestGeneTemp.set(textParameterIndex + 2, Integer.toString(temp));
				}

				// shift +1
				if (mutateShift == 2) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex + 2));
					temp += 1;
					fittestGeneTemp.set(textParameterIndex + 2, Integer.toString(temp));
				}

				// shift +2
				if (mutateShift == 3) {
					int temp = Integer.valueOf(fittestGeneTemp.get(textParameterIndex + 2));
					temp += 2;
					fittestGeneTemp.set(textParameterIndex + 2, Integer.toString(temp));
				}
			}
		}
		// mutate text2 parameter
		else if (mutationPoint == 5 && fittestGeneTemp.get(17) != "") {
			int text2ParameterIndex = 18;
			// System.out.println(fittestGeneTemp.get(text2ParameterIndex));
			// shift -2
			if (mutateShift == 0) {
				int temp = Integer.valueOf(fittestGeneTemp.get(text2ParameterIndex));
				temp -= 2;
				fittestGeneTemp.set(text2ParameterIndex, Integer.toString(temp));
			}

			// shift -1
			if (mutateShift == 1) {
				int temp = Integer.valueOf(fittestGeneTemp.get(text2ParameterIndex));
				temp -= 1;
				fittestGeneTemp.set(text2ParameterIndex, Integer.toString(temp));
			}

			// shift +1
			if (mutateShift == 2) {
				int temp = Integer.valueOf(fittestGeneTemp.get(text2ParameterIndex));
				temp += 1;
				fittestGeneTemp.set(text2ParameterIndex, Integer.toString(temp));
			}

			// shift +2
			if (mutateShift == 3) {
				int temp = Integer.valueOf(fittestGeneTemp.get(text2ParameterIndex));
				temp += 2;
				fittestGeneTemp.set(text2ParameterIndex, Integer.toString(temp));
			}
		}
		// mutate mate text parameter
		else if (mutationPoint == 6) {
			int mateTextParameterIndex = 24;
			if (fittestGeneTemp.get(23) == "EffectSelfSTRTillEnemyEnd" || fittestGeneTemp.get(23) == "EffectBuffAllySTR"
					|| fittestGeneTemp.get(23) == "EffectBombardRandom" || fittestGeneTemp.get(23) == "EffectDrawCard") {
				// shift -2
				if (mutateShift == 0) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex));
					temp -= 2;
					fittestGeneTemp.set(mateTextParameterIndex, Integer.toString(temp));
				}

				// shift -1
				if (mutateShift == 1) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex));
					temp -= 1;
					fittestGeneTemp.set(mateTextParameterIndex, Integer.toString(temp));
				}

				// shift +1
				if (mutateShift == 2) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex));
					temp += 1;
					fittestGeneTemp.set(mateTextParameterIndex, Integer.toString(temp));
				}

				// shift +2
				if (mutateShift == 3) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex));
					temp += 2;
					fittestGeneTemp.set(mateTextParameterIndex, Integer.toString(temp));
				}
			} else if (fittestGeneTemp.get(23) == "EffectBombardAuto") {
				// shift -2
				if (mutateShift == 0) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex + 2));
					temp -= 2;
					fittestGeneTemp.set(mateTextParameterIndex + 2, Integer.toString(temp));
				}

				// shift -1
				if (mutateShift == 1) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex + 2));
					temp -= 1;
					fittestGeneTemp.set(mateTextParameterIndex + 2, Integer.toString(temp));
				}

				// shift +1
				if (mutateShift == 2) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex + 2));
					temp += 1;
					fittestGeneTemp.set(mateTextParameterIndex + 2, Integer.toString(temp));
				}

				// shift +2
				if (mutateShift == 3) {
					int temp = Integer.valueOf(fittestGeneTemp.get(mateTextParameterIndex + 2));
					temp += 2;
					fittestGeneTemp.set(mateTextParameterIndex + 2, Integer.toString(temp));
				}
			}
		}

		else {
			// shift -2
			if (mutateShift == 0) {
				int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
				temp -= 2;
				fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
			}

			// shift -1
			if (mutateShift == 1) {
				int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
				temp -= 1;
				fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
			}

			// shift +1
			if (mutateShift == 2) {
				int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
				temp += 1;
				fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
			}

			// shift +2
			if (mutateShift == 3) {
				int temp = Integer.valueOf(fittestGeneTemp.get(mutationPoint));
				temp += 2;
				fittestGeneTemp.set(mutationPoint, Integer.toString(temp));
			}

		}
		population.addIndividual(new IndividualSquadSaraSquad(fittestGeneTemp));
		
		int leastFittestIndex = population.getLeastFittestIndex();
		population.individuals.remove(leastFittestIndex);

	}
	/*
	IndividualSquadSaraSquad getFittestOffspring() {
		ArrayList<String> gene = new ArrayList<String>();
		if (fittest.fitness > secondFittest.fitness) {
			for (int i = 0; i < fittest.gene.size(); i++) {
				gene.add(fittest.gene.get(i));
			}
		} else {
			for (int i = 0; i < secondFittest.gene.size(); i++) {
				gene.add(secondFittest.gene.get(i));
			}
		}
		return new IndividualSquadSaraSquad(gene);

	}

	void addFittestOffspring() {
		
	}
	*/
}
