import java.util.Scanner;

public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        String[] words = input.trim().split("\\s+");
        int wordCount = words.length;
        int charCount = 0;
        for (char ch : input.toCharArray()) {
            if (ch != ' ') {
                charCount++;
            }
        }
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("\n--- String Analysis ---");
        System.out.println("Original String : " + input);
        System.out.println("Word Count      : " + wordCount);
        System.out.println("Character Count : " + charCount);
        System.out.println("Reversed String : " + reversed);
        System.out.println("Words:");
        for (int i = 0; i < words.length; i++) {
            System.out.println("  Word " + (i + 1) + ": " + words[i]);
        }
    }
}
