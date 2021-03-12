package equation.io;

import equation.calculator.*;
import equation.exceptions.EquationDefinitionException;

public class CsvEquationParser implements EquationParser<String> {
    @Override
    public Equation parse(String equationString) throws EquationDefinitionException {
        Coefficient[] coefficients = parseTerms(extractTerms(equationString));
        return new EquationFactory().makeEquation(coefficients);
    }

    private String[] extractTerms(String string) {
        return string.split(",");
    }

    private Coefficient[] parseTerms(String[] terms) throws EquationDefinitionException {
        Coefficient[] coefficients = new Coefficient[terms.length];
        int term = 0;
        try {
            for(term=0; term < terms.length; term++) {
                int ordinal = terms.length - term - 1;
                coefficients[ordinal] = new CoefficientDouble(Double.parseDouble(terms[term]));
            }
        } catch(NumberFormatException ex) {
            throw new EquationDefinitionException("Invalid coefficient '" + terms[term]  + "'");
        }
        return coefficients;
    }
}
