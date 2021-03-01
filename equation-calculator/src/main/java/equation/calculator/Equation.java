package equation.calculator;

public abstract class Equation {
    protected Coefficient[] coefficients;
    public abstract Coefficient[] solve();
    public Equation(Coefficient[] terms){
        coefficients = terms;
    }
}
