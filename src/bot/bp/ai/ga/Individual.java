package bot.bp.ai.ga;

import bot.bp.ai.Parameters;

public class Individual
{
	private byte[] genes = new byte[Parameters.geneLength];
	
	private int fitness = 0;
	
	public void generateIndividual()
	{
		for (int i = 0; i < genes.length; i++)
			genes[i] = (byte) Math.round(Math.random());
	}
	
	public int getGene(int index)
	{
		return getGene(index, 1);
	}
	
	public int getGene(int index, int length)
	{
		int gene = 0;
		if (length > 4)
			length = 4;
		else if (length < 0)
			length = 1;
		
		for (int i = 0; i < length; i++)
			gene = (gene << 8) | genes[index + i]; 
		
		return gene;
	}
	
	public void setGene(int index, int value)
	{
		
	}
	
	public double getFitness()
	{
		//fitness = Fitness.calculate();
		return fitness;
	}
}
