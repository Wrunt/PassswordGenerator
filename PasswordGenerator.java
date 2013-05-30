/*
 * Password Generator
 * Creates random password based off given length.
 */
package password.generator;
import java.awt.*;
import javax.swing.*;

public class PasswordGenerator {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame ("Password Generator");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,150));
        
        frame.getContentPane().add(new PasswordPanel());
        
        frame.pack();
        frame.setVisible(true);
    }
}
