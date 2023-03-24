package functions;

import logarithm.Ln;
import logarithm.Log10;
import logarithm.Log3;
import logarithm.Log5;

import model.AbstractFunction;

public class LogFunction extends AbstractFunction {

    private Ln ln;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public LogFunction() {
        this.ln = new Ln();
        this.log3 = new Log3();
        this.log5 = new Log5();
        this.log10 = new Log10();
    }

    @Override
    public double calculate(double x) {
        double result1 = log5.calculate(x) - ln.calculate(x);
        result1 /= log3.calculate(x);

        double result2 = log3.calculate(x) + log10.calculate(x);

        double result = result1 * result2;
        return result;
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public void setLog3(Log3 log3) {
        this.log3 = log3;
    }

    public void setLog5(Log5 log5) {
        this.log5 = log5;
    }

    public void setLog10(Log10 log10) {
        this.log10 = log10;
    }
}
