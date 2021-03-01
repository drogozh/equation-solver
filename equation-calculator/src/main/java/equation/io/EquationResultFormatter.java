package equation.io;

import equation.calculator.Coefficient;

public interface EquationResultFormatter {
    String format(Coefficient[] roots);
}
