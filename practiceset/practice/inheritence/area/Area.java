
abstract class areacal{
    abstract void calarea();
} 
class traingle extends areacal{
    int base,height;
    void getdata(int base,int height){
        this.height=height;
        this.base=base;
    }
    void calarea() {
        System.out.println(0.5*height*base);
        
    }
}
class rec extends areacal{
    int h,b;
    void getdata(int h,int b){
        this.b=b;
        this.h=h;
    }
    void calarea(){
        System.out.println(h*b);
    }
}
 class Area {
    
    public static void main(String[] args) {
        traingle t=new traingle();
        t.getdata(5,7);
        t.calarea();
    }
}
