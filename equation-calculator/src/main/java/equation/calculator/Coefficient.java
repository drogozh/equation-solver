package equation.calculator;

public interface Coefficient {
    Coefficient add(Coefficient augend);
    Coefficient subtract(Coefficient subtrahend);
    Coefficient multiply(Coefficient multiplicand);
    Coefficient multiply(int multiplicand);
    Coefficient divide(Coefficient divisor);
    Coefficient divide(int divisor);
    Coefficient negate();
    Coefficient sqrt();
    Coefficient zero();
    boolean isZero();
    boolean isNegative();
    Object getValue();
}
