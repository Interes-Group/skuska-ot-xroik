package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@Getter
@Setter
public class MyJPanel extends JPanel implements ActionListener {

    private final JButton JBstrom;
    private final JButton JBdom;
    private final JButton JBcesta;
    private final JLabel  JLtext;
    private Color c = Color.RED;
    private int counter = 1;
    private boolean isTreeClicked = true;
    private boolean isHouseClicked = false;
    private boolean isLineClicked = false;

    public MyJPanel(){
        JBstrom = new JButton("Strom");
        JBdom = new JButton("Dom");
        JBcesta = new JButton("Cesta");
        JLtext = new JLabel("Kreslenie stromu",SwingConstants.CENTER);
        JLtext.setOpaque(true);
        JLtext.setBackground(Color.RED);
        this.setLayout(new GridLayout(1,4));
        JBstrom.addActionListener(this);
        JBdom.addActionListener(this);
        JBcesta.addActionListener(this);
        this.add(JBstrom);
        this.add(JBdom);
        this.add(JBcesta);
        this.add(JLtext);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Strom")) {
            isTreeClicked = true;
            isHouseClicked = false;
            isLineClicked = false;
            JLtext.setText("Kreslenie stromu");
            //switchColor();
        }
        if (e.getActionCommand().equals("Dom")) {
            isTreeClicked = false;
            isHouseClicked = true;
            isLineClicked = false;
            JLtext.setText("Kreslenie domu");
            //switchColor();
        }
        if (e.getActionCommand().equals("Cesta")) {
            isTreeClicked = false;
            isHouseClicked = false;
            isLineClicked = true;
            JLtext.setText("Kreslenie cesty");
            //switchColor();
        }
    }
    }
