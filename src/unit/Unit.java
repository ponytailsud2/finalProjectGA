package unit;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class Unit {
	PopulationUnit population = new PopulationUnit();
	int generationCount = 0;

	public static void main(String[] args) throws IOException {
		Random rn = new Random();

		BufferedWriter writer = new BufferedWriter(new FileWriter("D:/unit.txt"));

		IndividualUnit acolyte = new IndividualUnit(0, 2, "PSI", 2, "Inspired_Full", "EffectSelfSTRTillEnemyEnd", 3, 0,
				"", "", 0, 0, "", "", 0, 0);
		IndividualUnit supplicant = new IndividualUnit(0, 2, "PSI", 2, "Deploy", "EffectDeploy", 1, 0, "", "", 0, 0, "",
				"", 0, 0);
		IndividualUnit amplifier = new IndividualUnit(1, 2, "PSI", 2, "Inspired_Back", "EffectBuffAllySTR", 1, 0, "",
				"", 0, 0, "", "", 0, 0);
		IndividualUnit khala = new IndividualUnit(0, 3, "PSI", 3, "Active", "EffectDestroyManualAllied", 1, 0, "Active",
				"EffectRamp", 5, 0, "", "", 0, 0);
		IndividualUnit pylon = new IndividualUnit(0, 3, "PSI", 3, "Active", "EffectDeploy", 2, 0, "", "", 0, 0, "", "",
				0, 0);
		IndividualUnit spectre = new IndividualUnit(3, 0, "PSI", 1, "Legacy", "EffectDestroyRandom", 2, 0, "", "", 0, 0,
				"", "", 0, 0);
		IndividualUnit chosen = new IndividualUnit(2, 4, "PSI", 6, "Inspired_Full", "EffectSelfSTRTillEnemyEnd", 3, 0,
				"", "", 0, 0, "", "", 0, 0);
		IndividualUnit cAvartar = new IndividualUnit(3, 3, "PSI", 3, "Piercing", "", 0, 0, "Deploy",
				"EffectSelfSTRRelative", 1, 0, "", "", 0, 0);
		IndividualUnit hWarrior = new IndividualUnit(1, 2, "PSI", 2, "Deploy", "EffectDestroyManualAllied", 1, 0,
				"Deploy", "EffectDrawCard", 3, 0, "", "", 0, 0);

		IndividualUnit mortar = new IndividualUnit(1, 1, "BAL", 2, "Begin_Turn", "EffectBombardRandomStrongest", 2, 0,
				"", "", 0, 0, "", "", 0, 0);
		IndividualUnit assualt = new IndividualUnit(2, 2, "BAL", 1, "Deploy", "EffectBombardAutoFront", 4, 0, "Active",
				"EffectReturnSelf", 0, 0, "Active", "EffectRamp", 3, 0);
		IndividualUnit supplier = new IndividualUnit(0, 2, "BAL", 2, "Begin_Turn", "EffectRamp", 2, 0, "", "", 0, 0, "",
				"", 0, 0);
		IndividualUnit sacrifice = new IndividualUnit(0, 1, "BAL", 1, "Legacy", "EffectBombardAutoFront", 2, 0, "", "",
				0, 0, "", "", 0, 0);
		IndividualUnit turret = new IndividualUnit(1, 3, "BAL", 8, "Can't Attack", "", 0, 0, "", "", 0, 0, "", "", 0,
				0);
		IndividualUnit siegeTank = new IndividualUnit(1, 2, "BAL", 1, "Begin_Turn", "EffectMillDeck", 2, 0, "", "", 0,
				0, "", "", 0, 0);
		IndividualUnit cSupport = new IndividualUnit(2, 2, "BAL", 2, "Once_On_Board", "EffectBuffAllySTREnemy", 2, 0,
				"", "", 0, 0, "", "", 0, 0);
		IndividualUnit fGuard = new IndividualUnit(1, 2, "BAL", 2, "Begin_Turn", "EffectBombardAutoOtherFront", 2, 0,
				"", "", 0, 0, "", "", 0, 0);
		IndividualUnit scout = new IndividualUnit(0, 3, "BAL", 1, "Deploy", "EffectPutToHand", 1, 2, "", "", 0, 0, "",
				"", 0, 0);
		IndividualUnit oGuardian = new IndividualUnit(1, 2, "BAL", 1, "Once_On_Board", "EffectSelfSTRPermanentEnemy", 8,
				0, "End_TurnEnemy", "EffectBombardSelf", 1, 0, "", "", 0, 0);
		IndividualUnit fBetty = new IndividualUnit(2, 4, "BAL", 9, "End_TurnEnemy", "EffectBombardSelf", 2, 0, "", "",
				0, 0, "", "", 0, 0);

		IndividualUnit wrath = new IndividualUnit(2, 1, "SHA", 3, "Oversoul", "EffectSelfSTRTillEnd", 2, 2, "", "", 0,
				0, "", "", 0, 0);
		IndividualUnit bBringer = new IndividualUnit(1, 1, "SHA", 4, "Attack", "EffectDestroyRandomAllied", 0, 3, "",
				"", 0, 0, "", "", 0, 0);
		IndividualUnit sCollector = new IndividualUnit(1, 1, "SHA", 4, "Deploy", "EffectMillDeckAllied", 2, 0, "", "",
				0, 0, "", "", 0, 0);
		IndividualUnit pride = new IndividualUnit(3, 1, "SHA", 2, "Legacy", "EffectGiveConstSTRRandom", 1, 0,
				"Oversoul", "Piercing", 0, 4, "", "", 0, 0);
		IndividualUnit zhibok = new IndividualUnit(1, 0, "SHA", 1, "Oversouled", "EffectSelfSTRPermanent", 1, 0, "", "",
				0, 0, "", "", 0, 0);
		IndividualUnit sloth = new IndividualUnit(3, 2, "SHA", 4, "Oversoul", "EffectPutToHand", 1, 3, "NotAttack",
				"EffectSelfSTRPermanent", 2, 0, "", "", 0, 0);
		IndividualUnit lust = new IndividualUnit(2, 0, "SHA", 2, "Oversoul", "EffectSelfSTRPermanent", 1, 2, "", "", 0,
				0, "", "", 0, 0);
		IndividualUnit dContractor = new IndividualUnit(1, 1, "SHA", 2, "Active", "EffectSelfSTRTillEnd", 3, 0, "", "",
				0, 0, "", "", 0, 0);
		IndividualUnit envy = new IndividualUnit(2, 0, "SHA", 2, "Oversoul", "EffectDestroyManual", 2, 6, "", "", 0, 0,
				"", "", 0, 0);
		IndividualUnit gluttony = new IndividualUnit(2, 0, "SHA", 2, "Oversoul", "EffectSelfSTRPermanent", 2, 4, "", "",
				0, 0, "", "", 0, 0);
		IndividualUnit greed = new IndividualUnit(2, 1, "SHA", 2, "Legacy", "EffectDrawCard", 1, 0, "Oversoul",
				"EffectDrawCard", 1, 2, "", "", 0, 0);
		IndividualUnit animaRuki = new IndividualUnit(1, 0, "SHA", 4, "Legacy", "EffectDiscardRandom", 1, 0, "", "", 0,
				0, "", "", 0, 0);
	}

	public void crossover() {
		Random rn = new Random();
		for (int i = 0; i < population.getFitArray().size(); i++) {
			for (int j = i + 1; j < population.getFitArray().size(); j++) {
				ArrayList<String> parent1 = new ArrayList<String>(population.getFitArray().get(i).gene);
				ArrayList<String> parent2 = new ArrayList<String>(population.getFitArray().get(j).gene);
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

				population.individuals.add(new IndividualUnit(parent1));
				population.individuals.add(new IndividualUnit(parent2));

				int leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
				leastFittestIndex = population.getLeastFittestIndex();
				population.individuals.remove(leastFittestIndex);
			}
		}
	}

	public void mutation() {

	}
}
