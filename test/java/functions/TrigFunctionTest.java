package functions;

import model.CSVLogger;
import model.Calculable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import trigonometry.TrigMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Trig function tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigFunctionTest {
    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new TrigFunction();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_trig_function.csv", 1, 5, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/trig/trig_function_data.csv")
    void dataTestStub(double input, double expected) {
        TrigFunction trigResultFunction = new TrigFunction();
        trigResultFunction.setCos(TrigMocks.createCosMock());
        trigResultFunction.setSin(TrigMocks.createSinMock());
        trigResultFunction.setCsc(TrigMocks.createCscMock());
        trigResultFunction.setTan(TrigMocks.createTanMock());

        double radian = input / 180 * Math.PI;
        double actual = trigResultFunction.calculate(radian);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest()
    @CsvFileSource(resources = "/trig/trig_function_data.csv")
    void dataTest(double input, double expected) {
        double radian = input / 180 * Math.PI;
        double actual = fun.calculate(radian);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

}

