import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine().toLowerCase();
        char[] charArray = input.toCharArray();
        int vowels = 0, consonants = 0;
        System.out.println("\nCharacter Analysis:");
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            System.out.print("Index " + i + ": '" + ch + "' → ");
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                    System.out.println("Vowel");
                } else {
                    consonants++;
                    System.out.println("Consonant");
                }
            } else {
                System.out.println("Ignored (not a letter)");
            }
        }
        System.out.println("\nVowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
