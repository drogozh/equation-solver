package equation.cli;

import equation.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static final String HELP = "-h";
    private static final String INTERACTIVE = "-i";
    private static final String STDIO = "-s";

    private static Solver<String,String> solver = new CsvSolver();

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
        StringBuilder text = new StringBuilder();
        text.append("Solves quadratic and linear equations.\n\n");
        text.append("Usage: solve [option]\n\n");
        text.append("[option]:\n");
        text.append(" " + INTERACTIVE + "\t\t interactive mode, enter 'q' to exit\n");
        text.append(" " + STDIO + "\t\t process standard input, press Ctrl+C to exit\n");
        text.append(" " + HELP + "\t\t show this help");
        text.append("\n");
        System.out.print(text.toString());
    }

    private static void interactive(){
        StringBuilder text = new StringBuilder();
        text.append("Solves quadratic and linear equations.\n\n");
        text.append("Enter comma separated equation coefficients\n");
        text.append("example: for ax^2 + bx + c = 0 enter a,b,c\n");
        text.append("Enter 'q' to exit\n\n");
        text.append("coefficients: ");
        System.out.print(text.toString());

        String line;
        Scanner scanner = new Scanner(System.in);
        while(!(line = scanner.nextLine()).equals("q") ) {
            String result = solver.solve(line);
            System.out.println(result);
            System.out.print("coefficients: ");
        }
    }

    private static void standard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(solver.solve(line));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
