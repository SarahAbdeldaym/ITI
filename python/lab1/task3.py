import math

def splitWords(word1, word2):

    return (word1[:math.ceil(len(word1)/2)]+ \
    word2[:math.ceil(len(word2)/2)], \
     word1[math.ceil(len(word1)/2):]+\
     word2[math.ceil(len(word2)/2):])




input_word1 = input("first word: ")
input_word2 = input("second word: ")

print(splitWords(input_word1, input_word2))
