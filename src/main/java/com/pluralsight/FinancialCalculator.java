package com.pluralsight;
import java.util.Scanner;

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
    }
}
