package Model;

import java.util.ArrayList;
import java.util.List;

public class HiddenLayer {
    private Matrix matrix;
    private Matrix bias;
    private int neuronCount;
    private Matrix hiddenLayerError;
    private List<Neuron> neurons;
    private List<Double> weightsIn;
    private List<Double> biasIn;
    private Matrix hiddenLayerOutMatrix;

    public HiddenLayer(int neuronCount) {
        this.matrix = new Matrix(neuronCount, 3);
       // bias = new Matrix(neuronCount, 1);
        this.neuronCount = neuronCount;
        neurons = new ArrayList<Neuron>(neuronCount);
    }

    public Matrix hiddenLayerOut(Matrix a){
        this.hiddenLayerOutMatrix = Matrix.multiply(matrix, a);
       // hiddenLayerOutMatrix.add(bias);

        return this.hiddenLayerOutMatrix;
    }

    public Matrix calOutLayerError(Matrix hiddenWeight, Matrix outError, Matrix inputOut, double lear){
        this.hiddenLayerError = Matrix.backPropError(hiddenWeight, outError, inputOut, lear);
        return this.hiddenLayerError;
    }

    public Matrix weightActualization(Matrix outWeight, Matrix error, double learningRate, Matrix inputLayerOut){
        this.matrix = Matrix.weightActualization(outWeight,error, learningRate, inputLayerOut);
        return this.matrix;
    }

    public int getNeuronCount() {
        return neuronCount;
    }

    public void setNeuronCount(int neuronCount) {
        this.neuronCount = neuronCount;
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(List<Neuron> neurons) {
        this.neurons = neurons;
    }

    public List<Double> getWeightsIn() {
        return weightsIn;
    }

    public void setWeightsIn(List<Double> weightsIn) {
        this.weightsIn = weightsIn;
    }

    public List<Double> getBiasIn() {
        return biasIn;
    }

    public void setBiasIn(List<Double> biasIn) {
        this.biasIn = biasIn;
    }

    public Matrix getHiddenLayerOutMatrix() {
        return hiddenLayerOutMatrix;
    }

    public void setHiddenLayerOutMatrix(Matrix hiddenLayerOutMatrix) {
        this.hiddenLayerOutMatrix = hiddenLayerOutMatrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getHiddenLayerError() {
        return hiddenLayerError;
    }

    public void setHiddenLayerError(Matrix hiddenLayerError) {
        this.hiddenLayerError = hiddenLayerError;
    }

    @Override
    public String toString() {
        return "HiddenLayer{" +
                "neuronCount=" + neuronCount +
                ", hiddenLayerError=" + hiddenLayerError +
                ", neurons=" + neurons +
                ", weightsIn=" + weightsIn +
                ", biasIn=" + biasIn +
                '}';
    }
}
