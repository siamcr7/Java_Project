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
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class AdminFrame extends JFrame
{

    JTable jtb = null;
    JTable jtbOption = null;

    public AdminFrame(String us)
    {
        super("Admin Page");
        try
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            double widthh = screenSize.getWidth();
            double heightt = screenSize.getHeight();
            setSize((int) widthh - 450, (int) heightt - 250);

            this.setAlwaysOnTop(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);

            JPanel frameBackground = new JPanel();
            frameBackground.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            JScrollPane scr = new JScrollPane(frameBackground);
            scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            /// things -> insert,update,delete ; admin password,username change
            ///add admin password username
            JPanel addAdminPasswordUsernamePanel = new JPanel();
            addAdminPasswordUsernamePanel.setLayout(new FlowLayout());

            JPanel adminUsernamePanel = new JPanel();
            adminUsernamePanel.setLayout(new GridLayout(0, 1, 0, 0));
            JLabel adminUsername = new JLabel("New Username");
            JTextField adminUsernameTX = new JTextField(20);
            adminUsernameTX.setPreferredSize(new Dimension(50, 30));
            adminUsernamePanel.add(adminUsername);
            adminUsernamePanel.add(adminUsernameTX);

            JPanel adminPasswordPanel = new JPanel();
            adminPasswordPanel.setLayout(new GridLayout(0, 1, 0, 0));
            JLabel adminPassword = new JLabel("New Password");
            JTextField adminPasswordTX = new JTextField(20);
            adminPasswordTX.setPreferredSize(new Dimension(50, 30));
            adminPasswordPanel.add(adminPassword);
            adminPasswordPanel.add(adminPasswordTX);

            JLabel msgAdd = new JLabel();
            JButton adminPasswordUsernameButton = new JButton("Add admin!");
            addAdminPasswordUsernamePanel.add(adminUsernamePanel);
            addAdminPasswordUsernamePanel.add(adminPasswordPanel);
            addAdminPasswordUsernamePanel.add(adminPasswordUsernameButton);
            addAdminPasswordUsernamePanel.add(msgAdd);
            /// done add admin

            ///remove admin
            JPanel removeAdminPanel = new JPanel();
            removeAdminPanel.setLayout(new FlowLayout());

            JLabel msgDel = new JLabel();
            JLabel removeUsername = new JLabel("Remove Username :");
            JTextField removeUsernameTX = new JTextField(30);
            removeUsernameTX.setPreferredSize(new Dimension(50, 30));
            JButton removeUsernameButton = new JButton("Remove Admin!");
            removeAdminPanel.add(removeUsername);
            removeAdminPanel.add(removeUsernameTX);
            removeAdminPanel.add(removeUsernameButton);
            removeAdminPanel.add(msgDel);
            /// done remove admin

            /// add player
            JPanel addPlayerPanel = new JPanel();
            addPlayerPanel.setLayout(new GridLayout(0, 1, 0, 0));
            JLabel playerEdit = new JLabel("Player Edit");
            playerEdit.setFont(new Font("Serif", Font.BOLD, 45));
            JLabel hint = new JLabel("HINT: To update-> give playerID and desired value || to Add -> fill up all the box! || to Delete -> just select the player id");
            JPanel hintP = new JPanel();
            hintP.setLayout(new GridBagLayout());
            c.gridy = 1;
            hintP.add(playerEdit, c);
            c.gridy = 2;
            hintP.add(hint, c);
            addPlayerPanel.add(hintP);

            /// player id
            JPanel addPlayerIDP = new JPanel();
            addPlayerIDP.setLayout(new FlowLayout());
            JLabel addPlayerIDL = new JLabel("Player ID (pk): ");
            JTextField addPlayerIDTF = new JTextField(30);
            //JButton addPlayerIDB = new JButton("Update PlayerID");
            addPlayerIDP.add(addPlayerIDL);
            addPlayerIDP.add(addPlayerIDTF);
            //addPlayerIDP.add(addPlayerIDB);
            addPlayerPanel.add(addPlayerIDP);

            /// player name
            JPanel addPlayerNameP = new JPanel();
            addPlayerNameP.setLayout(new FlowLayout());
            JLabel addPlayerNameL = new JLabel("Player Name: ");
            JTextField addPlayerNameTF = new JTextField(30);
//        JButton addPlayerNameB = new JButton("Update PlayerName");
            addPlayerNameP.add(addPlayerNameL);
            addPlayerNameP.add(addPlayerNameTF);
//        addPlayerNameP.add(addPlayerNameB);
            addPlayerPanel.add(addPlayerNameP);

            /// loc id
            JPanel addPlayerLOCIDP = new JPanel();
            addPlayerLOCIDP.setLayout(new FlowLayout());
            JLabel addPlayerLOCIDL = new JLabel("Player LOC ID: ");
            JTextField addPlayerLOCIDTF = new JTextField(30);
//        JButton addPlayerLOCIDB = new JButton("Update PlayerLOCID");
            addPlayerLOCIDP.add(addPlayerLOCIDL);
            addPlayerLOCIDP.add(addPlayerLOCIDTF);
//        addPlayerLOCIDP.add(addPlayerLOCIDB);
            addPlayerPanel.add(addPlayerLOCIDP);

            /// team id
            JPanel addPlayerTeamIDP = new JPanel();
            addPlayerTeamIDP.setLayout(new FlowLayout());
            JLabel addPlayerTeamIDL = new JLabel("Player Team ID: ");
            JTextField addPlayerTeamIDTF = new JTextField(30);
//        JButton addPlayerTeamIDB = new JButton("Update PlayerTeamID");
            addPlayerTeamIDP.add(addPlayerTeamIDL);
            addPlayerTeamIDP.add(addPlayerTeamIDTF);
//        addPlayerTeamIDP.add(addPlayerTeamIDB);
            addPlayerPanel.add(addPlayerTeamIDP);

            /// sponsor id
            JPanel addPlayerSponsorIDP = new JPanel();
            addPlayerSponsorIDP.setLayout(new FlowLayout());
            JLabel addPlayerSponsorIDL = new JLabel("Player Sponsor ID: ");
            JTextField addPlayerSponsorIDTF = new JTextField(30);
//        JButton addPlayerSponsorIDB = new JButton("Update PlayerSponsorID");
            addPlayerSponsorIDP.add(addPlayerSponsorIDL);
            addPlayerSponsorIDP.add(addPlayerSponsorIDTF);
//        addPlayerSponsorIDP.add(addPlayerSponsorIDB);
            addPlayerPanel.add(addPlayerSponsorIDP);

            /// Position
            JPanel addPlayerPositionP = new JPanel();
            addPlayerPositionP.setLayout(new FlowLayout());
            JLabel addPlayerPositionL = new JLabel("Player Position: ");
            JTextField addPlayerPositionTF = new JTextField(30);
//        JButton addPositionB = new JButton("Update Position");
            addPlayerPositionP.add(addPlayerPositionL);
            addPlayerPositionP.add(addPlayerPositionTF);
//        addPlayerPositionP.add(addPositionB);
            addPlayerPanel.add(addPlayerPositionP);

            /// Age
            JPanel addPlayerAgeP = new JPanel();
            addPlayerAgeP.setLayout(new FlowLayout());
            JLabel addPlayerAgeL = new JLabel("Player Age: ");
            JTextField addPlayerAgeTF = new JTextField(30);
//        JButton addPlayerAgeB = new JButton("Update Age");
            addPlayerAgeP.add(addPlayerAgeL);
            addPlayerAgeP.add(addPlayerAgeTF);
//        addPlayerAgeP.add(addPlayerAgeB);
            addPlayerPanel.add(addPlayerAgeP);

            /// Height
            JPanel addPlayerHeightP = new JPanel();
            addPlayerHeightP.setLayout(new FlowLayout());
            JLabel addPlayerHeightL = new JLabel("Player Height(x FT x IN): ");
            JTextField addPlayerHeightTF = new JTextField(30);
//        JButton addPlayerHeightB = new JButton("Update Height");
            addPlayerHeightP.add(addPlayerHeightL);
            addPlayerHeightP.add(addPlayerHeightTF);
//        addPlayerHeightP.add(addPlayerHeightB);
            addPlayerPanel.add(addPlayerHeightP);

            /// Weight
            JPanel addPlayerWeightP = new JPanel();
            addPlayerWeightP.setLayout(new FlowLayout());
            JLabel addPlayerWeightL = new JLabel("Player Weight(x kg): ");
            JTextField addPlayerWeightTF = new JTextField(30);
//        JButton addPlayerWeightB = new JButton("Update Weight");
            addPlayerWeightP.add(addPlayerWeightL);
            addPlayerWeightP.add(addPlayerWeightTF);
//        addPlayerWeightP.add(addPlayerWeightB);
            addPlayerPanel.add(addPlayerWeightP);

            /// kit No
            JPanel addPlayerKitNoP = new JPanel();
            addPlayerKitNoP.setLayout(new FlowLayout());
            JLabel addPlayerKitNoL = new JLabel("Player Kit No: ");
            JTextField addPlayerKitNoTF = new JTextField(30);
//        JButton addPlayerKitNoB = new JButton("Update KitNo");
            addPlayerKitNoP.add(addPlayerKitNoL);
            addPlayerKitNoP.add(addPlayerKitNoTF);
//        addPlayerKitNoP.add(addPlayerKitNoB);
            addPlayerPanel.add(addPlayerKitNoP);

            /// goalScored
            JPanel addPlayerGoalScoredP = new JPanel();
            addPlayerGoalScoredP.setLayout(new FlowLayout());
            JLabel addPlayerGoalScoredL = new JLabel("Player GoalScored: ");
            JTextField addPlayerGoalScoredTF = new JTextField(30);
//        JButton addPlayerGoalScoredB = new JButton("Update GoalScored");
            addPlayerGoalScoredP.add(addPlayerGoalScoredL);
            addPlayerGoalScoredP.add(addPlayerGoalScoredTF);
//        addPlayerGoalScoredP.add(addPlayerGoalScoredB);
            addPlayerPanel.add(addPlayerGoalScoredP);

            /// assist
            JPanel addPlayerAssistP = new JPanel();
            addPlayerAssistP.setLayout(new FlowLayout());
            JLabel addPlayerAssistL = new JLabel("Player Assist: ");
            JTextField addPlayerAssistTF = new JTextField(30);
//        JButton addPlayerAssistB = new JButton("Update Assist");
            addPlayerAssistP.add(addPlayerAssistL);
            addPlayerAssistP.add(addPlayerAssistTF);
//        addPlayerAssistP.add(addPlayerAssistB);
            addPlayerPanel.add(addPlayerAssistP);

            /// saves
            JPanel addPlayerSavesP = new JPanel();
            addPlayerSavesP.setLayout(new FlowLayout());
            JLabel addPlayerSavesL = new JLabel("Player Saves: ");
            JTextField addPlayerSavesTF = new JTextField(30);
            //JButton addPlayerSavesB = new JButton("Update Saves");
            addPlayerSavesP.add(addPlayerSavesL);
            addPlayerSavesP.add(addPlayerSavesTF);
//            addPlayerSavesP.add(addPlayerSavesB);
            addPlayerPanel.add(addPlayerSavesP);

            ///img button and text field
            JPanel addPlayerImgP = new JPanel();
            addPlayerImgP.setLayout(new FlowLayout());
            JLabel addPlayerImgL = new JLabel("Player Image Dir: ");
            JTextField addPlayerImgTF = new JTextField(30);
            JButton addPlayerImgB = new JButton("Upload Image");
            addPlayerImgP.add(addPlayerImgL);
            addPlayerImgP.add(addPlayerImgTF);
            addPlayerImgP.add(addPlayerImgB);
            addPlayerPanel.add(addPlayerImgP);

            /// addPlayer, updatePlayer Button & msg
            JPanel playerActionP = new JPanel();
            playerActionP.setLayout(new GridBagLayout());

            JLabel playerMsg = new JLabel();
            JButton addPlayerB = new JButton("ADD PLAYER!");
            JButton updatePlayerB = new JButton("UPDATE PLAYER!");
            JButton delPlayerB = new JButton("DELETE PLAYER!");
            c.gridx = 1;
            c.gridy = 1;
            playerActionP.add(playerMsg, c);
            c.gridy = 2;
            playerActionP.add(addPlayerB, c);
            c.gridx = 2;
            playerActionP.add(updatePlayerB, c);
            c.gridx = 3;
            playerActionP.add(delPlayerB, c);

            addPlayerPanel.add(playerActionP);
            /// done with player

            /// simple table for betterment of Admin
            /// heading for playerInfo
            JLabel playerInfo = new JLabel("Player Info From Database");
            playerInfo.setFont(new Font("Serif", Font.BOLD, 25));
            /// done

            indexClass ic = new indexClass();

            String[] sColName =
            {
                "playerid", "playername", "location", "goalscored", "assists", "saves", "team", "sponsor", "position",
                "age", "height", "weight", "kitnumber"
            };

            DataAccess da = new DataAccess();
            ResultSet rs = null;
            ResultSet rs2 = null;
            rs = da.getData("select * from player");
            rs2 = da.getData("select * from player");

            int fetchedRow = 0;
            while (rs2.next())
            {
                fetchedRow++;
            }
            da.close();

            System.out.println("Row Count : " + fetchedRow);
            boolean tableEmpty = true;
            Object[][] ob = new Object[fetchedRow][14];
            int iRow = 0;
            int iCol = -1;

            while (rs.next())
            {
                tableEmpty = false;
                int id = rs.getInt("playerid");
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
                String img = rs.getString("img");

                ob[iRow][++iCol] = id;
                ob[iRow][++iCol] = name;
                ob[iRow][++iCol] = ic.getLocName(locid);
                ob[iRow][++iCol] = goalscored;
                ob[iRow][++iCol] = assists;
                ob[iRow][++iCol] = saves;
                ob[iRow][++iCol] = ic.getTeamName(teamid);
                ob[iRow][++iCol] = ic.getSponsorName(sponsorid);
                ob[iRow][++iCol] = position;
                ob[iRow][++iCol] = age;
                ob[iRow][++iCol] = height;
                ob[iRow][++iCol] = weight;
                ob[iRow][++iCol] = kitnumber;
                iRow++;
                iCol = -1;

                System.out.println(ob[0][0]);

                System.out.println("result name : " + name);
            }
            da.close();
            jtb = new JTable(ob, sColName);
            jtb.setPreferredScrollableViewportSize(new Dimension(1000, 300));
            jtb.setFont(new Font("Serif", Font.TRUETYPE_FONT, 15));
            jtb.setAutoCreateRowSorter(true);
            //done

            /// an option so that admin can see the names to the corresponding id
            JLabel adminOptionHint = new JLabel("Which class index are you looking for?");
            JTextField adminOption = new JTextField(30);
            JButton seeNameId = new JButton("See name-id");
            JPanel adminOptionP = new JPanel();
            adminOptionP.setLayout(new GridBagLayout());
            c.gridx = 1;
            c.gridy = 1;
            adminOptionP.add(adminOptionHint, c);
            c.gridx = 2;
            adminOptionP.add(adminOption, c);
            c.gridx = 3;
            c.gridy = 1;
            adminOptionP.add(seeNameId, c);

            Object[][] ob2 = new Object[10][2];
            String[] sColName2 =
            {
                "ID", "Name"
            };

            jtbOption = new JTable(ob2, sColName2);
            jtbOption.setPreferredScrollableViewportSize(new Dimension(300, 100));
            jtbOption.setAutoCreateRowSorter(true);

            c.gridx = 2;
            c.gridy = 3;
            adminOptionP.add(new JScrollPane(jtbOption), c);

            ///adding to main background
            c.insets = new Insets(0, 0, 50, 0);
            c.gridx = 1;
            c.gridy = 1;
            frameBackground.add(addAdminPasswordUsernamePanel, c);
            c.gridy = 2;
            frameBackground.add(removeAdminPanel, c);
            c.insets = new Insets(250, 0, 0, 0);
            c.gridy = 3;

            frameBackground.add(adminOptionP, c);
            c.insets = new Insets(25, 0, 0, 0);
            c.gridy = 4;
            frameBackground.add(playerInfo, c);
            c.insets = new Insets(50, 0, 0, 0);
            c.gridy = 5;
            frameBackground.add(new JScrollPane(jtb), c);
            c.insets = new Insets(10, 0, 0, 0);
            c.gridy = 6;

            frameBackground.add(addPlayerPanel, c);

            /// add -> admin password and user name done
            /// buttonSensor stuffs
            ButtonSensor bs = new ButtonSensor(this, "Admin Frame", us, adminPasswordUsernameButton, adminUsernameTX,
                    adminPasswordTX, msgAdd, removeUsernameButton, removeUsernameTX, msgDel,
                    addPlayerIDTF, addPlayerNameTF, addPlayerLOCIDTF, addPlayerGoalScoredTF, addPlayerAssistTF, addPlayerSavesTF,
                    addPlayerTeamIDTF, addPlayerSponsorIDTF, addPlayerPositionTF, addPlayerAgeTF, addPlayerHeightTF,
                    addPlayerWeightTF, addPlayerKitNoTF, addPlayerImgTF,
                    playerMsg, addPlayerB, updatePlayerB, addPlayerImgB, delPlayerB, jtb, adminOption);

            adminPasswordUsernameButton.addActionListener(bs);
            removeUsernameButton.addActionListener(bs);
            addPlayerB.addActionListener(bs);
            updatePlayerB.addActionListener(bs);
            addPlayerImgB.addActionListener(bs);
            delPlayerB.addActionListener(bs);
            seeNameId.addActionListener(bs);
            
            MouseMotionSensor ms = new MouseMotionSensor(this);
            adminPasswordUsernameButton.addMouseMotionListener(ms);
            removeUsernameButton.addMouseMotionListener(ms);
            addPlayerB.addMouseMotionListener(ms);
            updatePlayerB.addMouseMotionListener(ms);
            addPlayerImgB.addMouseMotionListener(ms);
            delPlayerB.addMouseMotionListener(ms);
            seeNameId.addMouseMotionListener(ms);

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
        catch (Exception ex)
        {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reTable()
    {
        DefaultTableModel jtbTemp = new DefaultTableModel();
        try
        {
            indexClass ic = new indexClass();

            String[] sColName =
            {
                "playerid", "playername", "location", "goalscored", "assists", "saves", "team", "sponsor", "position",
                "age", "height", "weight", "kitnumber"
            };
//            JPanel adminTable = new JPanel();

            DataAccess da = new DataAccess();
            ResultSet rs = null;
            ResultSet rs2 = null;
            rs = da.getData("select * from player");
            rs2 = da.getData("select * from player");

            int fetchedRow = 0;
            while (rs2.next())
            {
                fetchedRow++;
            }
            da.close();

            System.out.println("Row Count : " + fetchedRow);
            boolean tableEmpty = true;
            Object[][] ob = new Object[fetchedRow][14];
            int iRow = 0;
            int iCol = -1;

            while (rs.next())
            {
                tableEmpty = false;
                int id = rs.getInt("playerid");
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
                String img = rs.getString("img");

                ob[iRow][++iCol] = id;
                ob[iRow][++iCol] = name;
                ob[iRow][++iCol] = ic.getLocName(locid);
                ob[iRow][++iCol] = goalscored;
                ob[iRow][++iCol] = assists;
                ob[iRow][++iCol] = saves;
                ob[iRow][++iCol] = ic.getTeamName(teamid);
                ob[iRow][++iCol] = ic.getSponsorName(sponsorid);
                ob[iRow][++iCol] = position;
                ob[iRow][++iCol] = age;
                ob[iRow][++iCol] = height;
                ob[iRow][++iCol] = weight;
                ob[iRow][++iCol] = kitnumber;
                iRow++;
                iCol = -1;

                System.out.println(ob[0][0]);

                System.out.println("result name : " + name);
            }
            da.close();
            jtbTemp = new DefaultTableModel(ob, sColName);
            jtbTemp.fireTableDataChanged();
            jtb.setModel(jtbTemp);

        }
        catch (Exception ex)
        {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reOptionTable(String s)
    {
        DefaultTableModel jtbTemp2 = new DefaultTableModel();
        String[] sColName2 =
        {
            "ID", "Name"
        };

        if (s.equals("location"))
        {
            try
            {
                System.out.println("loca loca!!");

                indexClass ic = new indexClass();
                DataAccess da = new DataAccess();
                ResultSet rs = null;
                ResultSet rs2 = null;
                rs = da.getData("select * from " + s);
                rs2 = da.getData("select * from " + s);

                int fetchedRowCount = 0;
                while (rs2.next())
                {
                    fetchedRowCount++;
                }

                Object[][] ob2 = new Object[fetchedRowCount + 1][2];
                int rowCount = 0;
                int colCount = -1;

                while (rs.next())
                {
                    int id = rs.getInt("locid");
                    String name = rs.getString("loc");
                    ob2[rowCount][++colCount] = id;
                    ob2[rowCount][++colCount] = name;

                    rowCount++;
                    colCount = -1;
                }

                jtbTemp2 = new DefaultTableModel(ob2, sColName2);
                jtbTemp2.fireTableDataChanged();
                jtbOption.setModel(jtbTemp2);

            }
            catch (Exception ex)
            {
                Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        else if (s.equals("admin"))
        {
            sColName2[0] = "Admin Name";
            sColName2[1] = "Admin Pass";

            try
            {
                System.out.println("loca loca!!");

                indexClass ic = new indexClass();
                DataAccess da = new DataAccess();
                ResultSet rs = null;
                ResultSet rs2 = null;
                rs = da.getData("select * from " + s);
                rs2 = da.getData("select * from " + s);

                int fetchedRowCount = 0;
                while (rs2.next())
                {
                    fetchedRowCount++;
                }

                Object[][] ob2 = new Object[fetchedRowCount + 1][2];
                int rowCount = 0;
                int colCount = -1;

                while (rs.next())
                {
                    String id = rs.getString("username");
                    String name = rs.getString("password");
                    ob2[rowCount][++colCount] = id;
                    ob2[rowCount][++colCount] = name;

                    rowCount++;
                    colCount = -1;
                }

                jtbTemp2 = new DefaultTableModel(ob2, sColName2);
                jtbTemp2.fireTableDataChanged();
                jtbOption.setModel(jtbTemp2);

            }
            catch (Exception ex)
            {
                Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        else
        {
            try
            {
                System.out.println("loca loca!!");

                indexClass ic = new indexClass();
                DataAccess da = new DataAccess();
                ResultSet rs = null;
                ResultSet rs2 = null;
                rs = da.getData("select * from " + s);
                rs2 = da.getData("select * from " + s);

                int fetchedRowCount = 0;
                while (rs2.next())
                {
                    fetchedRowCount++;
                }

                Object[][] ob2 = new Object[fetchedRowCount + 1][2];
                int rowCount = 0;
                int colCount = -1;

                while (rs.next())
                {
                    int id = rs.getInt(s + "id");
                    String name = rs.getString(s + "name");
                    ob2[rowCount][++colCount] = id;
                    ob2[rowCount][++colCount] = name;

                    rowCount++;
                    colCount = -1;
                }

                jtbTemp2 = new DefaultTableModel(ob2, sColName2);
                jtbTemp2.fireTableDataChanged();
                jtbOption.setModel(jtbTemp2);

            }
            catch (Exception ex)
            {
                Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
