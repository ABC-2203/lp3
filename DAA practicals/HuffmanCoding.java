
import java.util.Comparator;
import java.util.PriorityQueue;

// Node class for creating the Huffman Tree
class Node {

    char ch;          // Stores the character
    int freq;         // Stores the frequency of the character

    Node left, right; // Stores left and right child nodes

    // Constructor to initialize a node
    Node(char ch, int freq) {

        this.ch = ch;
        this.freq = freq;

        // Initially, a new node has no children
        this.left = null;
        this.right = null;
    }
}

// Comparator class to compare nodes based on frequency
class NodeComparator implements Comparator<Node> {

    public int compare(Node a, Node b) {

        // Smaller frequency gets higher priority
        // This makes the PriorityQueue work as a Min Priority Queue
        return Integer.compare(a.freq, b.freq);
    }
}

public class HuffmanCoding {

    // Method to generate Huffman Codes using recursion
    public static void generateCodes(
            Node root,
            String code,
            StringBuilder result) {

        // Base condition: If node is null, stop recursion
        if (root == null)
            return;

        // Check whether the current node is a leaf node
        // A leaf node has no left and right children
        if (root.left == null && root.right == null) {

            // Store the character and its binary code
            result.append(root.ch)
                  .append(": ")
                  .append(code)
                  .append("\n");

            return;
        }

        // Move to the left child and append 0
        generateCodes(root.left, code + "0", result);

        // Move to the right child and append 1
        generateCodes(root.right, code + "1", result);
    }

    // Method to build Huffman Tree and generate codes
    public static void huffmanEncode(char[] chars, int[] freqs) {

        // Create a Min Priority Queue
        // Nodes with smaller frequencies are removed first
        PriorityQueue<Node> pq =
                new PriorityQueue<>(new NodeComparator());

        // Create a node for each character and insert it into the queue
        for (int i = 0; i < chars.length; i++) {

            // Create a new node using character and frequency
            Node newNode = new Node(chars[i], freqs[i]);

            // Add the node to the Priority Queue
            pq.add(newNode);
        }

        // Build the Huffman Tree
        // Continue until only one node (root) remains
        while (pq.size() > 1) {

            // Remove the node with the smallest frequency
            Node left = pq.poll();

            // Remove the second smallest frequency node
            Node right = pq.poll();

            // Create a new internal parent node
            // Its frequency is the sum of both child frequencies
            // '-' represents an internal node, not an actual character
            Node newNode =
                    new Node('-', left.freq + right.freq);

            // Connect the two removed nodes as children
            newNode.left = left;
            newNode.right = right;

            // Insert the new parent node back into the queue
            pq.add(newNode);
        }

        // The last remaining node becomes the root of the Huffman Tree
        Node root = pq.poll();

        // StringBuilder stores all generated Huffman Codes
        StringBuilder result = new StringBuilder();

        // Generate codes starting from the root
        // Initially, the code is an empty string
        generateCodes(root, "", result);

        // Print all Huffman Codes
        System.out.println(result.toString());
    }

    // Main method: Execution starts here
    public static void main(String[] args) {

        // Array containing characters
        char[] chars = {
            'a', 'b', 'c', 'd', 'e', 'f'
        };

        // Array containing corresponding frequencies
        int[] freqs = {
            5, 9, 12, 13, 16, 45
        };

        // Display heading
        System.out.println("Huffman Codes:");

        // Call the Huffman Encoding method
        huffmanEncode(chars, freqs);
    }
}










// Huffman Encoding is a lossless data compression technique that assigns shorter binary codes to frequently occurring characters and longer binary codes to less frequently occurring characters.

// 1. What is Huffman Encoding?
// Huffman Encoding is a data compression algorithm that reduces the number of bits required to store data.

// It works using a Greedy Approach.

// In simple words:
// - Characters that occur frequently get shorter codes.
// - Characters that occur less frequently get longer codes.
// - Each character gets a unique binary code.
// - The original data can be recovered without losing information.
// Example
// Suppose we have the following characters and their frequencies:
// Character	Frequency
// a	5
// b	9
// c	12
// d	13
// e	16
// f	45

