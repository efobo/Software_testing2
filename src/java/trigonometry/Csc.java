package trigonometry;

import model.AbstractFunction;

public class Csc extends AbstractFunction {
    private Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    @Override
    public double calculate(double value) {
        return 1 / sin.calculate(value);
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }
}
