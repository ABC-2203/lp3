import threading
import time
import random


# ---------------------------------------------------
# Function for Sequential Matrix Multiplication
# ---------------------------------------------------
def sequential_matrix_multiply(A, B):
    rows_A = len(A)
    cols_A = len(A[0])
    cols_B = len(B[0])

    C = [[0 for _ in range(cols_B)] for _ in range(rows_A)]

    for i in range(rows_A):
        for j in range(cols_B):
            for k in range(cols_A):
                C[i][j] += A[i][k] * B[k][j]

    return C


# ---------------------------------------------------
# Function executed by each thread
# One thread calculates one complete row
# ---------------------------------------------------
def multiply_row(A, B, C, row):
    cols_A = len(A[0])
    cols_B = len(B[0])

    for j in range(cols_B):
        for k in range(cols_A):
            C[row][j] += A[row][k] * B[k][j]


# ---------------------------------------------------
# Multithreaded Matrix Multiplication
# One thread per row
# ---------------------------------------------------
def multithreaded_matrix_multiply(A, B):
    rows_A = len(A)
    cols_B = len(B[0])

    C = [[0 for _ in range(cols_B)] for _ in range(rows_A)]

    threads = []

    # Create one thread for each row
    for i in range(rows_A):
        thread = threading.Thread(
            target=multiply_row,
            args=(A, B, C, i)
        )

        threads.append(thread)
        thread.start()

    # Wait for all threads to finish
    for thread in threads:
        thread.join()

    return C


# ---------------------------------------------------
# Function to generate a random matrix
# ---------------------------------------------------
def generate_matrix(rows, cols):
    return [
        [random.randint(1, 10) for _ in range(cols)]
        for _ in range(rows)
    ]


# ---------------------------------------------------
# Function to print a matrix
# ---------------------------------------------------
def print_matrix(matrix):
    for row in matrix:
        print(row)


# ---------------------------------------------------
# Main Program
# ---------------------------------------------------

n = int(input("Enter size of square matrix: "))

# Generate matrices
A = generate_matrix(n, n)
B = generate_matrix(n, n)

print("\nMatrix A:")
print_matrix(A)

print("\nMatrix B:")
print_matrix(B)


# ---------------------------------------------------
# Sequential Multiplication
# ---------------------------------------------------

start = time.perf_counter()

C1 = sequential_matrix_multiply(A, B)

end = time.perf_counter()

sequential_time = end - start


# ---------------------------------------------------
# Multithreaded Multiplication
# ---------------------------------------------------

start = time.perf_counter()

C2 = multithreaded_matrix_multiply(A, B)

end = time.perf_counter()

multithreaded_time = end - start


# ---------------------------------------------------
# Display Results
# ---------------------------------------------------

print("\nResult using Sequential Multiplication:")
print_matrix(C1)

print("\nResult using Multithreaded Multiplication:")
print_matrix(C2)


# ---------------------------------------------------
# Verify both results
# ---------------------------------------------------

if C1 == C2:
    print("\nVerification: Both results are identical.")
else:
    print("\nVerification: Results are different!")


# ---------------------------------------------------
# Performance Comparison
# ---------------------------------------------------

print("\n---------- PERFORMANCE ANALYSIS ----------")

print(f"Sequential Execution Time     : {sequential_time:.8f} seconds")
print(f"Multithreaded Execution Time  : {multithreaded_time:.8f} seconds")

if multithreaded_time < sequential_time:
    improvement = (
        (sequential_time - multithreaded_time)
        / sequential_time
    ) * 100

    print(f"Multithreading Improvement     : {improvement:.2f}%")

else:
    overhead = (
        (multithreaded_time - sequential_time)
        / sequential_time
    ) * 100

    print(f"Threading Overhead             : {overhead:.2f}%")