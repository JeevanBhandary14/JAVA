import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class SalaryImpl extends UnicastRemoteObject implements SalaryInterface {

    protected SalaryImpl() throws RemoteException {
        super();
    }

    public double calculateDA(double basic) throws RemoteException {
        return basic * 0.10; // Assuming DA is 10% of basic
    } 

    public double calculateHRA(double basic) throws RemoteException {
        return basic * 0.20; // Assuming HRA is 20% of basic
    }
 
    public double calculateNetSalary(double basic) throws RemoteException {
        double da = calculateDA(basic);
        double hra = calculateHRA(basic);
        return basic + da + hra;
    }
}
