/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagebeans;

/**
 *
 * @author Druia
 */
public class Fund implements java.io.Serializable {

    private int id;
    private String ticker;
    private String name;
    private double amount;
    private int client;

    public Fund() {
    }

    public Fund(String ticker, String name, double amount) {
        this.ticker = ticker;
        this.name = name;
        this.amount = amount;
    }

    public Fund(int id, String ticker, String name, double amount) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.amount = amount;
    }

    public Fund(int id, String ticker, String name, double amount, int client) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.amount = amount;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return name + " " + amount + " " + client;
    }

}
