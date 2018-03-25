package com.imit.omsu;

public interface IMatrix {
    double getElement(int xIndex, int yIndex);
    void setElement(double value, int xIndex, int yIndex);
    double calculateDeterminant() throws MatrixException;
    int getSize();
}
