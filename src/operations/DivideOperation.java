package operations;

public class DivideOperation implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}
