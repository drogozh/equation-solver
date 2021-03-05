package equation.io;

import equation.calculator.Equation;
import equation.exceptions.EquationDefinitionException;

public interface EquationParser<T> {
    Equation parse(T equation) throws EquationDefinitionException;
}
