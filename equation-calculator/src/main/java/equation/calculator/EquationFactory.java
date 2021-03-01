package equation.calculator;

import equation.exceptions.EquationDefinitionException;

public class EquationFactory {
    private final int LINEAR_EQUATION = 2;
    private final int QUADRATIC_EQUATION = 3;

    /**
     * Constructs instances of Equation interface
     * @param coefficients Higher order coefficients occupy lower position index, i.e. left to right;
     *                     for example: ax^2 + bx + c = 0 coefficient packing is [a,b,c]
     * @return Equation
     * @throws EquationDefinitionException
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
