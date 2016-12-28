/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blk;

import client.Client;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import org.eclipse.persistence.sessions.server.Server;
import remote.RemoteInterface;
import dbcontrollers.MainController;
import java.util.ArrayList;

/**
 *
 * @author Druia
 */
public class BLK extends UnicastRemoteObject implements RemoteInterface {

    private Registry registry;

    public BLK() throws RemoteException {
        registry = LocateRegistry.createRegistry(4321);
        registry.rebind("server", this);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new BLK();
    }

    @Override
    public void addClient(String nume, String prenume) throws RemoteException {
        MainController.getInstance().addClient(nume, prenume);
    }

    @Override
    public ArrayList<Client> getClients() throws RemoteException {
        ArrayList<Client> clients = (ArrayList) MainController.getInstance().getClients();
        return clients;
    }

    @Override
    public void addFund(String name, String ticker, double amount, int client) throws RemoteException {
        MainController.getInstance().addFund(name, ticker, amount, client);
    }

    @Override
    public void addTransaction(String ticker, double amount, String direction) {
        MainController.getInstance().addTransaction(ticker, amount, direction);
    }

}
