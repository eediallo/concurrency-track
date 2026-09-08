package bankaccount;

public class BankAccount {
    private int balance = 120;

    private final Object lock = new Object();

    public int getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    public void withdraw(int amount) {
        System.out.println("[" + Thread.currentThread().getName() + "] withdrawing money");
        synchronized (lock) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("[" + Thread.currentThread().getName() + "] withdrew. Balance: £" + balance);
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "]  finished their transaction");

    }


    static void main() throws InterruptedException {
        BankAccount bankAccount = new BankAccount();

        Thread tA = new Thread(() -> {
            bankAccount.withdraw(50);
        });

        Thread tB = new Thread(() -> {
            bankAccount.withdraw(50);
        });

        tA.start();
        tB.start();

        tB.join();
        tA.join();


        int balance = bankAccount.getBalance();
        System.out.println( "[" + Thread.currentThread().getName() +  "] Remaining Balance: " + balance);

    }
}
