package equation.calculator;

public abstract class Equation {
    protected static Coefficient[] noRoots = new Coefficient[]{};
    protected Coefficient[] coefficients;

    /**
     * @param coefficients Coefficient's power matches its position in the array;
     *                     for example: ax^2 + bx^1 + cx^0 = 0 coefficient packing is [c,b,a]
     */
    public Equation(Coefficient[] coefficients){
        this.coefficients = coefficients;
    }

    /**
     * Solves equation, returning results as individual coefficients
     * @return
     */
    public abstract Coefficient[] solve();
}
