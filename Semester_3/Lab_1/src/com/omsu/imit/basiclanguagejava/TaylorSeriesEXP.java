package com.omsu.imit.yana.basiclanguagejava;

import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class TaylorSeriesEXP {
    public static double taylorSeries(double x, double eps) {
        double sum, an;
        int n = 0;
        an = 1;
        sum = 0;
        while (Math.abs(an) > eps) {
            sum += an;
            n++;
            an *= x / n;
        }
        return sum;
    }
}


