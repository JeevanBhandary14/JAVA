import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Employee Number: ");
            int empNo = scanner.nextInt();
 
            System.out.print("Enter Employee Name: ");
            String empName = scanner.next();

            System.out.print("Enter Basic Salary: ");
            double basic = scanner.nextDouble();

            Registry registry = LocateRegistry.getRegistry("localhost", 1199);
            SalaryInterface calculator = (SalaryInterface) registry.lookup("SalaryCalculator");

            double da = calculator.calculateDA(basic);
            double hra = calculator.calculateHRA(basic);
            double netSalary = calculator.calculateNetSalary(basic);

            System.out.println("Employee Details:");
            System.out.println("Emp No: " + empNo);
            System.out.println("Emp Name: " + empName);
            System.out.println("Basic Salary: " + basic);
            System.out.println("DA: " + da);
            System.out.println("HRA: " + hra);
            System.out.println("Net Salary: " + netSalary);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
