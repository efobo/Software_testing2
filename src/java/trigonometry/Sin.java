package trigonometry;

import model.AbstractFunction;

public class Sin extends AbstractFunction {
    private Cos cos;

    public Sin() {
        this.cos = new Cos();
    }

    @Override
    public double calculate(double x) {
        double value = Math.sqrt(1 - cos.calculate(x) * cos.calculate(x));
        Quarter quarter = Quarter.of(x);
        return quarter.isTop() ? value : -value;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }
}
