package logarithm;

import model.CSVLogger;
import model.Calculable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Log5 tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log5Test {

    private static final double DELTA = 0.1;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Log5();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_log_5.csv", 0.01, 11, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_log5_data.csv")
    void dataLog5Test(double input, double expected) {
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
