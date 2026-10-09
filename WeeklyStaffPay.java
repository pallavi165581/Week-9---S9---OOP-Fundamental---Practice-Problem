import java.util.Scanner;

// Problem 2 - Weekly Staff Pay
// StaffMember is abstract on purpose - a "generic" staffer can't be created.
public class WeeklyStaffPay {

    static abstract class StaffMember {
        protected String name;

        StaffMember(String name) {
            this.name = name;
        }

        abstract double weeklyPay(); // every staff type must define this
    }

    static class FullTimeStaff extends StaffMember {
        private double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }
        double weeklyPay() { return weeklySalary; }
    }

    static class HourlyStaff extends StaffMember {
        private double hours;
        private double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }
        double weeklyPay() {
            if (hours <= 40) {
                return hours * rate;
            }
            return 40 * rate + (hours - 40) * rate * 1.5; // overtime at 1.5x
        }
    }

    static class Intern extends StaffMember {
        private double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }
        double weeklyPay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        StaffMember[] staff = new StaffMember[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String name = parts[1];
            switch (parts[0]) {
                case "FULLTIME":
                    staff[i] = new FullTimeStaff(name, Double.parseDouble(parts[2])); break;
                case "HOURLY":
                    staff[i] = new HourlyStaff(name,
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3])); break;
                case "INTERN":
                    staff[i] = new Intern(name, Double.parseDouble(parts[2])); break;
            }
        }

        double total = 0;
        for (StaffMember s : staff) {
            double pay = s.weeklyPay();
            System.out.printf("%s: %.2f%n", s.name, pay);
            total += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
