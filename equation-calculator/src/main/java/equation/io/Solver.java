package equation.io;

import equation.calculator.Coefficient;
import equation.calculator.Equation;
import equation.exceptions.EquationDefinitionException;

public abstract class Solver<TInput,TOutput> {

    EquationParser<TInput> parser;
    EquationResultFormatter<TOutput> formatter;

    public Solver(EquationParser<TInput> parser, EquationResultFormatter<TOutput> formatter) {
        this.parser = parser;
        this.formatter = formatter;
    }

    public TOutput solve(TInput input) {
        try {
            Equation equation = parser.parse(input);
            Coefficient[] roots = equation.solve();
            return formatter.format(roots);
        } catch (EquationDefinitionException ex) {
            return formatter.formatError(ex.getMessage());
        }
    }
}
