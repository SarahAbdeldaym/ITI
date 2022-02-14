#include <iostream>
#include <string.h>
#include<conio.h>
#include <string>

using namespace std;

class Employee {
  private:

    int id;
    char *name;
    int salary;
    static int empcounter;
    static char* companyname;

  public:

     Employee (){
         id=0;
         salary=0;

         name = new char(strlen("no name")+1);
         strcpy(name,"no name");
         empcounter++;

     }


     Employee(int d, int sal){
        id=d;
        salary=sal;
        name = new char(strlen("no name")+1);
        strcpy(name,"no name");
        empcounter++;
     }
     Employee(int d, char* n){
        id=d;
        salary=50000;

        name = new char(strlen(n)+1);
        strcpy(name,n);
        empcounter++;

     }

     Employee (Employee& emp){
      id=emp.id;
      salary=emp.salary;
      name=new char[strlen(emp.name)+1];
      name = emp.name;
     }


    void setSalary(int s) {
      salary = s;
    }
    void setId(int i){
    id=i;
    }
    void setName(char *n){
    name=new char[strlen(n)+1];
    strcpy(name,n);
    }
    void setCompanyname(char *comp){
    companyname= new char[strlen(comp)+1];
    strcpy(companyname,comp);
    }

    int getSalary() {
      return salary;
    }
    int getId(){
        return id;
    }
    char* getName()
    {

        return name;
    }
    char* getCompanyname(){
    return companyname;
    }

    static int getCounter(){
    return empcounter;
    }

};
void printEmployee(Employee emp);
Employee FillEmployee( );
int Employee::empcounter=0;
char*  Employee::companyname="QNB";

int main()
{
    Employee emp(13,"sarah");

        printEmployee(emp);
        int f;
        f=Employee::getCounter();
        cout<<"Employee counter : "<<f<<endl;
        char* cn;
        cn=emp.getCompanyname();
        cout<<"company name : "<<cn<<endl;

cout << "Press any key to continue";

getch();
    return 0;
}

Employee FillEmployee(){
    Employee emp;
int d,sal;
char n[10];
cin>>d;
cin>>sal;
cin>>n;
emp.setId(d);
emp.setSalary(sal);
emp.setName(n);
return emp;
}
void printEmployee(Employee emp){
    cout<<"id : "<< emp.getId()<<endl;
    cout<<"salary : "<<emp.getSalary()<<endl;
    cout<<"name : "<<emp.getName()<<endl;

}
