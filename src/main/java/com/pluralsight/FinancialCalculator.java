package com.pluralsight;
import java.util.*;

public class FinancialCalculator {
    private static String system;

    public static void main(String[] args) {

        Scanner calcScanner = new Scanner(System.in);
        System.out.println("What calculator would you like to use? ");

        int calcNumber = calcScanner.nextInt();

        if (calcNumber == 1) {
            System.out.print("What is the principal? ");
            double numPrincipal = calcScanner.nextDouble();
            System.out.print("What is the interest rate? ");
            double yearlyInterestRate = calcScanner.nextDouble();
            yearlyInterestRate /= 100;
            System.out.print("What is the length of the loan? ");
            int loanLength = calcScanner.nextInt();

            int loanMonths = loanLength * 12;
            double monthlyInterest = yearlyInterestRate / 12;

            double monthlyPayment = numPrincipal * (monthlyInterest * Math.pow(1 + monthlyInterest, loanMonths) / (Math.pow(1 + monthlyInterest, loanMonths) - 1));
            double totalInterest = loanMonths * monthlyPayment - numPrincipal;

            System.out.printf("Your monthly payment is %.2f\n", monthlyPayment);
            System.out.printf("Your total interest is %.2f\n", totalInterest);
        }
        else if (calcNumber == 2) {
            System.out.print("How much will you deposit? ");
            double numDeposit = calcScanner.nextDouble();
            System.out.print("What is the interest rate? ");
            double yearlyInterest = calcScanner.nextDouble();
            System.out.println("How many years for it to mature? ");
            int numYears = calcScanner.nextInt();
            yearlyInterest /= 100;
            yearlyInterest /= 365;
            int numDaysInYears = numYears * 365;

            double futureValue = numDeposit * Math.pow(1 + yearlyInterest, numDaysInYears);
            double totalInterest2 = futureValue - numDeposit;

            System.out.printf("Your matured balance is: %.2f\n", futureValue);
            System.out.printf("Your total interest earned is: %.2f\n", totalInterest2);
        }

    }
}
