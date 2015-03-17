package bot.bp.ai.nn;

import java.util.Random;

public class Neuron
{
	private double[] weights;
	
	Neuron(int numInputs)
	{
		numInputs++;
		weights = new double[numInputs];
		Random rand = new Random();
		for (int i = 0; i < weights.length; i++)
			weights[i] = rand.nextDouble();
	}
	
	public double[] getWeights()
	{
		return weights;
	}
}
