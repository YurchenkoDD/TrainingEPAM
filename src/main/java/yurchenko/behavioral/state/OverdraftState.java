package yurchenko.behavioral.state;

public class OverdraftState extends AccountState {
    public OverdraftState(AccountState state) {
        this.account = state.account;
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    public void computeInterest() {
    }

    public void stateCheck() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        } else if (account.getBalance() <= -100) {
            account.setState(new RestrictedState(this));
        }
    }
}