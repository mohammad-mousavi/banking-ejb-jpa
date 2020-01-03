package com.mohammad.banking.service;


import com.mohammad.banking.entity.BankAccount;
import com.mohammad.banking.exception.AccountNotFoundException;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(mappedName = "BankingService")
@Local(ITransferService.class)
@Remote(ITransferServiceRemote.class)
public class BankAccountService implements ITransferService, ITransferServiceRemote {

    @PersistenceContext(unitName = "myJPA")
    private EntityManager em;

    public BankAccountService() {
    }

    public void deposit(BankAccount e, long amount) {
        e.setBalance(e.getBalance() + amount);
    }

    public void withdraw(BankAccount e, long amount) {
        e.setBalance(e.getBalance() - amount);
    }

    public void transfer(int sourceAccount, int destinationAccount, long amount) {

        try {
            BankAccount source = findByNumber(sourceAccount);
            source.setBalance(source.getBalance() - amount);
            BankAccount destination = findByNumber(destinationAccount);
            destination.setBalance(destination.getBalance() + amount);
        } catch (Exception e) {
            System.out.println("Transfer Failed!");
        }

    }

    public void save(BankAccount ba) {
        em.persist(ba);
    }

    public BankAccount findByNumber(int number) throws AccountNotFoundException {
        BankAccount ba;
        Query q = em.createQuery("select ba from BankAccount ba where ba.number = :num");
        q.setParameter("num", number);
        try {
            ba = (BankAccount) q.getSingleResult();
        } catch (Exception e) {
            System.out.println("Account Not Found!");
            throw new AccountNotFoundException();
        }
        return ba;
    }

    public List findAll() {
        List list = null;
        Query q = em.createQuery("select ba from BankAccount ba");
        list = q.getResultList();
        return list;
    }

    public void update() {
    }

    public void delete() {
    }

}
