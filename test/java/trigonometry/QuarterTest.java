package trigonometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Quarter tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuarterTest {
    private final double DELTA = 0.001D;

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_radian_quarter_data.csv")
    public void quarterRadianTest(double radian, int expectedQuarter) {
        Quarter actualQuarter = Quarter.of(radian);
        assertEquals(expectedQuarter, actualQuarter.ordinal());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_degree_quarter_data.csv")
    public void quarterDegreeTest(double degree, int expectedQuarter) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertEquals(expectedQuarter, actualQuarter.ordinal());
    }

    @ParameterizedTest
    @CsvSource(value = {"10", "30", "60", "88", "90", "120", "170"})
    public void quarterTopTest(double degree) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertTrue(actualQuarter.isTop());
    }

    @ParameterizedTest
    @CsvSource(value = {"190", "220", "270", "320", "350"})
    public void quarterBottomTest(double degree) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertTrue(actualQuarter.isBottom());
    }

    @ParameterizedTest
    @CsvSource(value = {"10", "30", "60", "80", "350", "300"})
    public void quarterRightTest(double degree) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertTrue(actualQuarter.isRight());
    }

    @ParameterizedTest()
    @CsvSource(value = {"100", "170", "180", "190", "260"})
    public void quarterLeftTest(double degree) {
        double radian = degree / 180 * Math.PI;
        Quarter actualQuarter = Quarter.of(radian);
        assertTrue(actualQuarter.isLeft());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trig/trig_quarter_crop_data.csv")
    public void quarterCropAnglePositiveTest(double inputDegree, int expectedDegree) {
        double inputRadian = inputDegree / 180D * Math.PI;
        double expectedRadian = expectedDegree / 180D * Math.PI;
        double actualRadian = Quarter.cropAnglePositive(inputRadian);
        assertEquals(expectedRadian, actualRadian, DELTA);
    }
}

