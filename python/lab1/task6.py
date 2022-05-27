def  characterLocator(str, Search_char):
    return [i for i, x in enumerate(str) if x == Search_char]

userString = input("Enter a word : ")

userSearchChar = input("Enter The Character you want to search for : ")

print(
    f"Congrats!!  I found it, it is in the index number : {characterLocator(userString, userSearchChar)}")