import java.util.Scanner;

public class EvenWithoutArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers: ");
        int count = sc.nextInt();

        System.out.println("Enter the numbers:");
        for (int i = 1; i <= count; i++) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                System.out.println(num + " is even");
            }
        }

        sc.close();
    }
}
