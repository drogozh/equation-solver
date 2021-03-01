@echo off
call mvn -f .\pom.xml clean compile
call mvn -f .\pom.xml test
echo @echo off > solve.cmd
echo java -classpath equation-solver-cli\target\classes;equation-calculator\target\classes equation.cli.Main %%1 >> solve.cmd
