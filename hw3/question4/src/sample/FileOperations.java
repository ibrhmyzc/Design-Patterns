package sample;

import java.io.*;
import java.util.ArrayList;

public class FileOperations {

    /**
     * Reads from inputs.txt and return an array list containing these numbers that are stored in the file
     * @param filename
     * @return
     * @throws IOException
     */
    public static ArrayList<Double> readFromFile(String filename) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(new File(filename)));
        ArrayList<Double> numbers = new ArrayList<Double>();
        String line;
        while((line = input.readLine()) != null) {
            String[] tmp = line.split(" ");
            for(int i = 0 ; i < tmp.length; ++i) {
                numbers.add(Double.parseDouble(tmp[i]));
            }
        }
        input.close();
        return numbers;
    }

    /**
     * Writes the results to the output file
     * @param filename
     * @param results
     * @throws IOException
     */
    public static void writeToFile(String filename, Object[] results) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)));
        for(int i = 0 ; i < results.length; ++i)
            output.write(results[i].toString() + "   ");
        output.close();
    }
}
