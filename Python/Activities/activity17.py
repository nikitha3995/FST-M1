import pandas

data ={
    "username" : ["admin", "charles","deku"],
    "passwords" : ["password","charl13","allmight"]
}

df = pandas.DataFrame(data)
print(df)

df.to_csv("sample.csv",index=False)