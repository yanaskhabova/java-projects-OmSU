package com.omsu.imit.yana.simpleclasses;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//----------------Point3D---------------------

        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(10, 9, 1738);
        Point3D p3 = new Point3D(10, 9, 1738);
        Point3D p4 = new Point3D(2, 4, 5);
        Point3D p5 = new Point3D();
        Point3D p6 = new Point3D(1, 1, 1);
/*
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);
        System.out.println("p5: " + p5);
        System.out.println("p1 and p2: " + p1.checkEquality(p2));
        System.out.println("p3 and p2: " + p3.checkEquality(p2));
        System.out.println("p1 and p4: " + p1.checkEquality(p4));
        System.out.println("p1 and p5: " + p1.checkEquality(p5));
        System.out.println("p5 and p5: " + p5.checkEquality(p5));
        System.out.println("p1: " + p1 + "-->");
        p1.setX(10);
        p1.setY(9);
        p1.setZ(1738);
        System.out.println(p1);
        System.out.println("p1 and p2: "+p1.checkEquality(p2));
*/
        //----------------Vector3D-------------------

        Vector3D v1 = new Vector3D(100, 200, 300);
        Vector3D v2 = new Vector3D();
        Vector3D v3 = new Vector3D(p1, p4);// [1,2,2]
        Vector3D v4 = new Vector3D(100, 200, 300);
        Vector3D v5 = new Vector3D(1, -1, -3);
        Vector3D v6 = new Vector3D(3, 6, 9);
/*
        System.out.println("v1:"+v1);
        System.out.println("v2:"+v2);
        System.out.println("v3:"+v3);
        System.out.println("v4:"+v4);

        System.out.println("\n|v1| = " + v1.lengthVector());
        System.out.println("|v2| = " + v2.lengthVector());
        System.out.println("|v3| = " + v3.lengthVector());
        System.out.println("|v4| = " + v4.lengthVector());
        System.out.println("check equality v1 " + v1 + "& v2" + v2 + ": " + v1.checkEquality(v2));
        System.out.println("check equality v1 " + v1 + "& v4" + v4 + ": " + v1.checkEquality(v4));
        System.out.println("check equality v1 " + v1 + "& v1" + v1 + ": " + v1.checkEquality(v1));
*/
        //----------------Vector3DProcessor---------------------
/*
        System.out.println("Sum " + Vector3DProcessor.sumVector(v1, v3));
        System.out.println("Substruct " + Vector3DProcessor.subtractVector(v2, v4));
        System.out.println("Substruct " + Vector3DProcessor.subtractVector(v4, v2));
        System.out.println("scalar multiplication v1 & v2: " + Vector3DProcessor.scalarMultiplication(v1, v2));
        System.out.println("scalar multiplication v1 & v4: " + Vector3DProcessor.scalarMultiplication(v1, v4));
        System.out.println("vector multiplication v1 & v4: " + Vector3DProcessor.vectorMultiplication(v1, v4));
        System.out.println("vector multiplication v1 & v5: " + Vector3DProcessor.vectorMultiplication(v1, v5));
        System.out.println("check collinearity v5 & v6: " + Vector3DProcessor.checkCollinearity(v5, v6));
        System.out.println("check collinearity v4 & v3: " + Vector3DProcessor.checkCollinearity(v4, v3));
        System.out.println("check collinearity v1 & v2: " + Vector3DProcessor.checkCollinearity(v1, v2));

*/
        // ----------------Vector3DArray---------------------

        try {

            Vector3DArray vArray = new Vector3DArray(3);
            Vector3D vector1 = new Vector3D(1, 2, 3);
            Vector3D vector2 = new Vector3D(4, 5, 6);
            Vector3D vector3 = new Vector3D(7, 8, 9);

            vArray.changeVector(0, vector1);
            vArray.changeVector(1, vector2);
            vArray.changeVector(2, vector3);

            float[] array = {1, 2, 3};
            System.out.println("index of given vector(or -1 if it doesn't exist): " + vArray.findVector(vector3));

            System.out.println("\nlinear combination: " + vArray.linearСombinationVectors(array));

            System.out.println("\nmax length vector: " + vArray.maxLengthVector());

            System.out.println("\nlength array: " + vArray.getSize());

            System.out.println("\nsum of all lengths of vectors: " + vArray.sumAllVectors());
            System.out.println("\npoint array: ");

            vArray.pointArray(p6);
            vArray.printPointArray();
        } catch (BadSizeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

