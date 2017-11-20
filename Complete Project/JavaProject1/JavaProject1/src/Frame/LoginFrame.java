/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

/**
 *
 * @author Jamil
 */

import Sensor.*;
import Database.*;
import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame
{
    public LoginFrame()
    {
        super("Admin Login Page!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(600,500);
        this.setAlwaysOnTop(true);
        setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
        
        setLayout(new GridBagLayout());
    
        JLabel warning = new JLabel("Authorized Personal Only");
        warning.setFont(new Font("Serif", Font.BOLD, 50));
        warning.setForeground(Color.RED);
        
        JLabel userName = new JLabel("UserName");
        userName.setFont(new Font("Serif", Font.BOLD, 20));
        
        JTextField userNameField = new JTextField(30);
        userNameField.setName("username");
        userNameField.setPreferredSize(new Dimension(30,30));
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Serif", Font.BOLD, 20));
        
        JPasswordField passwordField = new JPasswordField(30);
        passwordField.setName("password");
        passwordField.setPreferredSize(new Dimension(30,30));
        
            
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(60,0,0,0);
        
        c.gridx = 1;
        int i = 0;
        
        c.gridy = ++i;
        add(warning,c);
        
        c.gridy = ++i;
        add(userName,c);
        
        c.insets = new Insets(0,0,0,0);
        
        c.gridy = ++i;
        add(userNameField,c);
        
        c.insets = new Insets(30,0,0,0);
        
        c.gridy = ++i;
        add(password,c);
        
        c.insets = new Insets(0,0,0,0);
        
        c.gridy = ++i;
        add(passwordField,c);
        
        c.insets = new Insets(20,0,0,0);
        
        c.gridy = ++i;
        
        JLabel msg = new JLabel();
        add(msg,c);

        
        KeySensor ks = new KeySensor(this,userNameField,passwordField,msg);
        userNameField.addKeyListener(ks);
        passwordField.addKeyListener(ks);
        
    }
    
  
    
}