// Here, f occurs 45 times, so it should receive a shorter binary code.

// On the other hand, a occurs only 5 times, so it can receive a longer binary code.






// 2. Why do we use Huffman Encoding?
// Suppose we store each character using standard ASCII encoding.

// ASCII generally uses 8 bits per character.

// For the word:

// AAAAABBBCC

// There are 10 characters.

// Using 8-bit ASCII:
// \[
// 10 \times 8 = 80 \text{ bits}
// \]

// Using Huffman encoding, we can assign shorter codes to frequently occurring characters and reduce the total number of bits.

// Main advantage: It saves storage space and reduces the amount of data that needs to be transmitted.
// 3. Applications of Huffman Encoding
// Huffman Encoding is used in:
// 1. ZIP compression: Used as part of DEFLATE compression.
// 2. JPEG: Huffman coding is used in JPEG entropy coding.
// 3. File compression: Helps reduce file sizes.
// 4. Data transmission: Reduces the amount of data transmitted.
// 5. Multimedia compression: Used in certain image, audio and video compression formats.
// 4. What is a Greedy Strategy?
// A Greedy Algorithm is an algorithm that makes the best possible choice at each step, hoping to reach an optimal overall solution.

// In Huffman Encoding, the greedy choice is:

// Always select the two nodes having the lowest frequencies.

// For example:

// Frequencies:

// 5, 9, 12, 13, 16, 45

// First, select 5 and 9.

// Add them:
// \[
// 5+9=14
// \]

// Insert 14 back into the priority queue.

// Now repeat the same process until only one node remains.

// That is the greedy strategy used in Huffman Encoding.

// 5. What is a Priority Queue?
// A Priority Queue is a special type of data structure in which every element has a priority.

// The element with the highest priority is removed first.

// Unlike a normal queue, which follows FIFO (First In First Out), a priority queue removes elements according to their priority.

// In our Huffman program, the priority is based on frequency.

// The node with the smallest frequency gets the highest priority.
// Example
// Suppose we insert these numbers into a minimum priority queue:

// 40, 10, 30, 5, 20

// When we remove elements, they come out in this order:

// 5 → 10 → 20 → 30 → 40






// 6. Types of Priority Queue
// There are two basic types based on removal priority:
// 1. Min Priority Queue
// Smallest element first
// - The smallest element has the highest priority.
// - Elements are removed in ascending order.
// - Example: 5, 10, 20, 30.

// 2. Max Priority Queue
// Largest element first
// - The largest element has the highest priority.
// - Elements are removed in descending order.
// - Example: 40, 30, 20, 10.

// Other priority queue implementations / variants
// Data structure	Description
// Binary Heap	Complete binary tree, commonly used to implement priority queues.
// Min Heap	Parent is smaller than or equal to its children.
// Max Heap	Parent is greater than or equal to its children.
// Binomial Heap	Collection of binomial trees; supports efficient merging.
// Fibonacci Heap	Supports efficient amortized decrease-key operations.
// Pairing Heap	Heap-based structure with relatively simple implementation.

// Important for viva: Min Heap and Max Heap are heap types. Binary, Binomial, Fibonacci and Pairing Heaps are different heap structures that can implement priority queues.
// Priority Queue vs Normal Queue
// Normal Queue	Priority Queue
// Follows FIFO	Follows priority
// First inserted is removed first	Highest-priority element is removed first
// No priority required	Every element has a priority
// Example: Ticket line	Example: CPU scheduling


// 7. Understanding the Huffman Tree
// Before understanding the Java code, let's understand how the tree is created.

// A Huffman Tree is a binary tree in which:
// - Leaf nodes represent characters.
// - Internal nodes represent the sum of frequencies of their children.
// - Left edges represent 0.
// - Right edges represent 1.
// Step-by-step construction
// Given:
// Character	a	b	c	d	e	f
// Frequency	5	9	12	13	16	45

// Follow these steps:
// Step	Selected frequencies	New frequency
// 1	5 + 9	14
// 2	12 + 13	25
// 3	14 + 16	30
// 4	25 + 30	55
// 5	45 + 55	100

