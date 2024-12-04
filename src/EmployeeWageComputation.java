import java.util.Scanner;

public class EmployeeWageComputation {
	public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    public static final int PART_TIME_HOURS = 4;
    public static final int WORKING_DAYS_PER_MONTH = 20;
    public static final int MAX_WORKING_HOURS = 100;
    public static final int MAX_WORKING_DAYS = 20;
    public static void main(String[] args) {
    	/*Company tcs = new Company("TCS", 20, 20, 100);
        Company infosys = new Company("Infosys", 25, 22, 110);
        Company wipro = new Company("Wipro", 22, 18, 90);
    	System.out.println("Welcome to Employee Wage Computation");
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the name of Employee:");
        String name=scan.next();
        System.out.print("Enter id of the Employee:");
        int id=scan.nextInt();
        Employee emp=new Employee(name, id);
       // emp.checkAttendance();
        //emp.calculateDailyWage();
        //emp.calculateMonthlyWage();
        emp.calculateWageWithConditions(tcs);
        emp.calculateWageWithConditions(infosys);
        emp.calculateWageWithConditions(wipro);*/
        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("TCS", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Infosys", 25, 22, 110);
        empWageBuilder.addCompanyEmpWage("Wipro", 22, 18, 90);
        empWageBuilder.computeEmpWage();
        System.out.println("Total Wage for TCS: " + empWageBuilder.getTotalWage("TCS"));
        System.out.println("Total Wage for Infosys: " + empWageBuilder.getTotalWage("Infosys"));
        System.out.println("Total Wage for Wipro: " + empWageBuilder.getTotalWage("Wipro"));
    }
}