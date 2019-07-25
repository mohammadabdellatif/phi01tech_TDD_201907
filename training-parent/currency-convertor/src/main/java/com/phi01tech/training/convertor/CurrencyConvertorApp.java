package com.phi01tech.training.convertor;

import java.util.Scanner;

// implement a console based application that accepts:
// a currency code from
// currency code to
// amount
// then display the converted amount
public class CurrencyConvertorApp {

    // Strategy design pattern
    private RateProvider rateProvider;

    public CurrencyConvertorApp(RateProvider rateProvider) {
        this.rateProvider = rateProvider;
    }


    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter from to amount:");
        String from = scanner.next();
        String to = scanner.next();
        double amount = scanner.nextDouble();

        double exchangeRate = rateProvider.getExchangeRate(from, to);
        double convertedValue = amount * exchangeRate;
        System.out.println(convertedValue);
    }

}
