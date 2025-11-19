import operations.Operation;

public class Calculator {

    private Double firstNumber = null;
    private Operation currentOperation = null;

    public void setOperation(Operation operation) {
        this.currentOperation = operation;
    }

    public void setFirstNumber(double number) {
        this.firstNumber = number;
    }

    public double calculate(double secondNumber) {
        if (currentOperation == null || firstNumber == null)
            throw new IllegalStateException("Missing operation or first number");

        double result = currentOperation.execute(firstNumber, secondNumber);

        // reset calculator for next operation
        firstNumber = null;
        currentOperation = null;

        return result;
    }

    public void clear() {
        firstNumber = null;
        currentOperation = null;
    }
}
