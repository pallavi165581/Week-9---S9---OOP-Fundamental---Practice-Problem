import java.util.Scanner;

// Problem 1 - Garden Plot Area Report
// Abstract base Plot holds the owner; each shape overrides area() with its own formula.
public class GardenPlotAreaReport {

    static abstract class Plot {
        protected String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double area();
        abstract String shapeName();
    }

    static class CirclePlot extends Plot {
        private double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }
        double area() { return Math.PI * radius * radius; }
        String shapeName() { return "CIRCLE"; }
    }

    static class RectanglePlot extends Plot {
        private double length;
        private double width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }
        double area() { return length * width; }
        String shapeName() { return "RECTANGLE"; }
    }

    static class TrianglePlot extends Plot {
        private double base;
        private double height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }
        double area() { return 0.5 * base * height; }
        String shapeName() { return "TRIANGLE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Plot[] plots = new Plot[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            String owner = parts[1];
            switch (parts[0]) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, Double.parseDouble(parts[2])); break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(owner,
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3])); break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(owner,
                            Double.parseDouble(parts[2]), Double.parseDouble(parts[3])); break;
            }
        }

        double total = 0;
        for (Plot p : plots) {
            double area = p.area();
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shapeName(), area);
            total += area;
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
