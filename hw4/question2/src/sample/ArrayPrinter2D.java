package sample;

public class ArrayPrinter2D {
    /**
     * This function prints a matrix on the screen
     * @param arr matrix to be printed
     * @return a string that contains a matrix
     */
    public static String printArray(double[][] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; ++i){
            for(int j = 0; j < arr[0].length; ++j){
                sb.append(String.format("%5.1f", arr[i][j]));
                System.out.print(arr[i][j] + "   ");
            }
            sb.append(System.lineSeparator());
            System.out.println();
        }
        return sb.toString();
    }

}
