package equation.calculator;

import equation.exceptions.EquationDefinitionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EquationFactoryTest {

    @Test
    void expectLinearEquationInstance() throws EquationDefinitionException {
        EquationFactory factory = new EquationFactory();
        Equation equation = factory.makeEquation(new Coefficient[] {
                new CoefficientDouble(0d),
                new CoefficientDouble(0d)
        });
        assertTrue(equation instanceof LinearEquation);
    }

    @Test
    void expectQuadraticEquationInstance() throws EquationDefinitionException {
        EquationFactory factory = new EquationFactory();
        Equation equation = factory.makeEquation(new Coefficient[] {
                new CoefficientDouble(0d),
                new CoefficientDouble(0d),
                new CoefficientDouble(0d)
        });
        assertTrue(equation instanceof QuadraticEquation);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 4 })
    void throwExceptionOnWrongCoefficientCount(int count) {
        Coefficient[] coefficients = new Coefficient[count];
        while(count-- > 0 ) {
            coefficients[count] = new CoefficientDouble(0d);
        }
        EquationFactory factory = new EquationFactory();
        try {
            Equation equation = factory.makeEquation(coefficients);
        } catch (Exception ex) {
            assertTrue(ex instanceof EquationDefinitionException);
            return;
        }
        fail();
    }
}
