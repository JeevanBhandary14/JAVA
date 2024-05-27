package files.bytecopy;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class filecopy {
    public static void main(String[] args) {
        try {
            
        FileInputStream fis=new FileInputStream("f1");
        FileOutputStream fos=new FileOutputStream("f2");

        byte[] buffer=new byte[1024];
        int byteRead;
        while((byteRead=fis.read(buffer))!=-1){
            fos.write(buffer,0,byteRead);
        }
    } catch (Exception e) {
        // TODO: handle exception
    }
    }
}
