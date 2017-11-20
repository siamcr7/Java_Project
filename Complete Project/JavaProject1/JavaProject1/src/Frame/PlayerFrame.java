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
import Printer.*;
import Database.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class PlayerFrame extends JFrame
{


    public PlayerFrame() throws SQLException, PrinterException
    {
        super("Player Page!");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthh = screenSize.getWidth();
        double heightt = screenSize.getHeight();
        setSize((int) widthh - 450, (int) heightt - 250);
        
        this.setAlwaysOnTop(true);
        setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
        //setLayout(new GridLayout(0,4,0,0));

        JPanel frameBackground = new JPanel();
        frameBackground.setLayout(new GridLayout(0, 3, 0, 50));

        JLabel[] playerFace = new JLabel[50]; /// for playerFace
        JPanel[] player = new JPanel[50]; /// merge playerFace and name

        GridBagConstraints c = new GridBagConstraints();

        JButton[] playerName = new JButton[50]; /// playerName
//        JButton[] playerButton = new JButton[50];
//        JLabel[] playerNationality = new JLabel[50];
        
        ButtonSensor bs = new ButtonSensor(this, "Player Frame!");
        MouseMotionSensor ms = new MouseMotionSensor(this);
        indexClass ic = new indexClass();
        DataAccess da = new DataAccess();
        ResultSet rs = null;
        rs = da.getData("select * from player");

        while (rs.next())
        {
            int id = rs.getInt("playerid");
            String name = rs.getString("playername");
            String sImg = rs.getString("img");
            int locid = rs.getInt("locid");

            System.out.println(sImg);

            player[id] = new JPanel();

            playerFace[id] = new JLabel(new ImageIcon(sImg));
            c.gridx = 1;
            c.gridy = 1;
            player[id].setLayout(new GridBagLayout());
            player[id].add(playerFace[id], c);
            playerName[id] = new JButton(name);
            playerName[id].setPreferredSize(new Dimension(250, 20));
            playerName[id].setFont(new Font("Verdana", Font.BOLD, 15));
            playerName[id].setBackground(Color.WHITE);
            playerName[id].setForeground(new Color(139, 0, 0));
            playerName[id].addMouseMotionListener(ms);
            playerName[id].addActionListener(bs);
            c.gridx = 1;
            c.gridy = 2;
            player[id].add(playerName[id], c);

            

            frameBackground.add(player[id]);

        }
        /// merge Done!

        /// scrollBar
        JScrollPane scr = new JScrollPane(frameBackground);
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scr);
        /// done

        /// menuBar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu optionMenu = new JMenu("Print Option");
        menuBar.add(optionMenu);

        JMenuItem printFrame = new JMenuItem("Print This Page");
        optionMenu.add(printFrame);
        /// done
        printFrame.addActionListener(bs);
        printFrame.addMouseMotionListener(ms);

//        PrinterJob pjob = PrinterJob.getPrinterJob();
//        PageFormat preformat = pjob.defaultPage();
//        preformat.setOrientation(PageFormat.LANDSCAPE);
//        PageFormat postformat = pjob.pageDialog(preformat);
//        //If user does not hit cancel then print.
//        if (preformat != postformat) 
//        {
//            //Set print component
//           pjob.setPrintable(new Printer(this), postformat);
//           
//           if (pjob.printDialog()) 
//           {
//                pjob.print();
//           }
//        }
    }

    

}
