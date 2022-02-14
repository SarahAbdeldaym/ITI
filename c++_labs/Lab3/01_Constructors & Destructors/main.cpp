#include <iostream>
#include <string.h>

using namespace std;

class Employee
{
    private:
        int id;
        char* name;
        int salary;

    public:
        void setId(int F_Id) // setters and getters
        {
            id = F_Id;
        }
        void setName(char* F_Name)
        {
            delete (name);
            name = new char[strlen(F_Name)+1];
            strcpy(name, F_Name);
        }

        void setSalary(int F_Salary)
        {
            salary = F_Salary;
        }

        int GetId()
        {
            return id;
        }
        char* GetName()
        {
            return name;
        }

        int GetSalary()
        {
            return salary;
        }



        Employee() // Constructors
        {
            name = new char[1];
        }

        Employee(int F_Id) // print that name and salary are not sent.
        {
            setId(F_Id);
            name = new char[1];
            cout << "ID only was sent and it's value was : " << id << endl;
        }

        Employee(int F_Id, char* F_Name) //print that salary is not sent.
        {
            setId(F_Id);
            name = new char[1];
            setName(F_Name);
            cout << "ID & Name was sent and their values were : " << id << ", " << name <<endl;
        }

        Employee(int F_Id, char* F_Name, float F_Salary) //print that all was sent.
        {
            setId(F_Id);
            name = new char[1];
            setName(F_Name);
            setSalary(F_Salary);
            cout << "ID & Name and Salary was sent and their values were : " << id << ", " << name << ", " << salary <<endl;
        }


        ~Employee() // Destructor
        {
            delete (name);
            cout << "Destructor was called" <<endl;
        };


        Employee(Employee& F_Emp) // Copy constructor
        {
            cout << "Copy was called" <<endl;
            id = F_Emp.id;
            salary = F_Emp.salary;
            name = new char[strlen(F_Emp.name)+1];
            strcpy(name, F_Emp.name);
        }







        Employee operator=(Employee F_Emp) // Operators overloading
        {
            id=F_Emp.id;
            name=F_Emp.name;
            salary=F_Emp.salary;
            return *this;
        }

};


Employee FillEmp(); // non members functions
void PrintEmp(Employee F_Emp);














int main()
{
    /*
    Employee M_Emp1;
    Employee M_Emp2(13);
    Employee M_Emp3(13, "Hossam");
    Employee M_Emp4(13, "Adel", 15000.5);
    */

    Employee M_Emp5;
    M_Emp5 = FillEmp();
    PrintEmp(M_Emp5);
    return 0;

}





























Employee FillEmp() //Functions
{
    Employee T_Emp;
    int T_Id, T_Salary;
    char T_Name[10];

    cout << "Please enter Employee ID : ";
    cin >> T_Id;

    cout << "Please enter Employee Name : ";
    cin >> T_Name;

    cout << "Please enter Employee Salary : ";
    cin >> T_Salary;

    T_Emp.setId(T_Id);
    T_Emp.setName(T_Name);
    T_Emp.setSalary(T_Salary);

    return T_Emp;
}

void PrintEmp(Employee F_Emp)
{
    cout << "Employee ID is : " << F_Emp.GetId() << endl;

    cout << "Employee Name is : " << F_Emp.GetName() << endl;

    cout << "Employee Salary is : " << F_Emp.GetSalary() << endl;
}
