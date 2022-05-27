class Person:

    def __init__(self, full_name, money, sleep_hours, meals_amount):
        self.full_name = full_name
        self.money = money
        self.sleep(sleep_hours)
        self.eat(meals_amount)

    def sleep(self, hours):
        if hours == 7:
            self.sleep_mood = "Happy"
        elif hours > 7:
            self.sleep_mood = "Lazy"
        elif hours < 7:
            self.sleep_mood = "Tired"

    def eat(self, meals_amount):
        if meals_amount not in range(1, 3):
            raise ValueError("Meals amount must be from 1 to 3 meals!")
        
        if meals_amount == 3:
            self.health_rate = 100
        elif meals_amount == 2:
            self.health_rate = 75
        elif meals_amount == 1:
            self.health_rate = 50

    def buy(self, items_count):
        amount = 10 * items_count
        
        if (0 < self.money - amount):
            raise ValueError('Insuffient balance')
        self.money -= amount
