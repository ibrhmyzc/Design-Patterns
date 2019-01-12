package sample;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Getter for real part
     * @return
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Setter for real part
     * @param realPart
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * Getter for imaginary part of the complex number
     * @return
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Getter for imaginary part of the imaginary number
     * @param imaginaryPart
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        if(imaginaryPart < 0)
            return realPart + "  i" + imaginaryPart;
        else
            return realPart + " + i" + imaginaryPart;
    }
}
