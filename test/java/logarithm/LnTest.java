package logarithm;

import model.CSVLogger;
import model.Calculable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Ln tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LnTest {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Ln();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_ln.csv", 0.01, 5, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "/logarithm/log_ln_data.csv")
    void dataLnTest(double input, double expected) {
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
