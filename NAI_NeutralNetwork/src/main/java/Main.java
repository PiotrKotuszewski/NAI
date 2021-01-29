import Model.*;
import util.MatrixReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final double LEARNING_RATE = 0.1;

    public static void main(String [] args) throws IOException {

        List<double []> expectedOut = new ArrayList<>();
        expectedOut.add(new double[]{1,0,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{1,0,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{1,0,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,1,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,1,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,1,0,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,1,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,1,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,1,0,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,1,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,1,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,1,0,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,1,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,1,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,1,0,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,1,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,1,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,1,0,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,1,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,1,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,1,0,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,1,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,1,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,1,0,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,1,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,1,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,1,0});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,0,1});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,0,1});
        expectedOut.add(new double[]{0,0,0,0,0,0,0,0,0,1});

        List<String> lines = Files.lines(Paths.get("C:\\Users\\piotr\\Desktop\\NAI\\ITN\\Projekt\\daneTreningowe.txt"))
                .map(String::trim)
                .collect(Collectors.toList());
        List<double[]> inArrays = MatrixReader.convert(lines);

        double [] testArray0 = new double[]{
                1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,0,0
        };

        double [] testArray1 = new double[]{
                1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1
        };

        double [] testArray4 = new double[]{
                1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1,1
        };

        double [] testArray6 = new double[]{
                1,0,0,0,1,1,0,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,0,1,1,0,0,0,1
        };

        NeuralNetwork neuralNetwork = new NeuralNetwork(30,17,10);

        neuralNetwork.train(inArrays, expectedOut, 5000,LEARNING_RATE);

        System.out.println("Test dla 0");

        System.out.println(neuralNetwork.test(testArray0));

        System.out.println("Test dla 1");

        System.out.println(neuralNetwork.test(testArray1));

        System.out.println("Test dla 4");

        System.out.println(neuralNetwork.test(testArray4));

        System.out.println("Test dla 6");

        System.out.println(neuralNetwork.test(testArray6));
    }
}