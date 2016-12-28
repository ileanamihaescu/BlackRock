/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontrollers;

import dbbeans.Clients;
import messagebeans.Client;
import dbbeans.Funds;
import dbbeans.Transactions;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Druia
 */
public class MainController {

    private static MainController singleton;
    private ClientsJpaController clientController;
    private FundsJpaController fundController;
    private TransactionsJpaController transactionController;
    private EntityManagerFactory emf;

    private MainController() {
        emf = Persistence.createEntityManagerFactory("BLKPU");
        clientController = new ClientsJpaController(emf);
        fundController = new FundsJpaController(emf);
        transactionController = new TransactionsJpaController(emf);

    }

    public static MainController getInstance() {
        if (singleton == null) {
            singleton = new MainController();
        }
        return singleton;
    }

    public void addClient(String name, String details) {
        clientController.create(new Clients(0, name, details));
    }

    public ArrayList<Client> getClients() {
        List<Clients> clients = clientController.findClientsEntities();
        ArrayList<Client> list = new ArrayList<>();
        for (Clients c : clients) {
            list.add(new Client(c.getId(), c.getName()));
        }
        return list;
    }

    public void addFund(String name, String ticker, double amount, int client) {
        fundController.create(new Funds(0, ticker, name, amount, client));
    }

    public void addTransaction(String ticker, double amount, String direction) {
        transactionController.create(new Transactions(0, ticker, amount, direction, 0));
    }
}
