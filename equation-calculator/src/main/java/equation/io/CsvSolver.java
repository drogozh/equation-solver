package equation.io;

import equation.calculator.Coefficient;
import equation.calculator.Equation;
import equation.exceptions.EquationDefinitionException;

public class CsvSolver implements Solver<String,String> {
    @Override
    public String solve(String input) {
        EquationStringParser parser = new CsvEquationParser();
        EquationResultFormatter formatter = new CsvResultFormatter();
        try {
            Equation equation = parser.parse(input);
            Coefficient[] roots = equation.solve();
            return formatter.format(roots);
        } catch (EquationDefinitionException ex) {
            return formatter.formatError(ex.getMessage());
        }
    }
}
