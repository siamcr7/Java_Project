/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

/**
 *
 * @author Jamil
 */
import Database.indexClass;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class MouseSensor implements MouseListener
{

    JFrame jf;

    String className;

    public MouseSensor(JFrame jf, String s)
    {
        this.jf = jf;
        this.className = s;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        try
        {
            Object ob = e.getSource();
            indexClass ic = new indexClass();
            if (e.getClickCount() == 1 && ob instanceof JTable)
            {
                JTable jtb = (JTable) ob;

                int row = jtb.getSelectedRow();
                int column = jtb.getSelectedColumn();
                Object tempOb = jtb.getValueAt(row, column);
                String select = (String) tempOb;
                select = select.toLowerCase();

                ButtonSensor bs = new ButtonSensor(jf, className);
                

                if (ic.getPlayerID(select) != 0)
                {
                    bs.openGeneralPlayerFrame(select);
                }
                else if (ic.getTeamID(select) != 0)
                {
                    bs.openGeneralTeamFrame(select);
                }
                

                System.out.println("Mouse Pressed at :" + jtb.getColumnName(column) + " and selected: " + select);
            }
            System.out.println("Mouse Pressed from " + className);

        }
        catch (SQLException ex)
        {
            Logger.getLogger(MouseSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
