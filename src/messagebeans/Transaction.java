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
public class Transaction implements java.io.Serializable {

    private int id;
    private String ticker;
    private double amount;
    private String direction;
    private int client;

    public Transaction() {
    }

    public Transaction(int id, String ticker, double amount, String direction) {
        this.id = id;
        this.ticker = ticker;
        this.amount = amount;
        this.direction = direction;
    }

    public Transaction(int id, String ticker, double amount, String direction, int client) {
        this.id = id;
        this.ticker = ticker;
        this.amount = amount;
        this.direction = direction;
        this.client = client;
    }

    public Transaction(int id, double amount, String direction) {
        this.id = id;
        this.amount = amount;
        this.direction = direction;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String toString() {
        return ticker + " " + amount + " " + direction;
    }
}
