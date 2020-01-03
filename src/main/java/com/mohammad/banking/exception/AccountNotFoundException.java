package com.mohammad.banking.exception;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException() {
        super("Bank Account Not Found!");
    }

}
