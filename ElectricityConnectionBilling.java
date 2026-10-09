import java.util.Scanner;

// Problem 4 - Electricity Connection Billing
// Abstract Connection holds the shared "units" field; each type overrides the bill rule.
public class ElectricityConnectionBilling {

    static abstract class Connection {
        protected String type;
        protected int units;

        Connection(String type, int units) {
            this.type = type;
            this.units = units;
        }

        abstract double calculateBill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(int units) { super("HOME", units); }
        double calculateBill() {
            // 5/unit for the first 100, 7/unit for whatever's above
            if (units <= 100) {
                return 5.0 * units;
            }
            return 5.0 * 100 + 7.0 * (units - 100);
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(int units) { super("SHOP", units); }
        double calculateBill() {
            return 8.0 * units + 100; // fixed charge on top
        }
    }

    static class FactoryConnection extends Connection {
        private static final double MIN_BILL = 1000.0;

        FactoryConnection(int units) { super("FACTORY", units); }
        double calculateBill() {
            return Math.max(6.0 * units, MIN_BILL);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Connection[] connections = new Connection[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            int units = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "HOME":    connections[i] = new HomeConnection(units); break;
                case "SHOP":    connections[i] = new ShopConnection(units); break;
                case "FACTORY": connections[i] = new FactoryConnection(units); break;
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n", c.type, bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
