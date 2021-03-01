package equation.calculator;

public class QuadraticEquation extends LinearEquation {
    protected final int QUADRATIC = 2;

    public QuadraticEquation(Coefficient[] coefficients) {
        super(coefficients);
    }

    @Override
    public Coefficient[] solve() {
        if(coefficients[QUADRATIC].isZero()) {
            return super.solve();
        }

        if(coefficients[LINEAR].isZero()) {
            return calculateNonDiscriminantRoots();
        }

        Coefficient discriminant = calculateDiscriminant();
        if(discriminant.isNegative()) {
            return calculateComplexRoots(discriminant);
        }
        return calculateRealRoots(discriminant);
    }

    private Coefficient calculateDiscriminant() {
        return coefficients[LINEAR].multiply(coefficients[LINEAR])
                .subtract(coefficients[QUADRATIC].multiply(coefficients[CONSTANT]).multiply(4));
    }

    private Coefficient[] calculateRealRoots(Coefficient discriminant) {
        if(discriminant.isZero()) {
            return new Coefficient[] {
                    coefficients[LINEAR].negate().add(discriminant.sqrt()).divide(coefficients[QUADRATIC]).divide(2)
            };
        }
        return new Coefficient[] {
                coefficients[LINEAR].negate().add(discriminant.sqrt()).divide(coefficients[QUADRATIC]).divide(2),
                coefficients[LINEAR].negate().subtract(discriminant.sqrt()).divide(coefficients[QUADRATIC]).divide(2)
        };
    }

    private Coefficient[] calculateNonDiscriminantRoots(){
        Coefficient intermediate = coefficients[CONSTANT].negate().divide(coefficients[QUADRATIC]);
        if(intermediate.isNegative()) {
            return new Coefficient[]{};
        }
        return new Coefficient[] {
                intermediate.sqrt(),
                intermediate.sqrt().negate()
        };
    }

    private Coefficient[] calculateComplexRoots(Coefficient discriminant) {
        return new Coefficient[]{};
    }
}
