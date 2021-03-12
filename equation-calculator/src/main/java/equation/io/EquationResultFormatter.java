package equation.io;

import equation.calculator.Coefficient;

public interface EquationResultFormatter<T> {
    T format(Coefficient[] roots);
    T formatError(String error);
}
