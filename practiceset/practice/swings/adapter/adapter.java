import javax.swing.*;
import java.awt.event.*;

public class adapter extends JFrame {

    public adapter(){
        setTitle("sdemo");
        setSize(300,400);

        JTextArea txt=new JTextArea();
        txt.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e){
                System.out.println("The key pressed:"+e.getKeyChar()+" the code:"+e.getKeyCode());
            }
        }); 
        add(txt); 
        setVisible(true);
    }


    public static void main(String[] args) {
        new adapter();
    }
}
