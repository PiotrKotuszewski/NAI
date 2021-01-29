package Model;

import java.util.ArrayList;
import java.util.List;

public class OutputLayer {
    private Matrix matrix;
    private Matrix bias;
    private int neuronCount;
    private List<Neuron> neurons;
    private List<Double> weightsIn;
    private List<Double> biasIn;
    private Matrix outLayerOutMatrix;
    private Matrix expectedResponse;
    private Matrix outLayerError;

    public OutputLayer(int neuronCount) {
        matrix = new Matrix(neuronCount, 3);
        //bias = new Matrix(neuronCount, 1);
        this.neuronCount = neuronCount;
        neurons = new ArrayList<Neuron>(neuronCount);
        }

    public Matrix outLayerOut(Matrix a){
        outLayerOutMatrix = Matrix.multiply(matrix, a);
        //outLayerOutMatrix.add(bias);

        return outLayerOutMatrix;
    }

    public Matrix calOutLayerErrorBetter(Matrix expected, Matrix our){
        this.outLayerError = Matrix.errorCal(expected, our);
        return this.outLayerError;
    }

    public Matrix weightActualization(Matrix outWeight, Matrix error, double learningRate, Matrix hiddenLayerOut){
        this.matrix = Matrix.weightActualization(outWeight,error, learningRate, hiddenLayerOut);
        return this.matrix;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix getBias() {
        return bias;
    }

    public void setBias(Matrix bias) {
        this.bias = bias;
    }

    public int getNeuronCount() {
        return neuronCount;
    }

    public void setNeuronCount(int neuronCount) {
        this.neuronCount = neuronCount;
    }

    public Matrix getOutLayerError() {
        return outLayerError;
    }

    public void setOutLayerError(Matrix outLayerError) {
        this.outLayerError = outLayerError;
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

    public Matrix getOutLayerOutMatrix() {
        return outLayerOutMatrix;
    }

    public void setOutLayerOutMatrix(Matrix outLayerOutMatrix) {
        this.outLayerOutMatrix = outLayerOutMatrix;
    }

    public Matrix getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(Matrix expectedResponse) {
        this.expectedResponse = expectedResponse;
    }
}