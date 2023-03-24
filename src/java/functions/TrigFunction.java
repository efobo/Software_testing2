package functions;

import model.AbstractFunction;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Sin;
import trigonometry.Tan;

public class TrigFunction extends AbstractFunction {
    private Cos cos;
    private Sin sin;
    private Csc csc;
    private Tan tan;

    public TrigFunction() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.csc = new Csc();
        this.tan = new Tan();
    }

    @Override
    public double calculate(double x) {
        double result1 = 1;
        result1 *= csc.calculate(x);
        result1 *= csc.calculate(x);
        result1 -= cos.calculate(x);

        double result2 = 1;
        result2 *= sin.calculate(x);
        result2 *= sin.calculate(x);
        result2 *= sin.calculate(x);
        result2 += sin.calculate(x) * tan.calculate(x);

        double result3 = result1 + result2;

        double result4 = result3 + csc.calculate(x);

        double result = 1;
        result *= result4;
        result *= result4;

        return result;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }


    public void setCsc(Csc csc) {
        this.csc = csc;
    }


    public void setTan(Tan tan) {
        this.tan = tan;
    }
}
