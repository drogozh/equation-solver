package equation.calculator;

import equation.exceptions.EquationDefinitionException;

public abstract class Equation {
    protected Coefficient[] coefficients;
    public abstract Coefficient[] solve();

    /**
     * Constructs instances of Equation interface
     * @param coefficients Coefficient's power matches its position in the array;
     *                     for example: ax^2 + bx^1 + cx^0 = 0 coefficient packing is [c,b,a]
     * @return Equation
     * @throws EquationDefinitionException
     */
    public Equation(Coefficient[] coefficients){
        this.coefficients = coefficients;
    }

    public Coefficient[] getCoefficients() {
        Coefficient[] copy = new Coefficient[coefficients.length];
        for(int index=0; index < coefficients.length; index++) {
            copy[index] = coefficients[index];
        }
        return copy;
    }
}
