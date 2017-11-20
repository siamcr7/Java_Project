/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensor;

import Database.DataAccess;
import Database.indexClass;
import Frame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamil
 */
public class ButtonSensor implements ActionListener
{

    AdminFrame af;

    JFrame jf;

    JTable jtb;

    JButton adminAdd, adminDel, addPlayerB, updatePlayerB, addPlayerImgB, delPlayerB;

    JLabel msgAdd, msgDel, playerMsg;

    JTextField adminAddPassTX, adminAddUserTX, adminDelUserTX,
            addPlayerIDTF, addPlayerNameTF, addPlayerLOCIDTF, addPlayerGoalScoredTF, addPlayerAssistTF,
            addPlayerSavesTF, addPlayerTeamIDTF, addPlayerSponsorIDTF, addPlayerPositionTF, addPlayerAgeTF,
            addPlayerHeightTF, addPlayerWeightTF, addPlayerKitNoTF, addPlayerImgTF,
            searchPlayerNameTF, searchPlayerLOCIDTF, searchPlayerGoalScoredTF, searchPlayerAssistTF, searchPlayerSavesTF,
            searchPlayerTeamIDTF, searchPlayerSponsorIDTF, searchPlayerPositionTF, searchPlayerAgeTF, searchPlayerHeightTF,
            searchPlayerWeightTF, searchPlayerKitNoTF,
            searchTeamNameTF, searchGameWonTF, searchGameLostTF, searchGameDrawnTF, searchGamePlayedTF,
            searchTeamSponsorIDTF, searchCoachIDTF, searchStadiumIDTF, searchOwnerIDTF, searchTeamKitIDTF, adminOption;

    String s, currentAdmin;
    String sMain = "";
    String buttonPressed;

    int x = 0;
    int y = 0;

    public ButtonSensor(JFrame mf, String s)
    {
        this.jf = mf;
        this.s = s;
    }

    /// search team frame
    public ButtonSensor(JFrame mf, String s, JTextField searchTeamNameTF, JTextField searchGameWonTF, JTextField searchGameLostTF, JTextField searchGameDrawnTF, JTextField searchGamePlayedTF, JTextField searchTeamSponsorIDTF, JTextField searchCoachIDTF, JTextField searchStadiumIDTF, JTextField searchOwnerIDTF, JTextField searchTeamKitIssDTF)
    {
        this.jf = mf;
        this.s = s;
        this.searchTeamNameTF = searchTeamNameTF;
        this.searchGameWonTF = searchGameWonTF;
        this.searchGameLostTF = searchGameLostTF;
        this.searchGameDrawnTF = searchGameDrawnTF;
        this.searchGamePlayedTF = searchGamePlayedTF;
        this.searchTeamSponsorIDTF = searchTeamSponsorIDTF;
        this.searchCoachIDTF = searchCoachIDTF;
        this.searchStadiumIDTF = searchStadiumIDTF;
        this.searchOwnerIDTF = searchOwnerIDTF;
        this.searchTeamKitIDTF = searchTeamKitIDTF;
    }

    /// for playerSearchFrame
    public ButtonSensor(JFrame mf, String s, JTextField searchPlayerNameTF, JTextField searchPlayerLOCIDTF,
            JTextField searchPlayerGoalScoredTF, JTextField searchPlayerAssistTF, JTextField searchPlayerSavesTF,
            JTextField searchPlayerTeamIDTF, JTextField searchPlayerSponsorIDTF, JTextField searchPlayerPositionTF,
            JTextField searchPlayerAgeTF, JTextField searchPlayerHeightTF, JTextField searchPlayerWeightTF,
            JTextField searchPlayerKitNoTF)
    {
        this.jf = mf;
        this.s = s;
        this.searchPlayerNameTF = searchPlayerNameTF;
        this.searchPlayerLOCIDTF = searchPlayerLOCIDTF;
        this.searchPlayerGoalScoredTF = searchPlayerGoalScoredTF;
        this.searchPlayerAssistTF = searchPlayerAssistTF;
        this.searchPlayerSavesTF = searchPlayerSavesTF;
        this.searchPlayerTeamIDTF = searchPlayerTeamIDTF;
        this.searchPlayerSponsorIDTF = searchPlayerSponsorIDTF;
        this.searchPlayerPositionTF = searchPlayerPositionTF;
        this.searchPlayerAgeTF = searchPlayerAgeTF;
        this.searchPlayerHeightTF = searchPlayerHeightTF;
        this.searchPlayerWeightTF = searchPlayerWeightTF;
        this.searchPlayerKitNoTF = searchPlayerKitNoTF;
    }

