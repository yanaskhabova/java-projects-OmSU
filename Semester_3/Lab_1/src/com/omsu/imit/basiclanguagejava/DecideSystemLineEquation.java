package com.omsu.imit.yana.basiclanguagejava;

import java.io.*;
import java.util.Scanner;

public class DecideSystemLineEquation {

    public static void decideSystem(double a1, double b1, double c1, double a2, double b2, double c2) {
        double determinant=a1*b2-b1*a2;
        double dX = c1 * b2 - c2 * b1;
        double dY = a1 * c2 - a2 * c1;
        double x = dX / determinant;
        double y = dY / determinant;
        if (determinant != 0) {
            System.out.printf("The desicion: x = %f, y = %f \n", x, y);
        } else {
            if (dX == dY && dY == 0) {
                System.out.println("The system has infinitely number of decisions.");
            } else {
                System.out.println("The system of equations hasn't decisions.");
            }
        }
    }
}
