import java.util.Scanner;

public class EmployeeWageComputation {
	public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    public static void main(String[] args) {
    	System.out.println("Welcome to Employee Wage Computation");
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the name of Employee:");
        String name=scan.next();
        System.out.print("Enter id of the Employee:");
        int id=scan.nextInt();
        Employee emp=new Employee(name, id);
        emp.checkAttendance();
        emp.calculateDailyWage();
    }
}