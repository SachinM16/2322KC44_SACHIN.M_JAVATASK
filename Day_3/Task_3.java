public class Calculator {
    public int sum(int a, int b) {
        System.out.println("Calling sum(int, int)");
        return a + b;
    }
    public double sum(double a, double b) {
        System.out.println("Calling sum(double, double)");
        return a + b;
    }
    public static void main(String[] args) {
        Calculator myCalculator = new Calculator();
        int resultInt = myCalculator.sum(10, 20);
        System.out.println("Sum of integers (10, 20): " + resultInt);
        System.out.println("------------------------------------");
        double resultDouble = myCalculator.sum(10.5, 20.3);
        System.out.println("Sum of doubles (10.5, 20.3): " + resultDouble);
        System.out.println("------------------------------------");
    }
}