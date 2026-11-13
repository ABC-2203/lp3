//2. Write a program to solve a fractional Knapsack problem using a greedy method.

// COLLEGE CODE 


// import java.util.Arrays;
// import java.util.Comparator;

// class Item {
//     int value, weight;

//     Item(int value, int weight) {
//         this.value = value;
//         this.weight = weight;
//     }
// }

// public class FractionalKnapsack {

//     static double getMaxValue(Item[] items, int capacity) {

//         // Sort items by value-to-weight ratio in descending order
//         Arrays.sort(items, new Comparator<Item>() {
//             @Override
//             public int compare(Item o1, Item o2) {
//                 double r1 = (double) o1.value / o1.weight;
//                 double r2 = (double) o2.value / o2.weight;

//                 return Double.compare(r2, r1);
//             }
//         });

//         double totalValue = 0.0;

//         for (Item item : items) {

//             if (capacity >= item.weight) {
//                 // Take the whole item
//                 capacity -= item.weight;
//                 totalValue += item.value;
//             } 
//             else {
//                 // Take the fractional part of the item
//                 totalValue += item.value * ((double) capacity / item.weight);
//                 break;
//             }
//         }

//         return totalValue;
//     }

//     public static void main(String[] args) {

//         Item[] items = {
//             new Item(60, 10),
//             new Item(100, 20),
//             new Item(120, 30)
//         };

//         int capacity = 50;

//         double maxValue = getMaxValue(items, capacity);

//         System.out.println("Maximum value we can obtain = " + maxValue);
//     }
// }







// // OPTIONAL IN A DIFFERENT WAY SIMPLE 

// import java.util.Arrays;
// import java.util.Comparator;

// public class FractionalKnapsack {
//     public static void main(String[] args) {
//         // Sample values and weights
//         int[] val = {60, 100, 120};
//         int[] weight = {10, 20, 30};
//         int W = 50; // Total capacity

//         double[][] ratio = new double[val.length][2];
//         for (int i = 0; i < val.length; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = val[i] / (double) weight[i];
//         }

//         // Ascending order sorting based on the value-to-weight ratio
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = W;
//         double finalVal = 0.0; // Declared as double to accurately handle fractional values
        
//         for (int i = ratio.length - 1; i >= 0; i--) {
//             int idx = (int) ratio[i][0];
//             if (capacity >= weight[idx]) { // Include full item
//                 finalVal += val[idx];
//                 capacity -= weight[idx];
//             } else {
//                 // Include fractional item
//                 finalVal += (ratio[i][1] * capacity);
//                 capacity = 0;
//                 break;
//             }
//         }

//         System.out.println("final value = " + finalVal);
//     }
// }











// // USER INPUT CODE
// import java.util.Scanner;
// import java.util.Arrays;
// import java.util.Comparator;

// public class FractionalKnapsackUserInput {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Take user input for number of items
//         System.out.print("Enter the number of items: ");
//         int n = scanner.nextInt();

//         int[] val = new int[n];
//         int[] weight = new int[n];

//         System.out.println("Enter the values of the items:");
//         for (int i = 0; i < n; i++) {
//             val[i] = scanner.nextInt();
//         }

//         System.out.println("Enter the weights of the items:");
//         for (int i = 0; i < n; i++) {
//             weight[i] = scanner.nextInt();
//         }

//         System.out.print("Enter the capacity of the knapsack (W): ");
//         int W = scanner.nextInt();

//         scanner.close();

//         // Exact original logic and variables
//         double[][] ratio = new double[val.length][2];
//         for (int i = 0; i < val.length; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = val[i] / (double) weight[i];
//         }

//         // Ascending order sorting based on the value-to-weight ratio
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = W;
//         double finalVal = 0.0; // Declared as double to handle fractional values smoothly
        
//         for (int i = ratio.length - 1; i >= 0; i--) {
//             int idx = (int) ratio[i][0];
//             if (capacity >= weight[idx]) { // Include full item
//                 finalVal += val[idx];
//                 capacity -= weight[idx];
//             } else {
//                 // Include fractional item
//                 finalVal += (ratio[i][1] * capacity);
//                 capacity = 0;
//                 break;
//             }
//         }

