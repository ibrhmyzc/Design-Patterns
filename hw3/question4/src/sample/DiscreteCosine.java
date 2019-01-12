package sample;

import java.util.ArrayList;

public class DiscreteCosine extends FourierTransform {

    @Override
    Object[] calculateFourier(ArrayList<Double> numbers) {
        Object[] results = new Object[numbers.size()];
        double sum = 0.0;
        for(int i = 0; i < numbers.size(); ++i) {
            for(int j = 0 ; j < numbers.size(); ++j) {
                sum += numbers.get(j) * Math.cos((Math.PI / numbers.size()) * (j + 0.5) * i);
            }
            results[i] = sum;
            sum = 0.0;
        }
        return results;
    }
}
