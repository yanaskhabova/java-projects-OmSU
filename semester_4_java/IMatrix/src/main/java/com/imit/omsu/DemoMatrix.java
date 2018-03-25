package com.imit.omsu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DemoMatrix {

    public static double sumAllElements(Matrix matrix) {
        double sum = 0f;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.getElement(i, j);
            }
        }
        return sum;
    }

    public static Matrix reader(String fileName) throws IOException, MatrixException {
        try (BufferedReader bufFile = new BufferedReader(new FileReader(fileName))) {
            List<String> matrixBuffer = new ArrayList<>();
            String s = "";
            while ((s = bufFile.readLine()) != null) {
                matrixBuffer.add(s);
            }
            Matrix matrix = new Matrix(matrixBuffer.size());
            for (int i = 0; i < matrix.getSize(); i++) {
                String[] str = matrixBuffer.get(i).split("\\s+");
                for (int j = 0; j < matrix.getSize(); j++) {
                    matrix.setElement(Double.parseDouble(str[j]), i, j);
                }
            }
            return matrix;
        } catch (IOException ioe) {
            throw new MatrixException(ErrorCode.FILE_NOT_FOUND);
        }
    }

    public static void writer(String fileName, Matrix matrix) throws IOException, MatrixException {
        try (BufferedWriter bufFile = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    bufFile.write(Double.toString(matrix.getElement(i, j)));
                    bufFile.write(" ");
                }
                bufFile.newLine();
            }
        } catch (IOException ioe) {
            throw new MatrixException(ErrorCode.FILE_NOT_FOUND);
        }
    }
}