// Let's understand each step.

// Step 1: Select the two smallest frequencies: 5 and 9. Add them to create a new node with frequency 14.

// Step 2: The remaining frequencies are 12, 13, 14, 16, 45. Select 12 and 13. Create a new node with frequency 25.

// Step 3: Select 14 and 16. Create a new node with frequency 30.

// Step 4: Select 25 and 30. Create a new node with frequency 55.

// Step 5: Select 45 and 55. Create a new node with frequency 100.

// Now only one node remains. This becomes the root of the Huffman Tree.





// Final Huffman Codes
// Following the left and right paths from the root:
// Character	Frequency	Huffman Code
// f	45	0
// c	12	100
// d	13	101
// e	16	111
// a	5	1100
// b	9	1101

// Notice:
// - f has the highest frequency and gets the shortest code.
// - a and b have lower frequencies and get longer codes.
// Remember: The exact codes can differ if equal-frequency nodes are arranged differently. The total optimal compression cost remains the same.

// 8. Understanding Your Java Code
// Now let's understand your actual code, line by line.

// Your program has four main parts:
// 1. Node class
// 2. NodeComparator class
// 3. generateCodes() method
// 4. huffmanEncode() method
// Part 1: Importing packages
// import java.util.Comparator;
// import java.util.PriorityQueue;


// What is import?

// Import allows us to use predefined Java classes.
// - Comparator: Used to compare two nodes based on their frequencies.
// - PriorityQueue: Used to store nodes according to their priority.
// Why do we need these?

// Because Huffman Encoding always needs to select the two nodes having the smallest frequencies.
// Part 2: Node class
// class Node {
//     char ch;
//     int freq;
//     Node left, right;

//     Node(char ch, int freq) {
//         this.ch = ch;
//         this.freq = freq;
//         this.left = null;
//         this.right = null;
//     }
// }


// What is a Node?

// A node is an individual element of a tree.

// Every node contains four things:
// Variable	Meaning
// ch	Stores the character
// freq	Stores its frequency
// left	Stores reference to left child
// right	Stores reference to right child

// Why do we use a constructor?
// Node(char ch, int freq)


// A constructor initializes the node when we create an object.

// For example:
// Node n = new Node('a', 5);


// This creates a node containing:
// - Character = a
// - Frequency = 5
// - Left = null
// - Right = null
// Initially, every character is a separate leaf node.

// Later, we combine these nodes to construct the Huffman Tree.
// Part 3: NodeComparator class
// class NodeComparator implements Comparator<Node> {

//     public int compare(Node a, Node b) {
//         return a.freq - b.freq;
//     }
// }


// This is one of the most important parts of your program.

// Why do we need Comparator?

// Comparator tells the PriorityQueue how to arrange the nodes.

// Here:
// return a.freq - b.freq;


// It compares the frequencies of two nodes.

// For example:
// - Node A has frequency 5.
// - Node B has frequency 9.
// Then:
// 5 - 9 = -4


// A negative result means Node A should come before Node B.

// Therefore, the smallest frequency gets the highest priority.

// This makes our PriorityQueue behave like a Min Priority Queue.

// A safer modern Java implementation is:
// public int compare(Node a, Node b) {
//     return Integer.compare(a.freq, b.freq);
// }


// It avoids possible integer overflow.
// Part 4: generateCodes() method
// public static void generateCodes(
//         Node root,
//         String code,
//         StringBuilder result) {


// This method generates the binary code for every character.

// It takes three parameters:
// Parameter	Purpose
// root	Current node of the Huffman Tree
// code	Binary code generated so far
// result	Stores all final Huffman codes

// Condition 1: Check whether the node is null
// if (root == null)
//     return;


// If there is no node, stop the function.

// This prevents unnecessary traversal.
// Condition 2: Check whether the node is a leaf node
// if (root.left == null && root.right == null) {
//     result.append(root.ch)
//           .append(": ")
//           .append(code)
//           .append("\n");
//     return;
// }


// What is a leaf node?

