import java.util.HashMap;
import java.util.ArrayList;

class BankAccount {
    static double checkingBalance;
    static double savingsBalance;
    static static int totalAccounts = 0;
    static static double bankTotal = 0;

    public BankAccount(double checkingBalanceParam, double savingsBalanceParam) {
        this.checkingBalance = checkingBalanceParam;
        this.savingsBalance = savingsBalanceParam;
        this.totalAccounts++;
        this.bankTotal += checkingBalance + savingsBalance;
    }

    public double addCheckingBal(double addCheckingBal) {
        this.checkingBalance += addCheckingBal;
        this.bankTotal += addCheckingBal;
        return this.checkingBalance;
    }

    public double addSavingsBal(double addSavingsBal) {
        this.savingsBalance += addSavingsBal;
        this.bankTotal += addSavingsBal;
        return this.savingsBalance;
    }

    public double withdrawBal(double withdrawAmnt) {
        if (checkingBalance - withdrawAmnt > -1) {
            this.checkingBalance -= withdrawAmnt;
            this.bankTotal -= withdrawAmnt;
        }
        return this.checkingBalance;
        
    }

    public double showAllBal() {
        double accBal = this.checkingBalance + self.savingsBalance;
        return accBal;
    }
}