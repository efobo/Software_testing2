package trigonometry;

import functions.MockCSVer;
import functions.TrigFunction;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class TrigMocks {
    private static final double DELTA = 0.01;

    public static Double degreesStrToRadian(String angle) {
        return Double.parseDouble(angle) / 180 * Math.PI;
    }

    public static Cos createCosMock() {
        Cos fun = mock(Cos.class);
        MockCSVer.setupFromCSV(fun, "test/resources/trig/mocks/trig_cos_data.csv", DELTA,
                TrigMocks::degreesStrToRadian);
        return fun;
    }

    public static Sin createSinMock() {
        Sin fun = Mockito.mock(Sin.class);
        MockCSVer.setupFromCSV(fun, "test/resources/trig/mocks/trig_sin_data.csv", DELTA, TrigMocks::degreesStrToRadian);
        return fun;
    }

    public static Csc createCscMock() {
        Csc fun = mock(Csc.class);
        MockCSVer.setupFromCSV(fun, "test/resources/trig/mocks/trig_csc_data.csv", DELTA,
                TrigMocks::degreesStrToRadian);
        return fun;
    }


    public static Tan createTanMock() {
        Tan fun = mock(Tan.class);
        MockCSVer.setupFromCSV(fun, "test/resources/trig/mocks/trig_tan_data.csv", DELTA,
                TrigMocks::degreesStrToRadian);
        return fun;
    }


    public static TrigFunction createTrigFunctionMock() {
        TrigFunction fun = mock(TrigFunction.class);
        MockCSVer.setupFromCSV(fun, "test/resources/trig/mocks/trig_function_data.csv", DELTA,
                TrigMocks::degreesStrToRadian);
        return fun;
    }
}

