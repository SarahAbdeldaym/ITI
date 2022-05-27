from classes.MySqlConnector import DBConnectionWrapper

class Office:
    def __init__(self, id=0, name=''):
        self.id = id
        self.name = name
        self.connection = DBConnectionWrapper()
        
    def __str__(self):
        return f"#{self.id} {self.name}"
        
    def save(self):
        cursor = self.connection.cursor()
        cursor.execute("INSERT INTO `offices` (`name`) VALUES (%s);", (self.name,))
        self.connection.commit()
        
        cursor = self.connection.cursor()
        cursor.execute("SELECT id FROM `offices` ORDER BY id DESC LIMIT 1")
        self.id = cursor.fetchall()[0][0]

    def find(self, office_id):
        cursor = self.connection.cursor()
        cursor.execute("SELECT * FROM `offices` WHERE id = %s", (office_id,))
        office_data = cursor.fetchone()
        return Office(office_data[0], office_data[1])

    def get_all_employees(self):
        cursor = self.connection.cursor()
        cursor.execute("SELECT * FROM `employees` JOIN `office_employees` ON employees.id = office_employees.employee_id WHERE office_employees.office_id = %s", (self.id, ))
        return cursor.fetchall()

    def get_employee(self, employee_id):
        cursor = self.connection.cursor()
        cursor.execute("SELECT * FROM `employees` JOIN `office_employees` ON employees.id = office_employees.employee_id WHERE office_employees.office_id = %s AND employees.id = %s", (self.id, employee_id))
        return cursor.fetchall()
    
    def hire(self, employee):
        if self.is_hired(employee):
            raise ValueError("Employee already hired")
        
        cursor = self.connection.cursor()
        cursor.execute("INSERT INTO `office_employees` (`office_id`, `employee_id`) VALUES (%s, %s);", (self.id, employee.id,))
        self.connection.commit()

    def fire(self, employee):
        if not self.is_hired(employee):
            raise ValueError("Employee is not hired")
        
        cursor = self.connection.cursor()
        cursor.execute("DELETE FROM `office_employees` WHERE office_id = %s AND employee_id = %s;", (self.id, employee.id,))
        self.connection.commit()
    
    def is_hired(self, employee):
        cursor = self.connection.cursor()
        cursor.execute("SELECT COUNT(*) FROM `office_employees` WHERE office_id = %s AND employee_id = %s", (self.id, employee.id,))
        return 1 == cursor.fetchall()[0][0]
