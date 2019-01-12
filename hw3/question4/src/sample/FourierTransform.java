package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FourierTransform {
    double start = 0.0;
    double finish = 0.0;
    ArrayList<Double> numbers;
    Object[] results;

    /**
     * Umbrella method for all of the necessary actions
     * @return
     * @throws IOException
     */
    final public Object[] templateMethod() throws IOException {
       readFromFile();
       results = calculateFourier(this.numbers);
       writeToFile();
       return results;
    }

    /**
     * Getting the input
     * @throws IOException
     */
    void readFromFile() throws IOException {
        this.numbers = FileOperations.readFromFile("inputs.txt");
    }

    /**
     * Writing the input
     * @throws IOException
     */
    void writeToFile() throws IOException {
        FileOperations.writeToFile("output.txt", this.results);
    }

    /**
     * Calculates the spent time for dft
     * @return the time in milliseconds
     */
    double timeSpent() {
        double million = 1000000;
        return (finish -start) / million;
    }

    /**
     * Common method for both of these fourier operations
     * @param numbers
     * @return
     */
    abstract Object[] calculateFourier(ArrayList<Double> numbers);


}
