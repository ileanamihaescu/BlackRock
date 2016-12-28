/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Druia
 */
@Entity
@Table(name = "funds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funds.findAll", query = "SELECT f FROM Funds f"),
    @NamedQuery(name = "Funds.findById", query = "SELECT f FROM Funds f WHERE f.id = :id"),
    @NamedQuery(name = "Funds.findByTicker", query = "SELECT f FROM Funds f WHERE f.ticker = :ticker"),
    @NamedQuery(name = "Funds.findByName", query = "SELECT f FROM Funds f WHERE f.name = :name"),
    @NamedQuery(name = "Funds.findByAmount", query = "SELECT f FROM Funds f WHERE f.amount = :amount"),
    @NamedQuery(name = "Funds.findByClient", query = "SELECT f FROM Funds f WHERE f.client = :client")})
public class Funds implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ticker")
    private String ticker;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @Column(name = "client")
    private int client;

    public Funds() {
    }

    public Funds(Integer id) {
        this.id = id;
    }

    public Funds(Integer id, String ticker, String name, double amount, int client) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.amount = amount;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funds)) {
            return false;
        }
        Funds other = (Funds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbbeans.Funds[ id=" + id + " ]";
    }
    
}
