import java.util.Random;

public class QuickSortAnalysis {

    // Deterministic QuickSort
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            deterministicQuickSort(arr, low, pivotIndex - 1);
            deterministicQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Randomized QuickSort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition function for deterministic QuickSort
    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    // Partition function for randomized QuickSort
    private static int randomizedPartition(int[] arr, int low, int high) {

        Random rand = new Random();

        int randomPivotIndex =
                low + rand.nextInt(high - low + 1);

        swap(arr, randomPivotIndex, high);

        return partition(arr, low, high);
    }

    // Utility function to swap elements
    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to print the array
    private static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        // Deterministic QuickSort
        int[] deterministicArr = arr.clone();

        long startTime = System.nanoTime();

        deterministicQuickSort(
            deterministicArr, 0, n - 1
        );

        long endTime = System.nanoTime();

        System.out.println(
            "Sorted Array using Deterministic QuickSort:"
        );

        printArray(deterministicArr);

        System.out.println(
            "Time taken by Deterministic QuickSort: "
            + (endTime - startTime) + " ns"
        );

        // Randomized QuickSort
        int[] randomizedArr = arr.clone();

        startTime = System.nanoTime();

        randomizedQuickSort(
            randomizedArr, 0, n - 1
        );

        endTime = System.nanoTime();

        System.out.println(
            "Sorted Array using Randomized QuickSort:"
        );

        printArray(randomizedArr);

        System.out.println(
            "Time taken by Randomized QuickSort: "
            + (endTime - startTime) + " ns"
        );
    }
}










//1. What is Quick Sort?
// Quick Sort is a sorting algorithm based on the Divide and Conquer technique.

// It sorts an array by selecting one element as a pivot and dividing the array into two parts:
// 1. Elements smaller than or equal to the pivot.
// 2. Elements greater than the pivot.
// Then it recursively sorts both parts.
// Example
// Suppose we have:

// 10, 7, 8, 9, 1, 5

// Choose 5 as the pivot.
// Step 1: Select pivot
// 10
// 7
// 8
// 9
// 1
// 5
// Pivot

// Step 2: Partition
// 1
// Smaller
// 5
// Pivot
// 10, 7, 8, 9
// Larger

// Step 3: Recursively sort both sides
// 1, 5, 7, 8, 9, 10
// Final sorted array
// 2. What are the two variants?
// A. Deterministic Quick Sort
// - It selects the pivot using a fixed rule.
// - In your program, the last element is always selected as the pivot.
// - Example: If the array is {10, 7, 8, 9, 1, 5}, the pivot is 5.
// B. Randomized Quick Sort
// - It selects the pivot randomly from the array.
// - The pivot can be the first, middle, last, or any other element.
// - It reduces the possibility of repeatedly getting an extremely unbalanced partition for certain input arrangements.
// Main difference: Deterministic Quick Sort uses a fixed pivot-selection rule, whereas Randomized Quick Sort uses a randomly selected pivot.

// 3. Understanding the Java code line by line
// Part 1: Import Random class
// import java.util.Random;


// - import is a Java keyword used to include a class from a package.
// - java.util is a built-in Java package.
// - Random is a class used to generate random numbers.
// Why do we need it?

// Randomized Quick Sort needs a random index to select its pivot.
// Part 2: Class declaration
// public class QuickSortAnalysis {


// - public means the class can be accessed from other classes.
// - class is used to define a class.
// - QuickSortAnalysis is the name of our class.
// Part 3: Deterministic Quick Sort
// public static void deterministicQuickSort(
//     int[] arr, int low, int high) {

//     if (low < high) {

//         int pivotIndex = partition(arr, low, high);

//         deterministicQuickSort(arr, low, pivotIndex - 1);

//         deterministicQuickSort(arr, pivotIndex + 1, high);
//     }
// }


// Let's understand each line.
// Code	Explanation
// public	Accessible from other classes.
// static	Can be called without creating an object.
// void	Does not return a value.
// int[] arr	Array that needs sorting.
// int low	Starting index of the array section.
// int high	Ending index of the array section.

// What does if (low < high) mean?

// It checks whether the array section contains at least two elements.

// If there is only one element, it is already sorted.

// What does this line do?
// int pivotIndex = partition(arr, low, high);


// - Calls the partition function.
// - Places the pivot in its correct sorted position.
// - Returns the index of the pivot.
// - Stores that index in pivotIndex.
// Recursive calls:
// deterministicQuickSort(arr, low, pivotIndex - 1);


// Sorts the left side of the pivot.
// deterministicQuickSort(arr, pivotIndex + 1, high);


// Sorts the right side of the pivot.

