package com.phi01tech.training.convertor;

// Encapsulation for what varies (or unknown)
public interface RateProvider {

    double getExchangeRate(String from, String to);
}
