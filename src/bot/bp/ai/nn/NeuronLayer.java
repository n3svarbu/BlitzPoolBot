package bot.bp.ai.nn;

public class NeuronLayer
{
	private Neuron[] neurons;
	
	NeuronLayer(int numNeurons, int numInputsPerNeuron)
	{
		neurons = new Neuron[numNeurons];
		for (int i = 0; i < neurons.length; i++)
			neurons[i] = new Neuron(numInputsPerNeuron);
	}
	
	public Neuron[] getNeurons()
	{
		return neurons;
	}
}