    /// for admin frame!
    public ButtonSensor(JFrame mf, String s, String us, JButton adminAdd, JTextField adminAddUser, JTextField adminAddPass,
            JLabel msgAdd, JButton adminDel, JTextField adminDelUser, JLabel msgDel,
            JTextField addPlayerIDTF, JTextField addPlayerNameTF, JTextField addPlayerLOCIDTF, JTextField addPlayerGoalScoredTF,
            JTextField addPlayerAssistTF, JTextField addPlayerSavesTF, JTextField addPlayerTeamIDTF,
            JTextField addPlayerSponsorIDTF, JTextField addPlayerPositionTF, JTextField addPlayerAgeTF,
            JTextField addPlayerHeightTF, JTextField addPlayerWeightTF, JTextField addPlayerKitNoTF, JTextField addPlayerImgTF,
            JLabel playerMsg, JButton addPlayerB, JButton updatePlayerB, JButton addPlayerImgB, JButton delPlayerB, JTable jtb, JTextField adminOption)
    {
        this.af = (AdminFrame) mf;
        this.jf = mf;
        
        this.s = s;
        this.currentAdmin = us;

        this.adminAdd = adminAdd;
        this.adminAddUserTX = adminAddUser;
        this.adminAddPassTX = adminAddPass;
        this.msgAdd = msgAdd;
        this.adminDel = adminDel;
        this.adminDelUserTX = adminDelUser;
        this.msgDel = msgDel;

        this.addPlayerIDTF = addPlayerIDTF;
        this.addPlayerNameTF = addPlayerNameTF;
        this.addPlayerLOCIDTF = addPlayerLOCIDTF;
        this.addPlayerGoalScoredTF = addPlayerGoalScoredTF;
        this.addPlayerAssistTF = addPlayerAssistTF;
        this.addPlayerSavesTF = addPlayerSavesTF;
        this.addPlayerTeamIDTF = addPlayerTeamIDTF;
        this.addPlayerSponsorIDTF = addPlayerSponsorIDTF;
        this.addPlayerPositionTF = addPlayerPositionTF;
        this.addPlayerAgeTF = addPlayerAgeTF;
        this.addPlayerHeightTF = addPlayerHeightTF;
        this.addPlayerWeightTF = addPlayerWeightTF;
        this.addPlayerKitNoTF = addPlayerKitNoTF;
        this.addPlayerImgTF = addPlayerImgTF;

        this.playerMsg = playerMsg;
        this.addPlayerB = addPlayerB;
        this.updatePlayerB = updatePlayerB;
        this.addPlayerImgB = addPlayerImgB;
        this.delPlayerB = delPlayerB;

        this.jtb = jtb;

        this.adminOption = adminOption;
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            indexClass ic = new indexClass();
            String c = ae.getActionCommand();
            c = c.toLowerCase();
            buttonPressed = c;

            if (c.equals("admin"))
            {
                openAdminLoginFrame();
            }

            else if (c.equals("see name-id"))
            {
                System.out.println("see name id pressed");
                af.reOptionTable(adminOption.getText());
            }

            else if (c.equals("teams!"))
            {
                openTeamFrame();
            }

            else if (c.equals("players!"))
            {
                openPlayerFrame();
            }

            else if (c.equals("print this page"))
            {
                ic.setAllFrameAlwaysOnTop(false);
                printCurrentFrame();
                ic.setAllFrameAlwaysOnTop(true);
            }
            
            else if(c.equals("back to main"))
            {
                jf.setVisible(false);
                System.out.println("GO BACK TO MAIN NOW!!");
            }

            else if (c.equals("add admin!"))
            {
                indexClass icStack = new indexClass();
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this change?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
                {
                    addAdminFromAdminFrame();
                }
                icStack.setAllFrameAlwaysOnTop(true);
            }

            else if (c.equals("remove admin!"))
            {
                indexClass icStack = new indexClass();
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this change?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
                {
                    removeAdminFromAdminFrame();
                }
                icStack.setAllFrameAlwaysOnTop(true);

            }

            else if (c.equals("add player!"))
            {
                indexClass icStack = new indexClass();
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this change?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
                {
                    addPlayerFromAdminFrame();
                }
                icStack.setAllFrameAlwaysOnTop(true);

            }

            else if (c.equals("update player!"))
            {
                indexClass icStack = new indexClass();
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this change?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
                {
                    updatePlayerFromAdminFrame();
                }
                icStack.setAllFrameAlwaysOnTop(true);

            }

            else if (c.equals("delete player!"))
            {
                indexClass icStack = new indexClass();
                icStack.setAllFrameAlwaysOnTop(false);
                int conformation = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this change?", "Warning!", JOptionPane.OK_CANCEL_OPTION);
                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
                {
                    deletePlayerFromAdminFrame();
                }
                icStack.setAllFrameAlwaysOnTop(true);

            }

            else if (c.equals("upload image"))
            {
                ic.setAllFrameAlwaysOnTop(false);
                uploadImageFromAdminFrame();
                ic.setAllFrameAlwaysOnTop(true);
            }

            else if (c.equals("search by player"))
            {
                openSearchByPlayerFrame();
            }

            else if (c.equals("search player!"))
            {
                openPlayerSearchResultFrame();
            }

            else if (ic.getPlayerID(c) != 0)
            {
                System.out.println("PLAYAA ID: " + ic.getPlayerID(c));
                openGeneralPlayerFrame(c);
            }

            else if (ic.getTeamID(c) != 0)
            {
                openGeneralTeamFrame(c);
            }
            
            //                indexClass icStack = new indexClass();
            //                icStack.setAllFrameAlwaysOnTop(false);
            //                int conformation = JOptionPane.showConfirmDialog(null, "We are updating! Stay Tuned.", "Sorry!", JOptionPane.OK_CANCEL_OPTION);
            ////
            //                if (conformation == JOptionPane.OK_OPTION || conformation == JOptionPane.CANCEL_OPTION)
            //                {
            //                    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            //                }
            //                icStack.setAllFrameAlwaysOnTop(true);

            System.out.println(c + " Button Pressed from.. " + s);
            //mf.setMessage("Button Pressed");
            //mf.repaint(); // to call paint for the 2nd time
        }
        catch (Exception ex)
        {
//            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error from ButtonSensor cuz of admin Page!");
        }

    }

    public void openPlayerSearchResultFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;
            ResultSet rs2 = null;

            boolean error = false;

            String[] sColName =
            {
                "playername", "locid", "goalscored", "assists", "saves", "teamid", "sponsorid", "position",
                "age", "height", "weight", "kitnumber"
            };

            int strToInt;
            String[] s = new String[20];
            //String s1 =  searchPlayerIDTF.getText();
            s[0] = (searchPlayerNameTF.getText());
            s[1] = (searchPlayerLOCIDTF.getText());
            s[2] = (searchPlayerGoalScoredTF.getText());
            s[3] = (searchPlayerAssistTF.getText());
            s[4] = (searchPlayerSavesTF.getText());
            s[5] = (searchPlayerTeamIDTF.getText());
            s[6] = (searchPlayerSponsorIDTF.getText());
            s[7] = (searchPlayerPositionTF.getText());
            s[8] = (searchPlayerAgeTF.getText());
            s[9] = (searchPlayerHeightTF.getText());
            s[10] = (searchPlayerWeightTF.getText());
            s[11] = (searchPlayerKitNoTF.getText());
            //String s14 = addPlayerImgTF.getText();

            ///
            if (!s[0].isEmpty())
            {
                s[0] = "'%" + s[0] + "%'";
            }
            if (!s[7].isEmpty())
            {
                s[7] = "'" + s[7] + "'";
            }
            /// above these two are strings and will be directly used

            if (!s[1].isEmpty())
            {
                int locid = ic.getLocID(s[1]);
                System.out.println("loc id 0 or not : " + locid);
                if (locid == 0)
                {
                    error = true;
                }
                else
                {
                    s[1] = Integer.toString(locid);
                }
            }

            if (!s[5].isEmpty())
            {
                int teamid = ic.getTeamID(s[5]);
                if (teamid == 0)
                {
                    error = true;
                }
                else
                {
                    s[5] = Integer.toString(teamid);
                }
            }

            if (!s[6].isEmpty())
            {
                int sponsorid = ic.getSponsorID(s[6]);
                if (sponsorid == 0)
                {
                    error = true;
                }
                else
                {
                    s[6] = Integer.toString(sponsorid);
                }
            }

            if (!error) ///if some value is found
            {
                String queryString = "select * from player where ";

                int whereClauseCount = 0;
                for (int i = 0; i < 12; i++)
                {
                    if (!s[i].isEmpty())
                    {
                        System.out.println("Found : " + s[i]);
                        if (whereClauseCount == 0 && sColName[i] != "playername")
                        {
                            queryString += sColName[i];
                            queryString += " = ";
                            queryString += s[i] + " ";
                            whereClauseCount++;
                        }

                        else if (whereClauseCount == 0 && sColName[i] == "playername")
                        {
                            queryString += sColName[i];
                            queryString += " like ";
                            queryString += s[i] + " ";
                            whereClauseCount++;
                        }

                        else
                        {
                            queryString += "and ";
                            queryString += sColName[i];
                            queryString += " = ";
                            queryString += s[i] + " ";
                            whereClauseCount++;
                        }

                    }
                }

                if (queryString.equals("select * from player where "))
                {
                    queryString = "select * from player";
                }

                System.out.println("queryString : " + queryString);
                rs = da.getData(queryString);
                rs2 = da.getData(queryString);

                int fetchedRow = 0;
                while (rs2.next())
                {
                    fetchedRow++;
                }

                System.out.println("Row Count : " + fetchedRow);
                boolean tableEmpty = true;
                Object[][] ob = new Object[fetchedRow][13];
                int iRow = 0;
                int iCol = -1;

                while (rs.next())
                {
                    tableEmpty = false;
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

                if (!tableEmpty)
                {
                    JTable jtb = new JTable(ob, sColName);
                    PlayerSearchResult psf = new PlayerSearchResult(jtb);
                    indexClass icStack = new indexClass();

                    if (jf != icStack.getStartFrame())
                    {
                        jf.setVisible(false);
                    }
                        
                    icStack.frameOpened(psf, jf);
                    psf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    psf.addWindowListener(new WindowSensor(psf));
                    psf.setVisible(true);
                }

                if (tableEmpty)
                {
                    System.out.println("No Data Found");
                    PlayerSearchResult psf2 = new PlayerSearchResult();
                    indexClass icStack = new indexClass();
                    if (jf != icStack.getStartFrame())
                    {
                        jf.setVisible(false);
                    }
                    icStack.frameOpened(psf2, jf);
                    psf2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    psf2.addWindowListener(new WindowSensor(psf2));
                    psf2.setVisible(true);
                }

            }

            else
            {
                System.out.println("Error! No Data Found");
                PlayerSearchResult psf2 = new PlayerSearchResult();
                indexClass icStack = new indexClass();
                if (jf != icStack.getStartFrame())
                {
                    jf.setVisible(false);
                }
                icStack.frameOpened(psf2, jf);
                psf2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                psf2.addWindowListener(new WindowSensor(psf2));
                psf2.setVisible(true);
            }

        }
        catch (SQLException ex)
        {
//            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openSearchByPlayerFrame()
    {
        try
        {
            PlayerSearchFrame psf = new PlayerSearchFrame();
            indexClass icStack = new indexClass();
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(psf, jf);
            psf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            psf.addWindowListener(new WindowSensor(psf));
            psf.setVisible(true);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void uploadImageFromAdminFrame()
    {
        JFileChooser myFileChooser = new JFileChooser();

//        Component aComponent = new Component()
//        {
//        };

        myFileChooser.showOpenDialog(null);

        addPlayerImgTF.setText(myFileChooser.getSelectedFile().getAbsolutePath());

        String s = addPlayerImgTF.getText();
        String sArr[] = new String[50];
        int iCountArr = -1;
        
        /// processing the dir
        String sTemp = "";
        for (int i = 0; i < s.length(); i++)
        {
            char cc = s.charAt(i);
            int x = cc;
            if (x == 92)
            {
                sArr[++iCountArr] = sTemp;
                System.out.println(i + 1);
                sTemp = "";
            }

            else if (i == s.length() - 1)
            {
                sTemp += cc;
                sArr[++iCountArr] = sTemp;
            }

            else
            {
                sTemp += cc;
            }
        }

        sMain = "";
        for (int i = 0; i <= iCountArr; i++)
        {
            if (i > 0)
            {
                sMain += "\\\\";
                sMain += sArr[i];
            }
            else if (i == 0)
            {
                sMain += sArr[i];
            }
            System.out.println(sArr[i]);

        }
        System.out.println(sMain);

        addPlayerImgTF.setText(sMain);

        System.out.println(addPlayerImgTF.getText());
    }

    public void deletePlayerFromAdminFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;
            String s1 = addPlayerIDTF.getText();

            int cc = da.updateDB("delete from player where playerid = " + s1);
            da.close();

            if (cc == 1)
            {
                playerMsg.setText("Successfully Deleted");
            }

            else
            {
                playerMsg.setText("Error! Check Hint");
            }
            af.reTable();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePlayerFromAdminFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;

            String s1 = addPlayerIDTF.getText();
            String s2 = addPlayerNameTF.getText();
            String s3 = addPlayerLOCIDTF.getText();
            String s4 = addPlayerGoalScoredTF.getText();
            String s5 = addPlayerAssistTF.getText();
            String s6 = addPlayerSavesTF.getText();
            String s7 = addPlayerTeamIDTF.getText();
            String s8 = addPlayerSponsorIDTF.getText();
            String s9 = addPlayerPositionTF.getText();
            String s10 = addPlayerAgeTF.getText();
            String s11 = addPlayerHeightTF.getText();
            String s12 = addPlayerWeightTF.getText();
            String s13 = addPlayerKitNoTF.getText();
            String s14 = addPlayerImgTF.getText();

            int ColUpdated = 0;
            String[] sChk =
            {
                s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14
            };
            String[] sChkIndex =
            {
                "playername", "locid", "goalscored", "assists", "saves",
                "teamid", "sponsorid", "position", "age", "height", "weight", "kitnumber", "img"
            };

            for (int i = 0; i < sChk.length; i++)
            {
                String sTemp = sChk[i];

                if (!sTemp.isEmpty())
                {
                    sTemp = "'" + sTemp + "'";

                    ColUpdated += da.updateDB("update player set " + sChkIndex[i] + " = " + sTemp + "where playerid=" + s1);
                    da.close();
                }

            }
            if (ColUpdated > 0)
            {
                playerMsg.setText(ColUpdated + " coloumbs Succssfully updated");
            }
            else
            {
                playerMsg.setText("update Error! check hint");
            }

            af.reTable();

            System.out.println(ColUpdated + " col updated");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPlayerFromAdminFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;

            String s1 = addPlayerIDTF.getText();
            String s2 = addPlayerNameTF.getText();
            String s3 = addPlayerLOCIDTF.getText();
            String s4 = addPlayerGoalScoredTF.getText();
            String s5 = addPlayerAssistTF.getText();
            String s6 = addPlayerSavesTF.getText();
            String s7 = addPlayerTeamIDTF.getText();
            String s8 = addPlayerSponsorIDTF.getText();
            String s9 = addPlayerPositionTF.getText();
            String s10 = addPlayerAgeTF.getText();
            String s11 = addPlayerHeightTF.getText();
            String s12 = addPlayerWeightTF.getText();
            String s13 = addPlayerKitNoTF.getText();
            String s14 = addPlayerImgTF.getText();
            String sDob = "";

            s1 = "'" + s1 + "'";
            s2 = "'" + s2 + "'";
            s3 = "'" + s3 + "'";
            s4 = "'" + s4 + "'";
            s5 = "'" + s5 + "'";
            s6 = "'" + s6 + "'";
            s7 = "'" + s7 + "'";
            s8 = "'" + s8 + "'";
            s9 = "'" + s9 + "'";
            s10 = "'" + s10 + "'";
            s11 = "'" + s11 + "'";
            s12 = "'" + s12 + "'";
            s13 = "'" + s13 + "'";
            s14 = "'" + s14 + "'";
            //sDob = "'"+sDob+"'";

            String sTot = "";
            sTot += s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + s7 + "," + s8 + "," + s9 + "," + s10 + "," + s11 + "," + s12 + "," + s13 + "," + s14;

            System.out.println(sTot);

            int cc = da.loadDB("insert into player values(" + sTot + ")");
            da.close();

            if (cc == 1)
            {
                playerMsg.setText("Succesfully Added a Player");
            }
            else
            {
                playerMsg.setText("Error! Please make sure player id is unique and all the boxes are filled");
            }

            af.reTable();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAdminFromAdminFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;

            String us = adminDelUserTX.getText();

            if (us.equals(currentAdmin))
            {
                msgDel.setText("username is currently logged in!");
            }

            else
            {
                System.out.println(us);

                us = "'" + us + "'";

                int cc = da.loadDB("delete from admin where username = " + us);

                if (cc == 1)
                {
                    msgDel.setText("Succesfully Deleted!");
                }

                else
                {
                    msgDel.setText("username does not exists!");
                }
            }

        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addAdminFromAdminFrame()
    {
        try
        {
            indexClass ic = new indexClass();
            DataAccess da = new DataAccess();
            ResultSet rs = null;

            //System.out.println("add adming working");
            String us = adminAddUserTX.getText();
            String ps = adminAddPassTX.getText();

            String sT = "'" + us + "'" + "," + "'" + ps + "'";
            System.out.println(sT);

            int cc = 0;

            if (!us.equals("") && !ps.equals(""))
            {
                cc = da.loadDB("insert into admin values(" + sT + ")");
                da.close();
            }
            else
            {
                cc = -1;
            }

            if (cc == 1)
            {
                msgAdd.setText("Succesfully added!");
            }
            else if (cc == -1)
            {
                msgAdd.setText("error! Field can not be empty!");
            }
            else
            {
                msgAdd.setText("username already exists!");
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printCurrentFrame() throws PrinterException
    {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);
        PageFormat postformat = pjob.pageDialog(preformat);
        //If user does not hit cancel then print.
        if (preformat != postformat)
        {
            //Set print component
            pjob.setPrintable(new Printer(jf), postformat);

            if (pjob.printDialog())
            {
                pjob.print();
            }
        }
    }

    public void openGeneralTeamFrame(String sT) /// general team frame
    {
        try
        {
            GenralTeamFrame ars = new GenralTeamFrame(jf, sT);
            indexClass icStack = new indexClass();
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(ars, jf);
            ars.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            ars.addWindowListener(new WindowSensor(ars));
            ars.setVisible(true);
        }

        catch (Exception ex)
        {
            System.out.println("Arsenal error!");
        }
    }

    public void openGeneralPlayerFrame(String playerNameCurrent)
    {
        try
        {

            indexClass icStack = new indexClass();

            GenralPlayerFrame ars = new GenralPlayerFrame(playerNameCurrent);
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(ars, jf);
            ars.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            ars.addWindowListener(new WindowSensor(ars));
            ars.setVisible(true);

        }

        catch (Exception ex)
        {
            System.out.println("Arsenal error!");
        }
    }

    public void openPlayerFrame()
    {
        try
        {
            PlayerFrame pf = new PlayerFrame();
            indexClass icStack = new indexClass();
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(pf, jf);
            pf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            pf.addWindowListener(new WindowSensor(pf));
            pf.setVisible(true);
        }

        catch (Exception ex)
        {
            System.out.println("Player error!");
        }
    }

    public void openTeamFrame()
    {
        try
        {
            TeamFrame tf = new TeamFrame();
            indexClass icStack = new indexClass();
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(tf, jf);
            tf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            tf.addWindowListener(new WindowSensor(tf));
            tf.setVisible(true);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openAdminLoginFrame()
    {
        try
        {
            LoginFrame lf = new LoginFrame();
            indexClass icStack = new indexClass();
            if (jf != icStack.getStartFrame())
            {
                jf.setVisible(false);
            }
            icStack.frameOpened(lf, jf);
            lf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            lf.addWindowListener(new WindowSensor(lf));
            lf.setVisible(true);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ButtonSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
