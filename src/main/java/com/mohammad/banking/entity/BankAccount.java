package com.mohammad.banking.entity;

import javax.persistence.*;

@Entity
@Table(name="TBL_ACCOUNT")
@NamedQueries({
        @NamedQuery(name="BankAccount.findByNumber",
                query="SELECT ba FROM BankAccount ba Where ba.number = :number"),
        @NamedQuery(name="BankAccount.findByOwner",
                query="SELECT ba FROM BankAccount ba Where ba.owner = :owner"),
        @NamedQuery(name="BankAccount.findByBalance",
                query="SELECT ba FROM BankAccount ba Where ba.balance = :balance")
})
public class BankAccount implements java.io.Serializable {

    @Id
    @Column(name="F_ID")
    private int id;
    @Column(name="F_NUMBER")
    private int number;
    @Column(name="F_OWNER")
    private String owner;
    @Column(name="F_BALANCE")
    private long balance;

    public BankAccount() {
    }

    public BankAccount(int number, String owner, long balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
