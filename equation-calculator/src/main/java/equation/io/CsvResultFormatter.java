package equation.io;

import equation.calculator.Coefficient;

public class CsvResultFormatter implements EquationResultFormatter<String> {
    private static final String SEPARATOR = ",";

    public String format(Coefficient[] roots) {
        if(roots.length < 1) return "No Roots";
        StringBuilder result = new StringBuilder();
        result.append("Roots");
        for(Coefficient root: roots) {
            result.append(SEPARATOR);
            result.append(root.toString());
        }
        return result.toString();
    }

    public String formatError(String errorMessage) {
        return "Error," + errorMessage;
    }
}
