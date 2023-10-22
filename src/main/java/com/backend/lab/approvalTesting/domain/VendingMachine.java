package com.backend.lab.approvalTesting.domain;

import java.util.*;

public class VendingMachine {

    private String display;
    private List<Integer> coins;
    private Integer balance;
    private String selectedProduct;

    private String dispensedProduct;
    private List<Integer> returns;

    private List<Integer> bank;

    private Map<String, Integer> stock;

    private Map<String, Integer> prices;
    private Integer[] acceptedCoins;



    public VendingMachine(String selectedProduct, HashMap<String, Integer> stock) {
        this("", new ArrayList<>(), 0, selectedProduct, null, new ArrayList<>(), new ArrayList<>(), stock, (HashMap<String, Integer>) Map.of("Cola", 100, "Chips", 50, "Candy", 65), new Integer[]{1, 5, 10, 25});
    }

    public VendingMachine(String display, List<Integer> coins, Integer balance,
                          String selectedProduct, String dispensedProduct, List<Integer> returns, List<Integer> bank,
                          HashMap<String, Integer> stock, HashMap<String, Integer> prices, Integer[] acceptedCoins) {
        this.display = display;
        this.coins = coins;
        this.balance = balance;
        this.selectedProduct = selectedProduct;
        this.dispensedProduct = dispensedProduct;
        this.returns = returns;
        this.bank = bank;
        this.stock = stock;
        this.prices = prices;
        this.acceptedCoins = acceptedCoins;

        displayBalance();
    }

    private void displayBalance() {
        if(this.balance != 0){
            this.display = String.valueOf(this.balance);
        }
        else{
            this.display = "INSERT COIN";
        }
    }

    public void insertCoin(Integer coin){
        if(Arrays.asList(acceptedCoins).contains(coin)){
            this.coins.add(coin);
            this.balance += coin;
            this.displayBalance();
        }
        else{
            this.returns.add(coin);
        }
    }

    public Integer balance() {
        return balance;
    }

    public Integer[] coins() {
        return coins.toArray(new Integer[0]);
    }

    public String display() {
        return display;
    }

    public List<Integer> returns() {
        return returns;
    }

    public List<Integer> returnCoins(){
        this.balance = 0;
        this.returns = this.coins;
        this.coins = new ArrayList<>();
        this.displayBalance();

        return this.returns;
    }
}
