# # Write a iterative program to calculate Fibonacci numbers and find its step count.
# COUNT = 0
# x=int(input("Enter Number of Terms :"))
# first=0
# sec=1
# c=0
# if(x<0):
#     print("Enter valid input..")
# elif(x==0):
#     print(0)
# elif(x==1):
#     print("Fibbonacci series upto",x,"is",first)
# else:
#     while c<x:
#         print(first) 
#         COUNT = COUNT +1
#         nth=first+sec 
#         COUNT = COUNT +1
#         first=sec 
#         COUNT = COUNT +1
#         sec=nth 
#         COUNT = COUNT +1
#         c+=1  
#         COUNT = COUNT +1
        

# print("Steps required using Counter ", COUNT)








# CHATGPT
n = int(input("Enter number of terms: "))

first = 0
second = 1
total = 0
counter = 0

print("Fibonacci Series:", end=" ")

for i in range(n):

    print(first, end=" ")

    total = total + first
    counter += 1

    next_num = first + second

    first = second
    second = next_num

print("\nSum =", total)
print("Counter =", counter)











# 1. How to Run Python Code in Ubuntu (Linux)
# Step 1: Open Terminal
# Press:

# Ctrl + Alt + T

# This opens the Ubuntu Terminal.
# Step 2: Check Python installation
# Type:
# python3 --version


# Example output:
# Python 3.12.3


# If Python is not installed, install it using:
# sudo apt update
# sudo apt install python3


# Step 3: Create a Python file
# Type:
# nano fibonacci.py


# This opens the Nano text editor.

# Step 5: Save the file
# In Nano:
# 1. Press Ctrl + O to save.
# 2. Press Enter.
# 3. Press Ctrl + X to exit.
# Step 6: Run the program
# Type:
# python3 fibonacci.py






# ALTERNATIVEStep 5: Open the file location in CMD
# If you saved the file on Desktop, type:
# cd Desktop


# Step 6: Run the program
# Type:
# python fibonacci.py


# Alternatively:
# py fibonacci.py