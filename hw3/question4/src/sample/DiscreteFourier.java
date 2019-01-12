package sample;

import java.util.ArrayList;

public class DiscreteFourier extends FourierTransform {

    @Override
    Object[] calculateFourier(ArrayList<Double> numbers) {
        super.start = System.nanoTime();
        double power = 0.0;
        double degree = 0.0;
        double real = 0.0;
        double imaginary = 0.0;
        ComplexNumber[] results = new ComplexNumber[numbers.size()];
        for(int k = 0; k < numbers.size(); ++k) {
            for(int x = 0; x < numbers.size(); ++x) {
                power = 2 * k * x;
                degree = power / numbers.size();
                real += Math.cos(degree * Math.PI) * numbers.get(x);
                imaginary += -Math.sin(degree * Math.PI) * numbers.get(x);
            }
            results[k] = new ComplexNumber(real, imaginary);
            real = 0.0;
            imaginary = 0.0;
        }
        super.finish = System.nanoTime();
        return results;
    }
}
