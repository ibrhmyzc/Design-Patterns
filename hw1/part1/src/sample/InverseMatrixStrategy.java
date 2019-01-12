package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InverseMatrixStrategy implements SolutionStrategy {
    private int numberOfLines = 0;
    private double[][] matrix = null;
    private double[][] invertedMatrix = null;
    private double[][] squareMatrix = null;
    private String filename = "system.txt";

    /**
     * Constructor for calling reading the equation from text
     * And creating the matrix
     */
    public InverseMatrixStrategy(){
        readInputFromFile();
        createMatrix();
    }

    /**
     * Solves the equation by gaussian elimination
     * @return roots in a string
     */
    @Override
    public StringBuilder solve() {
        double[] root = new double[numberOfLines];
        StringBuilder sb = new StringBuilder();

        double[] answers = new double[matrix.length];
        invertedMatrix = inverse(squareMatrix);
        for(int i = 0 ; i < matrix.length; ++i)
            answers[i] = matrix[i][matrix[0].length -1];

        for(int i = 0 ; i < matrix.length; ++i){
            double r = 0.0;
            for(int j = 0; j < matrix.length; ++j){
                r += invertedMatrix[i][j] * answers[j];
            }
            root[i] = r;
        }
        sb.append(System.lineSeparator() + "Roots are  " +  System.lineSeparator());
        for(int i = 0; i < root.length; ++i)
            sb.append("x").append(i).append(" = ").append(root[i]).append(System.lineSeparator());
        return sb;
    }

    /**
     * Reads the numbers from system.txt
     */
    private void readInputFromFile() {

        try {
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            while((input.readLine()) != null) {
                numberOfLines += 1;
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error: reading input from file");
        }

    }

    /**
     * Creates teh matrix with the read numbers
     */
    private void createMatrix() {
        matrix = new double[numberOfLines][numberOfLines+1];
        squareMatrix = new double[numberOfLines][numberOfLines];
        String line = "";
        try {
            int j = 0 ;
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            while((line = input.readLine()) != null) {
                String[] tmp = line.split(",");
                for(int i = 0; i < tmp.length; ++i) {
                    matrix[j][i] = Double.parseDouble(tmp[i]);
                }
                j += 1;
            }
            input.close();
            for(int i = 0; i < matrix.length; ++i)
                for(int k = 0; k < matrix.length; ++k)
                    squareMatrix[i][k] = matrix[i][k];
        } catch(Exception e) {
            System.out.println("Error: reading input from file");
        }
    }


    /**
     * Writes matrix into a string
     * @return a nice formatted matrix in a string
     */
    private StringBuilder printMatrix() {
        System.out.println("print matrix");
        StringBuilder strMatrix = new StringBuilder();
        for(int i = 0; i < matrix.length; ++i) {
            strMatrix.append(System.lineSeparator() + "[");
            for(int j = 0; j < matrix[0].length; ++j) {
                String f = String.format("%6.2f", matrix[i][j]);
                strMatrix.append(f);
                System.out.print(matrix[i][j] + "  ");
            }
            strMatrix.append("  ]" + System.lineSeparator());
            System.out.println();
        }
        return strMatrix;
    }

    /**
     * Checks the equation and decide if it is solvabla or not
     * @return returns true if it is solvable otherwise returns false
     */
    private boolean isSolvable() {
        System.out.println("Solvable?");

        if(matrix != null && matrix.length + 1 < matrix[0].length) {
            System.out.println("invalid matrix number");
            return false;
        }

        double det = findDeterminant(squareMatrix, squareMatrix.length);
        System.out.println("Determinant is " + det);
        if(det == 0) {
            return false;
        }

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                if(i != j && i < j) {
                    double[] tmp = new double[matrix.length];
                    for(int k = 0; k < matrix.length; ++k) {

                        try {
                            //System.out.println("Normal:" + i + ", " + j);
                            tmp[k] = matrix[i][k] / matrix[j][k];
                        } catch(Exception ex) {
                            System.out.println("Exception:" + i + ", " + j);
                        }

                    }
                    Arrays.sort(tmp);
                    double ratio = matrix[i][matrix[0].length -1] / matrix[j][matrix[0].length -1];
//						System.out.println("Tmp = " + Arrays.toString(tmp) + " and i and j "
//											+ i + ", " + j + "and ratio = " + ratio);

                    if(tmp[0] == tmp[tmp.length - 1] && tmp[0] == ratio) {
                        System.out.println(i + " and " + j + " are the same equations!");
                        return false;
                    }

                }

            }
        }

        return true;
    }

    /**
     * Finds the determinant of a given square matrix
     * @param m matrix
     * @param n size of the matrix
     * @return determinant of the matrix
     */
    private double findDeterminant(double[][] m, int n) {

        double determinantValue = 0.0;

        if(n == 1)
            return m[0][0];
        if(n == 2)
            return m[0][0] * m[1][1] - m[0][1] * m[1][0];

        for(int p=0;p<n;p++)
        {
            double[][] tmp = new double[n-1][];
            for(int k=0;k<(n-1);k++)
            {
                tmp[k] = new double[n-1];
            }
            for(int i=1;i<n;i++)
            {
                int h=0;
                for(int j=0;j<n;j++)
                {
                    if(j == p)
                        continue;
                    tmp[i-1][h] = m[i][j];
                    h++;
                }
            }
            determinantValue += Math.pow(-1.0,1.0+p+1.0)* m[0][p] * findDeterminant(tmp,n-1);
        }

        return determinantValue;
    }

    /**
     * Finds the transpose of a matrix
     * @param m matrix
     * @return transpose of m
     */
    private double[][] transposeMatrix(double[][] m){
        double[][] t = new double[m.length][m.length];

        for(int i = 0; i < m.length; ++i)
            for(int j = 0; j < m.length; ++j)
                t[j][i] = m[i][j];

        return t;
    }

    /**
     * Inverse of a matrix
     * @param m matrix
     * @return inverse of m
     */
    private double[][] inverse(double[][] m)  {
        double[][] c = cofactor(m);
        double[][] t = transposeMatrix(c);
        double det = findDeterminant(m, m.length);
        for(int i = 0; i < m.length; ++i)
            for(int j = 0 ; j < m.length; ++j){
                t[i][j] *= 1.0 / det;
            }
        return t;
    }

    /**
     * Finds cofactors for inversing
     * @param m matrix
     * @return cofactors
     */
    private double[][] cofactor(double[][] m) {
        double[][] c = new double[m.length][m.length];
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0 ; j < m.length; ++j) {
                int sign_i = -1;
                int sign_j = -1;
                double[][] tmp = new double[m.length-1][m.length-1];
                tmp = subM(m, i, j);
                double det = findDeterminant(tmp, tmp.length);
                if(i % 2 == 0)
                    sign_i = 1;
                if(j % 2 == 0)
                    sign_j = 1;
                c[i][j] = sign_i * sign_j * det;
            }
        }

        return c;
    }

    /**
     * Matrices to find the inverse
     * @param m matrix
     * @param row row
     * @param col col
     * @return sub
     */
    private double[][] subM(double[][] m, int row, int col) {
        double[][] s = new double[m.length - 1][m.length - 1];
        int r = -1;
        for (int i=0;i<m.length; i++) {
            if (i==row)
                continue;
            r++;
            int c = -1;
            for (int j=0;j<m.length;j++) {
                if (j==col)
                    continue;
                c += 1;
                s[r][c] = m[i][j];
            }
        }
        return s;
    }
}
