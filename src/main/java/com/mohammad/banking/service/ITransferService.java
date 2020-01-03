package com.mohammad.banking.service;

import com.mohammad.banking.entity.BankAccount;
import com.mohammad.banking.exception.AccountNotFoundException;

public interface ITransferService {
    
    void transfer(int sourceAccount, 
                  int destinationAccount,
                  long amount);
            
    BankAccount findByNumber(int number) throws AccountNotFoundException;
    
    void save(BankAccount ba);
    
}
