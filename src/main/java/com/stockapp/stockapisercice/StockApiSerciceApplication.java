package com.stockapp.stockapisercice;

import com.stockapp.stockapisercice.stockApp.Logger;
import com.stockapp.stockapisercice.stockApp.RemoteURLReader;
import com.stockapp.stockapisercice.stockApp.Trader;
import com.stockapp.stockapisercice.stockApp.TradingApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class StockApiSerciceApplication {
    @Autowired
    TradingApp app;

    @Autowired
    Trader trader;
    @Autowired
    Logger logger;


    public static void main(String[] args) {
        SpringApplication.run(StockApiSerciceApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a stock symbol (for example aapl):");
        String symbol = keyboard.nextLine();
        System.out.println("Enter the maximum price you are willing to pay: ");
        double price;
        try {
            price = keyboard.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Enter a number");
            return;
        }
        app.showResult(symbol, price);
    }
}
