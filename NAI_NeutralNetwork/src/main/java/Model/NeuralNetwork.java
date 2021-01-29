package Model;

import java.util.Collections;
import java.util.List;

public class NeuralNetwork {
    private final InputLayer inputLayer;
    private final HiddenLayer hiddenLayer;
    private final OutputLayer outputLayer;
    int iteration = 0;

    public NeuralNetwork(int inputNeurons, int hiddenNeurons, int outNeurons) {
        inputLayer = new InputLayer(inputNeurons);
        hiddenLayer = new HiddenLayer(hiddenNeurons);
        outputLayer = new OutputLayer(outNeurons);
    }

    public void train(List<double []> inList, List<double []> expectedList,  int epos, double LEARNING_RATE) {

        Matrix expectedArray = null;
        Matrix in;

        for (int i = 0; i < epos; i++) {
            for(int j=0;j<inList.size();j++) {

                if(iteration == 0) {

                    in = Matrix.fromArray(inList.get(j));
                    expectedArray = Matrix.fromArray(expectedList.get(j));
                }else{
                    int random = (int)(Math.random() * 28 + 1);
                    in = Matrix.fromArray(inList.get(random));
                    expectedArray = Matrix.fromArray(expectedList.get(random));
                }

                Matrix net = inputLayer.inputLayerOut(in);

                Matrix a = Matrix.sigomidChange(net); //Wyjscie pierwszej warstwy

                Matrix net2 = hiddenLayer.hiddenLayerOut(a);

                Matrix b = Matrix.sigomidChange(net2); // Wyjsciej warstwy ukrytej

                outputLayer.outLayerOut(b);

                Matrix c = Matrix.sigomidChange(outputLayer.getOutLayerOutMatrix()); // Wyjscie calej sieci

                outputLayer.setExpectedResponse(expectedArray);

                Matrix outError = outputLayer.calOutLayerErrorBetter(expectedArray, c); // Blad sieci wyjsciowej wzor
                double avgError = 0;

                for(int z=0;z<outError.toArray().size();z++){
                    avgError += outError.toArray().get(z);
                }
                System.out.println("Sredni blad sieci: "+ avgError/10);

                outputLayer.weightActualization(outputLayer.getMatrix(), outError, LEARNING_RATE, b);

                Matrix hiddenError = hiddenLayer.calOutLayerError(net2, outError, a, LEARNING_RATE);

                hiddenLayer.weightActualization(hiddenLayer.getMatrix(), hiddenError, LEARNING_RATE, a);

            }
            iteration++;
            }
        }

        public int test (double [] inTest){
            Matrix net = inputLayer.inputLayerOut(Matrix.fromArray(inTest));

            Matrix a = Matrix.sigomidChange(net); //Wyjscie pierwszej warstwy

            Matrix net2 = hiddenLayer.hiddenLayerOut(a);

            Matrix b = Matrix.sigomidChange(net2); // Wyjsciej warstwy ukrytej

            Matrix c = Matrix.sigomidChange(outputLayer.outLayerOut(b));
            System.out.println(c.toArray());

            double max = Collections.max(c.toArray());

            return c.toArray().indexOf(max);
        }
}
