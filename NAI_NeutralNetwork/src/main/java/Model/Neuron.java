package Model;

public class Neuron {
    private double weight;
    private double biasWeight;

    public Neuron(){
        this.weight =  Math.random()*2 - 1;
        this.biasWeight = Math.random()*2 - 1;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBiasWeight() {
        return biasWeight;
    }

    public void setBiasWeight(double biasWeight) {
        this.biasWeight = biasWeight;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "weight=" + weight +
                ", biasWeight=" + biasWeight +
                '}';
    }
}