// Remember: The pivot is excluded from both recursive calls because it is already in its correct position.
// Part 4: Partition function (Deterministic Quick Sort)
// private static int partition(int[] arr, int low, int high) {

//     int pivot = arr[high];
//     int i = low - 1;

//     for (int j = low; j < high; j++) {

//         if (arr[j] <= pivot) {
//             i++;
//             swap(arr, i, j);
//         }
//     }

//     swap(arr, i + 1, high);

//     return i + 1;
// }


// This is the most important part of Quick Sort.

// What is partitioning?

// Partitioning means arranging the elements so that:
// - All elements smaller than or equal to the pivot come before it.
// - All elements greater than the pivot come after it.
// - The pivot reaches its correct sorted position.
// Your code uses the Lomuto Partition Scheme.

// Let's understand it line by line.

// 1. Select the pivot
// int pivot = arr[high];


// - Selects the last element of the current array section as the pivot.
// - high represents the last index.
// For example:

// arr = {10, 7, 8, 9, 1, 5}

// Here:
// - high = 5
// - arr[high] = 5
// - Therefore, pivot = 5.
// 2. Initialize variable i
// int i = low - 1;


// - i keeps track of the position of the smaller elements.
// - Initially, it is set to one position before low.
// For our example:

// i = -1

// 3. For loop
// for (int j = low; j < high; j++)


// - j starts from the first index.
// - It checks every element until the element before the pivot.
// - It does not check the pivot itself.
// 4. If condition
// if (arr[j] <= pivot)


// Checks whether the current element is smaller than or equal to the pivot.

// If the condition is true, the element should be placed on the left side.

// 5. Increment i
// i++;


// Increases the boundary of the smaller-elements section.

// 6. Swap elements
// swap(arr, i, j);


// Places the smaller element in its correct partition section.

// 7. Place pivot in the correct position
// swap(arr, i + 1, high);


// After the loop finishes, the pivot is swapped with the element immediately after the smaller-elements section.

// 8. Return pivot index
// return i + 1;


// Returns the final position of the pivot.
// Dry run of partition function
// Consider:

// 10, 7, 8, 9, 1, 5

// Pivot = 5

// Initially, i = -1.

// | j | arr[j] | Condition arr[j]
// 1
// Left side
// 5
// Pivot
// 7, 8, 9, 10
// Right side
// The partition function returns 1, which is the pivot index.
// Part 5: Randomized Quick Sort
// public static void randomizedQuickSort(
//     int[] arr, int low, int high) {

//     if (low < high) {

//         int pivotIndex = randomizedPartition(arr, low, high);

//         randomizedQuickSort(arr, low, pivotIndex - 1);

//         randomizedQuickSort(arr, pivotIndex + 1, high);
//     }
// }


// This function is almost identical to deterministic Quick Sort.

// The only difference is:
// int pivotIndex = randomizedPartition(arr, low, high);


// Instead of calling the normal partition function, it calls the randomized partition function.

// This means the pivot is selected randomly.
// Part 6: Randomized partition function
// private static int randomizedPartition(
//     int[] arr, int low, int high) {

//     Random rand = new Random();

//     int randomPivotIndex =
//         low + rand.nextInt(high - low + 1);

//     swap(arr, randomPivotIndex, high);

//     return partition(arr, low, high);
// }


// Let's understand this carefully.

// 1. Create Random object
// Random rand = new Random();


// Creates an object of the Random class to generate random numbers.

// 2. Generate random pivot index
// int randomPivotIndex =
//     low + rand.nextInt(high - low + 1);


// This is the most important line in Randomized Quick Sort.

// rand.nextInt(n) generates a random integer from 0 to n-1.

// For example:
// - low = 0
// - high = 5
// - high - low + 1 = 6
// Therefore:
// rand.nextInt(6);


// Can generate any number from 0 to 5.

// Adding low ensures that the random index belongs to the current array section.

// 3. Swap random pivot with last element
// swap(arr, randomPivotIndex, high);


// Why do we do this?

// Because our existing partition function always selects the last element as the pivot.

// So, we first move the randomly selected pivot to the last position.

// 4. Call partition function
// return partition(arr, low, high);


// Now the normal partition function works on the randomly selected pivot.

// This avoids writing the partitioning logic twice.
// Part 7: Swap function
// private static void swap(int[] arr, int i, int j) {

//     int temp = arr[i];

//     arr[i] = arr[j];

//     arr[j] = temp;
// }


// This function exchanges two elements in an array.

// Example:

// arr = {10, 20, 30}

// Suppose we want to swap 10 and 30.
// Statement	Explanation
// int temp = arr[i]	Stores the first element temporarily.
// arr[i] = arr[j]	Copies the second element into the first position.
// arr[j] = temp	Copies the original first element into the second position.

