package functions;

import logarithm.LogMocks;
import model.CSVLogger;
import model.Calculable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Log function tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogFunctionTest {
    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new LogFunction();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_log_function.csv", 0.01, 5, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log_function_data.csv")
    void dataTestStub(double input, double expected) {
        LogFunction logFunction = new LogFunction();
        logFunction.setLn(LogMocks.createLnMock());
        logFunction.setLog5(LogMocks.createLog5Mock());
        logFunction.setLog3(LogMocks.createLog3Mock());
        logFunction.setLog10(LogMocks.createLog10Mock());

        double actual = logFunction.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log_function_data.csv")
    void dataTest(double input, double expected) {
        double actual = fun.calculate(input);
        System.out.printf("input = %9f | expected = %9f | actual = %9f\n",
                input, expected, actual);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void zeroTest() {
        assertThrows(IllegalArgumentException.class, () -> fun.calculate(0));
    }

}
