package bot.bp.ai.nn;

import bot.bp.ai.Parameters;

public class NeuralNetwork
{
	private int numInputs;
	private int numOutputs;
	private int numHiddenLayers;
	private int numNeuronsPerHiddenLayer;
	
	private NeuronLayer[] layers;
	
	NeuralNetwork()
	{
		createNetwork();
	}
	
	public void createNetwork()
	{
		layers = new NeuronLayer[numHiddenLayers];
		for (int i = 0; i < layers.length; i++)
			layers[i] = new NeuronLayer(numNeuronsPerHiddenLayer, numInputs);
	}
	
	public double[] getWeights()
	{
		return null;
	}
	
	public int getNumberOfWeights()
	{
		return numHiddenLayers * numNeuronsPerHiddenLayer * (numInputs + 1);
	}
	
	public void putWeights(double[] weights)
	{
		
	}
	
	public double[] update(double[] inputs)
	{
		double[] outputs = new double[numOutputs];
		int cWeight = 0;
		
		if (inputs.length != numInputs)
			return new double[0];
		
		for (int i = 0; i < numHiddenLayers + 1; i++)
		{
			if (i > 0)
				inputs = outputs;
			
			Neuron[] neurons = layers[i].getNeurons();
			for (int j = 0; j < neurons.length; i++)
			{
				double netInput = 0d;
				double[] weights = neurons[j].getWeights();
				for (int k = 0; k < weights.length - 1; i++)
					netInput += weights[k] * inputs[cWeight++];
				netInput += weights[weights.length - 1] * Parameters.bias;
				
				outputs[j] = sigmoid(netInput, Parameters.activationResnponse);
				cWeight = 0;
			}
		}
		return outputs;
	}
	
	public double sigmoid(double activation, double response)
	{
		return 1d / (1 + Math.pow(Math.E, (-activation / response)));
	}
	
}
