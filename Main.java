package com.work;

import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame implements MouseListener{
    int size = 5;
    int size_screen = 200*size;
    int turnCount;
    private final String[] player = new String[2];
    private final String[][] board_array = new String[size][size];
    JPanel screen = new JPanel();
    public Main() {
        this.turnCount = 0;
        this.player[0] = "0";
        this.player[1] = "X";
        for (int i = 0;i < size;i++){
            for (int j = 0;j < size;j++){
                this.board_array[i][j] = " ";
            }
        }
        this.setTitle("OX Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        screen.setPreferredSize(new Dimension(size_screen, size_screen));
        screen.addMouseListener(this);
        this.add(screen);
        this.pack();
        this.setVisible(true);
    }
    public void add_position(int x,int y) {
        if (this.board_array[y][x].equals(" ")) {
            this.board_array[y][x] = this.player[0];
            this.turnCount++;
            this.change_player();
        }
    }
    private void change_player() {
        String swapplayer = this.player[0];
        this.player[0] = this.player[1];
        this.player[1] = swapplayer;
    }
    public boolean check_winner() {
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    public static void main(String[] args) {
        new Main();
    }
}
