package counterOp;

import java.util.ArrayList;

public class IndividualCounterOp {

	int classCost;
	int anyCost;
	double fitness;
	int turnCount;
	String condition;
	String textType;
	// int textParameterCounter = 8;
	int textParameter;
	String text2Type;
	int text2Parameter;
	String attribute;

	ArrayList<String> gene = new ArrayList<String>();

	public IndividualCounterOp(ArrayList<String> gene) {
		this.gene = new ArrayList<String>(gene);

		this.classCost = Integer.valueOf(gene.get(0));
		this.anyCost = Integer.valueOf(gene.get(1));
		this.turnCount = Integer.valueOf(gene.get(2));
		this.condition = (gene.get(3));
		this.textType = gene.get(4);
		this.textParameter = Integer.valueOf(gene.get(5));
		this.text2Type = gene.get(6);
		this.text2Parameter = Integer.valueOf(gene.get(7));
		this.attribute = gene.get(8);

	}

	public IndividualCounterOp(int classCost, int anyCost, int turnCount, String condition, String textType,
			int textParameter, String text2Type, int text2Parameter, String attribute) {
		this.classCost = classCost;
		this.anyCost = anyCost;
		this.turnCount = turnCount;
		this.condition = condition;
		this.textType = textType;
		this.textParameter = textParameter;
		this.text2Type = text2Type;
		this.text2Parameter = text2Parameter;
		this.attribute = attribute;

		gene.add(Integer.toString(classCost));
		gene.add(Integer.toString(anyCost));
		gene.add(Integer.toString(turnCount));
		gene.add(condition);
		gene.add(textType);
		gene.add(Integer.toString(textParameter));
		gene.add(text2Type);
		gene.add(Integer.toString(text2Parameter));
		gene.add(attribute);
	}

	public boolean geneEqual(IndividualCounterOp ind2) {
		boolean same = true;
		for (int i = 0; i < gene.size(); i++) {
			if (this.gene.get(i) != ind2.gene.get(i)) {
				same = false;
			}
		}
		return same;
	}

	public double calcFitness() {
		fitness = 0;

		double balance = 0;

		if (classCost < 0 || anyCost < 0 || classCost + anyCost < 0) {
			fitness -= 1000;
		}

		if (textType == "" && text2Type == "") {
			fitness -= 1000;
		}

		if (textType == "EffectBombardManual" || textType == "EffectBombardRandom" || textType == "EffectBombardAutoAll"
				|| textType == "EffectBombardRandomDefender" || textType == "EffectBombardAutoSource"
				|| text2Type == "EffectBombardManual" || text2Type == "EffectBombardRandom"
				|| text2Type == "EffectBombardAutoAll" || text2Type == "EffectBombardAutoSource"
				|| text2Type == "EffectBombardRandomDefender") {
			if (attribute != "BAL") {
				fitness -= 1000;
			}
		}

		if (condition == "EffectCondition_EnemyAttack") {
			balance = (classCost + anyCost) + ((turnCount * (turnCount + 1)) / 2) + 1;
		} else if (condition == "") {
			balance = (classCost + anyCost) + (((turnCount + 1) * (turnCount + 2)) / 2) + 1;
		} else {
			balance = (classCost + anyCost) + ((turnCount * (turnCount + 1)) / 2) + 3;
		}

		// check text 1
		if (textType == "EffectRampEffectPutToHand") {
			balance -= textParameter * 4;
		}

		if (textType == "EffectDestroySelfEffectDrawCard") {
			balance -= ((textParameter * 2) - 2);
		}

		if (textType == "EffectDestroyManual") {
			balance -= (8 - textParameter);
		}

		if (textType == "EffectPutToHand" || textType == "EffectReduceTurnCountAuto" || textType == "EffectMillDeck") {
			balance -= (textParameter * 3);
		}

		if (textType == "EffectBombardAutoAll") {
			balance -= (textParameter + 1);
		}

		if (textType == "EffectBombardManual" || textType == "EffectDrawCard") {
			balance -= (textParameter * 2);
		}

		if (textType == "EffectFatigueRandom" || textType == "EffectBombardRandom" || textType == "EffectFatigueManual"
				|| textType == "EffectRamp") {
			balance -= textParameter;
		}

		if (textType == "EffectBombardAutoSource") {
			balance -= (textParameter - 4);
		}

		if (textType == "EffectGiveConstSTRManualOversoul" || textType == "EffectGiveConstSTRManualCost") {
			balance -= (textParameter - 1);
		}

		if (textType == "EffectBombardRandomDefender") {
			balance += (textParameter / 2.5);
		}

		// check text 2
		if (text2Type == "EffectRampEffectPutToHand") {
			balance -= (text2Parameter * 4);
		}

		if (text2Type == "EffectDestroySelfEffectDrawCard") {
			balance -= ((text2Parameter * 2) - 2);
		}

		if (text2Type == "EffectDestroyManual") {
			balance -= (8 - text2Parameter);
		}

		if (text2Type == "EffectPutToHand" || text2Type == "EffectReduceTurnCountAuto"
				|| text2Type == "EffectMillDeck") {
			balance -= text2Parameter * 3;
		}

		if (text2Type == "EffectBombardAutoAll") {
			balance -= (text2Parameter + 1);
		}

		if (text2Type == "EffectBombardManual" || text2Type == "EffectDrawCard") {
			balance -= text2Parameter * 2;
		}

		if (text2Type == "EffectFatigueRandom" || text2Type == "EffectBombardRandom"
				|| text2Type == "EffectFatigueManual" || text2Type == "EffectRamp") {
			balance -= text2Parameter;
		}

		if (text2Type == "EffectBombardAutoSource") {
			balance -= (text2Parameter - 4);
		}

		if (text2Type == "EffectGiveConstSTRManualCost" || text2Type == "EffectGiveConstSTRManualOversoul") {
			balance -= (text2Parameter - 1);
		}

		if (text2Type == "EffectBombardRandomDefender") {
			balance += (text2Parameter / 2.5);
		}

		if (balance > 0) {
			fitness += 2 - balance;
		} else {
			fitness += 2 + balance;
		}

		// System.out.println(fitness);

		return fitness;
	}
}
