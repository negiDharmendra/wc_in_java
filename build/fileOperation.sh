alias rmc="rm -rf ./out/*"
alias rt="java -cp ./test:./out:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore FileOperationTest"
alias ct="javac -cp .:lib/junit-4.12.jar -d out test/FileOperationTest.java"
alias cm="javac source/FileOperation.java"
source ~/.bash_profile