/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Database.DataAccess;
import Database.indexClass;
import Frame.*;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Jamil
 */
public class KeySensor implements KeyListener
{
    JFrame jf;
    JTextField username;
    JLabel msg ;
    JPasswordField pass;
    private int x,y;

    public KeySensor(JFrame m,JTextField u,JPasswordField p,JLabel ms)
    {
        jf = m;
        username = u;
        pass = p;
        msg = ms;
    }
    
    
    public void keyTyped(KeyEvent ke)
    {
        //System.out.println(ke.getKeyChar()+" is typed");
    }
    
    public void keyPressed(KeyEvent ke)
    {
//        Object ob = ke.getSource();
//        
//        if(ob instanceof JTextField)
//        {
//            JTextField jft = (JTextField)ob;
//            String sFieldName = jft.getName();
//            {
//                if(ke.getKeyCode() == KeyEvent.VK_ENTER && sFieldName == "username")
//                {
//                    
//                    String username  = jft.getText();
//                    System.out.println("Entered : "+sFieldName);
//                }
//                if(ke.getKeyCode() == KeyEvent.VK_ENTER && sFieldName == "password")
//                {
//                    
//                    String password = jft.getText();
//                    System.out.println("Entered2 : "+sFieldName);
//                }
//            }
//        }  
        /// !!! THE ABOVE CODE WILL BE REALLY HELPFUL IF WE WANT TO TYPE AND PRESS ENTER IN A JTEXTFIELD! :D
        
        if(ke.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                String us = username.getText();
                String ps = new String(pass.getPassword());

                indexClass ic = new indexClass();
                DataAccess da=new DataAccess();
                ResultSet rs=null;
                rs=da.getData("select * from admin");
                
                boolean match = false;
                while(rs.next())
                {
                    String usernameDB = rs.getString("username");
                    String passwordDB = rs.getString("password");
                    
                    if(us.equals(usernameDB)== true && ps.equals(passwordDB) == true)
                    {
                        match = true;
                        break;
                    }
                }
                
                
                if(match)
                {
                    msg.setText("You are logged out!");
                    username.setText("");
                    pass.setText("");
                    
                    System.out.println("Successful Login!");
                    AdminFrame af = new AdminFrame(us);
                    indexClass icStack = new indexClass();
                    if(jf!=icStack.getStartFrame())jf.setVisible(false);
                    icStack.frameOpened(af,jf);
                    af.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    af.addWindowListener(new WindowSensor(af));
                    af.setVisible(true);
                }
                
                else
                {
                    System.out.println("pass not match");
                    msg.setText("username and password don't match!");
                    
                }
            }
            //System.out.println(ke);
            //System.out.println(ke.getKeyChar()+" is pressed");
//        if(ke.getKeyChar() == 'w' || ke.getKeyCode() == KeyEvent.VK_UP)
//        {
//            y = mf2.getY();
//            y -= 50;
//            mf2.setY(y);
//        }
//        
//        if(ke.getKeyChar() == 's' || ke.getKeyCode() == KeyEvent.VK_DOWN)
//        {
//            y = mf2.getY();
//            y += 50;
//            mf2.setY(y);
//        }
//        
//        if(ke.getKeyChar() == 'a' || ke.getKeyCode() == KeyEvent.VK_LEFT)
//        {
//            x = mf2.getX();
//            x -= 50;
//            mf2.setX(x);
//        }
//        
//        if(ke.getKeyChar() == 'd' || ke.getKeyCode() == KeyEvent.VK_RIGHT)
//        {
//            x = mf2.getX();
//            x += 50;
//            mf2.setX(x);
//        }
            //mf2.repaint();
            catch (SQLException ex) {
                //Logger.getLogger(KeySensor.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error from KeySensor cuz of admin log in!");
            }
        }
        
        
    }
    
    public void keyReleased(KeyEvent ke)
    {
        //System.out.println(ke);
        //System.out.println(ke.getKeyChar()+" is released");
    }
}
