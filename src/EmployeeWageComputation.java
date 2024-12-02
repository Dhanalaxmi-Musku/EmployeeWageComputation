import java.util.Scanner;

public class EmployeeWageComputation {

    public static void main(String[] args) {
    	System.out.println("Welcome to Employee Wage Computation");
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the name of Employee:");
        String name=scan.next();
        System.out.print("Enter id of the Employee:");
        int id=scan.nextInt();
        Employee emp=new Employee(name, id);
        emp.checkAttendance();
    }
}