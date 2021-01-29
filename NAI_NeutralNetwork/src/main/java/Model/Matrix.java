package Model;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private final double [][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        data = new double[rows][cols];

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public Matrix(int rows, int cols, boolean onlyZero){
        this.rows = rows;
        this.cols = cols;

        data = new double[rows][cols];

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = 0;
            }
        }
    }

    public void add(Matrix m)
    {
        if(cols!=m.cols || rows!=m.rows) {
            System.out.println("Shape Mismatch");
            return;
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                this.data[i][j]+=m.data[i][j];
            }
        }
    }

    /*

     */
    public static Matrix errorCal(Matrix expected, Matrix our){
        Matrix temp = new Matrix(expected.rows, expected.cols);
        for(int i=0;i<expected.cols;i++){
            for(int j=0;j<expected.rows;j++){
                temp.data[j][i]= our.data[j][i] * (1 - our.data[j][i]) * (expected.data[j][i] - our.data[j][i]);
            }
        }
        return temp;
    }

    /*
    Blad warstwy ukrytej =  sigmoidalenWyjscieWarstwyWejsciowej * ( 1 - sigmoidalenWyjscieWarstwyWejsciowej) *
    (Blad warstwy wyjsciowej * WyjscieWarstwyUkrytejPrzedSigoma)
     */
    public static Matrix backPropError(Matrix hiddenOut, Matrix outError, Matrix inputOut, double learning){
        Matrix temp = new Matrix(hiddenOut.rows, 1, true);

        double avgOutError = 0;
        for(int i =0; i <outError.toArray().size();i++)
            avgOutError += outError.toArray().get(i);

        avgOutError = avgOutError/outError.toArray().size();

        for(int i =0;i<temp.cols;i++){
            for(int j=0;j<temp.rows;j++) {
                temp.data[j][i] = (inputOut.data[j][i] * (1 - inputOut.data[j][i] )* (avgOutError * hiddenOut.data[j][i])) * learning;
            }
        }
        return temp;
    }

    /*
    W tej metodzie aktualizujemy wagi w warstwie wyjsciowej.
    Wzor to W(new) = W(old) + (learningRate*sygnalBledu*wartoscWejsciowa)
     */
    public static Matrix weightActualization(Matrix weights, Matrix error, double learningRate, Matrix hiddenLayerOut){
        Matrix temp = new Matrix(weights.rows, weights.cols);

        Matrix one = null;
        Matrix two = null;
        Matrix three = null;

        if(weights.toArray().size() == 51) {

            one = new Matrix(17, 1);
            two = new Matrix(17, 1);
            three = new Matrix(17, 1);
        }else if (weights.toArray().size() == 30){
            one = new Matrix(10, 1);
            two = new Matrix(10, 1);
            three = new Matrix(10, 1);
        }

        for(int i=0;i<one.cols;i++){
            for(int j=0;j<one.rows;j++){
                one.data[j][i]= weights.data[j][i] + (learningRate*error.data[j][i]* hiddenLayerOut.data[j][i]);
                temp.data[j][i] = one.data[j][i];
            }
        }

        for(int i=0;i<two.cols;i++){
            for(int j=0;j<two.rows;j++){
                two.data[j][i]= weights.data[j][i+1] + (learningRate*error.data[j][i]*hiddenLayerOut.data[j][i]);
                temp.data[j][i+1] = two.data[j][i];
            }
        }

        for(int i=0;i<three.cols;i++){
            for(int j=0;j<three.rows;j++){
                three.data[j][i]= weights.data[j][i+2] + (learningRate*error.data[j][i]*hiddenLayerOut.data[j][i]);
                temp.data[j][i+2] = three.data[j][i];
            }
        }

        return temp;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix temp=new Matrix(a.rows,b.cols);
        for(int i=0;i<temp.rows;i++)
        {
            for(int j=0;j<temp.cols;j++)
            {
                double sum=0;
                for(int k=0;k<a.cols;k++)
                {
                    sum+=a.data[i][k]*b.data[k][j];
                }
                temp.data[i][j]=sum;
            }
        }
        return temp;
    }

    public List<Double> toArray() {
        List<Double> temp= new ArrayList<>()  ;

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                temp.add(data[i][j]);
            }
        }
        return temp;
    }

    public static Matrix sigomidChange(Matrix a){
        for(int i=0;i<a.rows;i++)
        {
            for(int j=0;j<a.cols;j++)
            {
                a.data[i][j] = (1/(1+Math.exp(-a.data[i][j])));
            }
        }
        return a;
    }

    public static Matrix fromArray(double[]x)
    {
        Matrix temp = new Matrix(x.length,1);
        for(int i =0;i<x.length;i++)
            temp.data[i][0]=x[i];
        return temp;

    }
}