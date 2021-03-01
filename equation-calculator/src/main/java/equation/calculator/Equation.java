package equation.calculator;

public abstract class Equation {
    protected Coefficient[] coefficients;
    public abstract Coefficient[] solve();

    /**
     * @param coefficients Coefficient's power matches its position in the array;
     *                     for example: ax^2 + bx^1 + cx^0 = 0 coefficient packing is [c,b,a]
     */
    public Equation(Coefficient[] coefficients){
        this.coefficients = coefficients;
    }
}
