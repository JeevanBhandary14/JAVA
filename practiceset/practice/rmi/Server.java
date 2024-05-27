import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) {
        try {
            SalaryImpl calculator = new SalaryImpl();
            Registry registry = LocateRegistry.createRegistry(1199);
            registry.rebind("SalaryCalculator", calculator);
            System.out.println("Salary Calculator Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
 