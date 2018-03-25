package com.omsu.imit.yana.basiclanguagejava;

import static java.lang.Math.sqrt;

public class DecideQuadratic {
    public void decideQuatr(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("The equation hasn't float roots!");
        } else if (discriminant == 0) {
            double x1 = ((b = -b) + sqrt(discriminant)) / (2 * a);
            System.out.printf("The equation has one float root: %f", x1);
        } else {
            double x1 = ((b = -b) + sqrt(discriminant)) / (2 * a);
            double x2 = (b - sqrt(discriminant)) / (2 * a);
            System.out.printf("The equation has two float roots: %f and %f", x1, x2);
        }
    }
}
