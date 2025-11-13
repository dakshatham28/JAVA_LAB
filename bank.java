import java.util.Scanner;

// Base Class
class Account {
    String name;
    String accNo;
    String accType;
    double balance;

    Scanner sc = new Scanner(System.in);

    void setData() {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Account No: ");
        accNo = sc.nextLine();
        System.out.print("Enter Account Type (savings/current): ");
        accType = sc.nextLine();
        System.out.print("Enter Opening Balance: ");
        balance = sc.nextDouble();
    }

    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    void displayBalance() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Type: " + accType);
        System.out.println("Balance: " + balance);
    }
}

// Savings Account
class SavAcct extends Account {
    double interestRate = 0.05; // 5% interest

    void computeAndDepositInterest() {
        System.out.print("Enter number of years to calculate interest: ");
        int years = sc.nextInt();
        double interest = balance * Math.pow(1 + interestRate, years) - balance;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Current Account
class CurAcct extends Account {
    double minBalance = 1000;
    double serviceCharge = 100;

    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            if (balance < minBalance) {
                balance -= serviceCharge;
                System.out.println("Balance below minimum! Service charge applied: " + serviceCharge);
            }
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Main Class
public class bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Bank System");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account No: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Account Type (savings/current): ");
        String type = sc.nextLine();

        if (type.equalsIgnoreCase("savings")) {
            SavAcct s = new SavAcct();
            s.name = name;
            s.accNo = accNo;
            s.accType = type;

            System.out.print("Enter Opening Balance: ");
            s.balance = sc.nextDouble();

            // User actions
            s.deposit();
            s.computeAndDepositInterest();
            s.withdraw();
            s.displayBalance();

        } else if (type.equalsIgnoreCase("current")) {
            CurAcct c = new CurAcct();
            c.name = name;
            c.accNo = accNo;
            c.accType = type;

            System.out.print("Enter Opening Balance: ");
            c.balance = sc.nextDouble();

            // User actions
            c.deposit();
            c.withdraw();
            c.displayBalance();

        } else {
            System.out.println("Invalid account type!");
        }

        sc.close();
    }
}
