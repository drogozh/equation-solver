package equation.calculator;

public class QuadraticEquation extends LinearEquation {
    protected final int QUADRATIC = 2;

    protected Coefficient quadratic;

    public QuadraticEquation(Coefficient[] coefficients) {
        super(coefficients);
        quadratic = coefficients[QUADRATIC];
    }

    @Override
    public Coefficient[] solve() {
        if(quadratic.isZero()) {
            return super.solve();
        }
        if(linear.isZero()) {
            return calculateNonDiscriminantRoots();
        }
        Coefficient discriminant = calculateDiscriminant();
        if(discriminant.isNegative()) {
            return calculateComplexRoots(discriminant);
        }
        return calculateRealRoots(discriminant);
    }

    private Coefficient calculateDiscriminant() {
        return linear.multiply(linear).subtract(
                quadratic.multiply(constant).multiply(4)
        );
    }

    private Coefficient[] calculateRealRoots(Coefficient discriminant) {
        if(discriminant.isZero()) {
            return new Coefficient[] {
                    linear.negate().add(discriminant.sqrt()).divide(quadratic).divide(2)
            };
        }
        return new Coefficient[] {
                linear.negate().add(discriminant.sqrt()).divide(quadratic).divide(2),
                linear.negate().subtract(discriminant.sqrt()).divide(quadratic).divide(2)
        };
    }

    private Coefficient[] calculateNonDiscriminantRoots(){
        Coefficient intermediate = constant.negate().divide(quadratic);
        if(intermediate.isNegative()) {
            return noRoots;
        }
        return new Coefficient[] {
                intermediate.sqrt(),
                intermediate.sqrt().negate()
        };
    }

    private Coefficient[] calculateComplexRoots(Coefficient discriminant) {
        return noRoots;
    }
}
