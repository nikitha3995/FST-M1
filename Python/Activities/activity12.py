def myfunc(num):
    if num <= 1:
        return num
    else:
        return num + myfunc(num-1)

print(myfunc(10))