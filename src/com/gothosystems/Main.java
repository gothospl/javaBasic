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

        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest Rate: ");
        double annualInterest = scanner.nextDouble() / PERCENT;
        double monthlyInterest = annualInterest / MONTHS;

        System.out.print("Period (Years): ");
        int numberOfPayments = scanner.nextInt() * MONTHS;
        double totalInterest = Math.pow((1 + monthlyInterest), numberOfPayments);
        double mortgagePayment = principal * ((monthlyInterest * totalInterest) / (totalInterest - 1));

        System.out.println("Mortgage: " + currency.format(mortgagePayment));
    }
}
