package equation.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoefficientDoubleTest {

    @Test
    void addition() {
        Coefficient smaller = new CoefficientDouble(1d);
        Coefficient bigger = new CoefficientDouble(2d);
        Coefficient result = smaller.add(bigger);
        assertTrue(result.equals(new CoefficientDouble(3d)));
    }

    @Test
    void subtraction() {
        Coefficient smaller = new CoefficientDouble(generateValue(0.3,10));
        Coefficient bigger = new CoefficientDouble(generateValue(0.5,10));
        Coefficient result = smaller.subtract(bigger);
        Coefficient reference = new CoefficientDouble(generateValue(0.2,10)).negate();
        assertTrue(result.equals(reference));
    }

    @Test
    void multiplication() {
        Coefficient smaller = new CoefficientDouble(generateValue(0.3,10));
        Coefficient bigger = new CoefficientDouble(generateValue(0.5,10));
        Coefficient result = smaller.multiply(bigger);
        Coefficient reference = new CoefficientDouble(generateValue(1.5,10));
        assertTrue(result.equals(reference));
    }

    @Test
    void division() {
        Coefficient smaller = new CoefficientDouble(generateValue(0.1,6));
        Coefficient bigger = new CoefficientDouble(generateValue(0.4,9));
        Coefficient reference = new CoefficientDouble(6d);
        Coefficient result = bigger.divide(smaller);
        assertTrue(result.equals(reference));
        assertTrue(result.multiply(smaller).equals(bigger));
    }

    @Test
    void zeroValue() {
        Coefficient zero = new CoefficientDouble(0d);
        assertTrue(zero.isZero());
        Coefficient left = new CoefficientDouble(generateValue(0.31,9));
        Coefficient right = new CoefficientDouble(generateValue(0.31,9));
        assertTrue(left.subtract(right).isZero());
        assertTrue(left.subtract(right).equals(zero));
    }

    @Test
    void equals() {
        double leftValue = generateValue(0.1d,9);
        Coefficient left = new CoefficientDouble(leftValue);
        Coefficient right = new CoefficientDouble(0.1d*9);
        assertTrue(left.equals(right));
    }

    private double generateValue(double increment, int cycles) {
        double value = 0;
        for(int i=0; i<cycles; i++ ) {
            value += increment;
        }
        return value;
    }
}
