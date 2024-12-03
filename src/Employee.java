import java.util.Random;
public class Employee {
    String name;
    int id;
    boolean isPresent;
    int workingHours;
    int dailyWage;
    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public  void checkAttendance() {
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
    private  void handleAttendance(boolean present, int hours) {
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
    public  void calculateDailyWage() {
    	  dailyWage = EmployeeWageComputation.WAGE_PER_HOUR * workingHours;
        if (isPresent) {
            System.out.println("Daily Wage: " + dailyWage);
        } else {
            System.out.println("No wage as employee is absent.");
        }
    }
    public void calculateMonthlyWage()
    {
    	System.out.println("Montly wage is "+dailyWage*EmployeeWageComputation.WORKING_DAYS_PER_MONTH);
    }
    public void calculateWageWithConditions() {
    	
        /*Random random = new Random();*/
        int totalMonthlyWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        while (totalWorkingHours < EmployeeWageComputation.MAX_WORKING_HOURS && 
               totalWorkingDays < EmployeeWageComputation.MAX_WORKING_DAYS) {
        	checkAttendance();
        	//System.out.println(workingHours);
            if (totalWorkingHours +  workingHours <= EmployeeWageComputation.MAX_WORKING_HOURS && 
                totalWorkingDays + 1 <= EmployeeWageComputation.MAX_WORKING_DAYS) {
                
                totalWorkingHours += workingHours;
                totalWorkingDays++;
                totalMonthlyWage += dailyWage;
                calculateDailyWage();
            }
        }
        
        System.out.println("\n" + name + " Wage Summary:");
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: " + totalMonthlyWage);
    }
	
}