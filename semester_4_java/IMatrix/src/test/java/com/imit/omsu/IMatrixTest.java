package com.imit.omsu;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

public class IMatrixTest {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCalculateDeterminant() throws MatrixException {
        Matrix matrix0 = new Matrix(0.5, 0.25, 3, 5);
        Matrix matrix1 = new Matrix(11, -2, 7, 5);
        Matrix matrix2 = new Matrix(3, 3, -1, 4, 1, 3, 1, -2, -2);
        Matrix matrix3 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Matrix matrix4 = new Matrix(2, 3, 0, 4, 5, 0, 1, 0, -1, 2, 3, 2, 1, 0, 1, 0, 4, 0, -5, 0, 1, 1, 2, -2, 1);
        Matrix matrix5 = new Matrix(9); // constructor creates UNIT matrix default !!!
        Matrix copy = new Matrix(matrix0);
        assertEquals(1.75, matrix0.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(69, matrix1.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(54, matrix2.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(0, matrix3.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(195, matrix4.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(1, matrix5.calculateDeterminant(), DOUBLE_EPS);
        assertEquals(1.75, copy.calculateDeterminant(), DOUBLE_EPS);
    }

    @Test
    public void testGetInverseMatrix() throws MatrixException {
        InvertableMatrix matrix1 = new InvertableMatrix(7, 4, 5, 3);
        InvertableMatrix inverse1 = new InvertableMatrix(3, -4, -5, 7);
        InvertableMatrix matrix2 = new InvertableMatrix(1, 1, 1, 2);
        InvertableMatrix inverse2 = new InvertableMatrix(2, -1, -1, 1);
        InvertableMatrix matrix3 = new InvertableMatrix(2, 1, 1, 1, 0, 2, 3, 1, 2);
        InvertableMatrix inverse3 = new InvertableMatrix(-2, -1, 2, 4, 1, -3, 1, 1, -1);
        assertArrayEquals(inverse1.getArray(), matrix1.getInverseMatrix().getArray(), DOUBLE_EPS);
        assertArrayEquals(inverse2.getArray(), matrix2.getInverseMatrix().getArray(), DOUBLE_EPS);
        assertArrayEquals(inverse3.getArray(), matrix3.getInverseMatrix().getArray(), DOUBLE_EPS);

    }

    @Test
    public void testReadArrayFromFile() throws MatrixException, IOException {
        Matrix matrix1 = new Matrix(0.5, 0.25, 3, 5);
        DemoMatrix.writer("DemoMatrix1.txt", matrix1);
        Matrix matrixRead1 = DemoMatrix.reader("DemoMatrix1.txt");
        assertArrayEquals(matrixRead1.getArray(), matrix1.getArray(), DOUBLE_EPS);

        Matrix matrix2 = new Matrix(2, 3, 0, 4, 5, 0, 1, 0, -1, 2, 3, 2, 1, 0, 1, 0, 4, 0, -5, 0, 1, 1, 2, -2, 1);
        DemoMatrix.writer("DemoMatrix2.txt", matrix2);
        Matrix matrixRead2 = DemoMatrix.reader("DemoMatrix2.txt");
        assertArrayEquals(matrixRead2.getArray(), matrix2.getArray(), DOUBLE_EPS);
    }

    @Test
    public void testSumAllElements() {
        Matrix matrix1 = new Matrix(7, 4, 5, 3, -7, -4, -5, -3, 0);
        Matrix matrix2 = new Matrix(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, 0, 1.1, 2.2, 3.3, 4.4, 5.5);
        Matrix matrix3 = new Matrix(2, 1, 1, 1, 0, 2, 3, 1, 2);
        assertEquals(0, DemoMatrix.sumAllElements(matrix1), DOUBLE_EPS);
        assertEquals(16.5, DemoMatrix.sumAllElements(matrix2), DOUBLE_EPS);
        assertEquals(13, DemoMatrix.sumAllElements(matrix3), DOUBLE_EPS);
    }
}
