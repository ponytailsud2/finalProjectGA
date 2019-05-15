package SquadSara;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//import Individual;

public class SquadSaraGA {

	PopulationSquadSara population = new PopulationSquadSara();
	IndividualSquadSara fittest;
	IndividualSquadSara secondFittest;
	static int generationCount = 0;

	public static void main(String[] args) throws IOException {
		SquadSaraGA geneticA = new SquadSaraGA();
		//fr = front , l = left, m = mid, r =right, b = back
				/*
				1 , 2 , 3
				4 , 5 , 6
				*/
				//p as parameter
				//deploy : (mod 2)supplicant/pylon, position -> 1-6 / random
				//selfSTRTillEnemyEnd(1-2): p1:(mod 2) 2?3/p2:(mod 3) any, ally, opponent
				/*selfSTRRelative(4-10) : (p1 mod 7) + 4
				 * 					
				 * p2-pX -> mod 2 : yes/no
				   pX+1 -> mod 3 : Allied, Enemy, Any
				   pX+2 -> mod 3 : 1?1.5?2
				   pX+3 -> mod 3 : Allied, Enemy, Any
				   pX+4 -> (mod 4) End_EnemyTurn , End_Turn , Leave_Field , Source_Down
				 */
				//DestroyManual(only ally destroy): p0 -> (mod 3) how many targets, p1 -> (mod2)condition self or cannot
				/*BuffAllySTR(4): p0 -> (mod 2) STR 
					p1 -> not use(allied only)
					p2 -> (mod 3) allied?Enemy?any
					p3 -> (mod 4) EndEnemyturn?EndTurn?LeaveField?SourceDown
				*/
				//DrawCard: p0 -> (mod 5)number of drew cards
				
		//supplicant
		ArrayList<Integer> supplicantTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> supplicantTextType = new ArrayList<Integer>();
		ArrayList<Integer> supplicantParameter1 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> supplicantTextParameter = new HashMap<Integer,ArrayList<Integer>>();
		
		supplicantTextTiming.add(1);
		supplicantTextType.add(0);
		supplicantParameter1.add(0);
		supplicantParameter1.add(0);
		supplicantTextParameter.put(0, supplicantParameter1);
		
		IndividualSquadSara supplicant = new IndividualSquadSara(0,2,1,1,supplicantTextTiming,supplicantTextType,supplicantTextParameter);
		
		//pylon
		ArrayList<Integer> pylonTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> pylonTextType = new ArrayList<Integer>();
		ArrayList<Integer> pylonParameter1 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> pylonTextParameter = new HashMap<Integer,ArrayList<Integer>>();
		
		pylonTextTiming.add(2);
		pylonTextType.add(0);
		pylonParameter1.add(0);
		pylonParameter1.add(0);
		pylonTextParameter.put(0, pylonParameter1);
		
		IndividualSquadSara pylon = new IndividualSquadSara(0,3,3,1,pylonTextTiming,pylonTextType,pylonTextParameter);
		//the chosen
		ArrayList<Integer> theChosenTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> theChosenTextType = new ArrayList<Integer>();
		ArrayList<Integer> theChosenParameter1 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> theChosenTextParameter = new HashMap<Integer,ArrayList<Integer>>();
		
		theChosenTextTiming.add(3);
		theChosenTextType.add(1);
		theChosenParameter1.add(6);
		theChosenParameter1.add(2);
		theChosenTextParameter.put(0, theChosenParameter1);
		
		IndividualSquadSara theChosen = new IndividualSquadSara(4,2,6,1,theChosenTextTiming,theChosenTextType,theChosenTextParameter);
	
		//commander avater
		ArrayList<Integer> commanderTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> commanderTextType = new ArrayList<Integer>();
		ArrayList<Integer> commanderParameter1 = new ArrayList<Integer>();
		ArrayList<Integer> commanderParameter2 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> commanderTextParameter = new HashMap<Integer,ArrayList<Integer>>();
		
		//deploy +str
		commanderTextTiming.add(1);
		commanderTextTiming.add(4);
		commanderTextType.add(2);
		commanderTextType.add(0);
		commanderParameter1.add(7);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter1.add(0);
		commanderParameter2.add(0);
		
		commanderTextParameter.put(0, commanderParameter1);
		commanderTextParameter.put(1, commanderParameter2);		
		
		IndividualSquadSara commander = new IndividualSquadSara(4,2,6,2,commanderTextTiming,commanderTextType,commanderTextParameter);

		//holy warrior
		ArrayList<Integer> holyWarriorTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> holyWarriorTextType = new ArrayList<Integer>();
		ArrayList<Integer> holyWarriorParameter1 = new ArrayList<Integer>();
		ArrayList<Integer> holyWarriorParameter2 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> holyWarriorTextParameter = new HashMap<Integer,ArrayList<Integer>>();
		
		//deployDestroyManual + drawCard
		holyWarriorTextTiming.add(1);
		holyWarriorTextTiming.add(1);
		holyWarriorTextType.add(3);
		holyWarriorTextType.add(5);
		holyWarriorParameter1.add(0);
		holyWarriorParameter1.add(1);
		holyWarriorParameter2.add(2);
		
		holyWarriorTextParameter.put(0, holyWarriorParameter1);
		holyWarriorTextParameter.put(1, holyWarriorParameter2);
		
		IndividualSquadSara holyWarrior = new IndividualSquadSara(1,2,2,2,holyWarriorTextTiming,holyWarriorTextType,holyWarriorTextParameter);
	
		//Amplifier
		ArrayList<Integer> amplifierTextTiming = new ArrayList<Integer>();
		ArrayList<Integer> amplifierTextType = new ArrayList<Integer>();
		ArrayList<Integer> amplifierParameter1 = new ArrayList<Integer>();
		//start from 0
		Map<Integer,ArrayList<Integer>> amplifierTextParameter = new HashMap<Integer,ArrayList<Integer>>();
				
		amplifierTextTiming.add(3);
		amplifierTextType.add(4);
		amplifierParameter1.add(0);
		amplifierParameter1.add(0);
		amplifierParameter1.add(2);
		amplifierParameter1.add(0);
		
		amplifierTextParameter.put(0, amplifierParameter1);
				
		IndividualSquadSara amplifier = new IndividualSquadSara(1,2,2,1,amplifierTextTiming,amplifierTextType,amplifierTextParameter);
		
		geneticA.population.addIndividual(supplicant);
		geneticA.population.addIndividual(pylon);
		geneticA.population.addIndividual(theChosen);
		geneticA.population.addIndividual(commander);
		geneticA.population.addIndividual(holyWarrior);
		geneticA.population.addIndividual(amplifier);
		
		ArrayList<IndividualSquadSara> firstgen = new ArrayList<IndividualSquadSara>();
		
		firstgen.add(supplicant);
		firstgen.add(pylon);
		firstgen.add(theChosen);
		firstgen.add(commander);
		firstgen.add(holyWarrior);
		firstgen.add(amplifier);
		
		geneticA.population.setFirstGen(firstgen);
		
		supplicant.calcFitness();
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		for(int i = 0;i<supplicant.geneLength;i++) {
			if(supplicant.genes[i]==1) {
				test.add(i);
			}
		}
		
		for(int i =0;i<supplicant.allPosition.size();i++) {
			System.out.print(supplicant.allPosition.get(i) + " ");
		}
		
		/*
		BufferedWriter writer = new BufferedWriter(new FileWriter("d:/SquadSaraUnitgenerationLog.txt"));
	    writer.write("Generation: " + generationCount+", Fitness: "+geneticA.population.fittest);
	    writer.close();
	    */
	}

