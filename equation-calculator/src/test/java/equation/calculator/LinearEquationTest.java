package equation.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearEquationTest {

    @Test
    void allCoefficientsAreZero(){
        Coefficient[] coefficients = new Coefficient[]{
                new CoefficientDouble(0d),
                new CoefficientDouble(0d)
        };
        Equation equation = new LinearEquation(coefficients);
        Coefficient[] roots = equation.solve();
        assertEquals(1,roots.length);
        assertTrue(roots[0].isEqual(new CoefficientDouble(0d)));
    }

    @Test
    void linearCoefficientIsZero(){
        Coefficient[] coefficients = new Coefficient[]{
                new CoefficientDouble(1d),
                new CoefficientDouble(0d)
        };
        Equation equation = new LinearEquation(coefficients);
        Coefficient[] roots = equation.solve();
        assertEquals(0,roots.length);
    }
}
