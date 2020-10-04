package com.gothosystems;

import java.awt.*;
import java.sql.SQLOutput;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int PERCENT = 100;
        final int MONTHS = 12;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        int principal, numberOfPayments;
        float annualInterest, monthlyInterest;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            else
                System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 5) {
                annualInterest = annualInterest / PERCENT;
                monthlyInterest = annualInterest / MONTHS;
                break;
            }
            else
                System.out.println("Enter a value greater than 0 and less or equal to 5");
        }

        while (true) {
            System.out.print("Period (Years): ");
            numberOfPayments = scanner.nextInt();
            if (numberOfPayments >= 1 && numberOfPayments <= 30) {
                numberOfPayments = numberOfPayments * MONTHS;
                break;
            }
            else
                System.out.println("Enter a value between 1 and 30");
        }

        double totalInterest = Math.pow((1 + monthlyInterest), numberOfPayments);
        double mortgagePayment = principal
                                * ((monthlyInterest * totalInterest)
                                / (totalInterest - 1));

        System.out.println("Mortgage: " + currency.format(mortgagePayment));
    }
}
