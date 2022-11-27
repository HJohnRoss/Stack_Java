import java.util.HashMap;
import java.util.ArrayList;

class BankAccount {
    public double checkingBalance;
    public double savingsBalance;
    public static int totalAccounts = 0;
    public static double bankTotal = 0;

    public BankAccount(double checkingBalanceParam, double savingsBalanceParam) {
        checkingBalance = checkingBalanceParam;
        savingsBalance = savingsBalanceParam;
        totalAccounts++;
        bankTotal += checkingBalance + savingsBalance;
    }

    public void addCheckingBal(double addCheckingBal) {
        checkingBalance += addCheckingBal;
        bankTotal += addCheckingBal;
    }

    public void addSavingsBal(double addSavingsBal) {
        savingsBalance += addSavingsBal;
        bankTotal += addSavingsBal;
    }

    public void withdrawBal(double withdrawAmnt) {
        if (checkingBalance - withdrawAmnt > -1) {
            checkingBalance -= withdrawAmnt;
            bankTotal -= withdrawAmnt;
        }
    }

    public double showAllBal() {
        double accBal = checkingBalance + savingsBalance;
        return accBal;
    }
}