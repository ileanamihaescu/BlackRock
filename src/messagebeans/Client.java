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
public class Client implements java.io.Serializable {

    private int id;
    private String name;
    private String details;

    public Client() {
    }

    public Client(int id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + details;
    }

}
