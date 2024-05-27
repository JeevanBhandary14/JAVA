import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class concat extends JFrame {
    public concat(){
        setTitle("concat");
        setSize(300,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lb1=new JLabel("First String");
        JTextField txt1=new JTextField(10);
        JLabel lbl=new JLabel("              ");
        JLabel lb2=new JLabel("Second String");
        JTextField txt2=new JTextField(10);
        JTextField ans=new JTextField(10);
        JButton btn=new JButton("concat");
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String txt1val=txt1.getText();
                String txt2val=txt2.getText();
                
                ans.setText(txt1val+txt2val);
                try {
                    
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
                String sql="insert into concat(string)values(?)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1,(txt1val+ txt2val));
                ps.executeUpdate();
            } catch (Exception es) {
                // TODO: handle exception
            }
            }
            
        });

        add(lb1);
        add(txt1);
        add(lbl);
        add(lb2);
        add(txt2);
        add(btn);
        add(ans);
        setVisible(true);
    }
    public static void main(String[] args) {
        new concat();
    }
}
