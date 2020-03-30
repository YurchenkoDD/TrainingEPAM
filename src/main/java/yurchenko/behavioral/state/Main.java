package yurchenko.behavioral.state;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("dd", 100);
        account.deposit(1000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(4000);
        account.withdraw(1000);
        account.withdraw(1000);
    }
}