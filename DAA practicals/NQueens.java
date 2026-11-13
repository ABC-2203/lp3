public class NQueens {

    static int N;  // Size of the chessboard

    // Function to print the solution matrix
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {

        // Check this column on the upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the right side
        for (int i = row, j = col;
             i >= 0 && j < N;
             i--, j++) {

            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve the N-Queens problem
    static boolean solveNQueens(int[][] board, int row) {

        // Base case: If all queens are placed
        if (row >= N) {
            return true;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;  // Place the queen

                // Recur to place the rest of the queens
                if (solveNQueens(board, row + 1)) {
                    return true;
                }

                // Backtrack: Remove the queen
                board[row][col] = 0;
            }
        }

        return false;  // No solution found
    }

    public static void main(String[] args) {

        N = 8;  // Size of the chessboard
        int[][] board = new int[N][N];

        // Place the first queen manually
        // at position (0, 0)
        board[0][0] = 1;

        // Solve the problem for the remaining queens
        if (solveNQueens(board, 1)) {
            printSolution(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}









// N-Queens Problem Using Backtracking in Java
// Your program implements the N-Queens problem using the Backtracking technique, where the first queen is already placed at position (0,0) and the remaining queens are placed safely on the chessboard.

// Let's understand the program step by step, including its logic, algorithm, dry run, output and viva questions.
// 1. Aim
// To design an N-Queens matrix with the first queen already placed and use the Backtracking technique to place the remaining queens so that no two queens attack each other.
// 2. What is the N-Queens problem?
// The N-Queens problem is a problem in which we have to place N queens on an N × N chessboard such that no two queens attack each other.

// A queen can attack in three directions:
// 1. Horizontally (same row).
// 2. Vertically (same column).
// 3. Diagonally (both directions).


// In this program:
// - Board size = 8 × 8.
// - Total queens = 8.
// - First queen is already placed at (0,0).
// - Remaining 7 queens are placed using backtracking.
// 3. What is Backtracking?
// Backtracking is an algorithmic technique that tries to find a solution by making choices one by one.

// If a choice leads to an incorrect solution, it goes back, removes that choice and tries another possibility.

// Simple example:
// 1. Place a queen in a safe position.
// 2. Move to the next row.
// 3. Check whether another queen can be placed safely.
// 4. If no safe position is available, go back to the previous row.
// 5. Remove the previous queen and try another column.
// 6. Repeat until all queens are placed.




// 4. Algorithm
// 1. Start.
// 2. Initialize an N × N chessboard with all elements as 0.
// 3. Place the first queen at position (0,0).
// 4. Call the solveNQueens() function starting from row 1.
// 5. Check each column of the current row using isSafe().
// 6. If the position is safe:
//    - Place the queen by setting board[row][col] = 1.
//    - Recursively call the function for the next row.
// 7. If the recursive call fails:
//    - Remove the queen by setting board[row][col] = 0.
//    - Try the next column.
// 8. If all N queens are placed, print the solution matrix.
// 9. Stop.
// 5. Explanation of important functions
// A. printSolution()
// static void printSolution(int[][] board) {
//     for (int i = 0; i < N; i++) {
//         for (int j = 0; j < N; j++) {
//             System.out.print(board[i][j] + " ");
//         }
//         System.out.println();
//     }
// }


// - Prints the final chessboard.
// - 1 represents a queen.
// - 0 represents an empty cell.
// - Outer loop represents rows.
// - Inner loop represents columns.
// B. isSafe()
// static boolean isSafe(int[][] board, int row, int col)


// This function checks whether placing a queen at a particular position is safe.

// It checks three conditions:

// 1. Check the upper column
// for (int i = 0; i < row; i++) {
//     if (board[i][col] == 1) {
//         return false;
//     }
// }


// Checks whether another queen is present in the same column above the current row.

// 2. Check upper-left diagonal
// for (int i = row, j = col;
//      i >= 0 && j >= 0;
//      i--, j--) {

//     if (board[i][j] == 1) {
//         return false;
//     }
// }


// Checks whether another queen exists in the upper-left diagonal.

// 3. Check upper-right diagonal
// for (int i = row, j = col;
//      i >= 0 && j < N;
//      i--, j++) {

//     if (board[i][j] == 1) {
//         return false;
//     }
// }


// Checks whether another queen exists in the upper-right diagonal.

// If all three checks are clear, it returns true.

// Important: We only check above the current row because the program places queens row by row, from top to bottom.
// C. solveNQueens()
// static boolean solveNQueens(int[][] board, int row)


// This is the main recursive function.

// Base condition:
// if (row >= N) {
//     return true;
// }


// If the current row reaches N, it means all queens have been placed successfully.

// Try every column:
// for (int col = 0; col < N; col++) {


// Checks every column in the current row.

// Place the queen:
// if (isSafe(board, row, col)) {
//     board[row][col] = 1;


// If the position is safe, place the queen.

// Recursive call:
// if (solveNQueens(board, row + 1)) {
//     return true;
// }


// Move to the next row to place another queen.

// Backtracking:
// board[row][col] = 0;


// If the next row cannot accommodate a queen, remove the previously placed queen and try another column.

// This is the most important step in backtracking.
// 6. Main function
// public static void main(String[] args) {

//     N = 8;
//     int[][] board = new int[N][N];

//     board[0][0] = 1;

//     if (solveNQueens(board, 1)) {
//         printSolution(board);
//     } else {
//         System.out.println("No solution exists.");
//     }
// }


// Explanation:
// - N = 8: Creates an 8 × 8 chessboard.
// - new int[N][N]: Initializes the board with zeros.
// - board[0][0] = 1: Manually places the first queen.
// - solveNQueens(board, 1): Starts placing queens from row 1.
// - printSolution(board): Prints the final arrangement if a solution exists.
// 7. Dry Run
// For understanding, consider a 4 × 4 chessboard.

// Initially:
// Q  0  0  0
// 0  0  0  0
// 0  0  0  0
// 0  0  0  0


// First queen is placed at (0,0).

// One valid arrangement is:



// This is a valid solution because no two queens share the same row, column or diagonal.
// 8. Output
// For your actual Java program with N = 8, one possible output is:
// 1 0 0 0 0 0 0 0
// 0 0 1 0 0 0 0 0
// 0 0 0 0 0 1 0 0
// 0 0 0 0 0 0 0 1
// 0 0 0 0 1 0 0 0
// 0 0 0 0 0 0 1 0
// 0 1 0 0 0 0 0 0
// 0 0 0 1 0 0 0 0


// Each row and column contains exactly one queen.
// 9. Complexity Analysis
// Complexity	Explanation
// Time	O(N!) approximately, with safety checks adding O(N) per placement
// Space	O(N²) for the chessboard

// The recursive call stack requires O(N) additional space.
// 10. Important Viva Questions and Answers
// Q1. What is the N-Queens problem?

// It is the problem of placing N queens on an N × N chessboard such that no two queens attack each other.

// Q2. Which technique is used?

// Backtracking.

// Q3. What is backtracking?

// It is a technique that tries possible solutions and goes back whenever a choice leads to failure.

// Q4. Why do we use isSafe()?

// To check whether a queen can be placed at a particular position without attacking another queen.

// Q5. What does 1 and 0 represent?
// - 1 = Queen is placed.
// - 0 = Empty position.
// Q6. Why do we start from row 1?

// Because the first queen is already placed at row 0.

// Q7. What is the base condition?
// if (row >= N)
//     return true;


// It indicates that all queens have been placed successfully.

// Q8. What is the purpose of board[row][col] = 0?

// It removes the queen when the selected position does not lead to a valid solution. This is called backtracking.

// Q9. Why do we check only upper diagonals?

// Because queens are placed row by row from top to bottom. Therefore, queens can only exist in previously completed rows.

// Q10. What is the space complexity?

// O(N²) for the board, plus O(N) recursion stack space.

// Q11. Can we solve this problem without backtracking?

// Yes, other approaches exist, but backtracking is a standard technique for finding N-Queens solutions.

// Q12. What happens if no safe position is available?

// The algorithm backtracks to the previous row, removes the queen and tries another position.

// 11. Most important points to remember for your practical exam
// - Problem: N-Queens.
// - Technique: Backtracking.
// - Board: N × N matrix.
// - Queen representation: 1.
// - Empty cell: 0.
// - First queen: (0,0).
// - Starting row: 1.
// - Safety checks: Column, upper-left diagonal and upper-right diagonal.
// - Backtracking statement: board[row][col] = 0.
// - Base condition: row >= N.

// Practical exam tip: If your examiner asks which is the most important statement in this program, explain:
// board[row][col] = 0;


// This statement performs backtracking. It removes a queen from an unsuccessful position so that the algorithm can try another possible arrangement.