/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

import Frame.*;
import Sensor.*;
import Database.*;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Jamil
 */
public class JavaProject1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException
    {
        // TODO code application logic here
        indexClass ic = new indexClass();
        DataAccess da = new DataAccess();

        StartFrame sf = new StartFrame();
//        ic.frameOpened(sf);
        ic.setStartFrame(sf);
        sf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        sf.addWindowListener(new WindowSensor(sf));
        sf.setVisible(true);

        /// beta tes frame
//        betaFrame sf = new betaFrame();
//        sf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        sf.addWindowListener(new WindowSensor(sf));
//        sf.setVisible(true);
        ///AdminFrame    
//        AdminFrame af = new AdminFrame();
//        af.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        af.addWindowListener(new WindowSensor(af));
//        af.setVisible(true);
        /// team Search Frame
//        TeamSearchFrame sf = new TeamSearchFrame();
//        sf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        sf.addWindowListener(new WindowSensor(sf));
//        sf.setVisible(true);
//        DataAccess da=new DataAccess();
//        ResultSet rs=null;
//        
//        rs=da.getData("select * from team where teamid = 1");
//        while(rs.next()){
//            int gp = rs.getInt("gameplayed");
//            
//            System.out.println(gp);
//        }
//        da.close();
    }

}
