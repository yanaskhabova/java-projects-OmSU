package com.omsu.imit.yana.basiclanguagejava;

import com.omsu.imit.yana.simpleclasses.Point3D;

import java.util.Scanner;

import static com.omsu.imit.yana.basiclanguagejava.DecideSystemLineEquation.decideSystem;
import static java.lang.StrictMath.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //---------------DecideQuadratic---------------
/*
        DecideQuadratic quadratic=new DecideQuadratic();
        double a;
        System.out.printf("a * x^2 + b * x + c = 0\n");
        do {
            System.out.print("Enter the coefficients a: ");
            a = in.nextFloat();
            if(a==0){
                System.out.println("Enter non-zero size!");
            }
        } while (a == 0);
        System.out.print("Enter the coefficients (b, c): ");
        double b = in.nextFloat();
        double c = in.nextFloat();
        quadratic.decideQuatr(a, b, c);

*/
        //---------------DecideSystemLineEquation---------------
/*
        DecideSystemLineEquation s = new DecideSystemLineEquation();
        System.out.printf("a1 * x + b1 * y = c1;\na2 * x + b2 * y = c2;\n");
        /*System.out.printf("Enter coefficients of equations(a1, b1, c1, a2, b2, c2): ");
        double a1 = in.nextFloat();
        double b1 = in.nextFloat();
        double c1 = in.nextFloat();
        double a2 = in.nextFloat();
        double b2 = in.nextFloat();
        double c2 = in.nextFloat();
        decideSystem(0,0,0,0,0,0);
        decideSystem(0,0,1, 0,0,0);
        decideSystem(0,0,0, 0,0,1);
        decideSystem(0,0,1, 0,0,1);
        decideSystem(1,1,2, 2,2,3);
        decideSystem(1,0,10, 1,0,3);//
        decideSystem(0,10,1, 0,2,2);//

        decideSystem(0,0,0, 1,2,3);
        decideSystem(1,2,3,0,0,0);
        decideSystem(1,1,2, 2,2,4);
        decideSystem(1,1,0, 0,0,0);
        decideSystem(1,0,0,0,0,0);
        decideSystem(0,1,0, 0,0,0);
        decideSystem(0,0,0,1,0,0);
        decideSystem(0,0,0, 0,1,0);

        decideSystem(1,2,3,4,5,6);
        decideSystem(1,0,5,0,1,3);

*/
        //---------------ProductAverageFloat---------------
/*
        System.out.print("Enter three numbers: ");
        double number1 = in.nextFloat();
        double number2 = in.nextFloat();
        double number3 = in.nextFloat();

        System.out.printf("number1 * number2 * number3 = %f\n", ProductAverageFloat.product(number1,number2,number3));

        System.out.printf("average = %f\n", ProductAverageFloat.average(number1, number2, number3));

        System.out.println("numbers: ");
        ProductAverageFloat.sorting(number1,number2,number3);

*/
        //---------------ProductAverageInt---------------

/*
        System.out.print("Enter three numbers: ");
        int number1 = in.nextInt();
        int number2 = in.nextInt();
        int number3 = in.nextInt();

        System.out.printf("number1 * number2 * number3 = %d\n", ProductAverageInt.product(number1,number2,number3));

        System.out.printf("average = %f\n", ProductAverageInt.average(number1, number2, number3));

        System.out.println("numbers: ");
        ProductAverageInt.sorting(number1,number2,number3);

*/
        //---------------TabulateSIN---------------
/*
        TabulateSIN tabSin=new TabulateSIN();
        double step = 0;
        double xMin = 0, xMax = 0;
        do {
            System.out.printf("Enter step of tabulation: \n");
            step = in.nextFloat();
            if (step <= 0) {
                System.out.printf("Try again! Step should be a positive!\n");
            }
        } while (step <= 0);
        do {
            System.out.printf("Enter lower bound: \n");
            xMin = in.nextFloat();
            System.out.printf("Enter upper bound: \n");
            xMax = in.nextFloat();
            if(xMin >= xMax){
                System.out.printf("Try again! Upper bound should be more than lower!");
            }
        } while ((xMin >= xMax) || (xMax - xMin < step));
        tabSin.tabSin(step, xMin, xMax);

*/
        // ---------------TaylorSeriesEXP---------------
/*
        System.out.println("Enter (x) and accuracy:");
//        double x = in.nextDouble();
//        double eps = in.nextDouble();
        TaylorSeriesEXP k = new TaylorSeriesEXP();
        System.out.println( "Sum exp(x) ="+ k.taylorSeries(-1, 0.00001));
        k.taylorSeries(1, 0.00001);
        */
    }
}
