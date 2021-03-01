package equation.cli;

import equation.exceptions.EquationDefinitionException;
import equation.io.*;
import equation.calculator.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final String HELP = "-h";
    private static final String INTERACTIVE = "-i";
    private static final String STDIO = "-s";

    public static void main(String[] args) {
        if(args.length == 0 ) {
            instructions();
            return;
        }
        executeWithOption(args[0]);
    }

    private static void executeWithOption(String option){
        if(option.equals(HELP)) instructions();
        if(option.equals(INTERACTIVE)) interactive();
        if(option.equals(STDIO)) standard();
    }

    private static void instructions(){
        StringBuilder builder = new StringBuilder();
        builder.append("Solves quadratic and linear equations.\n\n");
        builder.append("Usage: solve [option]\n\n");
        builder.append("[option]:\n");
        builder.append(" " + INTERACTIVE + "\t\t interactive mode, enter 'q' to exit\n");
        builder.append(" " + STDIO + "\t\t process standard input, press Ctrl+C to exit\n");
        builder.append(" " + HELP + "\t\t show this help");
        builder.append("\n");
        System.out.print(builder.toString());
    }

    private static void interactive(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solves quadratic and linear equations.\n");
        System.out.println("Enter comma separated equation coefficients");
        System.out.println("example: for ax^2 + bx + c = 0 enter a,b,c");
        System.out.println("Enter 'q' to exit\n");
        System.out.print("coefficients: ");
        String line;
        while(!(line = scanner.nextLine()).equals("q") ) {
            String result = solveQuadraticEquation(line);
            System.out.println(result);
            System.out.print("coefficients: ");
        }
    }

    private static void standard() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(solveQuadraticEquation(line));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private static String solveQuadraticEquation(String coefficients) {
        EquationStringParser parser = new CsvEquationParser();
        EquationResultFormatter formatter = new CsvResultFormatter();
        try {
            Equation equation = parser.parse(coefficients);
            Coefficient[] roots = equation.solve();
            return formatter.format(roots);
        } catch (EquationDefinitionException ex) {
            return formatter.formatError(ex.getMessage());
        }
    }
}
