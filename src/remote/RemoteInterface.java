/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import client.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Druia
 */
public interface RemoteInterface extends Remote {

    public void addClient(String name, String details) throws RemoteException;

    public ArrayList<Client> getClients() throws RemoteException;

    public void addFund(String name, String ticker, double amount, int client) throws RemoteException;

    public void addTransaction(String ticker, double amount, String direction) throws RemoteException;
}
