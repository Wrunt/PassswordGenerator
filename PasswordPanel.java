/*
 * Panel for PasswordGenerator
 * Listener generates password on button press.
 */
package password.generator;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class PasswordPanel extends JPanel {
    private JPanel controls;
    private JTextField length, lPass;
    private JButton gen;
   
    public PasswordPanel() {
        //uses label instead of text field so it's highlightable
        lPass = new JTextField ("Password will be here.");
        lPass.setBorder(null);
        lPass.setBackground(null);
        lPass.setEditable(false);
        lPass.setAlignmentX (Component.LEFT_ALIGNMENT);
        
        length = new JTextField ("Enter length - default is 12");
        length.setAlignmentX (Component.LEFT_ALIGNMENT);
        
        gen = new JButton ("Generate!");
        gen.setAlignmentX (Component.LEFT_ALIGNMENT);
        
        controls = new JPanel();
        BoxLayout layout = new BoxLayout (controls, BoxLayout.Y_AXIS);
        controls.setLayout (layout);
        controls.add (length);
        controls.add (Box.createRigidArea (new Dimension (0,20)));
        controls.add (gen);
        controls.add (Box.createRigidArea (new Dimension (0,20)));
        controls.add (lPass);
        add (controls);
        
        ButtonListener listener = new ButtonListener();
        gen.addActionListener (listener);
    }
    
    private class ButtonListener implements ActionListener {
        private char cPass;
        private int numP, passLength, var1, var2;
        private String sPass, sPassCurr, text;
        
        public void actionPerformed (ActionEvent event) {
            Random type = new Random ();
            StringBuilder builder = new StringBuilder();
            
            cPass = 0;
            sPass = "";
            sPassCurr = "";
            numP = 0;
            passLength = 0;
            var1 = 0;
            var2 = 0;
            
            text = length.getText();
            if (text.equals("Enter length - default is 12")) {
                passLength = 12;
            } else {
                    passLength = Integer.parseInt(text);
            }
            
            while (passLength > 0) {
                var1 = type.nextInt(4);
                switch (var1) {
                    case 0:
                        var2 = type.nextInt(10);
                        sPassCurr = Integer.toString(var2);
                        var2 = 0;
                        break;
                    case 1:
                        cPass = (char) (65 + type.nextInt(26));
                        sPassCurr = String.valueOf(cPass);
                        break;
                    case 2:
                        cPass = (char) (97 + type.nextInt(26));
                        sPassCurr = String.valueOf(cPass);
                        break;
                    case 3:
                        var2 = type.nextInt(9);
                        switch (var2) {
                            case 0:
                                sPassCurr = "!";
                                break;
                            case 1:
                                sPassCurr = "&";
                                break;
                            case 2:
                                sPassCurr = "*";
                                break;
                            case 3:
                                sPassCurr = "%";
                                break;
                            case 4:
                                sPassCurr = "$";
                                break;
                            case 5:
                                sPassCurr = "-";
                                break;
                            case 6:
                                sPassCurr = "+";
                                break;
                            case 7:
                                sPassCurr = "^";
                                break;
                            case 8:
                                sPassCurr = "#";
                                break;
                            case 9:
                                sPassCurr = "@";
                                break;
                        }
                        break;
                }
                
                builder.append(sPassCurr);
                
                cPass = 0;
                sPassCurr = "";
                numP = 0;
                var1 = 0;
                var2 = 0;
                
                passLength = passLength - 1;
            }
            
            sPass = builder.toString();
            lPass.setText(sPass);
        }
    }
}
