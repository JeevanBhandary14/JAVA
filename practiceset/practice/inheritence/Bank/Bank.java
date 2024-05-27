class BankEmp{
    
    void calSal(String name,float sal){}
    
    
}

class Manger extends BankEmp{
    void calSal(String name,float sal){
        System.out.println("The name is:"+name +" And the salary is:"+(sal+=(sal*0.16)));
    }
}

class staff extends BankEmp{
    void calSal(String name,float sal){
        System.out.println("The name is:"+name +" And the salary is:"+(sal+=(sal*0.08)));
    }
}

class intern extends BankEmp{
    void calSal(String name,float sal){
        System.out.println("The name is:"+name +" And the salary is:"+(sal+=(sal*0.04)));
    }
    void position(String name){
        
    }
}

class pos extends intern{
    void calSal(String name,float sal){
        System.out.println("The name is:"+name +" And the salary is:"+(sal+=(sal*0.06)));
    }

    void position(String name){
        System.out.println("Grade is A of intern:"+name);
    }
}
class Bank {
    public static void main(String[] args) {
        Manger m=new Manger();
        m.calSal("Ramu",70000);

        staff s=new staff();
        s.calSal("Sanjiv",40000);

        intern i=new intern();
        i.calSal("vijar",8000);

        pos p=new pos();
        p.calSal("Ranvijay", 8000);
        p.position("Ranvijay");
    }
}
