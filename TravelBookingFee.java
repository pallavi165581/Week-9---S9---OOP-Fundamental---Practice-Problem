import java.util.Scanner;

// Problem 5 - Travel Booking with a Common Fee
// The booking fee lives ONLY on the base class - one place to change it.
public class TravelBookingFee {

    static abstract class Booking {
        // the shared fee - written exactly once, used by every mode
        private static final double BOOKING_FEE = 50.0;

        protected String mode;
        protected double distanceKm;

        Booking(String mode, double distanceKm) {
            this.mode = mode;
            this.distanceKm = distanceKm;
        }

        abstract double baseFare(); // each mode's own fare rule

        // concrete shared method: every booking pays fare + the same fee
        double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double distanceKm) { super("BUS", distanceKm); }
        double baseFare() { return 2.0 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double distanceKm) { super("TRAIN", distanceKm); }
        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double distanceKm) { super("FLIGHT", distanceKm); }
        double baseFare() { return 2500 + 4.0 * distanceKm; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Booking[] bookings = new Booking[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            double distance = Double.parseDouble(parts[1]);
            switch (parts[0]) {
                case "BUS":    bookings[i] = new BusBooking(distance); break;
                case "TRAIN":  bookings[i] = new TrainBooking(distance); break;
                case "FLIGHT": bookings[i] = new FlightBooking(distance); break;
            }
        }

        // no total line for this problem - just each booking's final amount
        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.mode, b.total());
        }
        sc.close();
    }
}
