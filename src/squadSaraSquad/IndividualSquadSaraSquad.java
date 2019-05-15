package squadSaraSquad;

import java.util.ArrayList;

public class IndividualSquadSaraSquad {
	int classCost;
	int anyCost;
	int leaderStr;
	int mateStr;
	double fitness = 0;
	int leaderPosition;

	int textCount = 4;

	ArrayList<String> matePosition = new ArrayList<String>();
	String textTiming;
	String textType;
	ArrayList<String> textParameter = new ArrayList<String>();
	String text2Timing;
	String text2Type;
	ArrayList<String> text2Parameter = new ArrayList<String>();
	String mateTextTiming;
	String mateTextType;
	ArrayList<String> mateTextParameter = new ArrayList<String>();
	ArrayList<String> gene = new ArrayList<String>();

	String attribute;

	public IndividualSquadSaraSquad() {

	}

	public IndividualSquadSaraSquad(ArrayList<String> gene) {

		this.gene = new ArrayList<String>(gene);
		this.classCost = Integer.valueOf(gene.get(0));
		this.anyCost = Integer.valueOf(gene.get(1));
		this.leaderStr = Integer.valueOf(gene.get(2));
		this.mateStr = Integer.valueOf(gene.get(3));
		this.leaderPosition = Integer.valueOf(gene.get(4));
		for (int i = 5; i < 10; i++) {
			this.matePosition.add(gene.get(i));
		}
		this.textTiming = gene.get(10);
		this.textType = gene.get(11);
		for (int i = 12; i < 16; i++) {
			this.textParameter.add(gene.get(i));
		}
		this.text2Timing = gene.get(16);
		this.text2Type = gene.get(17);
		for (int i = 18; i < 22; i++) {
			this.text2Parameter.add(gene.get(i));
		}
		this.mateTextTiming = gene.get(22);
		this.mateTextType = gene.get(23);
		for (int i = 24; i < 27; i++) {
			this.mateTextParameter.add(gene.get(i));
		}
		this.attribute = gene.get(27);
	}

	public IndividualSquadSaraSquad(int classCost, int anyCost, int leaderStr, int mateStr, int leaderPosition,
			ArrayList<String> matePosition, String textTiming, String textType, ArrayList<String> textParameter,
			String text2Timing, String text2Type, ArrayList<String> text2Parameter, String mateTextTiming,
			String mateTextType, ArrayList<String> mateTextParameter, String attribute) {
		this.classCost = classCost;
		this.anyCost = anyCost;
		this.leaderStr = leaderStr;
		this.mateStr = mateStr;
		/*
		 * [0][1][2] [3][4][5]
		 */
		this.leaderPosition = leaderPosition;
		this.matePosition = matePosition;
		this.textTiming = textTiming;
		this.textType = textType;
		this.textParameter = textParameter;

		this.text2Timing = text2Timing;
		this.text2Type = text2Type;
		this.text2Parameter = text2Parameter;
		this.mateTextTiming = mateTextTiming;
		this.mateTextType = mateTextType;
		this.mateTextParameter = mateTextParameter;

		this.attribute = attribute;

		gene.add(Integer.toString(classCost));
		gene.add(Integer.toString(anyCost));
		gene.add(Integer.toString(leaderStr));
		gene.add(Integer.toString(mateStr));
		gene.add(Integer.toString(leaderPosition));
		for (int i = 0; i < 5; i++) {
			if (i < matePosition.size())
				gene.add(matePosition.get(i));
			else
				gene.add("");
		}
		gene.add(textTiming);
		gene.add(textType);
		for (int i = 0; i < textCount; i++) {
			if (i < textParameter.size())
				gene.add(textParameter.get(i));
			else
				gene.add("");
		}

		gene.add(text2Timing);
		gene.add(text2Type);
		for (int i = 0; i < textCount; i++) {
			if (i < text2Parameter.size())
				gene.add(text2Parameter.get(i));
			else
				gene.add("");
		}

		gene.add(mateTextTiming);
		gene.add(mateTextType);
		for (int i = 0; i < textCount - 1; i++) {
			if (i < mateTextParameter.size())
				gene.add(mateTextParameter.get(i));
			else
				gene.add("");
		}
		gene.add(attribute);
	}

