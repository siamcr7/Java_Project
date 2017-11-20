/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

/**
 *
 * @author Jamil
 */
public class MouseMotionSensor implements MouseMotionListener{
    JFrame jf;
    JButton jb;
    
    public MouseMotionSensor(JFrame jf)
    {
        this.jf = jf;
    }
    
    public MouseMotionSensor(JButton jb)
    {
        this.jb = jb;
    }
    //MouseMotionListener methods :
    public void mouseDragged(MouseEvent me){
        //System.out.println("Mouse dragged at, x : "+me.getX()+", y: "+me.getY());
    }
    public void mouseMoved(MouseEvent me){
        //System.out.println("Mouse moving at, x : "+me.getX()+", y: "+me.getY());
        Object c = me.getSource();
        
        if(c instanceof JButton)
        {
            Cursor crs = new Cursor(Cursor.HAND_CURSOR);
            
            JButton jbl = new JButton();
            jbl = (JButton)c;
            
            jbl.setCursor(crs);
            
            String s = jbl.getText();
            System.out.println("Mouse entered into "+s);
        }
        if (c instanceof JMenuItem)
        {
            Cursor crs = new Cursor(Cursor.HAND_CURSOR);

            JMenuItem jbl = new JMenuItem();
            jbl = (JMenuItem) c;

            jbl.setCursor(crs);

            String s = jbl.getText();
            System.out.println("Mouse entered into " + s);
        }
        
      
    }
}
