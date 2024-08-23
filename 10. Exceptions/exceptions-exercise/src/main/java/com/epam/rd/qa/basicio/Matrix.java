package com.epam.rd.qa.basicio;

import java.util.Arrays;
class MatrixException extends RuntimeException {
    public MatrixException(String message) {
        super(message);
    }

    // Optionally, constructors can be extended to include other types of initializations
    // such as chaining exceptions, etc.

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }
}

/**
 * Encapsulates two-dimensional array-matrix block of real ({@code double}) type.
 * {@code Matrix} is the cover for two-dimensional array of real values, storing matrix
 * values with operations of matrix addition, deduction, and multiplication.
 */
public class Matrix {

    /**
     * Creates an empty matrix with predetermined number
     * of rows and columns (all values in matrix equal to 0)
     *
     * @param rows number of rows
     * @param cols number of columns
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */

    private double [][] m;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) throws MatrixException {
        if(rows<1 || cols<1){
            throw new MatrixException("Rows and Colums Shoulnot be less than 1");
        }
        this.rows=rows;
        this.cols=cols;
        this.m=new double[rows][cols];
        for(double[] x:m){
            Arrays.fill(x,0);
        }
    }

    /**
     * Creates a matrix based on existing two-dimensional array
     *
     * @param values two-dimensional array
     * @throws MatrixException if {@code rows} or {@code cols} less than 1
     */
    public Matrix(double[][] values) throws MatrixException {
        if (values == null || values.length < 1 || values[0].length<1) {
            throw new MatrixException("Invalid matrix dimensions.");
        }
        int columnLength = values[0].length;
        for (double[] row : values) {
            if (row.length != columnLength) {
                throw new MatrixException("Rows in the matrix must have the same number of columns.");
            }
        }
        this.rows = values.length;
        this.cols = values[0].length;
        this.m = values;

    }

    /**
     * Returns count of matrix rows.
     *
     * @return count of rows in the matrix
     */
    public int getRows() {

        return this.rows;
    }

    /**
     * Returns count of matrix columns
     *
     * @return count of columns in the matrix
     */
    public int getColumns() {

        return this.cols;
    }

    /**
     * Returns an element via predetermined correct indexes.
     *
     * @param row row index
     * @param col column index
     * @return the element via indexes
     * @throws MatrixException if index out of bounds
     */
    public double get(int row, int col) throws MatrixException {
        if (row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
            throw new MatrixException("Invalid");
        }
        return m[row][col];
    }

    /**
     * Sets new value via predetermined correct indexes.
     *
     * @param row   row index
     * @param col   column index
     * @param value value to set
     * @throws MatrixException if index out of bounds
     */
    public void set(int row, int col, double value) throws MatrixException {
        if (row >= this.rows || col >= this.cols || row < 0 || col < 0) {
            throw new MatrixException("Index out of bounds.");
        }
        this.m[row][col] = value;
    }

    /**
     * Returns standard two-dimensional array out of matrix.
     * Any changes in the returned array will be reflected to internal array.
     *
     * @return matrix values
     */
    public double[][] toArray() {
//        double[][] arrCopy = new double[m.length][];
//        for (int i = 0; i < m.length; i++) {
//            arrCopy[i] = Arrays.copyOf(m[i], m[i].length);
//        }
        return this.m;
    }

    /**
     * Adds all elements of {@code other} matrix to corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix add(Matrix other) throws MatrixException {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new MatrixException("Invalid");
        }
        double[][] result = new double[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result[i][j] = this.get(i, j) + other.get(i, j);
            }
        }
        return new Matrix(result);
    }

    /**
     * Subtract all elements of {@code other} matrix from corresponding elements
     * of this matrix and creates new {@code Matrix} with resulting two-dimensional array
     *
     * @param other another {@code Matrix} object
     * @return new matrix
     * @throws MatrixException if matrices have different size
     */
    public Matrix subtract(Matrix other) throws MatrixException {
        if (this.rows != other.getRows() || this.cols != other.getColumns()) {
            throw new MatrixException("Matrices dimensions mismatch.");
        }

        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.set(i, j, this.m[i][j] - other.get(i, j));
            }
        }
        return result;
    }

    /**
     * Multiply this matrix to {@code other} matrix.<br/>
     * See
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication">Matrix multiplication</a>
     * <a href="https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm">Matrix multiplication algorithm</a>
     *
     * @param other another matrix
     * @return new matrix
     * @throws MatrixException if matrices have non-compliant sizes
     */
    public Matrix multiply(Matrix other) throws MatrixException {
        if (this.cols != other.getRows()) {
            throw new MatrixException("Incompatible matrix sizes for multiplication.");
        }

        Matrix result = new Matrix(this.rows, other.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                double cell = 0;
                for (int k = 0; k < this.cols; k++) {
                    cell += this.m[i][k] * other.get(k, j);
                }
                result.set(i, j, cell);
            }
        }
        return result;
    }
}

