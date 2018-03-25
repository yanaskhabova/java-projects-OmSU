package com.imit.omsu;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {
    public InvertableMatrix(int size) throws MatrixException {
        super(size);
        if (Double.compare(this.calculateDeterminant(), 0.0) == 0) {
            throw new MatrixException(ErrorCode.ZERO_DETERMINANT);
        }
    }

    public InvertableMatrix(double... array) throws MatrixException {
        super(array);
        if (Double.compare(this.calculateDeterminant(), 0.0) == 0) {
            throw new MatrixException(ErrorCode.ZERO_DETERMINANT);
        }
    }

    public InvertableMatrix(Matrix matrix) throws MatrixException {
        super(matrix);
        if (Double.compare(matrix.calculateDeterminant(), 0.0) == 0) {
            throw new MatrixException(ErrorCode.ZERO_DETERMINANT);
        }
    }

    public InvertableMatrix getInverseMatrix() throws MatrixException {
        InvertableMatrix E = new InvertableMatrix(getSize());
        InvertableMatrix matrix = new InvertableMatrix(this);
        double temp;
        for (int k = 0; k < getSize() ; k++) {
            if (matrix.getElement(k, k) != 0) {
                for (int i = k + 1; i < getSize(); i++) {
                    temp = matrix.getElement(i, k) / matrix.getElement(k, k);
                    for (int j = 0; j < getSize(); j++) {
                        matrix.setElement(matrix.getElement(i, j) - matrix.getElement(k, j) * temp, i, j);
                        E.setElement(E.getElement(i, j) - E.getElement(k, j) * temp, i, j);
                    }
                }
            }
        }
        for (int k = getSize() - 1; k >= 0; k--) {
            if (matrix.getElement(k, k) != 0) {
                for (int i = k - 1; i >= 0; i--) {
                    temp = matrix.getElement(i, k) / matrix.getElement(k, k);
                    for (int j = 0; j < getSize(); j++) {
                        matrix.setElement(matrix.getElement(i, j) - matrix.getElement(k, j) * temp, i, j);
                        E.setElement(E.getElement(i, j) - E.getElement(k, j) * temp, i, j);
                    }
                }
            }
        }
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                E.setElement(E.getElement(i, j) / matrix.getElement(i, i), i, j);
            }
        }
        return E;
    }
}
