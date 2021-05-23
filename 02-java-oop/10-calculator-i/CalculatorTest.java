public class CalculatorTest {
    public static void main(String[] args) {
        Calculator testClass = new Calculator();
        testClass.setOperandOne(10.5);
        testClass.setOperator('+');
        testClass.setOperandTwo(5.2);
        testClass.preformOperator();
        testClass.getresults();

    }
    
}
