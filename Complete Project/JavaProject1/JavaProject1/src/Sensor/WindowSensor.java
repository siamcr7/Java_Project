/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Database.indexClass;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jamil
 */
public class WindowSensor extends WindowAdapter
{

    JFrame jf,parJf;
    static JFrame startF;
    static Stack st;
    
    public WindowSensor(JFrame jf)
    {
        this.jf = jf;
    }

    public WindowSensor(JFrame jf,JFrame parJf)
    {
        this.jf = jf;
        this.startF = parJf;
    }


    public void windowClosing(WindowEvent we)
    {

        try
        {
            System.out.println("Window is closing");
             

//        int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Warning!", JOptionPane.YES_NO_CANCEL_OPTION);
        
//        if(conformation == JOptionPane.YES_OPTION)
//        {
//             jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jf.setVisible(false);
            indexClass icStack = new indexClass();
            if(jf!=icStack.getStartFrame())
            {
                icStack.setAllFrameAlwaysOnTop(false);
//                parJf = icStack.getParent(jf);

//                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back to " + parJf.getTitle()+"?", "Going Back", JOptionPane.YES_NO_CANCEL_OPTION);
//                if(conformation == JOptionPane.YES_OPTION)
//                {
                    parJf = icStack.frameClosed(jf);
                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    parJf.setVisible(true);
//                }
                icStack.setAllFrameAlwaysOnTop(true);
                
            }
             
            else if(jf==icStack.getStartFrame() )
            {
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the Program?", "Exit Warning!", JOptionPane.YES_NO_CANCEL_OPTION);
                if (conformation == JOptionPane.YES_OPTION)
                {
//                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    System.exit(0);
                }
                icStack.setAllFrameAlwaysOnTop(true);
            }
//        }



//            System.exit(0);
        }
        catch (Exception ex)
        {
            Logger.getLogger(WindowSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
