/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Frame.AdminFrame;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Jamil
 */
public class indexClass 
{
    
    private String[] team = new String[10];
    private String[] player = new String[50];
    private String[] coach = new String[10];
    private String[] owner = new String[10];
    private String[] sponsor = new String[10];
    private String[] kit = new String[10];
    private String[] location = new String[10];
    private String[] stadium = new String[10];
    
    private static JFrame[] jParent = new JFrame[50];
    private static JFrame[] jParentMapping = new JFrame[50];
    private static JFrame startFrame;
    
    public indexClass() throws SQLException
    {
        DataAccess da=new DataAccess();
        ResultSet rs=null;
        
        rs=da.getData("select * from team");
        while(rs.next())
        {
//            System.out.println("Working");
            int id = rs.getInt("teamid");
            String name = rs.getString("teamname");
            team[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from player");
        while(rs.next())
        {
            
            int id = rs.getInt("playerid");
            String name = rs.getString("playername");
            player[id] = name;
        }
        da.close();
        
        rs=da.getData("select * from coach");
        while(rs.next()){
            
            int id = rs.getInt("coachid");
            String name = rs.getString("coachname");
            coach[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from owner");
        while(rs.next()){
            
            int id = rs.getInt("ownerid");
            String name = rs.getString("ownername");
            owner[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from sponsor");
        while(rs.next()){
            
           int id = rs.getInt("sponsorid");
            String name = rs.getString("sponsorname");
            sponsor[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from kit");
        while(rs.next()){
            
            int id = rs.getInt("kitid");
            String name = rs.getString("kitcolor");
            kit[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from location");
        while(rs.next()){
            
            int id = rs.getInt("locid");
            String name = rs.getString("loc");
            location[id] = name;
        }
        da.close();
        
        
        rs=da.getData("select * from stadium");
        while(rs.next()){
            
            int id = rs.getInt("stadiumid");
            String name = rs.getString("stadiumname");
            stadium[id] = name;
        }
        da.close();
        
        
    }
    
    public void setStartFrame(JFrame jf)
    {
        startFrame = jf;
    }
    
    public JFrame getStartFrame()
    {
        return startFrame;
    }
    
    public void frameOpened(JFrame curJf, JFrame parJf)
    {
        int index;
        for(int i=0;i<jParent.length;i++)
        {
            if(jParent[i] == null)
            {
                jParent[i] = curJf;
                jParentMapping[i] = parJf;
                index = i;
                break;
            }
        }
 

    }
    
    public JFrame frameClosed(JFrame curJf)
    {
        JFrame a = null;
        
        for(int i=0;i<jParent.length;i++)
        {
            if(jParent[i] == curJf)
            {
                a = jParentMapping[i];
                jParentMapping[i] = null;
                jParent[i] = null;
                break;
            }
        }
        return a;
    }
    
    public JFrame getParent(JFrame curJf)
    {
        JFrame a = null;

        for (int i = 0; i < jParent.length; i++)
        {
            if (jParent[i] == curJf)
            {
                a = jParentMapping[i];
//                jParentMapping[i] = null;
//                jParent[i] = null;
                break;
            }
        }
        return a;
    }
    
    public int countFrame()
    {
        int count = 0;
        for(int i=0;i<jParent.length;i++)
        {
            if(jParent[i] != null)count++;
            
            else break;
        }
        return count;
    }
    
    public void setAllFrameAlwaysOnTop(boolean b)
    {
        for(int i=0;i<jParent.length;i++)
        {
            if(jParent[i] != null)
            {
                jParent[i].setAlwaysOnTop(b);
            }
        }
    }
    
    
    public String getLocName(int id)
    {
        for(int i=0;i<location.length;i++)
        {
            if(i == id)return location[i];
        }
        return null;
    }
    
    public String getTeamName(int id)
    {
        for (int i = 0; i < team.length; i++)
        {
            if (i == id)
            {
                return team[i];
            }
        }
        return null;
    }
    
    
    public String getPlayerName(int id)
    {
        for (int i = 0; i < player.length; i++)
        {
            if (i == id)
            {
                return player[i];
            }
        }
        return null;
    }
    
    
    public String getSponsorName(int id)
    {
        for (int i = 0; i < sponsor.length; i++)
        {
            if (i == id)
            {
                return sponsor[i];
            }
        }
        return null;
    }
    
    public String getCoachName(int id)
    {
        for (int i = 0; i < coach.length; i++)
        {
            if (i == id)
            {
                return coach[i];
            }
        }
        return null;
    }
    
    public String getOwnerName(int id)
    {
        for (int i = 0; i < owner.length; i++)
        {
            if (i == id)
            {
                return owner[i];
            }
        }
        return null;
    }
    
    public String getStadiumName(int id)
    {
        for (int i = 0; i < stadium.length; i++)
        {
            if (i == id)
            {
                return stadium[i];
            }
        }
        return null;
    }
    
    
    
    
    
    
    public int getLocID(String s)
    {
        s = s.toLowerCase();
        for(int i=1;i<location.length;i++)
        {
            try
            {
                location[i] = location[i].toLowerCase();

                if (location[i].equals(s))
                {
                    return i;
                }
            }

            catch(Exception ex)
            {
                return 0;
            }
            
        }
        return 0;
        
    }
    
    public int getTeamID(String s)
    {
        s = s.toLowerCase();
        for (int i = 1; i < team.length; i++)
        {
            try
            {
                team[i] = team[i].toLowerCase();

                if (team[i].indexOf(s) != -1)
                {
                    return i;
                }
            }

            catch (Exception ex)
            {
                return 0;
            }

        }
        return 0;

    }
    
    public int getSponsorID(String s)
    {
        s = s.toLowerCase();
        for (int i = 1; i < sponsor.length; i++)
        {
            try
            {
                sponsor[i] = sponsor[i].toLowerCase();

                if (sponsor[i].equals(s))
                {
                    return i;
                }
            }

            catch (Exception ex)
            {
                return 0;
            }

        }
        return 0;

    }
    
    public int getPlayerID(String s)
    {
        s = s.toLowerCase();
        for (int i = 1; i < player.length; i++)
        {
            try
            {
                player[i] = player[i].toLowerCase();
                
                if (player[i].equals(s))
                {
                    return i;
                }
            }

            catch (Exception ex)
            {
                return 0;
            }

        }
        
        return 0;
    }
    
    
    
}
