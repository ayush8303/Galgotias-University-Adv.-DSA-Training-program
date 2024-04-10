import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        generate(new StringBuilder(), n, n);
    }

    public static void generate(StringBuilder curConfig, int open, int close) {
        if (open == 0 && close == 0) {
            System.out.println(curConfig.toString());
            return;
        }

        if (open > 0) {
            curConfig.append('(');
            generate(curConfig, open - 1, close);
            curConfig.deleteCharAt(curConfig.length() - 1); // Equivalent to pop_back() in C++
        }
        if (close > 0 && open < close) {
            curConfig.append(')');
            generate(curConfig, open, close - 1);
            curConfig.deleteCharAt(curConfig.length() - 1); // Equivalent to pop_back() in C++
        }
    }
}
