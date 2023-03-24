package functions;

import logarithm.LogMocks;
import model.Calculable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import trigonometry.TrigMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Full function tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FullFunctionTest {
    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new FullFunction();
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/full_function_data.csv")
    void dataTestStub(double input, double expected) {
        FullFunction fullFunction = new FullFunction();
        fullFunction.setTrigFunction(TrigMocks.createTrigFunctionMock());
        fullFunction.setLogFunction(LogMocks.createLogFunctionMock());
        double actual = fullFunction.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }


    @ParameterizedTest()
    @CsvFileSource(resources = "/full_function_data.csv")
    void dataTest(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

}
