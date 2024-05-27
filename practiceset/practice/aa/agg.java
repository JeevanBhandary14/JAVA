class Employee{
    public String name;
    public int sal;
    public Employee(String name,int sal){
        this.sal=sal;
        this.name=name;
    }

    public String getname(){
        return name;
    } 

    public int getSal(){
        return sal;
    }
}

class Salary{
    Employee e;

    public Salary(Employee e){
        this.e=e;
    }

    public double calda(){
        return 0.05*e.sal;
    }

    public double calhra(){
        return 0.6*e.sal;
    }
    
    public double net(){
        return (e.sal+calda()+calhra());
    }
}
public class agg {
    public static void main(String[] args) {
        Employee e=new Employee("asd",300);
        Salary s=new Salary(e);
        System.out.println("The salary:"+e.getSal());
        System.out.println("The da:"+s.calda());
        System.out.println("The hra:"+s.calhra());
        System.out.println("Total:"+s.net());
    }
}
