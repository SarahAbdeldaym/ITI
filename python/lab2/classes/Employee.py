import re
from classes.MySqlConnector import DBConnectionWrapper

from classes.Person import Person

class Employee(Person):
    email_regex = re.compile(
        r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+'
    )

    def __init__(self, id=0, full_name='', money=0, sleep_hours=0, meals_amount=1, email='abc@abc.abc', work_hours=0, salary=1000, is_manager=False):
        super().__init__(full_name, money, sleep_hours, meals_amount)
        self.connection = DBConnectionWrapper()
    
        self.id = id
        self.work(work_hours)
        self.is_manager = is_manager
        
        if not re.fullmatch(self.email_regex, email):
            raise ValueError("Email is not valid email format!")
        self.email = email
        
        if salary < 1000:
            raise ValueError("Salary must be higher than 1000!")
        self.salary = salary
    
    def __str__(self):
        return f"#{self.id} {self.full_name}";
    
    def save(self):
        cursor = self.connection.cursor()
        cursor.execute("""
                       INSERT INTO `employees` (`full_name`, `email`, `money`, `sleep_mood`, `work_mood`, `health_rate`, `salary`, `is_manager`)
                       VALUES (%s, %s, %s, %s, %s, %s, %s, %s)
                       """, (
                           self.full_name, self.email, self.money, self.sleep_mood, self.work_mood, self.health_rate, self.salary, self.is_manager
                           )
                       )
        self.connection.commit()
        
        cursor = self.connection.cursor()
        cursor.execute("SELECT id FROM `employees` ORDER BY id DESC LIMIT 1")
        self.id = cursor.fetchall()[0][0]
    
    def find(self, employee_id):
        cursor = self.connection.cursor()
        cursor.execute("SELECT * FROM `employees` WHERE id = %s", (employee_id,))
        employee_data = cursor.fetchone()
        
        employee =Employee(
            employee_data[0],
            employee_data[1],
            employee_data[3],
            email=employee_data[2],
            salary=employee_data[7],
            is_manager=employee_data[8]
        )
        employee.sleep_mood = employee_data[4]
        employee.work_mood = employee_data[5]
        employee.health_rate = employee_data[6]
        
        return employee
    
    def work(self, hours):
        if hours == 8:
            self.work_mood = "Happy"
        elif hours > 8:
            self.work_mood = "Tired"
        elif hours < 8:
            self.work_mood = "Lazy"

    def sendEmail(self, to, subject, body, receiverName):
        f = open(f"email{self.emailNo}.txt", "w")
        f.write(f"From : {self.fullName}\n")
        f.write(f"To : {to}\n")
        f.write(f"Subject : {subject}\n")
        f.write(f"Body : {body}\n")
        f.write(f"Receiver Name : {receiverName}\n")
        f.close()
