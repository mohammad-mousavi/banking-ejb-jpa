package com.mohammad.banking.service;

public interface ITransferServiceRemote {
    
    void transfer(int sourceAccount, 
                  int destinationAccount,
                  long amount);

}
