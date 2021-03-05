package equation.io;

public class CsvSolver extends Solver<String,String> {
    public CsvSolver() {
        super(new CsvEquationParser(), new CsvResultFormatter());
    }
}
