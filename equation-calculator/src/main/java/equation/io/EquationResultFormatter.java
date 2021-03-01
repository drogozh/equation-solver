package equation.io;

import equation.calculator.Coefficient;

public interface EquationResultFormatter {
    public String format(Coefficient[] roots);
}
