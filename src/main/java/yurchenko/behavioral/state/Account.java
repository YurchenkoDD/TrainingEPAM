package yurchenko.behavioral.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

    private static final Logger log = LoggerFactory.getLogger(Account.class);
    private AccountState state;
    private String owner;
    private double balance;

    public Account(String owner, double initBalance) {
        this.owner = owner;
        this.balance = initBalance;
        this.state = new NormalState(this);
        log.info(this.owner + " balance: " + initBalance);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void deposit(double amount) {
        log.info(this.owner + " deposit: " + amount);
        state.deposit(amount);
        log.info("Balance: " + this.balance);
        log.info("State: " + this.state.getClass().getName());
    }

    public void withdraw(double amount) {
        log.info(this.owner + " withdraw " + amount);
        state.withdraw(amount);
        log.info("Balance: " + this.balance);
        log.info("State: " + this.state.getClass().getName());
    }

    public void computeInterest() {
        state.computeInterest();
    }
}
