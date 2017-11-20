/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Sensor.*;
import Database.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jamil
 */
public class StartFrame extends JFrame 
{
    private String className = "StartFrame";
    
    
    public StartFrame()
    {
        super("Start Page!");
        setSize(1280,720);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        JButton admin = new JButton("admin");
        admin.setFont(new Font("Serif", Font.TRUETYPE_FONT, 15));
        admin.setPreferredSize(new Dimension(70,20));
        admin.setBackground(new Color(50,205,50));
        
        JPanel adminPanel = new JPanel();
        adminPanel.setBackground(Color.BLACK);
        adminPanel.setLayout(new BorderLayout());
        adminPanel.add(admin,BorderLayout.LINE_END);
        
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.black);
        JButton searchPlayerB = new JButton("Search by Player");
//        JButton searchTeamB = new JButton("Search by Team");
        searchPanel.add(searchPlayerB);
//        searchPanel.add(searchTeamB);
        
        adminPanel.add(searchPanel);
        add(adminPanel,BorderLayout.NORTH);
        
        
        //setLayout(new FlowLayout());
        
        /// back ground image
        JLabel backGround = new JLabel(new ImageIcon("D:\\DropBox Sync\\Dropbox\\NetBeans Project Files\\JavaApplication3\\src\\Image\\pic2.jpg"));
        
        
        /// welcome text
        JLabel welcomeText = new JLabel("Welcome");
        JLabel welcomeText2 = new JLabel("to");
        //JLabel welcomeText3 = new JLabel("Premier League Football");
        
        
        /// welcome panel for welcome text
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.BLACK);
        welcomePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 1;
        c.gridy = 1;
        welcomePanel.add(welcomeText,c);
        welcomeText.setFont(new Font("Serif", Font.BOLD, 100));
        welcomeText.setForeground(new Color(153,204,255));
        
        c.gridx = 1;
        c.gridy = 2;
        welcomePanel.add(welcomeText2,c);
        welcomeText2.setFont(new Font("Serif", Font.BOLD, 55));
        welcomeText2.setForeground(new Color(153,204,255));
        /// welcome panel done
        
        
        /// backPanel to add welcome panel
        JPanel backPanel = new JPanel(); 
        backPanel.setLayout(new GridBagLayout());
        backPanel.setBackground(Color.BLACK);
        //backPanel.add(welcomePanel,BorderLayout.NORTH);
        
        /// aligning welcome panel and background img in the backPanel
        c.gridx = 1;
        c.gridy = 1;
        backPanel.add(welcomePanel,c);
        
        c.gridx = 1;
        c.gridy = 2;
        backPanel.add(backGround,c);
        /// alignment done
        
        
        /// frameBackGround is the main BackGround!
        JPanel frameBackGround = new JPanel();
        frameBackGround.setBackground(Color.BLACK);
        frameBackGround.setLayout(new BorderLayout());
        frameBackGround.add(backPanel,BorderLayout.CENTER);
        /// pic and text add done
        
        
        /// Button Creation Starts
        JButton teamButton = new JButton("Teams!");
        teamButton.setFont(new Font("Serif", Font.BOLD, 25));
        teamButton.setPreferredSize(new Dimension(165,55));
        teamButton.setBackground(new Color(50,205,50));
        
        JButton playerButton = new JButton("Players!");
        playerButton.setFont(new Font("Serif", Font.BOLD, 25));
        playerButton.setPreferredSize(new Dimension(165,55));
        playerButton.setBackground(new Color(50,205,50));
        
//        JButton locationButton = new JButton("Location!");
//        locationButton.setFont(new Font("Serif", Font.BOLD, 25));
//        locationButton.setPreferredSize(new Dimension(165,55));
//        locationButton.setBackground(new Color(50,205,50));
        /// Button Creation Ends
        
        ///Left and Right panel for the buttons, so that they do not take all the space 
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.BLACK);
        leftPanel.setLayout(new GridBagLayout());
        c.gridx = 1;c.gridy = 1;leftPanel.add(playerButton,c);
        c.insets = new Insets(100,0,0,0);
        //c.gridx = 1;c.gridy = 2;leftPanel.add(locationButton,c);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.BLACK);
        rightPanel.setLayout(new GridBagLayout());
        rightPanel.add(teamButton);
        /// left and right panel done
        
        
        /// adding left and right panel to the main backGround
        frameBackGround.add(rightPanel,BorderLayout.WEST);
        frameBackGround.add(leftPanel,BorderLayout.EAST);
        
        
        /// adding the main background to the frame
        add(frameBackGround);
        /// done
        
        
        /// Sensor work begins
        ButtonSensor bs = new ButtonSensor(this,className);
        
        teamButton.addActionListener(bs);
        playerButton.addActionListener(bs);
//        locationButton.addActionListener(bs);
        admin.addActionListener(bs);
        searchPlayerB.addActionListener(bs);
        
        MouseMotionSensor ms = new MouseMotionSensor(this);
        teamButton.addMouseMotionListener(ms);
        playerButton.addMouseMotionListener(ms);
        admin.addMouseMotionListener(ms);
        searchPlayerB.addMouseMotionListener(ms);

        
        
    }
   
}
