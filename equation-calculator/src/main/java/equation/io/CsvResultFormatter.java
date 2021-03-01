package equation.io;

import equation.calculator.Coefficient;

public class CsvResultFormatter implements EquationResultFormatter {
    public String format(Coefficient[] roots) {
        char separator = ',';
        StringBuilder result = new StringBuilder();

        if(roots.length < 1) return "No roots";

        for(Coefficient root: roots) {
            if(result.length() > 0) {
                result.append(separator);
            }
            result.append(root.toString());
        }
        return result.toString();
    }
}
