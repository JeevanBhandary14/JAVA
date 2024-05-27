import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class fact extends JFrame {
    public fact() {
        setTitle("Factorial");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed
        
        // Set layout manager
        setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Enter a number:");
        JTextField txt1 = new JTextField(10);
        JButton btn = new JButton("Calculate");
        JLabel ans = new JLabel("Result:");

        // Add action listener to the button
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(txt1.getText());
                    int r = calculate(num);
                    ans.setText("Result: " + r);
                } catch (NumberFormatException ex) {
                    ans.setText("Invalid input! Please enter a number.");
                }
            }
        });

        // Add components to the frame
        add(promptLabel);
        add(txt1);
        add(btn);
        add(ans);

        // Set frame visibility
        setVisible(true);
    }

    // Corrected method name
    public int calculate(int num) {
        int r = 1;
        for (int i = num; i > 0; i--) {
            r *= i;
        }
        return r;
    }

    public static void main(String[] args) {
        new fact();
    }
}
