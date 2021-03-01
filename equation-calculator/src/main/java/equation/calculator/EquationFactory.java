package equation.calculator;

import equation.exceptions.EquationDefinitionException;

public class EquationFactory {
    private final int LINEAR_EQUATION = 2;
    private final int QUADRATIC_EQUATION = 3;

    public Equation makeEquation(Coefficient[] coefficients) throws EquationDefinitionException {
        switch (coefficients.length) {
            case LINEAR_EQUATION:
                return new LinearEquation(coefficients);
            case QUADRATIC_EQUATION:
                return new QuadraticEquation(coefficients);
        }
        throw new EquationDefinitionException("Incorrect number of coefficients, expecting 3 or 2");
    }
}