// A leaf node is a node that has no children.

// In our Huffman Tree, leaf nodes contain the original characters.

// For example:
//     a


// If both left and right are null, it means we have reached a character.

// Then we store:
// a: 1100


// The StringBuilder stores the character and its corresponding binary code.
// Condition 3: Recursive calls
// generateCodes(root.left, code + "0", result);

// generateCodes(root.right, code + "1", result);


// This is where the actual code generation happens.
// - When we move left, we add 0.
// - When we move right, we add 1.
// For example:
// Root
//   |
//   1
//   |
//   Right
//   |
//   0
//   |
//   Left


// The resulting code is 10.

// This method uses recursion and tree traversal to generate the codes.

// It follows a Depth First Search (DFS) approach.

// Part 5: huffmanEncode() method
// This method builds the Huffman Tree and generates the codes.
// public static void huffmanEncode(char[] chars, int[] freqs) {


// It accepts two arrays:
// char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};

// int[] freqs = {5, 9, 12, 13, 16, 45};


// Both arrays are related through their indexes.

// For example:
// Index	chars[index]	freqs[index]
// 0	a	5
// 1	b	9
// 2	c	12
// 3	d	13
// 4	e	16
// 5	f	45

// Step 1: Create PriorityQueue
// PriorityQueue<Node> pq =
//         new PriorityQueue<>(new NodeComparator());


// Here, we create a PriorityQueue of type Node.

// We pass NodeComparator so that nodes are arranged according to their frequencies.

// The smallest frequency is given the highest priority.
// Step 2: Insert all nodes
// for (int i = 0; i < chars.length; i++) {
//     pq.add(new Node(chars[i], freqs[i]));
// }


// This loop creates a node for every character and adds it to the PriorityQueue.

// For example:
// a → 5
// b → 9
// c → 12
// d → 13
// e → 16
// f → 45


// Now all six nodes are inside the PriorityQueue.
// Step 3: Build the Huffman Tree
// while (pq.size() > 1) {

//     Node left = pq.poll();
//     Node right = pq.poll();

//     Node newNode =
//             new Node('-', left.freq + right.freq);

//     newNode.left = left;
//     newNode.right = right;

//     pq.add(newNode);
// }


// This is the main logic of Huffman Encoding.

// Let's understand each statement.

// A. while (pq.size() > 1)

// The loop continues as long as more than one node is present.

// Why?

// Because we need to combine nodes until only one root node remains.

// B. Remove two smallest nodes
// Node left = pq.poll();
// Node right = pq.poll();


// poll() removes and returns the highest-priority element.

// Since we have implemented a Min Priority Queue, it removes the two smallest frequencies.

// C. Create a new parent node
// Node newNode =
//         new Node('-', left.freq + right.freq);


// We add the frequencies of the two removed nodes.

// For example:
// 5 + 9 = 14


// The new parent node has frequency 14.

// We use '-' because this is an internal node, not an original character.

// D. Connect the children
// newNode.left = left;
// newNode.right = right;


// We connect the two removed nodes to the newly created parent.

// E. Insert the new node back
// pq.add(newNode);


// The new node is inserted into the PriorityQueue.

// The process repeats until only one node remains.
// Step 4: Get the root node
// Node root = pq.poll();


// After completing the loop, only one node remains.

// That node becomes the root of our Huffman Tree.
// Step 5: Generate and print codes
// StringBuilder result = new StringBuilder();

// generateCodes(root, "", result);

// System.out.println(result.toString());


// We create an empty StringBuilder.

// Then we call generateCodes().

// Initially, the binary code is an empty string because we are at the root.

// The recursive method traverses the tree and generates all character codes.

// Finally, we print the result.
// Part 6: Main method
// public static void main(String[] args) {

//     char[] chars = {
//         'a', 'b', 'c', 'd', 'e', 'f'
//     };

//     int[] freqs = {
//         5, 9, 12, 13, 16, 45
//     };

//     System.out.println("Huffman Codes:");

//     huffmanEncode(chars, freqs);
// }


// The main method is the starting point of Java execution.

