# # Write a recursive program to calculate Fibonacci numbers and find its step count.
# # COLLEGE CODE 


# COUNT=0
# def recur_fibo(n):  
#    global COUNT
#    COUNT=COUNT+1
#    if n <= 1:  
#        return n  
#    else:  
#        return(recur_fibo(n-1) + recur_fibo(n-2))  
# # take input from the user  


# nterms = int(input("How many terms? "))  
# # check if the number of terms is valid  
# if nterms <= 0:  
#    print("Plese enter a positive integer")  
# else:  
#    print("Fibonacci sequence:")  
#    for i in range(nterms):  
#        print(recur_fibo(i))


# print("Steps reqired using Counter ", COUNT)










# CHATGPT CODE USER INPUT

counter = 0

def fibonacci(n):
    global counter

    counter += 1

    # Base conditions
    if n == 0:
        return 0

    if n == 1:
        return 1

    # Recursive calls
    return fibonacci(n - 1) + fibonacci(n - 2)


n = int(input("Enter number of terms: "))
total = 0

print("Fibonacci Series:", end=" ")

for i in range(n):

    num = fibonacci(i)

    print(num, end=" ")
    total += num

print("\nSum =", total)
print("Counter =", counter)
