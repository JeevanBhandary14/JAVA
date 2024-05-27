import javax.swing.*;
import java.awt.event.*;

public class Keyss extends JFrame implements KeyListener {
    
    Keyss(){
        setTitle("Demo");
        setSize(300,300);

        JTextArea txt=new JTextArea();
        txt.addKeyListener(this);
        add(txt); 

        setVisible(true);
    }

    public void keyPressed(KeyEvent e){
        System.out.println("The key pressed"+e.getKeyChar()+" the code"+e.getKeyCode());
    }
    public void keyTyped(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){
  
    }

 
    public static void main(String[] args) {
        new Keyss();
    }
}
