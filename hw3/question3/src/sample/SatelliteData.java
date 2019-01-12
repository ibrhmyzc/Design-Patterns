package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class SatelliteData implements Iterable {
    private int[][] data;
    private String filename;

    /**
     * Constructor
     * @param filename name of the Input file
     */
    public SatelliteData(String filename) {
        this.filename = filename;
        readInputFromFile(this.filename);
        printMatrix();
    }

    /**
     * Reads the values from an input file and store them in an integer array
     * @param filename
     */
    private void readInputFromFile(String filename) {
        String line = "";
        int numberOfLines = 0;
        int colN = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            while((line = input.readLine()) != null) {
                numberOfLines += 1;
                String[] tmp = line.split(" ");
                colN = tmp.length;
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error: reading input from file1");
        }
        data = new int[numberOfLines][colN];
        try {
            int j = 0 ;
            BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
            while((line = input.readLine()) != null) {
                String[] tmp = line.split(" ");
                for(int i = 0; i < tmp.length; ++i) {
                    data[j][i] = Integer.parseInt(tmp[i]);
                }
                j += 1;
            }
            input.close();
        } catch(Exception e) {
            System.out.println("Error: reading input from file2");
        }
    }

    /**
     * Prints the array for debugging purposes
     */
    private void printMatrix() {
        for(int i = 0 ; i < data.length; ++i){
            for(int j = 0; j < data[0].length; ++j){
                System.out.printf("%5d", data[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public Iterator iterator() {
        return new TurkishSpaceAgencyIterator();
    }

    class TurkishSpaceAgencyIterator implements Iterator {
        private int row = 0;
        private int col = 0;
        private int rowMin = 0;
        private int colMin = 0;
        private int rowMax = data.length;
        private int colMax = data[0].length;
        private int remainingNumberOfElements = data.length * data[0].length;
        private int direction = 0;
        // 1 is down 2 is right 3 is up and 4 is left

        @Override
        public boolean hasNext() {
            return remainingNumberOfElements > 0;
        }

        @Override
        public Object next() {
            while ( remainingNumberOfElements > 0) {
                while(direction < 4) {
                    switch (direction){
                        case 0:
                            if(row < rowMax) {
                                --remainingNumberOfElements;
                                return data[row++][col];
                            }
                            col++;
                            row = rowMax - 1;
                            direction++;
                            break;
                        case 1:
                            if(col < colMax) {
                                --remainingNumberOfElements;
                                return data[row][col++];
                            }
                            row--;
                            col = colMax - 1;
                            direction++;
                            break;
                        case 2:
                            if(row >= rowMin) {
                                --remainingNumberOfElements;
                                return data[row--][col];
                            }
                            col--;
                            row = rowMin;
                            direction++;
                            break;
                        case 3:
                            if(col > colMin) {
                                --remainingNumberOfElements;
                                return data[row][col--];
                            }
                            direction++;
                            break;
                    }
                }
                direction = direction % 4;
                rowMin++;
                rowMax--;
                colMin++;
                colMax--;
                row = rowMin;
                col = colMin;
            }
            return null;
        }

    }
}
