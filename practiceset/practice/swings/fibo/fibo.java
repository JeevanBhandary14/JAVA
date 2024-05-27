import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class fibo extends JFrame{
    public fibo(){
        setTitle("Fibo");
        setSize(300,300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lb=new JLabel("Enter Fibonacci N:");
        JTextField txt=new JTextField(10);
        JButton btn=new JButton("Calculate");
        JTextArea Txtans=new JTextArea();

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    int val=Integer.parseInt(txt.getText());
                    String ans=fibofun(val);
                    Txtans.setText(ans);
            }
        } );

        add(lb);
        add(txt);
        add(btn);
        add(Txtans);
        setVisible(true);
    }

    public String fibofun(int val){
        StringBuilder sb=new StringBuilder();
        if(val==1){
            return "0";
        }
        if(val==2){
            return "0 1";
        }
        int f1=0,f2=1,f3=0;
        sb.append(f1).append(" ").append(f2);
        for(int i=2;i<val;i++){
            f3=f1+f2;
            sb.append(" ").append(f3);
            f1=f2;
            f2=f3;
        }
        return sb.toString();


    }
    public static void main(String[] args) {
        new fibo();
    }
}
