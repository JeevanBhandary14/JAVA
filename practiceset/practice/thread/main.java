class Bank {
    private int balance;

    public Bank(int val) {
        this.balance = val;
    }

    public synchronized void deposit(int val) {
        balance += val;


        System.out.println("Balance increased to:" + balance);
        notify();
    }

    public synchronized void withdraw(int val) {
        try {
            if (val > balance) {
                System.out.println("cannot withraw low balance");
                wait();
            } else {
                balance -= val;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int display() {
        return balance;
    }
}

class BankingThread extends Thread {
    Bank b;
    int amount;
    boolean decision;

    public BankingThread(Bank b, int val, boolean isDeposit) {
        this.b = b;
        this.amount = val;
        this.decision = isDeposit;
    }

    public void run() {
        if (decision == true) {
            b.deposit(amount);
        } else {
            b.withdraw(amount);
        }
    }
}

class main {
    public static void main(String[] args) {
        Bank b = new Bank(1000);

        Thread t1 = new BankingThread(b, 100, true);
        Thread t2 = new BankingThread(b, 10000, false);
        Thread t3 = new BankingThread(b, 10000, true);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Final balance: " + b.display());

    }
}