// It defines the characters and their frequencies and calls the huffmanEncode() method.

// 9. Dry Run of the Java Program
// A dry run means executing the program manually, step by step, to understand what happens internally.

// Our input is:
// char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
// int[] freqs = {5, 9, 12, 13, 16, 45};


// Step-by-step execution
// Iteration	First removed	Second removed	New node
// 1	5 (a)	9 (b)	14
// 2	12 (c)	13 (d)	25
// 3	14	16 (e)	30
// 4	25	30	55
// 5	45 (f)	55	100

// At the end:
// Priority Queue Size = 1
// Root Frequency = 100


// The Huffman Tree is complete.
// Expected output
// Huffman Codes:
// f: 0
// c: 100
// d: 101
// a: 1100
// b: 1101
// e: 111


// Your output follows the left-to-right traversal of the tree.
// How much compression do we achieve?
// Let's calculate the total number of bits.
// Character	Frequency	Code length	Total bits
// a	5	4	20
// b	9	4	36
// c	12	3	36
// d	13	3	39
// e	16	3	48
// f	45	1	45
// Total	100		224

// Using 8-bit ASCII, 100 characters require 800 bits.

// Using Huffman Encoding, these frequencies require only 224 bits.

// This illustrates how Huffman Encoding reduces storage requirements.

// Note: This calculation considers the encoded data only, not the additional space required to store or transmit the Huffman tree or code table.

// 10. Algorithm of Huffman Encoding
// You can write this algorithm in your practical journal or explain it during your examination.

// Algorithm: Huffman Encoding Using Greedy Strategy

// Input: Array of characters and their corresponding frequencies.

// Output: Huffman binary codes for each character.
// 1. Start.
// 2. Read the characters and their frequencies.
// 3. Create a leaf node for each character.
// 4. Insert all leaf nodes into a Min Priority Queue.
// 5. Repeat while the Priority Queue contains more than one node:
//    - Remove the two nodes with the smallest frequencies.
//    - Create a new internal node.
//    - Set its frequency equal to the sum of the two removed nodes.
//    - Assign the first removed node as its left child.
//    - Assign the second removed node as its right child.
//    - Insert the new node back into the Priority Queue.
// 6. The remaining node becomes the root of the Huffman Tree.
// 7. Traverse the Huffman Tree recursively:
//    - Assign 0 when moving left.
//    - Assign 1 when moving right.
//    - When a leaf node is reached, print its character and corresponding code.
// 8. Stop.







// 11. Time and Space Complexity
// This is an important topic for DAA practical examinations.

// Let n be the number of unique characters.
// Operation	Time complexity
// Creating n nodes	O(n)
// Inserting nodes into Priority Queue	O(n log n)
// Removing two minimum nodes	O(log n) per removal
// Building Huffman Tree	O(n log n)
// Generating codes	O(n), excluding string-copying overhead

// Overall time complexity:
// \[
// \boxed{O(n\log n)}
// \]

// Space complexity:
// \[
// \boxed{O(n)}
// \]

// The tree and Priority Queue require O(n) space. The recursive traversal also requires stack space proportional to the tree height.

// 12. Important Concepts You Must Know for Viva
// Term	Simple meaning
// Greedy Algorithm	Selects the best choice at each step.
// Huffman Tree	Binary tree used to generate Huffman codes.
// Leaf Node	Node without children.
// Internal Node	Node having children.
// Root Node	Topmost node of a tree.
// Priority Queue	Data structure that removes elements according to priority.
// Min Heap	Heap where the parent is smaller than its children.
// Comparator	Defines how two objects are compared.
// Recursion	A method calling itself.
// DFS	Traversing a tree deeply before backtracking.
// Binary Code	Code consisting of 0s and 1s.
// Lossless Compression	Compression without losing original information.
// Prefix-free Code	No character's code is the prefix of another character's code.

// What is Prefix-free Coding?
// This is a very important examiner question.

// A prefix-free code means no code is the starting portion of another code.

// For example:
// a = 0
// b = 10
// c = 110
// d = 111


// Here, no code is a prefix of another code.

// Why is this important?

