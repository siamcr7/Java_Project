/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Sensor.*;
import Database.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
//import java.util.Date;

/**
 *
 * @author Jereen
 */
public class GenralPlayerFrame extends JFrame
{
    
    public GenralPlayerFrame(String playerNameS)
    {
        super(playerNameS.toUpperCase() + " Page!");
        try
        {
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double widthh = screenSize.getWidth();
            double heightt = screenSize.getHeight();
            setSize((int) widthh - 450, (int) heightt - 250);
            
            this.setAlwaysOnTop(true);
            setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
            
            
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setBackground(Color.BLACK);

            GridBagConstraints c = new GridBagConstraints();
            indexClass ic = new indexClass(); /// to get the names against PKs
            DataAccess da = new DataAccess();
            ResultSet rs = null;

            JLabel info[] = new JLabel[20]; /// printing the attributes of player
            int i = 0;
            String img = "";
            rs = da.getData("select * from player where playerid = " + ic.getPlayerID(playerNameS));
            
            while (rs.next())
            {
                String name = rs.getString("playername");
                String position = rs.getString("position");
                int goalscored = rs.getInt("goalscored");
                int assists = rs.getInt("assists");
                int saves = rs.getInt("saves");
                int sponsorid = rs.getInt("sponsorid");
                int locid = rs.getInt("locid");
                int teamid = rs.getInt("teamid");
                int age = rs.getInt("age");
                String height = rs.getString("height");
                String weight = rs.getString("weight");
                int kitnumber = rs.getInt("kitnumber");
                img = rs.getString("img");
                
                info[i] = new JLabel("NAME : " + name);
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("LOCATION : " + ic.getLocName(locid));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("GOAL SCORED : " + (goalscored));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("ASSISTS : " + (assists));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("SAVES : " + (saves));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("TEAM : " + ic.getTeamName(teamid));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("SPONSOR : " + ic.getSponsorName(sponsorid));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("POSITION : " + position);
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("AGE : " + age);
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("HEIGHT : " + (height));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("WEIGHT : " + (weight));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);
                
                i++;
                info[i] = new JLabel("KIT NUMBER : " + (kitnumber));
                info[i].setFont(new Font("Serif", Font.BOLD, 25));
                info[i].setBackground(new Color(50, 205, 50));
                info[i].setForeground(Color.WHITE);
                infoPanel.add(info[i]);

            }
            da.close();
            JLabel player1Logo = new JLabel(new ImageIcon(img));
            JPanel frameBackground = new JPanel();
            frameBackground.setBackground(Color.BLACK);
            frameBackground.setLayout(new GridBagLayout());

            c.insets = new Insets(0, 0, 10, 0);
            frameBackground.add(player1Logo, c);
            c.insets = new Insets(0, 50, 0, 0);
            frameBackground.add(infoPanel, c);

            JPanel mainBackground = new JPanel(); /// mainBackGround!
            mainBackground.setBackground(Color.BLACK);
            mainBackground.setLayout(new GridBagLayout());

            JPanel playerPanel = new JPanel(); /// merged plane goes here
            playerPanel.setBackground(Color.BLACK);
            playerPanel.setLayout(new GridLayout(0, 2, 0, 0));

            mainBackground.add(frameBackground, c);
            c.gridx = 1;
            c.gridy = 1;
            mainBackground.add(playerPanel, c);
            c.gridx = 1;
            c.gridy = 2;

            add(mainBackground);
            
            /// menuBar
            ButtonSensor bs = new ButtonSensor(this,"General Player Frame");
            JButton backToMain = new JButton("Back To Main");
            JMenuBar menuBar = new JMenuBar();

            JMenu optionMenu = new JMenu("Print Option");
            menuBar.add(optionMenu);

            JMenuItem printFrame = new JMenuItem("Print This Page");
            optionMenu.add(printFrame);
            menuBar.add(Box.createHorizontalGlue());
            menuBar.add(backToMain, JMenuBar.RIGHT_ALIGNMENT);
            setJMenuBar(menuBar);
            printFrame.addActionListener(bs);
            backToMain.addActionListener(bs);
            
            MouseMotionSensor ms = new MouseMotionSensor(this);
            printFrame.addMouseMotionListener(ms);
            backToMain.addMouseMotionListener(ms);
            /// done menuBar

        }
        catch (Exception ex)
        {
            Logger.getLogger(GenralPlayerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