	void selection() {

		// select the fittest
		fittest = population.getFittest();

		// select the second fittest
		secondFittest = population.getSecondFittest();
	}

	// finished
	void crossover() {
		Random rn = new Random();

		// Select a random crossover point
		int crossOverPoint = rn.nextInt(population.individuals.get(0).geneLength);
		int crossOverPosition = -1;

		for (int i = 0; i < fittest.allPosition.size(); i++) {
			if (crossOverPoint < fittest.allPosition.get(i)) {
				crossOverPosition = fittest.allPosition.get(i);
				break;
			}
		}

		// Swap values among parents
		for (int i = 0; i < crossOverPosition; i++) {
			int temp = fittest.genes[i];
			fittest.genes[i] = secondFittest.genes[i];
			secondFittest.genes[i] = temp;
		}
	}

	void mutation() {
		Random rn = new Random();
		int mutatablePoint = 2;
		int mutationPoint = rn.nextInt(mutatablePoint);
		int mutateShift = rn.nextInt(4);

		// shift -2
		if (mutateShift == 0) {

			for (int i = fittest.allPosition.get(mutationPoint); i < fittest.allPosition.get(mutationPoint + 1); i++) {
				if (fittest.genes[i] == 1) {
					fittest.genes[i] = 0;
					fittest.genes[i - 2] = 1;
					break;
				}
			}
		}

		// shift -1
		if (mutateShift == 1) {

			for (int i = fittest.allPosition.get(mutationPoint); i < fittest.allPosition.get(mutationPoint + 1); i++) {
				if (fittest.genes[i] == 1) {
					fittest.genes[i] = 0;
					fittest.genes[i - 1] = 1;
					break;
				}
			}
		}

		// shift +1
		if (mutateShift == 2) {

			for (int i = fittest.allPosition.get(mutationPoint); i < fittest.allPosition.get(mutationPoint + 1); i++) {
				if (fittest.genes[i] == 1) {
					fittest.genes[i] = 0;
					fittest.genes[i + 1] = 1;
					break;
				}
			}
		}

		// shift +2
		if (mutateShift == 3) {

			for (int i = fittest.allPosition.get(mutationPoint); i < fittest.allPosition.get(mutationPoint + 1); i++) {
				if (fittest.genes[i] == 1) {
					fittest.genes[i] = 0;
					fittest.genes[i + 2] = 1;
					break;
				}
			}
		}

	}
}
