mylist = [1,2,3,4]
#mylist = list(input("enter a list of numbers:")).split(",")
num = 0
for i in mylist:
    num = num + int(i)

print(num)