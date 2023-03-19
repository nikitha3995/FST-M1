mylist1 = [1,2,3,4]
mylist2 = [5,6,7,8]
newlist1 = []
newlist2 = []


for i in mylist1:
    if i%2!=0:
        newlist1.append(i)

for i in mylist2:
    if i%2==0:
        newlist2.append(i)

finallist = newlist1 + newlist2
print(finallist)