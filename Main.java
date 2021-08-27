package com.work;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    static int countround = 0;
    static JFrame frame = new JFrame();
    static JPanel title_panel = new JPanel();
    static JPanel button_panel = new JPanel();
    static JLabel label = new JLabel();
    static JButton[] buttons = new JButton[9];
    static String player = "O";
    static void guidisplay() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("OX Game");
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setFont(new Font(Font.SERIF,Font.BOLD,30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Welcome to OX Game");

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,500,10);
        title_panel.add(label);
        frame.add(title_panel,BorderLayout.NORTH);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setText(" ");
            buttons[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("This is X Turn");
                    for (int x = 0; x < 9; x++) {
                        if (e.getSource() == buttons[x]) {
                            buttons[x].setText(player);
                            buttons[x].setEnabled(false);
                            if (player.equals("O")) {
                                player = "X";
                            } else {
                                player = "O";
                                label.setText("This is O Turn");
                            }
                            countround++;
                            if (countround == 9)
                                label.setText("DRAW");

                        }
                        checkwin();
                    }
                    if(checkwin()){
                        for (int i = 0; i < 9; i++)
                            buttons[i].setEnabled(false);
                        if (player.equals("X"))
                            label.setText("Player O WIN");
                        if (player.equals("O"))
                            label.setText("Player X WIN");
                    }


                }
            });
        }

        frame.add(button_panel);
    }
    static boolean checkwin(){
        if (buttons[0].getText().equals(buttons[1].getText())&& buttons[1].getText().equals(buttons[2].getText()) && !buttons[0].getText().equals(" "))
            return true;
        else if (buttons[3].getText().equals(buttons[4].getText())&& buttons[4].getText().equals(buttons[5].getText()) && !buttons[3].getText().equals(" "))
            return true;
        else if (buttons[6].getText().equals(buttons[7].getText())&& buttons[7].getText().equals(buttons[8].getText()) && !buttons[6].getText().equals(" "))
            return true;
        else if (buttons[0].getText().equals(buttons[3].getText())&& buttons[3].getText().equals(buttons[6].getText()) && !buttons[0].getText().equals(" "))
            return true;
        else if (buttons[1].getText().equals(buttons[4].getText())&& buttons[4].getText().equals(buttons[7].getText()) && !buttons[1].getText().equals(" "))
            return true;
        else if (buttons[2].getText().equals(buttons[5].getText())&& buttons[5].getText().equals(buttons[8].getText()) && !buttons[2].getText().equals(" "))
            return true;
        else if (buttons[3].getText().equals(buttons[4].getText())&& buttons[4].getText().equals(buttons[5].getText()) && !buttons[3].getText().equals(" "))
            return true;
        else if (buttons[0].getText().equals(buttons[4].getText())&& buttons[4].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals(" "))
            return true;
        else if (buttons[2].getText().equals(buttons[4].getText())&& buttons[4].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals(" "))
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        guidisplay();
        }


}
