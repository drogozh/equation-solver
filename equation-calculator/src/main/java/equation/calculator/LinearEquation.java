package equation.calculator;

public class LinearEquation extends Equation {
    protected final static int CONSTANT = 0;
    protected final static int LINEAR = 1;

    protected Coefficient linear;
    protected Coefficient constant;

    public LinearEquation(Coefficient[] coefficients) {
        super(coefficients);
        linear = coefficients[LINEAR];
        constant = coefficients[CONSTANT];
    }

    @Override
    public Coefficient[] solve() {
        if(linear.isZero()) {
            if(constant.isZero()) {
                return new Coefficient[] { constant };
            } else {
                return noRoots;
            }
        }
        return new Coefficient[] { constant.negate().divide(linear) };
    }
}
