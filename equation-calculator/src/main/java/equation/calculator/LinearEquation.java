package equation.calculator;

public class LinearEquation extends Equation {
    protected final int CONSTANT = 0;
    protected final int LINEAR = 1;

    public LinearEquation(Coefficient[] coefficients) {
        super(coefficients);
    }

    @Override
    public Coefficient[] solve() {
        if(coefficients[LINEAR].isZero()){
            if(coefficients[CONSTANT].isZero()) {
                return new Coefficient[] { coefficients[CONSTANT] };
            } else {
                return new Coefficient[]{};
            }
        }
        return new Coefficient[] {
                coefficients[CONSTANT].negate().divide(coefficients[LINEAR])
        };
    }
}
