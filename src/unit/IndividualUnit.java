package unit;

import java.util.ArrayList;

public class IndividualUnit {
	double fitness;

	int classCost;
	int anyCost;
	String attribute;
	int str;
	String text1Timing;
	String text1Type;
	int text1Parameter1;
	int text1Parameter2;
	String text2Timing;
	String text2Type;
	int text2Parameter1;
	int text2Parameter2;
	String text3Timing;
	String text3Type;
	int text3Parameter1;
	int text3Parameter2;

	ArrayList<String> gene = new ArrayList<String>();
	
	public IndividualUnit(ArrayList<String> gene) {
		this.gene = gene;

		this.classCost = Integer.valueOf(gene.get(0));
		this.anyCost = Integer.valueOf(gene.get(1));
		this.attribute = gene.get(2);
		this.str = Integer.valueOf(gene.get(3));
		this.text1Timing = gene.get(4);
		this.text1Type = (gene.get(5));
		this.text1Parameter1 = Integer.valueOf(gene.get(6));
		this.text1Parameter2 = Integer.valueOf(gene.get(7));


		this.text2Timing = gene.get(8);
		this.text2Type = (gene.get(9));
		this.text2Parameter1 = Integer.valueOf(gene.get(10));
		this.text2Parameter2 = Integer.valueOf(gene.get(11));
		

		this.text3Timing = gene.get(12);
		this.text3Type = (gene.get(13));
		this.text3Parameter1 = Integer.valueOf(gene.get(14));
		this.text3Parameter2 = Integer.valueOf(gene.get(15));
	}

	public IndividualUnit(int classCost, int anyCost, String attribute, int str, String text1Timing, String text1Type,
			int text1Parameter1, int text1Parameter2, String text2Timing, String text2Type, int text2Parameter1,
			int text2Parameter2, String text3Timing, String text3Type, int text3Parameter1,int text3Parameter2) {
		this.classCost = classCost;
		this.anyCost = anyCost;
		this.attribute = attribute;
		this.str = str;
		this.text1Timing = text1Timing;
		this.text1Type = text1Type;
		this.text1Parameter1 = text1Parameter1;
		this.text1Parameter2 = text1Parameter2;

		this.text2Timing = text2Timing;
		this.text2Type = text2Type;
		this.text2Parameter1 = text2Parameter1;
		this.text2Parameter2 = text2Parameter2;
		

		this.text3Timing = text3Timing;
		this.text3Type = text3Type;
		this.text3Parameter1 = text3Parameter1;
		this.text3Parameter2 = text3Parameter2;
		
		gene.add(Integer.toString(classCost));
		gene.add(Integer.toString(anyCost));
		gene.add(attribute);
		gene.add(Integer.toString(str));
		
		gene.add(text1Timing);
		gene.add(text1Type);
		gene.add(Integer.toString(text1Parameter1));
		gene.add(Integer.toString(text1Parameter2));
		

		gene.add(text2Timing);
		gene.add(text2Type);
		gene.add(Integer.toString(text2Parameter1));
		gene.add(Integer.toString(text2Parameter2));
		

		gene.add(text3Timing);
		gene.add(text3Type);
		gene.add(Integer.toString(text3Parameter1));
		gene.add(Integer.toString(text3Parameter2));
	}
	
	public double calFitness() {
		return fitness;
	}
}
