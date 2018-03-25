package com.imit.omsu;

interface IInvertableMatrix extends IMatrix {
    InvertableMatrix getInverseMatrix() throws MatrixException;
}
