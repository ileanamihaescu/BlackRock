/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Druia
 */
public class ClientController {

    private static ClientController singleton;

    private ClientController() {

    }

    public static ClientController getInstance() {
        if (singleton == null) {
            singleton = new ClientController();
        }
        return singleton;
    }

    public void addClient(String name, String details) {
        try {
            Client.ri.addClient(name, details);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Client> getClients() {
        try {
            return Client.ri.getClients();
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addFund(String name, String ticker, double amount, int client) {
        try {
            Client.ri.addFund(name, ticker, amount, client);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTransaction(String ticker, double amount, String direction) {
        try {
            Client.ri.addTransaction(ticker, amount, direction);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
