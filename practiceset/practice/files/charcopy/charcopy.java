import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class charcopy {
    public static void main(String[] args) {
        try {
            
      
        FileReader fis=new FileReader("f1");
        FileWriter fos=new FileWriter("f2");


        char[] buffer=new char[1024];
        int charRead;

        while((charRead=fis.read(buffer))!=-1){
            fos.write(buffer,0,charRead);
        }
        fis.close(); 

        fos.close();
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
    }
     }
}
