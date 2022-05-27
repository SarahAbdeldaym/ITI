from classes.Employee import Employee
from classes.Office import Office

class GUI:
    
    def register_employee(self):
        employee = Employee(
            0,
            input('full name: '),
            int(input('money: ')),
            int(input('sleep hours: ')),
            int(input('meals amount: ')),
            input('email: '),
            int(input('work hours: ')),
            int(input('salary: ')),
            int(input('is manager: '))
        )
        employee.save()
        return employee
    
    def register_office(self):
        office = Office(name=input('office name: '))
        office.save()
        return office
    
    def retrieve_office(self):
        return Office().find(int(input('office id: ')))
    
    def retrieve_employee(self):
        return Employee().find(int(input('employee id: ')))
    
    def hire_employee(self):
        office = self.retrieve_office()
        employee = self.retrieve_employee()
        
        office.hire(employee)
        
        return 'OK'
    
    def fire_employee(self):
        office = self.retrieve_office()
        employee = self.retrieve_employee()
        
        office.fire(employee)
        
        return 'OK'
        
    def render(self):
        self.render_menu()
        
        match self.select_meu_operation():
            case 1:
                print(self.register_office())
            case 2:
                print(self.retrieve_office())
            case 3:
                print(self.register_employee())
            case 4:
                print(self.retrieve_employee())
            case 5:
                print(self.hire_employee())
            case 6:
                print(self.fire_employee())
            case 7:
                exit()
                
        input('press enter key to continue...')
        self.render()

    def select_meu_operation(self):
        choice = int(input('Enter the number of the desired operation: '))
        if not choice in range(1, 7):
            raise ValueError('Invalid choice!')
        return choice
        
    def render_menu(self):
        print("""
1- Register a new office.
2- Retrieve an office
3- Register a new employee.
4- Retrieve an employee.
5- Hire an employee
6- Fire an employee
7- Exit
""")