// Result:

// {30, 20, 10}

// Why do we need temp?

// Without a temporary variable, the original value of one element would be lost during swapping.
// Part 8: Print array function
// private static void printArray(int[] arr) {

//     for (int num : arr) {
//         System.out.print(num + " ");
//     }

//     System.out.println();
// }


// - private: Accessible only within the class.
// - static: Can be called without creating an object.
// - void: Does not return anything.
// - int[] arr: Accepts an integer array.
// Enhanced for loop:
// for (int num : arr)


// It visits each element of the array one by one.
// System.out.print(num + " ");


// Prints each element with a space.
// System.out.println();


// Moves the cursor to the next line.
// Part 9: Main method
// public static void main(String[] args) {


// The main method is the starting point of Java program execution.

// 1. Create original array
// int[] arr = {10, 7, 8, 9, 1, 5};

// int n = arr.length;


// - Creates an integer array.
// - arr.length gives the total number of elements.
// - Here, n = 6.
// 2. Print original array
// System.out.println("Original Array:");
// printArray(arr);


// Displays the original array.

// 3. Create a copy for deterministic Quick Sort
// int[] deterministicArr = arr.clone();


// clone() creates a separate copy of the original array.

// Why?

// Because sorting changes the original array. We need two identical input arrays to compare the two algorithms fairly.

// 4. Start measuring time
// long startTime = System.nanoTime();


// - long stores a large integer value.
// - System.nanoTime() returns the current value of the JVM's high-resolution time source.
// - We store the starting time.
// 5. Execute deterministic Quick Sort
// deterministicQuickSort(
//     deterministicArr, 0, n - 1
// );


// Arguments:
// - deterministicArr: Array to sort.
// - 0: Starting index.
// - n - 1: Last index (5).
// 6. End measuring time
// long endTime = System.nanoTime();


// Stores the ending time after sorting.

// 7. Calculate execution time
// endTime - startTime


// Subtracts starting time from ending time.

// The result is the execution time in nanoseconds (ns).

// 8. Randomized Quick Sort
// int[] randomizedArr = arr.clone();


// Creates another copy of the original array.
// startTime = System.nanoTime();

// randomizedQuickSort(randomizedArr, 0, n - 1);

// endTime = System.nanoTime();


// Measures the execution time of Randomized Quick Sort.

// Finally, the program prints both sorted arrays and their execution times.

// 4. Complete program execution flow
// Understand this flowchart for your practical examination.
// Start

// Create original array
// Create two copies of the array
// Deterministic

// Select last element as pivot

// Partition array

// Recursive sorting

// Measure time


// Randomized

// Select random pivot

// Partition array

// Recursive sorting

// Measure time



// Compare execution times
// End


// 5. Time complexity of Quick Sort
// Time complexity describes how the execution time of an algorithm increases as the input size increases.

// Quick Sort has three main cases.
// Case	Time Complexity	Explanation
// Best Case	\(O(n\log n)\)	Pivot divides array into two nearly equal parts.
// Average Case	\(O(n\log n)\)	Partitions are reasonably balanced on average.
// Worst Case	\(O(n^2)\)	Pivot repeatedly becomes the smallest or largest element.

// A. Best case – O(n log n)
// When the pivot divides the array into two equal halves.

// Example:
//              8
//            /   \
//           4     12
//          / \    / \
//         2   6  10  14


// - Each level processes approximately n elements.
// - The number of levels is approximately log n.
// Therefore:
// \[
// T(n)=O(n\log n)
// \]

// B. Average case – O(n log n)
// When the pivot divides the array into reasonably balanced partitions on average.

// Quick Sort performs efficiently for most input arrangements.
// \[
// T(n)=O(n\log n)
// \]

// C. Worst case – O(n²)
// When the pivot is always the smallest or largest element.

// For example, a sorted array:
// 1  2  3  4  5


// If we always select the last element as pivot:
// - First pivot = 5
// - Second pivot = 4
// - Third pivot = 3
// The partitions become highly unbalanced.
// \[
// T(n)=n+(n-1)+(n-2)+...+1
// \]

// \[
// T(n)=\frac{n(n+1)}{2}
// \]

// Therefore:
// \[
// T(n)=O(n^2)
// \]

// 6. Space complexity
// Space complexity refers to the extra memory required by an algorithm.

// Quick Sort is an in-place sorting algorithm because it rearranges elements in the original array rather than creating additional arrays for its partitions.

// However, it uses recursion, which requires a call stack.
// Case	Space Complexity
// Best Case	O(log n)
// Average Case	O(log n)
// Worst Case	O(n)

