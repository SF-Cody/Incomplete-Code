import java.util.*;

interface Emp {
    String getName();    
    void setName(String name);
}

interface FullTime {
    void setMonthlySalary();
    double getMonthlySalary();
}

interface PartTime {
    void setWage();
    double getWage();
}

class ResultEvaluator {
    public void Evaluate(String name, char employeeTypeChar) {
        switch (employeeTypeChar) {
            case 'f':
            case 'F':
                FullTimeEmployee fullTimer = new FullTimeEmployee(name, 1);
                fullTimer.setMonthlySalary();
                break;
            case 'p':
            case 'P':
                PartTimeEmployee partTimer = new PartTimeEmployee(name, 1, 2, 3);
                partTimer.setWage();
                break;
            default:
                System.out.println("Invalid input.");
                System.exit(0);
                break;
            }
    }
}

class Employee implements Emp {
    public String name;
        
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}

class FullTimeEmployee extends Employee implements FullTime {
    
    double monthlySalary;
    
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        
        this.monthlySalary = monthlySalary;
    }
    
    public double getMonthlySalary() {
        return this.monthlySalary;
    }
    
    public void setMonthlySalary() {
        Scanner MonthlyScanner = new Scanner(System.in);
        System.out.println("Enter monthly salary: ");
        this.monthlySalary = MonthlyScanner.nextDouble();
        
        System.out.println("Calculating results...");
        
        System.out.println("Name: " + this.getName());
        
        System.out.println("Monthly Salary: " + getMonthlySalary());
        System.exit(0);
    }
}

class PartTimeEmployee extends Employee implements PartTime {
    double ratePerHour;
    int hoursWorked;
    double wage;
    
    public PartTimeEmployee(String name, double ratePerHour, int hoursWorked, double wage) {
        super(name);
        
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
        this.wage = wage;
    }
    
    public double getWage() {
        return this.wage;
    }
    
    public void setWage() {
        Scanner RateScanner = new Scanner(System.in);
        System.out.println("Enter rate per hour and no. of hours worked separated by space: ");
        this.ratePerHour = RateScanner.nextDouble();
        this.hoursWorked = RateScanner.nextInt();
        System.out.println("Calculating results...");
        this.wage = this.ratePerHour * this.hoursWorked;

        System.out.println("Name: " + this.getName());
        
        System.out.println("Wage: " + getWage());
        System.exit(0);
    }
}

public class Activity7 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        
        System.out.println("Press F for Full Time or P for Part Time: ");
        String employeeType = scanner.nextLine();
        char employeeTypeChar = employeeType.charAt(0);
        
        ResultEvaluator evaluator = new ResultEvaluator();
        evaluator.Evaluate(name, employeeTypeChar);
    }
}
