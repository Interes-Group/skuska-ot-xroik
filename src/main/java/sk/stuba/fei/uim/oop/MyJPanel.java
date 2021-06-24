package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJPanel extends JPanel implements ActionListener {

    private final JButton JBstrom;
    private final JButton JBdom;
    private final JButton JBcesta;
    private final JLabel  JLtext;
    private Color c = Color.RED;
    private int counter = 0;

    public MyJPanel(){
        JBstrom = new JButton("Strom");
        JBdom = new JButton("Dom");
        JBcesta = new JButton("Cesta");
        JLtext = new JLabel("Kreslenie stromu",SwingConstants.CENTER);
        this.setLayout(new GridLayout(1,4));
        JBstrom.addActionListener(this);
        JBdom.addActionListener(this);
        JBcesta.addActionListener(this);
        JLtext.setForeground(Color.MAGENTA);
        this.add(JBstrom);
        this.add(JBdom);
        this.add(JBcesta);
        this.add(JLtext);

        this.setVisible(true);
    }
    public void switchColor(){
        switch (counter) {
            case 0:
                c = Color.RED;
                counter++;
                break;
            case 1:
                c = Color.BLUE;
                counter++;
                break;
            case 2:
                c = Color.MAGENTA;
                counter=0;
                break;
        }
        JLtext.setForeground(c);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Strom")) {
            JLtext.setText("Kreslenie stromu");
            switchColor();
        }
        if (e.getActionCommand().equals("Dom")) {
            JLtext.setText("Kreslenie domu");
            switchColor();
        }
        if (e.getActionCommand().equals("Cesta")) {
            JLtext.setText("Kreslenie cesty");
            switchColor();
        }
    }
    }
