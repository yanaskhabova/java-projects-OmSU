package com.omsu.imit.yana.basiclanguagejava;


public class ProductAverageFloat {

    public static double product(double number1, double number2, double number3) {
        return number1 * number2 * number3;
    }

    public static double average(double number1, double number2, double number3) {

        return (number1 + number2 + number3) / 3;
    }

    public static void sorting(double number1, double number2, double number3) {
        double[] array = new double[3];
        array[0] = number1;
        array[1] = number2;
        array[2] = number3;
        double t = 0;
        int j = 0;
        for (int i = 0; i < 3; i++) {
            t = array[i];
            j = i - 1;
            while ((j >= 0) && (t < array[j])) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = t;
        }
        for (int i = 0; i < 3; i++) {
            System.out.printf("%f ", array[i]);
        }
    }
}
