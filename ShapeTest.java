import java.util.Scanner;

class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    // Constructor
    public Account(String name, String accNo, String accType, double initialBalance) {
        customerName = name;
        accountNumber = accNo;
        accountType = accType;
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }

    // Withdraw money (general)
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Savings Account class
class SavAcct extends Account {
    private double interestRate = 0.05; // 5% interest rate

    public SavAcct(String name, String accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    // Compute and deposit compound interest
    public void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate), years) - balance;
        balance += interest;
        System.out.println("Interest of " + interest + " added for " + years + " years.");
    }

    // Withdraw for Savings Account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance in Savings Account!");
        }
    }
}

// Current Account class
class CurAcct extends Account {
    private double minBalance = 1000.0;
    private double serviceCharge = 50.0;

    public CurAcct(String name, String accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }

    // Check minimum balance and impose penalty if needed
    private void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum! Service charge of " + serviceCharge + " imposed.");
        }
    }

    // Withdraw for Current Account
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance in Current Account!");
        }
    }
}

// Main Bank class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                                                                                               

        System.out.println("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.println("Enter Account Type (Savings/Current): ");
        String type = sc.nextLine();

        System.out.println("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        Account account;

        if (type.equalsIgnoreCase("Savings")) {
            account = new SavAcct(name, accNo, initialBalance);
        } else {
            account = new CurAcct(name, accNo, initialBalance);
        }

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct)
                System.out.println("4. Compute Interest");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    if (account instanceof SavAcct) {
                        System.out.print("Enter number of years: ");
                        int years = sc.nextInt();
                        ((SavAcct) account).computeAndDepositInterest(years);
                    } else {
                        System.out.println("Interest not available for Current Account!");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}