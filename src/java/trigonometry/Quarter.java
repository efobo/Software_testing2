package trigonometry;

import static java.lang.Math.PI;

public enum Quarter {
    RIGHT_TOP,
    LEFT_TOP,
    LEFT_BOTTOM,
    RIGHT_BOTTOM;

    static Quarter of(double angle) {
        double n = cropAnglePositive(angle);

        if (n <= PI / 2 && n >= 0) return Quarter.RIGHT_TOP;
        if (n <= PI && n >= PI / 2) return Quarter.LEFT_TOP;
        if (n <= PI * 3 / 2 && n >= PI) return Quarter.LEFT_BOTTOM;
        if (n <= PI * 2 && n >= PI * 3 / 2) return Quarter.RIGHT_BOTTOM;

        throw new IllegalArgumentException("Cant define quarter");
    }

    static double cropAnglePositive(double angle) {
        return (angle % (2 * PI) + 2 * PI) % (2 * PI);
    }

    boolean isTop() {
        return (this == RIGHT_TOP || this == LEFT_TOP);
    }

    boolean isBottom() {
        return (this == RIGHT_BOTTOM || this == LEFT_BOTTOM);
    }

    boolean isRight() {
        return (this == RIGHT_TOP || this == RIGHT_BOTTOM);
    }

    boolean isLeft() {
        return (this == LEFT_TOP || this == LEFT_BOTTOM);
    }
}
