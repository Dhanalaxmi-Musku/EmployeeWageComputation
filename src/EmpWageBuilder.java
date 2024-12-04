import java.util.ArrayList;
import java.util.Random;

public class EmpWageBuilder implements IComputeEmpWage{
	private ArrayList<CompanyEmpWage> companyEmpWageList;
    private Random random;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
        random = new Random();
    }

    @Override
    public void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        companyEmpWageList.add(companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            companyEmpWage.totalEmpWage = computeEmpWageForCompany(companyEmpWage);
        }
    }

    private int computeEmpWageForCompany(CompanyEmpWage companyEmpWage) {
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalEmpWage = 0;
        int dailyWageIndex = 0;

        while (totalWorkingHours < companyEmpWage.maxWorkingHours && 
               totalWorkingDays < companyEmpWage.maxWorkingDays) {
            
            int workingHours = getWorkingHours();
            
            if (totalWorkingHours + workingHours <= companyEmpWage.maxWorkingHours) {
                totalWorkingDays++;
                totalWorkingHours += workingHours;
                
                int dailyWage = workingHours * companyEmpWage.wagePerHour;
                totalEmpWage += dailyWage;
                
                companyEmpWage.dailyWages[dailyWageIndex++] = dailyWage;
            }
        }
        
        return totalEmpWage;
    }

    private int getWorkingHours() {
        int employeeCheck = random.nextInt(3);
        switch (employeeCheck) {
            case 0: return 0;  // Absent
            case 1: return 8;  // Full day
            case 2: return 4;  // Part time
            default: return 0;
        }
    }

    @Override
    public int getTotalWage(String companyName) {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            if (companyEmpWage.companyName.equals(companyName)) {
                return companyEmpWage.totalEmpWage;
            }
        }
        return 0;
    }

}
