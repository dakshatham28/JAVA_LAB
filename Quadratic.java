import java.util.Scanner;

public class Quadratic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coefficient a (non-zero): ");
        double a = sc.nextDouble();

        // Validate that 'a' is not zero
        if (a == 0) {
            System.out.println("Coefficient 'a' cannot be zero for a quadratic equation.");
            sc.close();
            return;
        }

        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();

        double disc = b * b - 4 * a * c;

        if (disc < 0) {
            System.out.println("There are no real solutions.");
        } else if (disc == 0) {
            double root = -b / (2 * a);
            System.out.println("There is one real solution: " + root);
        } else {
            double sqrtDisc = Math.sqrt(disc);
            double root1 = (-b + sqrtDisc) / (2 * a);
            double root2 = (-b - sqrtDisc) / (2 * a);
            System.out.println("There are two real solutions: " + root1 + " and " + root2);
        }

        sc.close();
    }
}

