package equation.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QudraticEquationTest {
    @Test
    void positiveCoefficients() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(10d),
                new CoefficientDouble(7d),
                new CoefficientDouble(1d),
        });
        Coefficient[] roots = equation.solve();
        assertEquals(2,roots.length);

        Coefficient rootA = new CoefficientDouble(-2d);
        Coefficient rootB = new CoefficientDouble(-5d);

        assertTrue(rootA.isEqual(roots[0]) || rootA.isEqual(roots[1]));
        assertTrue(rootB.isEqual(roots[0]) || rootB.isEqual(roots[1]));
    }

    @Test
    void negativeDiscriminant() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(10d),
                new CoefficientDouble(7d),
                new CoefficientDouble(20d),
        });
        Coefficient[] roots = equation.solve();
        assertEquals(0,roots.length);
    }

    @Test
    void zeroQuadraticCoefficient() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(10d),
                new CoefficientDouble(7d),
                new CoefficientDouble(0d),
        });
        Coefficient[] roots = equation.solve();
        assertEquals(1,roots.length);

        Coefficient rootA = new CoefficientDouble(-10d)
                .divide(new CoefficientDouble(7d));

        assertTrue(rootA.isEqual(roots[0]));
    }

    @Test
    void zeroConstantCoefficient() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(0d),
                new CoefficientDouble(7d),
                new CoefficientDouble(1d),
        });
        Coefficient[] roots = equation.solve();
        assertEquals(2,roots.length);

        Coefficient rootA = new CoefficientDouble(-7d);
        Coefficient rootB = new CoefficientDouble(0d);

        assertTrue(rootA.isEqual(roots[0]) || rootA.isEqual(roots[1]));
        assertTrue(rootB.isEqual(roots[0]) || rootB.isEqual(roots[1]));
    }

    @Test
    void zeroLinearCoefficientNoRoots() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(10d),
                new CoefficientDouble(0d),
                new CoefficientDouble(1d),
        });
        Coefficient[] roots = equation.solve();
        assertEquals(0,roots.length);
    }

    @Test
    void zeroLinearCoefficientWithRoots() {
        Equation equation = new QuadraticEquation(new Coefficient[]{
                new CoefficientDouble(-10d),
                new CoefficientDouble(0d),
                new CoefficientDouble(1d),
        });
        Coefficient[] roots = equation.solve();

        Coefficient reference = new CoefficientDouble(10d).sqrt();
        Coefficient negativeReference = new CoefficientDouble(10d).sqrt();
        assertEquals(2,roots.length);
        assertTrue(reference.isEqual(roots[0]) || reference.isEqual(roots[1]));
        assertTrue(negativeReference.isEqual(roots[0]) || negativeReference.isEqual(roots[1]));
    }
}