// Because it allows the receiver to decode the binary data without confusion.
// Does Huffman Encoding use recursion?
// Yes.

// Your program uses recursion in:
// generateCodes(root.left, code + "0", result);
// generateCodes(root.right, code + "1", result);


// It traverses the left and right subtrees until it reaches the leaf nodes.
// Does Huffman Encoding use a binary tree?
// Yes.

// It uses a binary tree because every internal node has two children: left and right.
// Is Huffman Encoding lossless or lossy?
// It is lossless compression because the original data can be reconstructed exactly.

// 13. Applications of Priority Queue in Different Domains
// Priority Queues are not limited to Huffman Encoding. They are used in many computer science applications.
// Domain	Application
// Operating Systems	CPU scheduling and process management
// Networking	Packet scheduling and routing
// Data Structures & Algorithms	Dijkstra's shortest path algorithm
// Data Compression	Huffman Encoding
// Artificial Intelligence	A* search algorithm
// Healthcare	Prioritizing emergency patients
// Event Simulation	Processing events according to their scheduled time
// Database Systems	Query scheduling and optimization

// Real-life example
// Imagine a hospital emergency room.

// Three patients arrive:
// Patient	Priority
// Patient A	3
// Patient B	1
// Patient C	2

// Suppose 1 represents the highest priority.

// The hospital treats patients in this order:

// B → C → A

// This is similar to how a Priority Queue works.

// 14. Important Viva Questions with Answers
// These are questions an examiner can ask based on your practical and Java implementation.
// A. Basic Huffman Encoding Questions
// 1. What is Huffman Encoding?

// Huffman Encoding is a lossless data compression technique that assigns variable-length binary codes to characters based on their frequencies.

// 2. Who developed Huffman Coding?

// David A. Huffman developed it in 1952.

// 3. Which algorithmic strategy does Huffman Encoding use?

// It uses the Greedy Algorithm.

// 4. Why is Huffman Encoding called a greedy algorithm?

// Because it repeatedly selects the two nodes having the smallest frequencies and combines them.

// 5. What is the main purpose of Huffman Encoding?

// To reduce the number of bits required to store data.

// 6. What is a Huffman Tree?

// It is a binary tree used to generate binary codes for characters based on their frequencies.

// 7. What is a leaf node?

// A node that does not have any children.

// 8. What is an internal node?

// A node that has children and stores the combined frequency of its child nodes.

// 9. Why do we assign 0 to the left child and 1 to the right child?

// It is a convention used to generate binary codes. We can also reverse the assignment, provided it is consistent.

// 10. Is Huffman Encoding lossless or lossy?

// It is lossless compression.
// B. Priority Queue Questions
// 11. What is a Priority Queue?

// A Priority Queue is a data structure in which elements are removed according to their priority.

// 12. Which Priority Queue is used in your program?

// Min Priority Queue.

// 13. Why do we use Min Priority Queue in Huffman Encoding?

// Because we need to repeatedly select the two nodes with the smallest frequencies.

// 14. What is the difference between a normal queue and a Priority Queue?

// A normal queue follows FIFO, whereas a Priority Queue follows priority.

// 15. What is a Heap?

// A Heap is a complete binary tree that satisfies the heap property.

// 16. What are the two types of Heap?
// - Min Heap
// - Max Heap
// 17. What is the time complexity of insertion in a binary heap?

// O(log n).

// 18. What is the time complexity of deleting the minimum element from a Min Heap?

// O(log n).

// 19. What is poll() in Java PriorityQueue?

// It removes and returns the element with the highest priority.

// 20. What is peek()?

// It returns the highest-priority element without removing it.

// 21. What is add()?

// It inserts an element into the Priority Queue.
// C. Java Code Questions
// 22. Why do we use Comparator in your program?

// To compare nodes based on their frequencies and arrange them in ascending order.

// 23. What is the purpose of the Node class?

// It represents each node of the Huffman Tree and stores the character, frequency and child references.

// 24. Why do we use '-' in the internal node?

// Because an internal node does not represent an original character. It only stores the combined frequency.

