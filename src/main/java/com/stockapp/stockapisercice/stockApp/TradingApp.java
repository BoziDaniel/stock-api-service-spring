package com.stockapp.stockapisercice.stockApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides a command line interface for stock trading.
 **/
@RestController
@Component
public class TradingApp {
    private Trader trader;


    public TradingApp(Trader trader) {
        this.trader = trader;

    }

    @GetMapping("/{symbol}/{price}")
    public String showResult(@PathVariable("symbol") String symbol, @PathVariable("price") double price) {
        String result = startWithInitials(symbol, price);
        System.out.println(result);
        return result;
    }

    public String startWithInitials(String symbol, double price) {
        String result;
        try {
            boolean purchased = trader.buy(symbol, price);
            if (purchased) {
                result = "Purchased stock!";
            } else {
                result = "Couldn't buy the stock at that price.";
            }
            return result;

        } catch (Exception e) {
            result = "There was an error while attempting to buy the stock: " + e.getMessage();
            return result;
        }
    }

}