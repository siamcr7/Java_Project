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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TeamFrame extends JFrame 
{
    private String className = "TeamFrame";
    public TeamFrame()
    {
        super("Team Page!");
        try
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double widthh = screenSize.getWidth();
            double heightt = screenSize.getHeight();
            setSize((int) widthh - 450, (int) heightt - 250);
            this.setAlwaysOnTop(true);
            setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
            
            GridBagConstraints c = new GridBagConstraints();
            
            JLabel[] teamLogo = new JLabel[20];
            
            JButton[] teamName = new JButton[20];

            c.insets = new Insets(10,0,0,0);  /// (leftSpace,rightSpace,upSpace,downSpace)
            
            JPanel[] team = new JPanel[20];
            
            JPanel frameBackGround = new JPanel();
            frameBackGround.setBackground(Color.BLACK);
            frameBackGround.setLayout(new GridLayout(0, 2, 0, 0));

            ButtonSensor bs = new ButtonSensor(this, "Team Frame!");
            MouseMotionSensor ms = new MouseMotionSensor(this);
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;
            
            rs = da.getData("select * from team");
            while(rs.next())
            {
                String name = rs.getString("teamname");
                String img = rs.getString("teamlogo");
                int id = rs.getInt("teamid");
                
                team[id] = new JPanel();
                teamLogo[id] = new JLabel(new ImageIcon(img));
                teamName[id] = new JButton(name);
                
                teamName[id].setFont(new Font("Serif", Font.BOLD, 25));
                teamName[id].setPreferredSize(new Dimension(400, 55));
                teamName[id].setBackground(new Color(234, 34, 18));
                teamName[id].setForeground(Color.WHITE);
                teamName[id].addActionListener(bs);
                teamName[id].addMouseMotionListener(ms);
                
                team[id].setLayout(new GridBagLayout());
                team[id].setBackground(Color.BLACK);
                c.gridx = 1;
                c.gridy = 1;
                team[id].add(teamLogo[id], c);
                c.gridx = 1;
                c.gridy = 2;
                team[id].add(teamName[id], c);
                
                frameBackGround.add(team[id]);
            }
            da.close();

            
            JScrollPane scr = new JScrollPane(frameBackGround);
            scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            add(scr);
            // done

        }
        catch (SQLException ex)
        {
//            Logger.getLogger(TeamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
