public class Calculator {

    public double previousResult = 0;
    public boolean usePreviousResult = false;

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double modulus(double a, double b) {
        return a % b;
    }

    public double percentage(double obtainedMarks, double totalMarks) {
        return (obtainedMarks / totalMarks) * 100;
    }

    public double calculate(String operation, double num1, double num2) {

        switch (operation) {

            case "+":
                return add(num1, num2);

            case "-":
                return sub(num1, num2);

            case "*":
                return multiply(num1, num2);

            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Can't divide by zero!");
                }
                return divide(num1, num2);

            case "sqrt":
                if (num1 < 0) {
                    throw new ArithmeticException("Square root of a negative number is not supported.");
                }
                return sqrt(num1);

            case "^":
                return power(num1, num2);

            case "mod":
                if (num2 == 0) {
                    throw new ArithmeticException("Can't perform modulus with zero!");
                }
                return modulus(num1, num2);

            case "%":
                if (num2 == 0) {
                    throw new ArithmeticException("Total marks can't be zero!");
                }
                return percentage(num1, num2);

            default:
                throw new IllegalArgumentException("Invalid operation!");
        }
    }
}