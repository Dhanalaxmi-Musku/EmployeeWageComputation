import java.util.Random;
public  class Employee {
    private String name;
    private int id;
    private boolean isPresent;
    private int workingHours;
    private int dailyWage;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void checkAttendance(int fullDayHours, int partTimeHours) {
        Random random = new Random();
        int attendanceType = random.nextInt(3);
        
        switch (attendanceType) {
            case 0: 
                handleAttendance(false, 0, fullDayHours, partTimeHours);
                break;
            case 1: 
                handleAttendance(true, fullDayHours, fullDayHours, partTimeHours);
                break;
            case 2: 
                handleAttendance(true, partTimeHours, fullDayHours, partTimeHours);
                break;
        }
    }

    private void handleAttendance(boolean present, int hours, int fullDayHours, int partTimeHours) {
        isPresent = present;
        workingHours = hours;
        
        if (!present) {
            System.out.println(name + " is absent today.");
        } else {
            String workType = (hours == fullDayHours) ? "full day" : "part-time";
            System.out.println(name + " is working " + workType + ".");
        }
    }

    public void calculateDailyWage(int wagePerHour) {
        dailyWage = wagePerHour * workingHours;
        if (isPresent) {
            System.out.println("Daily Wage: " + dailyWage);
        } else {
            System.out.println("No wage as employee is absent.");
        }
    }

    public void calculateWageWithConditions(Company company) {
        int totalMonthlyWage = 0;
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;

        int fullDayHours = 8;  
        int partTimeHours = 4; 

        while (totalWorkingHours < company.getMaxWorkingHours() && 
               totalWorkingDays < company.getMaxWorkingDays()) {
            
            checkAttendance(fullDayHours, partTimeHours);
            
            if (totalWorkingHours + workingHours <= company.getMaxWorkingHours() && 
                totalWorkingDays + 1 <= company.getMaxWorkingDays()) {
                
                totalWorkingHours += workingHours;
                totalWorkingDays++;
                calculateDailyWage(company.getWagePerHour());
                totalMonthlyWage += dailyWage;
            }
        }
        
        System.out.println("\n" + name + " Wage Summary for " + company.getName() + ":");
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Monthly Wage: " + totalMonthlyWage);
        System.out.println("------------------------");
    }
}