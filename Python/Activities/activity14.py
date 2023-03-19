def fibonacci(num):
    if num <= 1:
        return num
    else:
        return (fibonacci(num-1)+fibonacci(num-2))

mynum=int(input("enter a number:"))
print("fibonacci:")
for i in range(mynum):
    print(i)