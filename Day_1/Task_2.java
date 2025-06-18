import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal amount: ");
        float principal = sc.nextFloat();
        System.out.print("Enter Rate of interest: ");
        float rate = sc.nextFloat();
        System.out.print("Enter Time in years: ");
        float time = sc.nextFloat();
        float interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + interest);
        sc.close();
    }
}
