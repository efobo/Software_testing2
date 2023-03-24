package model;

public abstract class AbstractFunction implements Calculable {
    private double accuracy = 1e-7;
    public static final int MAX_ITERATIONS = 1_000_000;

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
