package Model;

import java.util.List;

public class Layer {
    private List<Neuron> listOfNeurons;
    private int numberOfNeuronsInLayer;

    public List<Neuron> getListOfNeurons(){
        return this.listOfNeurons;
    }

    public void setListOfNeurons(List<Neuron> listOfNeurons){
        this.listOfNeurons = listOfNeurons;
    }

    public int getNumberOfNeuronsInLayer(){
        return this.numberOfNeuronsInLayer;
    }

    public void setNumberOfNeuronsInLayer(int numberOfNeuronsInLayer){
        this.numberOfNeuronsInLayer = numberOfNeuronsInLayer;
    }
}
