
public class Company {
        private String name;
        private int wagePerHour;
        private int maxWorkingDays;
        private int maxWorkingHours;

        public Company(String name, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
            this.name = name;
            this.wagePerHour = wagePerHour;
            this.maxWorkingDays = maxWorkingDays;
            this.maxWorkingHours = maxWorkingHours;
        }

        public String getName() {
            return name;
        }

        public int getWagePerHour() {
            return wagePerHour;
        }

        public int getMaxWorkingDays() {
            return maxWorkingDays;
        }

        public int getMaxWorkingHours() {
            return maxWorkingHours;
        }
}

