package br.com.erudio.math;

public class SimpleMath {
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
    public Double subtract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }
    public Double multiply(Double numberOne,Double numberTwo) {
        return numberOne * numberTwo;
    }
    public Double divide(Double numberOne,Double numberTwo) {
        return numberOne / numberTwo;
    }
    public Double average(int[] numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
    public Double square(Double number) {
        return Math.sqrt(number);
    }
}
