//Write a program with a non-recursive and recursive program to calculate Fibonacci numbers

// TC: O (2^N)
// SC : O(N)
import java.util.Scanner;

public class Rec_Fibonacci {

    static int counter = 0;

    // Calculate nth term in Fibonacci
    public static int fib(int n) {

        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fib(n - 1);
        int fnm2 = fib(n - 2);

        int fn = fnm1 + fnm2;

        return fn;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        int sum = 0;

        System.out.print("Fibonacci Series: ");

        for (int i = 0; i < n; i++) {

            int num = fib(i);

            System.out.print(num + " ");

            sum = sum + num;
        }

        System.out.println("\nSum = " + sum);
        System.out.println("Counter = " + counter);

        sc.close();
    }
}





// NON -RECURSIVE : JUST CHANGE THE FILE NAME
// TC: O(N)
// SC : O(1)

// import java.util.Scanner;

// public class FibonacciIterative {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of terms: ");
//         int n = sc.nextInt();

//         int first = 0;
//         int second = 1;
//         int sum = 0;
//         int counter = 0;

//         System.out.print("Fibonacci Series: ");

//         for (int i = 0; i < n; i++) {

//             System.out.print(first + " ");

//             sum = sum + first;
//             counter++;

//             int next = first + second;

//             first = second;
//             second = next;
//         }

//         System.out.println("\nSum = " + sum);
//         System.out.println("Counter = " + counter);

//         sc.close();
//     }
// }









// Fibonacci Series Using Recursive and Non-Recursive Methods
// This program calculates the Fibonacci series, sum of Fibonacci numbers, number of steps using a counter, and time and space complexity using two approaches:
// 1. Non-Recursive Approach (Iterative)
// 2. Recursive Approach
// I'll explain both approaches using beginner-friendly Java and Python code, with dry runs and complexity analysis.
// 1. What is the Fibonacci Series?
// The Fibonacci series is a sequence in which each number is the sum of the previous two numbers.

// Formula:
// \[
// F(n)=F(n-1)+F(n-2)
// \]

// Where:
// - F(0) = 0
// - F(1) = 1
// - F(n) = F(n-1) + F(n-2)
// Example: If n = 7:
// Fibonacci Series
// 0, 1, 1, 2, 3, 5, 8

// Sum = 0 + 1 + 1 + 2 + 3 + 5 + 8 = 20

// Here, we consider n as the number of terms, not the last index.
// 2. Non-Recursive Approach (Iterative)
// Meaning: Non-recursive means we calculate Fibonacci numbers using loops instead of calling the same function repeatedly.

// Logic:
// 1. Initialize first = 0 and second = 1.
// 2. Print the first number.
// 3. Calculate the next number using next = first + second.
// 4. Update the values:
//    - first = second
//    - second = next
// 5. Repeat using a loop.
// 6. Add every Fibonacci number to sum.
// 7. Increment the counter for every loop iteration.



// RECURSION
// Meaning: Recursive means a function calls itself to solve a smaller version of the same problem.

// In Fibonacci, we calculate:
// \[
// F(n)=F(n-1)+F(n-2)
// \]

// Logic:
// 1. Create a function fibonacci(n).
// 2. Set two base conditions:
//    - If n = 0, return 0.
//    - If n = 1, return 1.
// 3. Otherwise, call the same function:
//    fibonacci(n-1) + fibonacci(n-2).
// 4. Use a loop in the main function to print the required terms.
// 5. Calculate the sum of all terms.
// 6. Increment a counter every time the recursive function is called.


// 4. Understanding the Counter
// The counter helps us analyze how many times an operation or function is executed.

// There is an important difference between the two approaches:
// Approach	What does counter count?
// Non-recursive	Number of loop iterations
// Recursive	Number of recursive function calls, including base cases

// For n = 7:

// Non-recursive:
// - Loop executes 7 times.
// - Counter = 7.
// Recursive:

// The recursive calls for each Fibonacci term are:
// Term	Function calls
// F(0)	1
// F(1)	1
// F(2)	3
// F(3)	5
// F(4)	9
// F(5)	15
// F(6)	25
// Total	59

