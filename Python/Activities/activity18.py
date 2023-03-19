import pandas

df = pandas.read_csv("sample.csv")
print("all usernames:")
print(df["username"])

print("2nd column username and password:")
print(df["username"][1],df["passwords"][1])

print("username sorted:")
print(df.sort_values("username"))

print(df.sort_values("passwords", ascending=False))