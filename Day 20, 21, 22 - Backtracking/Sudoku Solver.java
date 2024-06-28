import java.util.*;

public class Main {
    
    public static boolean isSafe(int[][] mat, int i, int j, int no) {
        // Check for row and col
        for (int k = 0; k < 9; k++) {
            if (mat[k][j] == no || mat[i][k] == no) {
                return false;
            }
        }
        // Check for subgrid
        int sx = (i / 3) * 3;
        int sy = (j / 3) * 3;
        for (int x = sx; x < sx + 3; x++) {
            for (int y = sy; y < sy + 3; y++) {
                if (mat[x][y] == no) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] mat, int i, int j, int n) {
        // Base case
        if (i == n) {
            // Print the solution
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    System.out.print(mat[x][y] + " ");
                }
                System.out.println();
            }
            return true;
        }
        // Recursive case
        if (j == n) {
            return solveSudoku(mat, i + 1, 0, n);
        }
        // Skip the prefilled cell
        if (mat[i][j] != 0) {
            return solveSudoku(mat, i, j + 1, n);
        }
        // Cell to be filled, try out all possibilities
        for (int no = 1; no <= n; no++) {
            if (isSafe(mat, i, j, no)) {
                mat[i][j] = no;
                boolean solveSubproblem = solveSudoku(mat, i, j + 1, n);
                if (solveSubproblem) {
                    return true;
                }
            }
        }
        // If no option works, backtracking
        mat[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] mat =
            {{5, 3, 0, 0, 7, 0, 0, 0, 0},
             {6, 0, 0, 1, 9, 5, 0, 0, 0},
             {0, 9, 8, 0, 0, 0, 0, 6, 0},
             {8, 0, 0, 0, 6, 0, 0, 0, 3},
             {4, 0, 0, 8, 0, 3, 0, 0, 1},
             {7, 0, 0, 0, 2, 0, 0, 0, 6},
             {0, 6, 0, 0, 0, 0, 2, 8, 0},
             {0, 0, 0, 4, 1, 9, 0, 0, 5},
             {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        
        if (!solveSudoku(mat, 0, 0, n)) {
            System.out.println("No solution exists!");
        }
    }
}
