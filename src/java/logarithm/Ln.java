package logarithm;


import model.AbstractFunction;

public class Ln extends AbstractFunction {


    @Override
    public double calculate(double value) {
        if (value <= 0) throw new IllegalArgumentException("Value need to be upper then zero");
        if (value > 2) return -calculate(1 / value);

        double x = value - 1;
        double result = x;
        double current = x;
        double previous = -1;
        double accuracy = getAccuracy();

        for (int i = 2; Math.abs(previous - result) > accuracy && i < MAX_ITERATIONS ; i++) {
            previous = result;
            current *= ( x * -1 * (i - 1) );
            current /= i;
            result += current;
        }

        return result;

    }
}

