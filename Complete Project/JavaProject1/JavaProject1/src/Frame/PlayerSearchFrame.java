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
import javax.swing.*;

public class PlayerSearchFrame extends JFrame{
    
    public PlayerSearchFrame()
    {
        super("Player Search Page");
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthh = screenSize.getWidth();
        double heightt = screenSize.getHeight();
        setSize((int) widthh - 450, (int) heightt - 250);

        
        this.setAlwaysOnTop(true);
        setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
        
        GridBagConstraints c = new GridBagConstraints();
        JPanel searchPlayerPanel = new JPanel();
        searchPlayerPanel.setLayout(new GridLayout(0,1,0,0));
        JLabel playerEdit = new JLabel("Player Search");
        playerEdit.setFont(new Font("Serif", Font.BOLD, 45));
        JLabel hint = new JLabel("HINT: To search-> give playerName and desired values");
        JPanel hintP = new JPanel();
        hintP.setLayout(new GridBagLayout());
        c.gridy=1;
        hintP.add(playerEdit,c);
        c.gridy=2;
        hintP.add(hint,c);
        searchPlayerPanel.add(hintP);
        
//        /// player id
//        JPanel searchPlayerIDP = new JPanel();
//        searchPlayerIDP.setLayout(new FlowLayout());
//        JLabel searchPlayerIDL = new JLabel("Player ID (pk): ");
//        JTextField searchPlayerIDTF = new JTextField(30);
//        //JButton searchPlayerIDB = new JButton("Update PlayerID");
//        searchPlayerIDP.search(searchPlayerIDL);
//        searchPlayerIDP.search(searchPlayerIDTF);
//        //searchPlayerIDP.search(searchPlayerIDB);
//        searchPlayerPanel.search(searchPlayerIDP);
        
        /// player name
        JPanel searchPlayerNameP = new JPanel();
        searchPlayerNameP.setLayout(new FlowLayout());
        JLabel searchPlayerNameL = new JLabel("Player Name: ");
        JTextField searchPlayerNameTF = new JTextField(30);
//        JButton searchPlayerNameB = new JButton("Update PlayerName");
        searchPlayerNameP.add(searchPlayerNameL);
        searchPlayerNameP.add(searchPlayerNameTF);
//        searchPlayerNameP.search(searchPlayerNameB);
        searchPlayerPanel.add(searchPlayerNameP);
        
        
        /// loc id
        JPanel searchPlayerLOCIDP = new JPanel();
        searchPlayerLOCIDP.setLayout(new FlowLayout());
        JLabel searchPlayerLOCIDL = new JLabel("Player Location: ");
        JTextField searchPlayerLOCIDTF = new JTextField(30);
//        JButton searchPlayerLOCIDB = new JButton("Update PlayerLOCID");
        searchPlayerLOCIDP.add(searchPlayerLOCIDL);
        searchPlayerLOCIDP.add(searchPlayerLOCIDTF);
//        searchPlayerLOCIDP.search(searchPlayerLOCIDB);
        searchPlayerPanel.add(searchPlayerLOCIDP);
        
        
        /// team id
        JPanel searchPlayerTeamIDP = new JPanel();
        searchPlayerTeamIDP.setLayout(new FlowLayout());
        JLabel searchPlayerTeamIDL = new JLabel("Player Team: ");
        JTextField searchPlayerTeamIDTF = new JTextField(30);
//        JButton searchPlayerTeamIDB = new JButton("Update PlayerTeamID");
        searchPlayerTeamIDP.add(searchPlayerTeamIDL);
        searchPlayerTeamIDP.add(searchPlayerTeamIDTF);
//        searchPlayerTeamIDP.search(searchPlayerTeamIDB);
        searchPlayerPanel.add(searchPlayerTeamIDP);
        
        
        /// sponsor id
        JPanel searchPlayerSponsorIDP = new JPanel();
        searchPlayerSponsorIDP.setLayout(new FlowLayout());
        JLabel searchPlayerSponsorIDL = new JLabel("Player Sponsor: ");
        JTextField searchPlayerSponsorIDTF = new JTextField(30);
//        JButton searchPlayerSponsorIDB = new JButton("Update PlayerSponsorID");
        searchPlayerSponsorIDP.add(searchPlayerSponsorIDL);
        searchPlayerSponsorIDP.add(searchPlayerSponsorIDTF);
//        searchPlayerSponsorIDP.search(searchPlayerSponsorIDB);
        searchPlayerPanel.add(searchPlayerSponsorIDP);
        
        
        /// Position
        JPanel searchPlayerPositionP = new JPanel();
        searchPlayerPositionP.setLayout(new FlowLayout());
        JLabel searchPlayerPositionL = new JLabel("Player Position: ");
        JTextField searchPlayerPositionTF = new JTextField(30);
//        JButton searchPositionB = new JButton("Update Position");
        searchPlayerPositionP.add(searchPlayerPositionL);
        searchPlayerPositionP.add(searchPlayerPositionTF);
//        searchPlayerPositionP.search(searchPositionB);
        searchPlayerPanel.add(searchPlayerPositionP);
        
        
        /// Age
        JPanel searchPlayerAgeP = new JPanel();
        searchPlayerAgeP.setLayout(new FlowLayout());
        JLabel searchPlayerAgeL = new JLabel("Player Age: ");
        JTextField searchPlayerAgeTF = new JTextField(30);
//        JButton searchPlayerAgeB = new JButton("Update Age");
        searchPlayerAgeP.add(searchPlayerAgeL);
        searchPlayerAgeP.add(searchPlayerAgeTF);
//        searchPlayerAgeP.search(searchPlayerAgeB);
        searchPlayerPanel.add(searchPlayerAgeP);
        
        /// Height
        JPanel searchPlayerHeightP = new JPanel();
        searchPlayerHeightP.setLayout(new FlowLayout());
        JLabel searchPlayerHeightL = new JLabel("Player Height(x FT x IN): ");
        JTextField searchPlayerHeightTF = new JTextField(30);
//        JButton searchPlayerHeightB = new JButton("Update Height");
        searchPlayerHeightP.add(searchPlayerHeightL);
        searchPlayerHeightP.add(searchPlayerHeightTF);
//        searchPlayerHeightP.search(searchPlayerHeightB);
        searchPlayerPanel.add(searchPlayerHeightP);
        
        /// Weight
        JPanel searchPlayerWeightP = new JPanel();
        searchPlayerWeightP.setLayout(new FlowLayout());
        JLabel searchPlayerWeightL = new JLabel("Player Weight(x kg): ");
        JTextField searchPlayerWeightTF = new JTextField(30);
//        JButton searchPlayerWeightB = new JButton("Update Weight");
        searchPlayerWeightP.add(searchPlayerWeightL);
        searchPlayerWeightP.add(searchPlayerWeightTF);
//        searchPlayerWeightP.search(searchPlayerWeightB);
        searchPlayerPanel.add(searchPlayerWeightP);
        
        /// kit No
        JPanel searchPlayerKitNoP = new JPanel();
        searchPlayerKitNoP.setLayout(new FlowLayout());
        JLabel searchPlayerKitNoL = new JLabel("Player Kit No: ");
        JTextField searchPlayerKitNoTF = new JTextField(30);
//        JButton searchPlayerKitNoB = new JButton("Update KitNo");
        searchPlayerKitNoP.add(searchPlayerKitNoL);
        searchPlayerKitNoP.add(searchPlayerKitNoTF);
//        searchPlayerKitNoP.search(searchPlayerKitNoB);
        searchPlayerPanel.add(searchPlayerKitNoP);
        
        
        /// goalScored
        JPanel searchPlayerGoalScoredP = new JPanel();
        searchPlayerGoalScoredP.setLayout(new FlowLayout());
        JLabel searchPlayerGoalScoredL = new JLabel("Player GoalScored: ");
        JTextField searchPlayerGoalScoredTF = new JTextField(30);
//        JButton searchPlayerGoalScoredB = new JButton("Update GoalScored");
        searchPlayerGoalScoredP.add(searchPlayerGoalScoredL);
        searchPlayerGoalScoredP.add(searchPlayerGoalScoredTF);
//        searchPlayerGoalScoredP.search(searchPlayerGoalScoredB);
        searchPlayerPanel.add(searchPlayerGoalScoredP);
        
        
        /// assist
        JPanel searchPlayerAssistP = new JPanel();
        searchPlayerAssistP.setLayout(new FlowLayout());
        JLabel searchPlayerAssistL = new JLabel("Player Assist: ");
        JTextField searchPlayerAssistTF = new JTextField(30);
//        JButton searchPlayerAssistB = new JButton("Update Assist");
        searchPlayerAssistP.add(searchPlayerAssistL);
        searchPlayerAssistP.add(searchPlayerAssistTF);
//        searchPlayerAssistP.search(searchPlayerAssistB);
        searchPlayerPanel.add(searchPlayerAssistP);
        
        
        /// saves
        JPanel searchPlayerSavesP = new JPanel();
        searchPlayerSavesP.setLayout(new FlowLayout());
        JLabel searchPlayerSavesL = new JLabel("Player Saves: ");
        JTextField searchPlayerSavesTF = new JTextField(30);
//        JButton searchPlayerSavesB = new JButton("Update Saves");
        searchPlayerSavesP.add(searchPlayerSavesL);
        searchPlayerSavesP.add(searchPlayerSavesTF);
//        searchPlayerSavesP.search(searchPlayerSavesB);
        searchPlayerPanel.add(searchPlayerSavesP);
        
        /// searchPlayer, updatePlayer Button & msg
        JPanel playerActionP = new JPanel();
        playerActionP.setLayout(new GridBagLayout());
        

        //JLabel searchMsg = new JLabel();
        JButton searchPlayerB = new JButton("Search PLAYER!");
        playerActionP.add(searchPlayerB,c);

        
        
        ButtonSensor bs = new ButtonSensor(this, "Player Search Frame",searchPlayerNameTF,searchPlayerLOCIDTF,searchPlayerGoalScoredTF,
                searchPlayerAssistTF,searchPlayerSavesTF,searchPlayerTeamIDTF,searchPlayerSponsorIDTF,searchPlayerPositionTF,searchPlayerAgeTF,
                searchPlayerHeightTF,searchPlayerWeightTF,searchPlayerKitNoTF);
        
        searchPlayerB.addActionListener(bs);
        
        MouseMotionSensor ms = new MouseMotionSensor(this);
        searchPlayerB.addMouseMotionListener(ms);
        
        
        
        searchPlayerPanel.add(playerActionP);
        
        
        JScrollPane scr = new JScrollPane(searchPlayerPanel);
        scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(scr);
        
        
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
