# equation-solver
Instructions for Windows
# Prerequisites
## JDK 1.8 & Maven
https://maven.apache.org/download.cgi

* Maven must be installed on the build system and 'mvn' command should be available on system PATH
* System variable JAVA_HOME pointing to JDK installation directory
* JAVA_HOME\bin location must be on system PATH  


# Build & Run
Clone repository
```
git clone https://github.com/drogozh/equation-solver.git
```
Execute build script to compile application and run unit tests
```
build.cmd
```

Build script will have generated 'solve.cmd' command file. Run 'solve.cmd'
```
solve.cmd
```

```
Solves quadratic and linear equations.

Options:
 -i              interactive mode, enter 'q' to exit
 -s              process standard input, press Ctrl+C to exit
 -h              show this help

```
Application accepts comma separated list of coefficients as an input, and outputs equation roots in CSV format or an error.
```
Solves quadratic and linear equations.

Enter comma separated equation coefficients
example: for ax^2 + bx + c = 0 enter a,b,c
coefficients: 1,2,-20
3.58257569495584,-5.58257569495584

```

Batch processing can be used with option '-s'. Input file shuold contain one line for every set of input coefficients.
```
type input.txt | solve -s > solutions.txt
``` 