// Why?
// - Best case: Recursion depth is approximately log n.
// - Average case: Recursion depth is approximately log n.
// - Worst case: Recursion depth can become n.
// Note: The partition and swap operations themselves use O(1) auxiliary space. The additional space above is for the recursion stack.
// 7. Difference between Deterministic and Randomized Quick Sort
// This is a very important viva question.
// Deterministic Quick Sort	Randomized Quick Sort
// Selects pivot using a fixed rule.	Selects pivot randomly.
// In your code, the last element is the pivot.	Any element can become the pivot.
// Pivot selection is predictable.	Pivot selection is unpredictable.
// Can perform poorly on certain input arrangements.	Reduces the risk of consistently unbalanced partitions.
// Best case: O(n log n).	Best case: O(n log n).
// Average case: O(n log n).	Expected case: O(n log n).
// Worst case: O(n²).	Worst case: O(n²).
// Does not require random number generation.	Requires random number generation.

// Important viva point: Randomized Quick Sort does not guarantee O(n log n) in every execution. Its expected time complexity is O(n log n), while its worst-case complexity is still O(n²).
// 8. Expected output
// Your program will produce output similar to this:
// Original Array:
// 10 7 8 9 1 5

// Sorted Array using Deterministic QuickSort:
// 1 5 7 8 9 10

// Time taken by Deterministic QuickSort: 15000 ns

// Sorted Array using Randomized QuickSort:
// 1 5 7 8 9 10

// Time taken by Randomized QuickSort: 25000 ns


// Note: Execution times above are illustrative. Actual timings will vary depending on your computer, JVM, input size and random pivot selection.

// Why can Randomized Quick Sort sometimes take more time?

// Because generating random numbers also takes time. For a small array, this overhead can make Randomized Quick Sort slower than Deterministic Quick Sort.

// For meaningful performance analysis, test both algorithms on large arrays, use identical input data, repeat the experiment several times, and compare average execution times. Also, your current implementation creates a new Random object at every partition; creating one reusable Random object is more efficient.

// 9. Important concepts for viva examination
// Concept	Meaning
// Pivot	Element selected to divide the array.
// Partition	Process of placing smaller elements before the pivot and larger elements after it.
// Recursion	A function calling itself.
// Divide and Conquer	Dividing a problem into smaller subproblems and solving them.
// In-place sorting	Sorting without creating another full-sized array.
// clone()	Creates a copy of an array.
// System.nanoTime()	Measures elapsed execution time with nanosecond precision.
// Random	Java class used to generate random numbers.
// swap()	Exchanges two array elements.
// pivotIndex	Final position of the pivot after partitioning.
// low	Starting index of the current subarray.
// high	Ending index of the current subarray.

// 10. SPPU practical viva questions with answers
// Q1. What is Quick Sort?

// Quick Sort is a divide-and-conquer sorting algorithm that selects a pivot and partitions the array into smaller and larger elements.

// Q2. Which technique is used in Quick Sort?

// Divide and Conquer.

// Q3. What is a pivot?

// A pivot is an element used to divide an array into two partitions.

// Q4. What is the difference between deterministic and randomized Quick Sort?

// Deterministic Quick Sort selects a pivot using a fixed rule, whereas randomized Quick Sort selects a pivot randomly.

// Q5. Which partition scheme is used in this program?

// Lomuto Partition Scheme.

// Q6. What is the best-case time complexity?

// O(n log n).

// Q7. What is the average-case time complexity of deterministic Quick Sort?

// O(n log n).

// Q8. What is the expected time complexity of randomized Quick Sort?

// O(n log n).

// Q9. What is the worst-case time complexity?

// O(n²) for both variants.

// Q10. Why is randomized Quick Sort preferred sometimes?

// It reduces the chances of consistently selecting a poor pivot for particular input arrangements.

// Q11. What is the purpose of rand.nextInt()?

// It generates a random integer within the specified range.

// Q12. Why do we use arr.clone()?

// To create two identical arrays so both algorithms can be tested using the same input.

// Q13. Why do we use recursion?

// To sort the left and right partitions independently.

// Q14. Is Quick Sort stable?

// No. Standard Quick Sort is not stable because equal elements may change their relative order.

// Q15. Is Quick Sort an in-place sorting algorithm?

// Yes. It sorts by rearranging elements in the same array, although recursion requires additional stack memory.

// Q16. Which is faster: deterministic or randomized Quick Sort?

// It depends on the input data and pivot selection. Neither is always faster.

// Q17. What does System.nanoTime() do?

// It measures elapsed time in nanoseconds.

// Q18. What happens if low == high?

// The subarray contains only one element, so it is already sorted. Recursion stops.