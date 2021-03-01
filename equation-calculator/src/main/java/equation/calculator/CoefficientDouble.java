package equation.calculator;

public class CoefficientDouble implements Coefficient {
    private final double TOLERANCE = 0.000000001d;

    private double value;

    public CoefficientDouble(Double value) {
        this.value = value;
    }

    @Override
    public Coefficient add(Coefficient operand) {
        return new CoefficientDouble(this.value + (double)operand.getValue());
    }

    @Override
    public Coefficient subtract(Coefficient operand) {
        return new CoefficientDouble(this.value - (double)operand.getValue());
    }

    @Override
    public Coefficient multiply(Coefficient operand) {
        return new CoefficientDouble(this.value * (double)operand.getValue());
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
    public Coefficient zero() {
        return new CoefficientDouble(0d);
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return isZero() ? "0" : ((Double)this.value).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CoefficientDouble)) return false;
        CoefficientDouble other = (CoefficientDouble)obj;
        return Math.abs(this.value - other.value) < TOLERANCE;
    }
}
