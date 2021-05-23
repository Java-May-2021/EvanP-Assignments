public class Calculator {
    private double OperandOne;
    private double OperandTwo;
    private char Operator;
    private double results;
    
    public Calculator() {
    }
    public void setOperandOne(double OperandOne) {
        this.OperandOne = OperandOne;        
    }
    public void setOperandTwo(double OperandTwo) {
        this.OperandTwo = OperandTwo;
    }
    public void setOperator(char Operator) {
        this.Operator = Operator;
    }
    public void preformOperator() {
        if (Operator == '+'){
            this.results = OperandOne + OperandTwo;
        }
        else if (Operator == '-') {
            this.results = OperandOne - OperandTwo;
        }
    }
    public void getresults() {
        System.out.println("The total is: " + this.results);
        
    }
}