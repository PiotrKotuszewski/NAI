package Model;

import java.util.List;

public class InputLayer {
    private Matrix matrix;
    private Matrix inputLayerOutMatrix;
    private int neuronCount;
    private List<Double> weightsIn;
    private List<Double> biasIn;
    private List<Double> biasTestIn;

    public InputLayer(int neuronCount) {
        this.matrix = new Matrix(neuronCount, 3);
       // bias = new Matrix(neuronCount, 1);
        this.neuronCount = neuronCount;

    }

    public Matrix inputLayerOut(Matrix a){
        this.inputLayerOutMatrix = Matrix.multiply(matrix, a);
        //inputLayerOutMatrix.add(bias);

        return this.inputLayerOutMatrix;
    }

    public int getNeuronCount() {
        return neuronCount;
    }

    public void setNeuronCount(int neuronCount) {
        this.neuronCount = neuronCount;
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

    public List<Double> getBiasTestIn() {
        return biasTestIn;
    }

    public void setBiasTestIn(List<Double> biasTestIn) {
        this.biasTestIn = biasTestIn;
    }

    public Matrix getInputLayerOutMatrix() {
        return inputLayerOutMatrix;
    }

    public void setInputLayerOutMatrix(Matrix inputLayerOutMatrix) {
        this.inputLayerOutMatrix = inputLayerOutMatrix;
    }

}
