public interface IComputeEmpWage {
	void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
    void computeEmpWage();
    int getTotalWage(String companyName);
}
