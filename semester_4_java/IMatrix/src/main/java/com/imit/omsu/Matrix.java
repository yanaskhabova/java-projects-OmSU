package com.imit.omsu;

import java.util.Arrays;

public class Matrix implements IMatrix {
    private double matrix[];
    private int size;
    private double determinant = 1;
    private boolean determinantIsActual = false;

    public Matrix(int size) throws MatrixException {
        if (size <= 0) {
            throw new MatrixException(ErrorCode.SIZE_INVALID);
        }
        matrix = new double[size * size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setElement(0, i, j);
            }
            setElement(1, i, i);
        }
    }

    public Matrix(double... array) {
        size = (int) Math.sqrt(array.length);
        matrix = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            matrix[i] = array[i];
        }
    }

    public Matrix(Matrix matrix) throws MatrixException {
        if (matrix.size <= 0) {
            throw new MatrixException(ErrorCode.SIZE_INVALID);
        }
        size = matrix.size;
        determinant = matrix.determinant;
        determinantIsActual = matrix.determinantIsActual;
        this.matrix = new double[matrix.size * matrix.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.matrix[i * size + j] = matrix.getElement(i, j);
            }
        }
    }

    public int getSize() {
        return this.size;
    }

    public double getElement(int xIndex, int yIndex) {
        return matrix[xIndex * size + yIndex];
    }

    public void setElement(double value, int xIndex, int yIndex) {
        matrix[xIndex * size + yIndex] = value;
        determinantIsActual = false;
    }

    public double calculateDeterminant() throws MatrixException {
        Matrix matrix = new Matrix(this);
        if (determinantIsActual) {
            return determinant;
        }
        double temp;
        for (int k = 0; k < matrix.size - 1; k++) {
            if (matrix.getElement(k, k) != 0) {
                for (int i = k + 1; i < matrix.size; i++) {
                    temp = matrix.getElement(i, k) / matrix.getElement(k, k);
                    for (int j = 0; j < matrix.size; j++) {
                        matrix.setElement(matrix.getElement(i, j) - matrix.getElement(k, j) * temp, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.size; i++) {
            determinant *= matrix.getElement(i, i);
        }
        determinantIsActual = true;
        return determinant;
    }

    public double[] getArray() {
        return matrix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;

        Matrix matrix1 = (Matrix) o;

        if (getSize() != matrix1.getSize()) return false;
        if (Double.compare(matrix1.determinant, determinant) != 0) return false;
        if (determinantIsActual != matrix1.determinantIsActual) return false;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.hashCode(matrix);
        result = 31 * result + getSize();
        temp = Double.doubleToLongBits(determinant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (determinantIsActual ? 1 : 0);
        return result;
    }
}
