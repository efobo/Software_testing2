package trigonometry;

import model.CSVLogger;
import model.Calculable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Cos tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CosTest {

    private static final double DELTA = 0.01;
    private Calculable fun;

    @BeforeAll
    void setUp() {
        fun = new Cos();
    }

    @AfterAll
    void log() {
        CSVLogger logger = new CSVLogger("graph_trig_cos.csv", 1, 5, 0.1);
        logger.log(fun);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_cos_pi_data.csv")
    void dataPITest(int nominator, int denominator, double expected) {
        double input = (nominator * Math.PI) / denominator;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | nominator = %3d | denominator = %3d | input = %9f | actual = %9f\n",
                expected, nominator, denominator, input, actual);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_cos_data.csv")
    void dataDegreeTest(double inputDeg, double expected) {
        double input = inputDeg / 180 * Math.PI;
        double actual = fun.calculate(input);
        System.out.printf("expected = %9f | inputDegrees = %9f | inputRad = %9f | actual = %9f\n",
                expected, inputDeg, input, actual);
        assertEquals(expected, actual, DELTA);
    }
}
