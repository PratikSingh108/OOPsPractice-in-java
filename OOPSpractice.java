package practice;

import java.util.ArrayList;

//using abstraction
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

//    using encapsulation
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name="+name+", id ="+id+",salary="+calculateSalary()+"]";
    }


}

class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary =monthlySalary;
    }


//using polymorphism
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}


// using inheritance
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id , double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrolSystem{
    private ArrayList<Employee> employeeList;
    public PayrolSystem(){
        employeeList = new ArrayList<Employee>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee: employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
    }

}

public class OOPSpractice {
    public static void main(String[] args) {
        PayrolSystem payrolSystem = new PayrolSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas",01 ,70000 );
        PartTimeEmployee emp2 = new PartTimeEmployee("Abhishek", 02, 600);

        payrolSystem.addEmployee(emp1);
        payrolSystem.addEmployee(emp2);
        System.out.println("Initial Employee details");
        payrolSystem.displayEmployees();
        System.out.println("Removing Employees");
        payrolSystem.removeEmployee(2);
        System.out.println("Remaining Employee details");
    }
}