	public double calcFitness() {

		fitness = 0;

		// System.out.println(classCost);

		if (mateStr < 1 || leaderStr < 1 || classCost < 0 || anyCost < 0 || (classCost+anyCost) < 1) {
			 //System.out.println("check1");
			
			fitness -= 1000;
			// return fitness;
		}

		if ((classCost + anyCost) > 7 || mateStr > 8 || leaderStr > 8) {
			//System.out.println("check2");
			fitness -= 1000;
			// return fitness;
		}

		if (attribute != "PSI") {
			if (textTiming == "Inspired_Right" || textTiming == "Inspired_Left" || textTiming == "Inspired_Full"
					|| textTiming == "Inspired_Front" || text2Timing == "Inspired_Front") {
				//System.out.println("check3");
				fitness -= 1000;
			}
		}

		if (attribute != "BAL") {
			if (textType == "EffectBombardAuto" || textType == "EffectBombardRandom"
					|| mateTextType == "EffectBombardAuto") {
				//System.out.println("check4");
				fitness -= 1000;
			}
		}

		if (leaderPosition < 0) {
			//System.out.println("check5");
			fitness -= 1000;
		}
		
		for (int i = 0; i < matePosition.size(); i++) {
			
			for (int j = i + 1; j < matePosition.size(); j++) {
				if (matePosition.get(i) == matePosition.get(j)) {
					//System.out.println("check6");
					fitness -= 1000;
				}
			}
			
			if (matePosition.get(i) != "") {
				if (Integer.valueOf(matePosition.get(i)) == leaderPosition) {
					//System.out.println("check7");
					fitness -= 1000;
				}
				if (Integer.valueOf(matePosition.get(i)) < 0 || Integer.valueOf(matePosition.get(i)) > 5) {
					//System.out.println("check8");
					fitness -= 1000;
				}

			}

		}

		double balance = 0;

		balance += leaderStr + (mateStr * matePosition.size()) - (classCost + anyCost + 2 + matePosition.size());

		// Inspired should not be able to inspired by itself
		if (textTiming == "Inspired_Right" && ((leaderPosition == 2 && matePosition.contains("5"))
				|| (leaderPosition == 5 && matePosition.contains("2")
						|| (matePosition.contains("2") && matePosition.contains("5"))))) {
			fitness -= 100;
			// return fitness;
		}

		if (textTiming == "Inspired_Left" && ((leaderPosition == 0 && matePosition.contains("3"))
				|| (leaderPosition == 3 && matePosition.contains("0")
						|| (matePosition.contains("0") && matePosition.contains("3"))))) {
			fitness -= 100;
			// return fitness;
		}
		if (textTiming == "Inspired_Full" && matePosition.size() == 5) {
			fitness -= 100;
			// return fitness;
		}

		ArrayList<String> positionCheck = new ArrayList<String>();
		positionCheck.add(Integer.toString(leaderPosition));
		for (int i = 0; i < matePosition.size(); i++) {
			positionCheck.add(matePosition.get(i));
		}
		if (textTiming == "Inspired_Front" && positionCheck.contains("0") && positionCheck.contains("1")
				&& positionCheck.contains("3")) {
			fitness -= 100;
		}
		
		if (text2Timing == "Inspired_Front" && positionCheck.contains("0") && positionCheck.contains("1")
				&& positionCheck.contains("3")) {
			fitness -= 100;
		}

		// if(outOfRule)return fitness;

		// +STR mate use same rule as +STR itself
		if (textTiming == "Inspired_Right" || textTiming == "Inspired_Left" || textTiming == "Inspired_Front") {
			if (textType == "EffectSelfSTRTillEnemyEnd" && Integer.valueOf(textParameter.get(0)) > 0
					&& Integer.valueOf(textParameter.get(0)) < 7) {
				balance += (Double.valueOf(textParameter.get(0)) / 2);
			} else if (textType == "EffectBuffAllySTR") {
				if (textParameter.get(1) == "Squadmate" && textParameter.get(2) == "Any"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 5) {
					balance += (Double.valueOf(textParameter.get(0)) / 2);
				} else if (textParameter.get(1) == "Squadmate" && textParameter.get(2) == "Enemy"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 7) {
					balance += Double.valueOf(textParameter.get(0));
				}
				// half board ouen 2:1
				else if (textParameter.get(1) == "Allied" && textParameter.get(2) == "Any"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 3) {
					balance += (2 * Double.valueOf(textParameter.get(0)));
				} else if (textParameter.get(1) == "Allied" && textParameter.get(2) == "Enemy"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 5) {
					balance += Double.valueOf(textParameter.get(0));
				} else {
					fitness -= 100;
				}
			} else {
				fitness -= 100;
			}
		}

		if (textTiming == "Inspired_Full") {
			if (textType == "EffectSelfSTRTillEnemyEnd" && Integer.valueOf(textParameter.get(0)) > 0
					&& Integer.valueOf(textParameter.get(0)) < 7) {
				balance += (Double.valueOf(textParameter.get(0)) / 3);
			} else if (textType == "EffectBuffAllySTR") {
				if (textParameter.get(1) == "Squadmate") {
					if (textParameter.get(2) == "Any" && Integer.valueOf(textParameter.get(0)) > 0
							&& Integer.valueOf(textParameter.get(0)) < 4) {
						balance += (Double.valueOf(textParameter.get(0)) / 3);
					}
					else if (textParameter.get(2) == "Enemy" && Integer.valueOf(textParameter.get(0)) > 0
							&& Integer.valueOf(textParameter.get(0)) < 7) {
						balance += (Double.valueOf(textParameter.get(0)) / 6);
					}
				}
				// full board ouen 2:2
				else if (textParameter.get(1) == "Allied" && textParameter.get(2) == "Any"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 3) {
					balance += (Double.valueOf(textParameter.get(0)));
				} else if (textParameter.get(1) == "Allied" && textParameter.get(2) == "Enemy"
						&& Integer.valueOf(textParameter.get(0)) > 0 && Integer.valueOf(textParameter.get(0)) < 5) {
					balance += Double.valueOf(textParameter.get(0)) / 2;
				}
			} else {
				fitness -= 100;
			}
		}

		// Continuous
		if (textTiming == "Once_On_Board") {
			if (textType == "EffectSelfSTRPermanent" && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) / 2);
			} else {
				fitness -= 100;
			}
		}

		// Legacy
		if (textTiming == "Legacy") {
			if (textType == "EffectDrawCard" && (Integer.valueOf(textParameter.get(0)) < 3)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)));
			} else if (textType == "EffectBombardAuto" && (Integer.valueOf(textParameter.get(2)) < 3)
					&& (Integer.valueOf(textParameter.get(2)) > 0)) {
				balance += (Double.valueOf(textParameter.get(2)) * 5) / 2;
			} else if (textType == "EffectBombardRandom" && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) / 2);
			} else if (textType == "EffectBuffAllySTR" && textParameter.contains("Allied")
					&& textParameter.contains("Any") && (Integer.valueOf(textParameter.get(0)) < 3)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2);
			} else if (textType == "EffectBuffAllySTR" && textParameter.contains("Squadmate")
					&& textParameter.contains("Any") && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2) / 3;
			} else {
				fitness -= 100;
			}
		}

		if (textTiming == "Begin_Turn") {
			if (textType == "EffectDrawCard" && (Integer.valueOf(textParameter.get(0)) < 3)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2);
			} else if (textType == "EffectBombardAuto" && (Integer.valueOf(textParameter.get(2)) < 3)
					&& (Integer.valueOf(textParameter.get(2)) > 0)) {
				balance += (Double.valueOf(textParameter.get(2)) * 5) / 2;
			} else if (textType == "EffectBombardRandom" && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) / 2);
			} else if (textType == "EffectBuffAllySTR" && textParameter.contains("Allied")
					&& textParameter.contains("Any") && (Integer.valueOf(textParameter.get(0)) < 3)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2);
			} else if (textType == "EffectBuffAllySTR" && textParameter.contains("Squadmate")
					&& textParameter.contains("Any") && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2) / 3;
			} else if (textType == "EffectSelfSTRTillEnemyEnd" && (Integer.valueOf(textParameter.get(0)) < 7)
					&& (Integer.valueOf(textParameter.get(0)) > 0)) {
				balance += (Double.valueOf(textParameter.get(0)) * 2) / 3;
			} else {
				fitness -= 100;
			}
		}

		if (text2Timing == "Inspired_Front") {
			// there is only 1 text for text2
			balance += 1;
		}
		
		
		//mateText = Legacy
		if (mateTextTiming == "Legacy") {
			if (mateTextType == "EffectDrawCard" && (Integer.valueOf(mateTextParameter.get(0)) < 3)
					&& (Integer.valueOf(mateTextParameter.get(0)) > 0)) {
				balance += (Double.valueOf(mateTextParameter.get(0))* matePosition.size());
			}
			else if (mateTextType == "EffectBombardAuto" && (Integer.valueOf(mateTextParameter.get(2)) < 5)
					&& (Integer.valueOf(mateTextParameter.get(2)) > 0)) {
				balance += (Double.valueOf(mateTextParameter.get(2)) / 2)*matePosition.size();
			} else {
				fitness -= 100;
			}
		}

		/*
		 * 2 = balance(0) + 2 1 = balance(-1) +2 1 = 2 - balance(1)
		 */
		if (balance < 0) {
			fitness += balance + 2;
		} else {
			fitness += 2 - balance;
		}
		return fitness;
	}

	public boolean geneEqual(IndividualSquadSaraSquad ind2) {
		boolean same = true;
		for (int i = 0; i < this.gene.size(); i++) {
			if(this.gene.get(i)!=ind2.gene.get(i)) {
				same = false;
			}
		}
		return same;
	}
}
