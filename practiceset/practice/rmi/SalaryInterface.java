import java.rmi.*;

public interface SalaryInterface extends Remote {
    public double calculateDA(double basic) throws RemoteException;
    public double calculateHRA(double basic) throws RemoteException;
    public double calculateNetSalary(double basic) throws RemoteException;
}
  