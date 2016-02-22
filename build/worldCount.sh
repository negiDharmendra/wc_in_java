alias rmc="rm -rf ./out/*"
alias rt="java -cp ./test:./out:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore WcTest"
alias ct="javac -cp .:lib/junit-4.12.jar -d out test/WcTest.java"
alias cm="javac source/WorldCount.java"
source ~/.bash_profile