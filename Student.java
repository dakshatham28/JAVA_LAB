import java.util.*;

class Student {
    String usn, name;
    int n, credits[], marks[];

    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter no. of subjects: ");
        n = sc.nextInt();

        credits = new int[n];
        marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Credits for sub " + (i+1) + ": ");
            credits[i] = sc.nextInt();
            System.out.print("Marks for sub " + (i+1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    double calcSGPA() {
        int totalC = 0; double sum = 0;
        for (int i = 0; i < n; i++) {
            int gp;
            if (marks[i] >= 90) gp = 10;
            else if (marks[i] >= 80) gp = 9;
            else if (marks[i] >= 70) gp = 8;
            else if (marks[i] >= 60) gp = 7;
            else if (marks[i] >= 50) gp = 6;
            else if (marks[i] >= 40) gp = 4;
            else gp = 0;
            sum += gp * credits[i];
            totalC += credits[i];
        }
        return sum / totalC;
    }

    void display() {
        System.out.println("\nUSN: " + usn + "  Name: " + name);
        System.out.printf("SGPA: %.2f\n", calcSGPA());
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.accept();
        s.display();
    }
}