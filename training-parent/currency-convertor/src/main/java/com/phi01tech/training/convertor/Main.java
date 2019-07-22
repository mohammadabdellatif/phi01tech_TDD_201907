package com.phi01tech.training.convertor;

public class Main {

    public static void main(String[] args) {
        RateProvider rateProvider = new RateProvider() {
            @Override
            public double getExchangeRate(String from, String to) {
                return 0.71;
            }
        };
        CurrencyConvertorApp app = new CurrencyConvertorApp(rateProvider);

        app.runApplication();
    }
}
