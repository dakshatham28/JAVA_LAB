import java.util.*;
import cie.*;
import see.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Internals[] internals = new Internals[n];
        external[] externals = new external[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Student " + (i + 1) + " details:");

            System.out.print("USN: ");
            String usn = sc.next();

            sc.nextLine();  // Clear buffer

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Sem: ");
            int sem = sc.nextInt();

            int[] cie = new int[5];
            int[] see = new int[5];

            System.out.println("Enter 5 CIE marks (out of 50):");
            for (int j = 0; j < 5; j++)
                cie[j] = sc.nextInt();

            System.out.println("Enter 5 SEE marks (out of 100):");
            for (int j = 0; j < 5; j++)
                see[j] = sc.nextInt();

            // Create objects
            internals[i] = new Internals(cie);
            externals[i] = new external(usn, name, sem, see);

            // Display results
            System.out.println("\nFinal Marks for " + name + " (" + usn + "):");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internals[i].internalMarks[j] + externals[i].seeMarks[j];
                System.out.println("Course " + (j + 1) + ": " + finalMarks + " / 100");
            }
        }
    }
}