//         System.out.println("final value = " + finalVal);
//     }
// }









//EXPLANATION
// 1. What is Fractional Knapsack?The Fractional Knapsack Problem is a classic optimization problem in computer science.
// Imagine you are a thief breaking into a store with a knapsack (bag) that can hold a maximum weight limit, denoted as W.There are multiple items available, 
// where each item has a specific weight and a value.The catch: Unlike the 0/1 Knapsack problem (where you must take an entire item or leave it completely), the Fractional Knapsack allows you to break items into smaller pieces. 
// You can take a fraction (part) of an item to maximize the total value inside your knapsack without exceeding weight W.




// 2. What is the Greedy Method?
// The Greedy Method (or Greedy Algorithm) is an algorithmic paradigm that makes the locally optimal choice at each stage with the hope of finding the global optimum.
// In simple terms, it always picks the "best available option right now" without worrying about future consequences.
// Why it works here: For the Fractional Knapsack problem, the greedy choice is to always pick the item that gives the highest value per unit of weight (i.e., the best value-to-weight ratio). 
// By taking as much of the most "valuable per pound" item as possible first, we guarantee the maximum possible total value.3. Concept Behind the ProblemTo solve this problem using a greedy approach, follow these conceptual steps:Calculate the Ratio: For every item, find its value-to-weight ratio (val / weight). 
// This tells you how much value you get per unit of weight.
// Sort the Items: Sort the items based on their ratios in descending order (highest ratio to lowest ratio). 
// Note: In your code, they are sorted in ascending order, which is why the code loops backward from the end of the array to pick the highest ratios first!   
// Greedy Selection:
// Start picking items starting from the highest ratio.
// If the entire item fits into the remaining knapsack capacity, take it all, add its full value, and reduce the remaining capacity.
// If the item is too heavy to fit entirely, take just enough of it (a fraction) to completely fill up the remaining capacity, add that fractional value, and stop.




// 4. Algorithm for Fractional KnapsackInput: 
// 1. Number of items $n$, arrays val[] and weight[], and total capacity W.

// 2. Create a 2D array or structure ratio of size n * 2 to store the original index of each item and its value-to-weight ratio.

// 3.For each item i, calculate:
//    ratio[i][0] = i (stores the item index)   
//    ratio[i][1] = val[i] / weight[i] (stores the ratio)   

// 4. Sort the ratio array in ascending order based on the ratios (ratio[i][1]).   

// 5. Initialize capacity = W and finalVal = 0.0.   

// 6. Loop through the sorted ratio array from the end (i = ratio.length - 1) down to 0:  
//    Retrieve the original item index: idx = (int) ratio[i][0].   
//    If capacity >= weight[idx] (the whole item fits):   
//        Add its value: finalVal += val[idx].   
//        Decrease capacity: capacity -= weight[idx].   
  
//   Else (only a fraction of the item fits):   
//       Add the fractional value: finalVal += (ratio[i][1] * capacity).   
//       Set capacity = 0 (bag is now full).   
//       break out of the loop.   

// 7. Print the final accumulated value (finalVal).





// 1. What data type is o?

// Because ratio is a 2D array (double[][]), its individual elements are 1D arrays (double[]). When Arrays.sort goes through the ratio array to sort it, it looks at each row one by one.

//   Therefore, o stands for one entire row of the ratio table.2. 


// What does o -> o[1] mean?

// This is a lambda expression (a shorthand way of writing a function). It translates to:

// "For each row o, extract the element at index 1 (o[1]), and use that specific value to compare and sort the rows."
//     o[0] would point to the first column (which holds the original item index).   
//     o[1] points to the second column (which holds the value-to-weight ratio).   

// 3. Why is it named o?

// o is just a temporary placeholder variable name (often short for "object" or "row"). You could actually rename it to anything you want, and the code would work identically. For example, these mean the exact same thing:
// Comparator.comparingDouble(row -> row[1])Comparator.comparingDouble(item -> item[1])Comparator.comparingDouble(x -> x[1])