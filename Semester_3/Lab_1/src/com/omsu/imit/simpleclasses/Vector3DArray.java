package com.omsu.imit.yana.simpleclasses;

import java.io.*;
import java.util.concurrent.Callable;

import static java.lang.Math.*;

public class Vector3DArray {
    private Vector3D array[];

    public Vector3DArray(int size) throws BadSizeException {
        if (size <= 0) {
            throw new BadSizeException("Unaccepable size of array: " + size);
        }
        array = new Vector3D[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Vector3D();
        }
    }

    public int getSize() {
        return array.length;
    }

    public void changeVector(int i, Vector3D vector3D) {
        this.array[i].setX(vector3D.getX());
        this.array[i].setY(vector3D.getY());
        this.array[i].setZ(vector3D.getZ());
    }

    public double maxLengthVector() {
        double maxLength = -1;
        for (Vector3D elem : array) {
            if (maxLength < elem.lengthVector()) {
                maxLength = elem.lengthVector();
            }
        }
        return maxLength;
    }

    public int findVector(Vector3D vector3D) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getX() == vector3D.getX() &&
                    array[i].getY() == vector3D.getY() &&
                    array[i].getZ() == vector3D.getZ()) {
                return i;
            }
        }
        return -1;
    }

    public double sumAllVectors() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].lengthVector();
        }
        return sum;
    }

    public Vector3D linearСombinationVectors(float[] arrayCoeff) {
        Vector3D v = new Vector3D();
        if (arrayCoeff.length != array.length) {
            return v;
        }
        for (int i = 0; i < array.length; i++) {
            v.setX(v.getX() + (arrayCoeff[i] * array[i].getX()));
            v.setY(v.getY() + (arrayCoeff[i] * array[i].getY()));
            v.setZ(v.getZ() + (arrayCoeff[i] * array[i].getZ()));
        }
        return v;
    }

    public Point3D[] pointArray(Point3D p) {
        Point3D[] points = new Point3D[array.length];
        for (int i = 0; i < array.length; i++) {
            points[i] = new Point3D(
                    array[i].getX() + p.getX(),
                    array[i].getY() + p.getY(),
                    array[i].getZ() + p.getZ()
            );
        }
        return points;
    }

    public void printPointArray() {
        int j = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.println("p" + j + array[i].toString());
            j++;
        }
    }
}
