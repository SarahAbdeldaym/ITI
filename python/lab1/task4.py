from collections import Counter

with open('task4.txt', 'r') as fileObj:
    word_list = fileObj.read().replace('\n', '').split()

top_20_Words = Counter(word_list).most_common(20)

print(top_20_Words)