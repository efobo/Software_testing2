package trigonometry;

import model.AbstractFunction;

public class Tan extends AbstractFunction {

    private Cos cos;
    private Sin sin;

    public Tan() {
        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        double accuracy = getAccuracy();
        double cropValue = Quarter.cropAnglePositive(value);
        if (Math.abs(cropValue - Math.PI / 2) < accuracy) return Double.POSITIVE_INFINITY;
        if (Math.abs(cropValue - Math.PI * 3 / 2) < accuracy) return Double.NEGATIVE_INFINITY;
        return sin.calculate(value) / cos.calculate(value);
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }
}

