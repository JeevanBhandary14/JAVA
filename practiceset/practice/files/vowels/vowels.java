import java.io.FileInputStream;
import java.io.IOException;

public class vowels {
    public static void main(String[] args) {
        try  {
            FileInputStream fis = new FileInputStream("f1");
            int byteRead;
            int digits = 0;
            int vowels = 0;
            int consonants = 0;

            while ((byteRead = fis.read()) != -1) {
                char ch = (char) byteRead;

               if(Character.isDigit(ch)){
                    digits++;
               }else if(Character.isLetter(ch)){
                    char temp=Character.toLowerCase(ch);
                    if(temp=='a'||temp=='e'||temp=='i'||temp=='o'||temp=='u'){
                        vowels++;
                    }else{
                        consonants++;
                    }
               }
            }

            // Display the counts
            System.out.println("Number of digits: " + digits);
            System.out.println("Number of vowels: " + vowels);
            System.out.println("Number of consonants: " + consonants);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
