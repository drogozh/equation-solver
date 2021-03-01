package equation.io;

import equation.calculator.Equation;
import equation.exceptions.EquationDefinitionException;

public interface EquationStringParser {
    Equation parse(String equation) throws EquationDefinitionException;
}
