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

public class PlayerSearchResult extends JFrame
{

    public PlayerSearchResult()
    {
        super("Player Search Result Page");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthh = screenSize.getWidth();
        double heightt = screenSize.getHeight();
        setSize((int) widthh - 450, (int) heightt - 250);

        this.setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setLayout(new FlowLayout());

        JLabel playerEdit = new JLabel("No Result Found");
        playerEdit.setFont(new Font("Serif", Font.BOLD, 85));
        add(playerEdit);
    }

    public PlayerSearchResult(JTable jtb)
    {
        super("Player Search Result Page");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double widthh = screenSize.getWidth();
        double heightt = screenSize.getHeight();
        setSize((int) widthh - 450, (int) heightt - 250);
        this.setAlwaysOnTop(true);
        setLocation(screenSize.width / 2 - this.getSize().width / 2, screenSize.height / 2 - this.getSize().height / 2);
        setLayout(new FlowLayout());

        JLabel playerEdit = new JLabel("Result Found");
        playerEdit.setFont(new Font("Serif", Font.BOLD, 85));
        add(playerEdit);

        jtb.setPreferredScrollableViewportSize(new Dimension((int) widthh - 490, (int) heightt - 290));
        jtb.setFont(new Font("Serif", Font.TRUETYPE_FONT, 15));
        jtb.setAutoCreateRowSorter(true);

        MouseSensor ms = new MouseSensor(this, "Player Search Result Frame");

        jtb.addMouseListener(ms);

        add(new JScrollPane(jtb));

    }

}
