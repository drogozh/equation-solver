package equation.io;

import equation.calculator.Coefficient;

public class CsvResultFormatter implements EquationResultFormatter {
    public String format(Coefficient[] roots) {
        if(roots.length < 1) return "No roots";
        StringBuilder result = new StringBuilder();
        char separator = ',';
        for(Coefficient root: roots) {
            if(result.length() > 0) {
                result.append(separator);
            }
            result.append(root.toString());
        }
        return result.toString();
    }
}