// Correction: The above recursive call counts sum to 59, so the correct output for the recursive programs is:
// Counter = 59


// This is because every call is counted, even when it returns through a base condition.
// 5. Dry Run of Non-Recursive Approach
// Suppose n = 7.
// Iteration	First	Second	Next	Sum
// 1	0	1	1	0
// 2	1	1	2	1
// 3	1	2	3	2
// 4	2	3	5	4
// 5	3	5	8	7
// 6	5	8	13	12
// 7	8	13	21	20

// Final result:
// - Fibonacci series = 0, 1, 1, 2, 3, 5, 8
// - Sum = 20
// - Counter = 7
// 6. Time and Space Complexity
// This is very important for your DAA practical and viva.
// Complexity	Non-Recursive	Recursive
// Time Complexity	O(n)	O(2ⁿ)
// Space Complexity	O(1)	O(n)
// Extra memory	Constant	Recursive call stack
// Execution	Faster	Slower for large n
// Counter	n iterations	Exponentially many calls

// Why?

// Non-recursive:
// - The loop executes n times.
// - Each iteration performs constant-time operations.
// - Therefore, time complexity is O(n).
// - Only a few variables are used, so space is O(1).
// Recursive:
// - Each function call can generate two more calls.
// - Many calculations are repeated.
// - Therefore, time complexity is O(2ⁿ) as a simple upper bound.
// - The maximum recursion depth is O(n), so space complexity is O(n).
// More precisely, the naive recursive Fibonacci algorithm takes O(φⁿ) time, where φ is the golden ratio (approximately 1.618). O(2ⁿ) is its commonly used upper bound.
// 7. Which Approach Is Better?
// Recommended: Non-Recursive (Iterative)
// The non-recursive approach is better for calculating Fibonacci numbers in practical applications.
// Reason	Non-Recursive	Recursive
// Speed	Faster	Slower
// Memory usage	Less	More
// Repeated calculations	No	Yes
// Code understanding	Easy	Requires understanding of recursion
// Large input	More suitable	Less suitable

// My recommendation for your practical:
// - Use Non-Recursive when you want better performance and less memory usage.
// - Use Recursive when you want to understand recursion and function calls.
// - For large Fibonacci calculations, iterative is generally the better choice.
// 8. Viva Questions and Answers
// Q1. What is Fibonacci series?

// A sequence in which each number is the sum of the previous two numbers.

// Q2. What is recursion?

// Recursion is a technique in which a function calls itself until a base condition is reached.

// Q3. What is a base condition?

// A condition that stops recursive function calls. In Fibonacci, F(0) = 0 and F(1) = 1.

// Q4. What is an iterative approach?

// An approach that uses loops such as for and while to repeat instructions.

// Q5. What is the time complexity of iterative Fibonacci?

// O(n).

// Q6. What is the time complexity of recursive Fibonacci?

// O(2ⁿ) as an upper bound for the basic recursive implementation.

// Q7. What is the space complexity of iterative Fibonacci?

// O(1).

// Q8. What is the space complexity of recursive Fibonacci?

// O(n), because of the recursive call stack.

// Q9. Why is recursion slower in Fibonacci?

// Because it calculates the same Fibonacci values repeatedly.

// Q10. What is the purpose of a counter?

// A counter measures the number of loop iterations or recursive function calls.

// Q11. Which approach is better and why?

// The iterative approach is better because it has O(n) time complexity and O(1) space complexity.

// Q12. Can Fibonacci be calculated using dynamic programming?

// Yes. Dynamic programming stores previously calculated values and avoids repeated calculations.

// 9. Final Comparison to Remember for Your Practical
// Non-Recursive
// Time
// O(n)

// Space
// O(1)

// Counter for n = 7

// 7


// Recursive
// Time
// O(2ⁿ) upper bound

// Space
// O(n)

// Counter for n = 7

// 59


// One important practical note: Both Java programs use int, which has a limited range. For larger Fibonacci numbers, use long or Python's built-in integers (which support arbitrarily large integers).

// Remember this for your viva: Iterative Fibonacci uses a loop, whereas recursive Fibonacci uses function calls. Both produce the same series, but iterative Fibonacci is more efficient in the basic implementations.