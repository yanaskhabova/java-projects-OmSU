package com.omsu.imit.yana.basiclanguagejava;

import java.util.Scanner;

import static java.lang.StrictMath.sin;

public class TabulateSIN {

    public static void tabSin(double step, double xMin, double xMax){
        System.out.printf("     x       -->     sin x \n");
        for (double x = xMin; x < xMax + step / 2; x += step) {
            System.out.printf("%10.6f   -->   ", x);
            System.out.printf("%f\n", sin(x));
        }
    }
}
