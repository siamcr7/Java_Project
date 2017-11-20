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
import javax.swing.*;

public class GenralTeamFrame extends JFrame
{

    private JFrame parent;

    private int chkArr[] = new int[50];
    private String[] teamArr =
    {
        "player", "coach", "stadium", "owner", "sponsor"
    };

    public GenralTeamFrame(JFrame jf, String teamNameS) throws SQLException
    {

        super(teamNameS.toUpperCase() + " Page!");
        parent = jf;

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

        JLabel info[] = new JLabel[10]; /// printing the attributes of player
        int i = 0;
        
        String teamPic = "";
        System.out.println(teamNameS);
        rs = da.getData("select * from team where teamid = " + ic.getTeamID(teamNameS));
        while (rs.next())
        {
            teamPic = rs.getString("teamlogo");
            String ss = rs.getString("teamname");
            int coachid = rs.getInt("coachid");
            int ownerid = rs.getInt("ownerid");
            int stadiumid = rs.getInt("stadiumid");
            int sponsorid = rs.getInt("sponsorid");
            int gamePlayed = rs.getInt("gameplayed");
            int gameWon = rs.getInt("gamewon");
            int gameLost = rs.getInt("gamelost");
            int gameDrawn = rs.getInt("gamedrawn");

            info[i] = new JLabel("Team Name : " + ss);
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Coach Name : " + ic.getCoachName(coachid));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Owner Name : " + ic.getOwnerName(ownerid));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));;
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Stadium Name : " + ic.getStadiumName(stadiumid));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Sponsor Name : " + ic.getSponsorName(sponsorid));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Game Played : " + Integer.toString(gamePlayed));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Game Won : " + Integer.toString(gameWon));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Game Drawn : " + Integer.toString(gameDrawn));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Game Lost : " + Integer.toString(gameLost));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            i++;
            info[i] = new JLabel("Total Points : " + Integer.toString(gameWon * 3 + gameDrawn));
            info[i].setFont(new Font("Serif", Font.BOLD, 25));
            info[i].setBackground(new Color(50, 205, 50));
            info[i].setForeground(Color.WHITE);
            infoPanel.add(info[i]);

            //System.out.println(ss);
        }
        da.close();

        System.out.println(teamNameS);
        JLabel team1Logo = new JLabel(new ImageIcon(teamPic));

        JPanel frameBackground = new JPanel();
        frameBackground.setBackground(Color.BLACK);
        frameBackground.setLayout(new GridBagLayout());

        c.insets = new Insets(0, 50, 0, 0);
        frameBackground.add(team1Logo, c);
        frameBackground.add(infoPanel, c);
        /// teamLogo and info merge Done

        JLabel[] playerFace = new JLabel[50];
        JButton[] playerName = new JButton[50];
        JPanel[] player = new JPanel[50]; /// to merge  playerFace and Names

        JPanel playerPanel = new JPanel(); /// merged plane goes here
        playerPanel.setBackground(Color.BLACK);
        playerPanel.setLayout(new GridLayout(0, 2, 200, 50));
        ButtonSensor bs = new ButtonSensor(this, "Arsenal Frame");
        MouseMotionSensor ms = new MouseMotionSensor(this);

        rs = da.getData("select * from player where teamid = " + ic.getTeamID(teamNameS));
        while (rs.next())
        {
            int id = rs.getInt("playerid");
            String name = rs.getString("playername");
            String img = rs.getString("img");

            playerName[id] = new JButton(name);
            playerName[id].setFont(new Font("Serif", Font.BOLD, 35));
            playerName[id].setBackground(new Color(50, 205, 50));
            playerName[id].setForeground(Color.WHITE);
            playerName[id].setForeground(Color.WHITE);
            playerName[id].addActionListener(bs);
            playerName[id].addMouseMotionListener(ms);

            playerFace[id] = new JLabel(new ImageIcon(img));

            player[id] = new JPanel();
            player[id].setLayout(new GridBagLayout());
            player[id].setBackground(Color.BLACK);

            c.gridx = 1;
            c.gridy = 1;
            player[id].add(playerFace[id], c);
            c.gridx = 1;
            c.gridy = 2;
            player[id].add(playerName[id], c);
            playerPanel.add(player[id]);
        }

        JLabel starPlayer = new JLabel("PLAYERS:");
        starPlayer.setFont(new Font("Serif", Font.BOLD, 45));
        starPlayer.setBackground(new Color(50, 205, 50));
        starPlayer.setForeground(Color.YELLOW);

        JPanel mainBackground = new JPanel(); /// mainBackGround!
        mainBackground.setBackground(Color.BLACK);
        mainBackground.setLayout(new GridBagLayout());

        c.insets = new Insets(0, 0, 50, 0);
        c.gridx = 1;
        c.gridy = 1;
        mainBackground.add(frameBackground, c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        mainBackground.add(starPlayer, c);

        c.gridx = 1;
        c.gridy = 3;
        mainBackground.add(playerPanel, c);

        JScrollPane scr = new JScrollPane(mainBackground);
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scr);
        /// Done!

        /// menuBar
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
        
        printFrame.addMouseMotionListener(ms);
        backToMain.addMouseMotionListener(ms);
        /// done menuBar

    }


}
