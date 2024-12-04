public class CompanyEmpWage {
	public String companyName;
    public int wagePerHour;
    public int maxWorkingDays;
    public int maxWorkingHours;
    public int totalEmpWage;
    public int[] dailyWages;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new int[maxWorkingDays];
    }

}
