def removeVowels(str):
    newString = ""
    for char in str:
        if (char not in "aeouiAEOUI"):
            newString = newString+char
    return newString

print("your word is : sarah")
print("the output after removing the vowel is :",removeVowels("sarah"))