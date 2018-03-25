package com.omsu.imit.yana.basiclanguagejava;

public class ProductAverageInt {

    public static int product(int number1, int number2, int number3) {

        return number1 * number2 * number3;
    }

    public static double average(int number1, int number2, int number3) {

        return (number1 + number2 + number3) / 3.;
    }

    public static void sorting(int number1, int number2, int number3) {
        int[] array = new int[3];
        array[0] = number1;
        array[1] = number2;
        array[2] = number3;
        int t = 0;
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
            System.out.printf("%d ", array[i]);
        }
    }
}
