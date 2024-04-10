import java.util.Scanner;

public class keypad {
    // Mapping the digits to their corresponding letters
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Function to recursively find the combinations
    public static void keypadOutput(int i, String input, StringBuilder curConfig) {
        // Base case: If we have processed all digits of the input
        if (i == input.length()) {
            System.out.println(curConfig.toString());
            return;
        }

        // Converting char to integer index, assuming input[i] is a digit
        int currentIndex = input.charAt(i) - '0';

        // If the current digit is 0 or 1, it does not correspond to any letters
        if (currentIndex == 0 || currentIndex == 1) {
            keypadOutput(i + 1, input, curConfig);
        }

        // Processing all possible letters for the current digit
        for (int k = 0; k < keypad[currentIndex].length(); k++) {
            curConfig.append(keypad[currentIndex].charAt(k)); // Adding the letter to the current configuration
            keypadOutput(i + 1, input, curConfig); // Moving to the next digit
            curConfig.deleteCharAt(curConfig.length() - 1); // Backtracking: removing the last character added
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        StringBuilder cur = new StringBuilder(); // Using StringBuilder for efficient modification
        keypadOutput(0, input, cur);
    }
}
