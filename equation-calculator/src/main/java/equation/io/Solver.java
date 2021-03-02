package equation.io;

public interface Solver<TInput,TOutput> {
    TOutput solve(TInput input);
}
