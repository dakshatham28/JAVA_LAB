import java.util.Scanner;

// Custom Exception
class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}

// Base Class
class Father {
    protected int fatherAge;

    public Father(int fatherAge) throws WrongAge {
        if (fatherAge < 0) {
            throw new WrongAge("Father's age cannot be negative!");
        }
        this.fatherAge = fatherAge;
        System.out.println("Father's age set to: " + fatherAge);
    }
}

// Derived Class
class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge); // Call Father constructor first

        if (sonAge < 0) {
            throw new WrongAge("Son's age cannot be negative!");
        }

        // Lab condition: Son cannot be older or equal
        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age must be less than Father's age!");
        }

        
        this.sonAge = sonAge;
        System.out.println("Son's age set to: " + sonAge);
    }
}

public class ExceptionInheritanceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Father's age: ");
            int fAge = sc.nextInt();

            System.out.print("Enter Son's age: ");
            int sAge = sc.nextInt();

            Son s = new Son(fAge, sAge);

            System.out.println("\nObject created successfully!");
        }
        catch (WrongAge e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        finally {
            System.out.println("\nProgram executed successfully (with or without exceptions).");
        }

        sc.close();
    }
}