// 25. Why do we use StringBuilder?

// To efficiently build and store the generated Huffman codes.

// 26. Why is recursion used in your program?

// To traverse the Huffman Tree and generate binary codes for every leaf node.

// 27. What is the base condition in generateCodes()?
// if (root == null)
//     return;


// It stops recursion when there is no node.

// Another important condition is the leaf-node check.

// 28. What is the purpose of pq.size() > 1?

// It ensures that we continue combining nodes until only one root node remains.

// 29. What is the purpose of pq.poll()?

// It removes the node with the smallest frequency.

// 30. What happens when two characters have the same frequency?

// The Priority Queue can choose either ordering depending on its tie-breaking behavior. The resulting Huffman codes may differ, but can still be optimal.
// D. Advanced Questions
// 31. What is the time complexity of Huffman Encoding?

// O(n log n), where n is the number of unique characters.

// 32. What is the space complexity?

// O(n).

// 33. What is prefix-free coding?

// A coding system in which no code is the prefix of another code.

// 34. Can Huffman Encoding be used for text compression?

// Yes, it can compress text by assigning shorter codes to frequently occurring characters.

// 35. Can we decode Huffman codes?

// Yes. We traverse the Huffman Tree according to the received bits. When a leaf node is reached, we obtain the character and return to the root.

// 36. What happens if all characters have equal frequencies?

// Huffman Encoding still works. It generates a valid prefix-free code, although the compression advantage may be limited.

// 37. Why is frequency important in Huffman Encoding?

// Frequency determines how many times a character occurs and helps decide its code length.

// 38. Can Huffman Encoding work with only one character?

// Yes, but a special convention is required. Usually, we assign that character a code such as 0, because this implementation generates an empty string for a single-character input.

// 39. What is the difference between fixed-length and variable-length coding?

// Fixed-length coding uses the same number of bits for every character. Variable-length coding uses different numbers of bits depending on the character.

// 40. Does your program actually compress a text file?

// No. This particular implementation constructs the Huffman Tree and generates the code table. An additional encoding and decoding module is needed to compress and reconstruct an actual message.

// 15. How to Explain This Program to Your Examiner
// This is the most important part. You should be able to explain your code confidently without reading every line.






// Here is a simple presentation you can practise.
// Your practical explanation
// SPEAKING SCRIPT · APPROXIMATELY 2–3 MINUTES

// "Good morning, sir/mam.

// My practical is to implement Huffman Encoding using a Greedy Strategy in Java.

// Huffman Encoding is a lossless data compression technique. It assigns shorter binary codes to characters that occur more frequently and longer binary codes to characters that occur less frequently.

// First, I have created a Node class that stores the character, its frequency, and its left and right child references.

// Then, I have created a NodeComparator class using the Comparator interface. It compares nodes according to their frequencies.

// After that, I have created a Min Priority Queue. I insert all the character nodes into it.

// Now, the main logic starts. Using a while loop, I remove the two nodes having the smallest frequencies using the poll method.

// I add their frequencies and create a new parent node. Then I connect the two removed nodes as its left and right children and insert the new node back into the Priority Queue.

// This process continues until only one node remains. That node becomes the root of the Huffman Tree.

// Finally, I use a recursive method called generateCodes to traverse the tree.

// Whenever I move left, I append 0, and whenever I move right, I append 1.

// When I reach a leaf node, I print the character and its corresponding Huffman code.

// Thus, I have implemented Huffman Encoding using the Greedy Approach.

// The overall time complexity is O(n log n), where n is the number of unique characters.

// Thank you."
//  Copy explanation






// 16. Last-Minute Revision Before Your Practical
// Memorize these 10 points:
// 1. Algorithm: Greedy Algorithm.
// 2. Technique: Lossless Data Compression.
// 3. Data structure: Min Priority Queue.
// 4. Tree: Binary Tree.
// 5. Selection: Two smallest frequencies.
// 6. Left child: 0.
// 7. Right child: 1.
// 8. Traversal: Recursive DFS.
// 9. Time complexity: O(n log n).
// 10. Space complexity: O(n).