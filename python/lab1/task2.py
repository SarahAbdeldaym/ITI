def eliminateDuplications(duplicatedList):
    return list(set(duplicatedList))



duplicatedList = [1, 2, 2, 3, 2]

print("your list ",duplicatedList,"before elementing duplications")

duplicatedList= eliminateDuplications(duplicatedList)

print("your list ",duplicatedList,"After elementing duplications")

