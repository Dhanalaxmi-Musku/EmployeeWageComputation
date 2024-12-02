import java.util.Random;
public class Employee {
    String name;
    int id;
    boolean isPresent;
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
	public void checkAttendance() {
        Random random = new Random();
        isPresent = random.nextBoolean();
        
        if (isPresent) {
            System.out.println(name + " is present today.");
        } else {
            System.out.println(name + " is absent today.");
        }
    }
	public void calculateDailyWage() {
        if (isPresent) {
            int dailyWage = EmployeeWageComputation.WAGE_PER_HOUR * 
                            EmployeeWageComputation.FULL_DAY_HOURS;
            System.out.println("Daily Wage: " + dailyWage);
        } else {
            System.out.println("No wage as employee is absent.");
        }
    }
}