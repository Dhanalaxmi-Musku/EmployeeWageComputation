import java.util.Random;
public class Employee {
    String name;
    int id;
    boolean isPresent;
    int workingHours;
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void checkAttendance() {
        Random random = new Random();
        int attendanceType = random.nextInt(3);
        
        switch (attendanceType) {
            case 0: 
                handleAttendance(false, 0);
                break;
            case 1: 
                handleAttendance(true, EmployeeWageComputation.FULL_DAY_HOURS);
                break;
            case 2: 
                handleAttendance(true, EmployeeWageComputation.PART_TIME_HOURS);
                break;
        }
    }
    private void handleAttendance(boolean present, int hours) {
        isPresent = present;
        workingHours = hours;
        
        if (!present) {
            System.out.println(name + " is absent today.");
        } else {
            String workType = (hours == EmployeeWageComputation.FULL_DAY_HOURS) ? 
                              "full day" : "part-time";
            System.out.println(name + " is working " + workType + ".");
        }
    }
    public void calculateDailyWage() {
        if (isPresent) {
            int dailyWage = EmployeeWageComputation.WAGE_PER_HOUR * workingHours;
            System.out.println("Daily Wage: " + dailyWage);
        } else {
            System.out.println("No wage as employee is absent.");
        }
    }
	
}