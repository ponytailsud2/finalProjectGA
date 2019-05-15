package SquadSara;

import java.util.ArrayList;
import java.util.Map;

class IndividualSquadSara {
	// array size
	int geneLength = 384;
	int fitness = 0;
	int[] genes = new int[geneLength];

	
	// start of the parameter
	ArrayList<Integer> allPosition = new ArrayList<Integer>();
 
	// length of parameters
	int classCostLength = 4;
	int anyCostLength = 6;
	int strLength = 11;
	
	int textCount = 3;
	//[notext,deploy,active,reactive,basetrait]
	int textTimingLength = 5;
	//[deploy,selfSTRTillEnemyEnd,selfSTRRelative, destroyManual,BuffAllySTR,drawcard]
	int textTypeLength = 6;
	int textParameterCount = 11;
	//fr = front , l = left, m = mid, r =right, b = back
	/*
	1 , 2 , 3
	4 , 5 , 6
	*/
	//p as parameter
	//deploy : (mod 2)supplicant/pylon, position -> 1-6 / random
	//selfSTRTillEnemyEnd(1-2) :0-5?6-10/ p1:2 -> 0-5, 3 -> 6-10/p2: ally -> 0-5, opponent -> 6-10
	/*selfSTRRelative(4-10) : (p1 mod 7) + 4
	 * 					
	 * p2-pX -> 0-5?6-10 : yes/no
	   pX+1 -> 0-3?4-6?7-10 : Allied, Enemy, Any
	   pX+2 -> 
	   pX+3 -> 0-3?4-6?7-10 : Allied, Enemy, Any
	   pX+4 -> (mod 4) End_EnemyTurn , End_Turn , Leave_Field , Source_Down
	 */
	//DestroyManual(only ally destroy): p0 -> (mod 3) how many targets, p1 -> (mod2)condition self?cannot
	/*BuffAllySTR(4): p0 -> (mod 2) STR 
		p1 -> not use(allied only)
		p2 -> (mod 3) allied?Enemy?any
		p3 -> (mod 4) EndEnemyturn?EndTurn?LeaveField?SourceDown
	*/
	//DrawCard: p0 -> (mod 5)number of drew cards 0->1
	int textParameterLength = 10;

	// for crossover and mutation
	int classCostPosition;
	int anyCostPosition;
	int strPosition;
	ArrayList<Integer> textTimingPosition = new ArrayList<Integer>();
	ArrayList<Integer> textTypePosition = new ArrayList<Integer>();
	ArrayList<Integer> textParameterPosition = new ArrayList<Integer>();
	

	// constructor for initialize
	public IndividualSquadSara(int classCost, int anyCost, int str, int textCount, ArrayList<Integer> textTiming,
			ArrayList<Integer> textType, Map<Integer, ArrayList<Integer>> textParameter) {
		
		this.textCount = textCount;
		
		int counter = classCostLength;
		classCostPosition = counter;
		allPosition.add(counter);

		genes[classCost] = 1;
		genes[counter + anyCost+1] = 1;
		//allPosition.add(counter);
		
		counter += anyCostLength;
		anyCostPosition = counter;
		allPosition.add(counter);

		genes[counter + str] = 1;

		counter += strLength;
		strPosition = counter;
		allPosition.add(counter);

		for (int i = 0; i < textCount; i++) {
			if (i < textTiming.size())
				genes[counter + textTiming.get(i)] = 1;

			counter += textTimingLength;
			textTimingPosition.add(counter);
			allPosition.add(counter);

			if (i < textTiming.size())
				//System.out.println(counter);
				//System.out.println(textType.get(i));
				genes[counter + textType.get(i)] = 1;

			counter += textTypeLength;
			textTypePosition.add(counter);
			allPosition.add(counter);

			for (int j = 0; j < textParameterCount; j++) {
				if (j < textParameter.get(i).size()) {
					genes[counter + textParameter.get(i).get(j)] = 1;
				}

				counter += textParameterLength;
				textParameterPosition.add(counter);
				allPosition.add(counter);
			}
		}
	}

	// fittest function

	public void setFitness(int i) {
		fitness = i;
	}
	
	public void calcFitness() {

			int balance = 0;
			
			int costClass = 0;
			int costAny = 0;
			int str = 0;
			
			for (int i = 0; i <= allPosition.get(0); i++) {
				if (genes[i] == 1) {
					costClass = i;
					System.out.println(i);
					break;
				}
			}
			
			//System.out.println(allPosition.get(1));
			//System.out.println(allPosition.get(2));
			
			if(textCount == 0) {
				
			}
			
			for (int i = allPosition.get(0)+1; i <= allPosition.get(1); i++) {
				if (genes[i] == 1) {
					//cost can be 0, so there are 0 position
					costAny = i-allPosition.get(0)-1;
					System.out.println(costAny);
					break;
				}
			}
			
			for (int i = allPosition.get(1)+1; i <= allPosition.get(2); i++) {
				if (genes[i] == 1) {
					//str cannot be 0 so there are no 0 position of str
					str = i-allPosition.get(1);
					System.out.println(str);
					break;
				}
			}
			
			balance += str -(costClass+costAny+1);
			
			ArrayList<String> text = new ArrayList<String>();
			
			
			for (int i = allPosition.get(2)+1;i<=allPosition.get(3);i++) {
				if(genes[i] == 1) {
					if(i-allPosition.get(2)==1) {
						break;
					}
					if(i-allPosition.get(2)==2) {
						for(int j = allPosition.get(3)+1;j<=allPosition.get(4);j++) {
							if(genes[j]==1) {
								
							}
						}
					}
				}
			}
			
			}
		
}