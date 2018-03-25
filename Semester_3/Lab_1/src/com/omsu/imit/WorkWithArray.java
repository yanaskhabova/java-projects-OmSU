package com.omsu.imit.yana;

import java.util.Scanner;

public class WorkWithArray {
    private int[] array;
    private static Scanner in = new Scanner(System.in);

    public WorkWithArray(int size) {
        array = new int[size];
    }


    public int[] enterFromKeyboard(int size) {

        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    public void outputOnScreen() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("\n");
    }

    public int sumAllElements() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int amountEvenNumbers() {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public int amountElementsInAB(double a, double b) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (a <= array[i] && array[i] <= b) {
                result++;
            }
        }
        return result;
    }

    public boolean checkPositiveAllElements() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public void invertArray() {
        int buffer = 0;
        for (int i = 0, k = array.length - 1; i < array.length / 2; i++, k--) {
            buffer = array[i];
            array[i] = array[k];
            array[k] = buffer;

        }
    }

    public static void main(String[] args) {
        int size;
        do {
            System.out.printf("Enter size of array: ");
            size = in.nextInt();
        } while (size <= 0);

        System.out.printf("Enter %d elements of array: ", size);
        WorkWithArray arr = new WorkWithArray(size);
        arr.enterFromKeyboard(size);
        arr.outputOnScreen();
        System.out.printf("Sum = %d\n", arr.sumAllElements());
        System.out.printf("Amount even numbers = %d\n", arr.amountEvenNumbers());
        float a;
        float b;
        do {
            System.out.printf("\nEnter boundary line [a,b]: ");
            a = in.nextFloat();
            b = in.nextFloat();
        } while (a > b);
        System.out.printf("Amount elements in [%f,%f] = %d\n", a, b, arr.amountElementsInAB(a, b));
        System.out.println("Check positive all elements: " + arr.checkPositiveAllElements());
        System.out.println("Inverting array: ");
        arr.invertArray();
        arr.outputOnScreen();

        in.close();
    }
}