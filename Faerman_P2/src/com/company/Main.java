package com.company;

class SavingsAccount{
    public static double annualInterestRate = 0.0;

    private double savingsBalance;

    public SavingsAccount(double amount){this.savingsBalance = amount;
    }

    public void calculateMonthlyInterest(){
        double interest;
        interest = (this.savingsBalance * (annualInterestRate/100))/12;
        this.savingsBalance += interest;
    }

    public void showBalance(){
        System.out.printf("$%.2f", this.savingsBalance);
    }

    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }
}

public class Main {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(4.0);
        System.out.println("Month         Saver_1      Saver_2");

        for(int i=1; i<=12; ++i){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.print("Month " + i + ":      ");
            saver1.showBalance();
            System.out.print("      ");
            saver2.showBalance();
            System.out.println();
        }
        System.out.println();

        System.out.println("Interest Rate is now 5%");
        System.out.println();
        SavingsAccount.modifyInterestRate(5.0);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.print("Month 13:      ");
        saver1.showBalance();
        System.out.print("      ");
        saver2.showBalance();
        System.out.println();
    }
}