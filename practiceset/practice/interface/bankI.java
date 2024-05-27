import java.util.Scanner;

interface Bank {
    public void readCustomerInfo();
}

interface ICICI extends Bank {
    public void calucalteI();

    public void display();
}

interface AXIS extends Bank {
    public void calucalteI();

    public void display();
}

class ICICIBankClass implements ICICI {
    Scanner sc = new Scanner(System.in);

    int amount = 0;

    public void readCustomerInfo() {
        amount = sc.nextInt();
    }

    public void calucalteI() {
        amount += amount * 0.008;
    }

    public void display() {
        System.out.println("ICIIC bank interest:" + amount);
    }
}

class AXISBank implements AXIS {
    Scanner sc = new Scanner(System.in);

    int amount = 0;

    public void readCustomerInfo() {
        amount = sc.nextInt();
    }

    public void calucalteI() {
        amount += amount * 0.018;
    }

    public void display() {
        System.out.println("AXIS bank interest:" + amount);
    }
}

public class bankI {

    public static void main(String[] args) {
        AXISBank ab = new AXISBank();
        ICICIBankClass ibc = new ICICIBankClass();
        ab.readCustomerInfo();
        ab.calucalteI();
        ab.display();

        ibc.readCustomerInfo();
        ibc.calucalteI();
        ibc.display();

    }
}
