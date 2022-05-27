import math

def calculateDistance(x1, y1, x2, y2):
    return math.sqrt(pow(x2-x1, 2)+pow(y2-y1, 2))



print(calculateDistance(5, 2, 1, 2))
