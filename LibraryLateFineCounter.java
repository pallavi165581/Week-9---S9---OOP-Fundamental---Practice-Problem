import java.util.Scanner;

// Problem 3 - Library Late Fine Counter
// Abstract LibraryItem holds title + daysLate; each item type overrides fine().
public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        protected String title;
        protected int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double fine() { return 2.0 * daysLate; }
    }

    static class Dvd extends LibraryItem {
        private static final double MAX_FINE = 50.0;

        Dvd(String title, int daysLate) { super(title, daysLate); }
        double fine() {
            return Math.min(5.0 * daysLate, MAX_FINE); // capped at 50
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double fine() { return 1.0 * daysLate; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LibraryItem[] items = new LibraryItem[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);
            switch (parts[0]) {
                case "BOOK":     items[i] = new Book(title, daysLate); break;
                case "DVD":      items[i] = new Dvd(title, daysLate); break;
                case "MAGAZINE": items[i] = new Magazine(title, daysLate); break;
            }
        }

        double total = 0;
        for (LibraryItem item : items) {
            double fine = item.fine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
