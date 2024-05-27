class customExp extends Exception{
    customExp(String err){
        super(err);
    }
}
public class Custom {
    public static void arth() throws ArithmeticException{
        System.out.println("Solution:"+(10/0));
    }

    public static void less(int n) throws customExp{
        if(n<10){
            throw new customExp("number is less");
        }
    }

    public static void main(String[] args) {
        try {
            arth();
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

        
        try {
            int n=15;
            less(n);
        } catch (customExp e) {
            System.out.println(e);
        }
    }
}
