package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GaussianEliminationStrategy implements SolutionStrategy{
    private int numberOfLines = 0;
    private double[][] matrix = null;
    private double[][] squareMatrix = null;
    private String filename = "system.txt";

    /**
     * Constructor for calling reading the equation from text
     * And creating the matrix
     */
    public GaussianEliminationStrategy(){
        readInputFromFile();
        createMatrix();
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
     * Solves the equation by gaussian elimination
     * @return roots in a string
     */
    public StringBuilder solve() {
        System.out.println("Gaussian Elimination has started");
        double[] root = new double[numberOfLines];
        StringBuilder sb = new StringBuilder();
        if(!isSolvable()) {
            System.out.println("can not be solved");
            return sb;
        }

        int changer = 0;
        double temp = matrix[changer][changer];
        double pivot = 0;

        for(int row = 1; row < numberOfLines; ++row)
        {
            temp = matrix[row-1][row-1];
            if(temp != 0.0)
            {
                //System.out.println("temp is " + temp);
                for(int i = 0 ; i < matrix.length + 1; ++i)
                    matrix[row-1][i] = matrix[row-1][i] / temp;

            }
            for(int count = 0; count < numberOfLines - row; ++count)
            {
                pivot = matrix[row+count][row-1];
                if(pivot != 0.0)
                {
                    //System.out.println("pivot is " + pivot);
                    for(int i = 0; i < matrix.length + 1; ++i)
                    {
                        //System.out.println("1e esitleme");
                        matrix[row+count][i] = matrix[row+count][i] - matrix[row-1][i]*pivot;
                    }
                }
            }
            //print(matrix);
            temp = matrix[row][row];
            //System.out.println("temp is " + temp);
            for(int i = 0 ; i < matrix.length + 1; ++i)
                matrix[row][i] = matrix[row][i] / temp;
        }
        System.out.println("Roots are ");
        for(int i = numberOfLines; i > 0; --i)
        {
            if(i == numberOfLines)
                root[i-1] = matrix[i-1][i] / matrix[i-1][i-1];
            else
            {
                for(int j = 0; j < numberOfLines; ++j)
                {
                    root[i-1] = root[i-1] + root[j] * matrix[i-1][j];
                }
                root[i-1] = - root[i-1] + matrix[i-1][numberOfLines];
            }

            System.out.println("x" + i + " = " + root[i-1]);

        }

        sb.append(System.lineSeparator() + "Roots are  " +  System.lineSeparator());
        for(int i = root.length - 1; i >= 0; --i)
            sb.append("x").append(i).append(" = ").append(root[i]).append(System.lineSeparator());

        return sb;
    }

    /**
     * Checks the equation and decide if it is solvabla or not
     * @return returns true if it is solvable otherwise returns false
     */
    private boolean isSolvable() {

        if(matrix != null && matrix.length + 1 < matrix[0].length) {
            System.out.println("invalid matrix number");
            return false;
        }

        double det = findDeterminant(squareMatrix, squareMatrix.length);

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

}
