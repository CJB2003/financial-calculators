package com.pluralsight;
import java.util.*;

public class FinancialCalculator {
    private static String system;

    public static void main(String[] args) {

        Scanner calcScanner = new Scanner(System.in);
        System.out.println("What calculator would you like to use? ");

        int calcNumber = calcScanner.nextInt();

        //Calc 1 calculates mortgages
        if (calcNumber == 1) {

            //asking for principal, interest rate, and length of loan from user
            System.out.print("What is the principal? ");
            double numPrincipal = calcScanner.nextDouble();
            System.out.print("What is the interest rate? ");
            double yearlyInterestRate = calcScanner.nextDouble();
            System.out.print("What is the length of the loan? ");
            int loanLength = calcScanner.nextInt();

            //divide annual interest by 100 to get the proper calculation in the hundreths place.
            yearlyInterestRate /= 100;
            //loan length is in years so multiply by 12 to get the months
            int loanMonths = loanLength * 12;
            //divide annual interest rate by 12 to get monthly
            double monthlyInterest = yearlyInterestRate / 12;

            //Formula to calculate the monthly payment
            double monthlyPayment = numPrincipal * (monthlyInterest * Math.pow(1 + monthlyInterest, loanMonths) / (Math.pow(1 + monthlyInterest, loanMonths) - 1));
            //Total interest formula
            double totalInterest = loanMonths * monthlyPayment - numPrincipal;

            System.out.printf("Your monthly payment is %.2f\n", monthlyPayment);
            System.out.printf("Your total interest is %.2f\n", totalInterest);
        }
        //Calc 2 calculates the future value
        else if (calcNumber == 2) {

            //Asks for deposit, interest rate, and years til maturity from user
            System.out.print("How much will you deposit? ");
            double numDeposit = calcScanner.nextDouble();
            System.out.print("What is the interest rate? ");
            double yearlyInterest = calcScanner.nextDouble();
            System.out.println("How many years for it to mature? ");
            int numYears = calcScanner.nextInt();
            yearlyInterest /= 100;
            //dividing by 365 to get the daily interest rate
            yearlyInterest /= 365;
            //multiplying by 365 to get years in terms of days
            int numDaysInYears = numYears * 365;

            //formula for calculating the future value
            double futureValue = numDeposit * Math.pow(1 + yearlyInterest, numDaysInYears);
            //total interest formula
            double totalInterest2 = futureValue - numDeposit;

            System.out.printf("Your matured balance is: %.2f\n", futureValue);
            System.out.printf("Your total interest earned is: %.2f\n", totalInterest2);
        }
        //Calc 3 for calculating present value of an ordinary annuity
        else {
            //Asks for length of annuity, annual interest rate, amount paid each period
            System.out.print("Enter how much you pay per period: ");
            double paymentAmount = calcScanner.nextDouble();
            System.out.print("Enter your annual interest rate: ");
            double intRate = calcScanner.nextDouble();
            System.out.print("Enter the length of the annuity: ");
            int annuityLength = calcScanner.nextInt();

            intRate /= 100;

            //Formula for present value of ordinary annuity that I found on google
            double presentValue = paymentAmount * (1 - Math.pow(1 + intRate, -annuityLength)) / intRate;

            //prints present value
            System.out.printf("The present value of your annuity is: %.2f", presentValue);
        }
    }
}
