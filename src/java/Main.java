import functions.FullFunction;
import functions.LogFunction;
import functions.TrigFunction;
import logarithm.Ln;
import logarithm.Log10;
import logarithm.Log3;
import logarithm.Log5;
import trigonometry.Cos;
import trigonometry.Csc;
import trigonometry.Sin;
import trigonometry.Tan;

public class Main {

    public static Double degreesStrToRadian(String angle) {
        return Double.parseDouble(angle) / 180 * Math.PI;
    }

    public static void main(String [] args) {
        LogFunction logFunction = new LogFunction();
        TrigFunction trigFunction = new TrigFunction();
        FullFunction fullFunction = new FullFunction();

        //System.out.println(logFunction.calculate(2.71828));


        Log5 log5 = new Log5();
        Log3 log3 = new Log3();
        Log10 log10 = new Log10();
        Ln ln = new Ln();

        Cos cos = new Cos();
        Sin sin = new Sin();
        Tan tan =new Tan();
        Csc csc = new Csc();

        System.out.println("-45 = " + fullFunction.calculate(degreesStrToRadian("-45")));
        System.out.println("-90 = " + fullFunction.calculate(degreesStrToRadian("-90")));
        System.out.println("tan-180 = " + tan.calculate(degreesStrToRadian("-180")));
        System.out.println("func -45 = " + trigFunction.calculate(degreesStrToRadian("-45")));
        System.out.println("csc-180 = " + csc.calculate(degreesStrToRadian("-180")));
    }
}
