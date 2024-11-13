import java.util.*;
interface ATM {
    double withdraw(double amount);
    double deposit(double amount);
    void checkBalance();
}
class ATMInterface implements ATM {
    double balance;
    double account;
    public ATMInterface(double a, double b) {
        account = a;
        balance = b;
    }
    public double withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Balance insufficient to withdraw");
            return balance; 
        } else {
            balance -= amount; 
            System.out.println("Withdeawn successfully...");
            return balance;
        }
    }
    public double deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount to deposit");
            return balance; 
        } else {
            balance += amount; 
            System.out.println("Deposited successfully");
            return balance;
        }
    }
    public void checkBalance() {
        System.out.println("Bank Balance: " + balance);
    }
}
class Bank {
    public static void main(String[] args) {
        double amount;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int acc = s.nextInt();
        System.out.print("Enter balance: ");
        double balance = s.nextDouble();
        ATMInterface atm = new ATMInterface(acc, balance);
        
        int c; 
        do {
            System.out.println("1. Withdraw\n2. Deposit\n3. Check balance\n4. Exit");
            System.out.print("Enter your choice:");
            c = s.nextInt();
            switch (c) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = s.nextDouble();
                    double w = atm.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    amount = s.nextDouble();
                    double d = atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (c > 0 && c < 4);
        
        s.close(); 
    }
}
