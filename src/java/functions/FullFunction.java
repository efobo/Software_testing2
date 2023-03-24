package functions;

import model.AbstractFunction;

public class FullFunction extends AbstractFunction {
    private LogFunction logFunction;
    private TrigFunction trigFunction;

    public FullFunction() {
        this.logFunction = new LogFunction();
        this.trigFunction = new TrigFunction();
    }

    @Override
    public double calculate(double value) {
        if (value <= 0) return trigFunction.calculate(value);
        return logFunction.calculate(value);
    }

    public void setLogFunction(LogFunction logResultFunction) {
        this.logFunction = logResultFunction;
    }

    public void setTrigFunction(TrigFunction trigResultFunction) {
        this.trigFunction = trigResultFunction;
    }
}
