package equation.calculator;

public class CoefficientDouble implements Coefficient {
    private static final double TOLERANCE = 0.000000001d;

    private final Double value;

    public CoefficientDouble(double value) {
        this.value = value;
    }

    @Override
    public Coefficient add(Coefficient augend) {
        return new CoefficientDouble(this.value + (double)augend.getValue());
    }

    @Override
    public Coefficient subtract(Coefficient subtrahend) {
        return new CoefficientDouble(this.value - (double)subtrahend.getValue());
    }

    @Override
    public Coefficient multiply(Coefficient multiplicand) {
        return new CoefficientDouble(this.value * (double)multiplicand.getValue());
    }

    @Override
    public Coefficient multiply(int multiplicand) {
        return new CoefficientDouble(this.value * multiplicand);
    }

    @Override
    public Coefficient divide(Coefficient divisor) {
        return new CoefficientDouble(this.value / (double)divisor.getValue());
    }

    @Override
    public Coefficient divide(int divisor) {
        return new CoefficientDouble(this.value / (double)divisor);
    }

    @Override
    public Coefficient negate() {
        return new CoefficientDouble(-1 * this.value);
    }

    @Override
    public Coefficient sqrt() {
        return new CoefficientDouble(Math.sqrt(this.value));
    }

    @Override
    public boolean isZero() {
        return this.value > -1 * TOLERANCE && this.value < TOLERANCE;
    }

    @Override
    public boolean isNegative() {
        return this.value < 0;
    }

    @Override
    public boolean isEqual(Coefficient other) {
        if(!(other instanceof CoefficientDouble)) return false;
        return Math.abs(this.value - ((CoefficientDouble)other).value) < TOLERANCE;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return isZero() ? "0" : this.value.toString();
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }


}
