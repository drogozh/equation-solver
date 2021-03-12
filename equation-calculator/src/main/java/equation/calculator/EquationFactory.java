package equation.calculator;

import equation.exceptions.EquationDefinitionException;

public class EquationFactory {
    private final static int LINEAR_EQUATION = 2;
    private final static int QUADRATIC_EQUATION = 3;

    /**
     * Constructs instances of Equation interface
     * @param coefficients Coefficient's power matches its position in the array;
     *                     for example: ax^2 + bx^1 + cx^0 = 0 coefficient packing is [c,b,a]
     * @return Equation
     * @throws EquationDefinitionException frown for any equation issues
     */
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
