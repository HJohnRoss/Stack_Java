import java.util.HashMap;
import java.util.ArrayList;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(12, 109);
        BankAccount bankAccount2 = new BankAccount(1, 39);

        bankAccount1.addCheckingBal(4499);
        bankAccount1.withdrawBal(4000);

        System.out.println("Checking Balance: $" + bankAccount1.checkingBalance);
        System.out.println("Savings Balance: $" + bankAccount1.savingsBalance);
        System.out.println("Account Balance: $" + bankAccount1.showAllBal());

        System.out.println("----------------------------------------");

        System.out.println("Checking Balance: $" + bankAccount2.checkingBalance);
        System.out.println("Savings Balance: $" + bankAccount2.savingsBalance);
        System.out.println("Account Balance: $" + bankAccount2.showAllBal());

        System.out.println("----------------------------------------");

        System.out.println("Bank Balance: $" + BankAccount.bankTotal);
    }
}