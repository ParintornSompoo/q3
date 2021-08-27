package com.work;

import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame implements MouseListener{
    int size = 3;
    int size_screen = 200*size;
    int turn_count;
    private final String[] player = new String[2];
    private final String[][] board_array = new String[size][size];
    JPanel screen = new JPanel();
    public Main() {
        this.turn_count = 0;
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
            this.turn_count++;
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
        int x = e.getX()/200;
        int y = e.getY()/200;
        add_position(x, y);
        this.repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    void gui_display(){
        screen.removeAll();
        Graphics2D g2d = (Graphics2D) screen.getGraphics();
        g2d.setStroke(new BasicStroke(2));
        for (int i=0;i<size;i++){
            g2d.setColor(Color.black);
            g2d.drawLine(0, i*200, size_screen, i*200);
            for (int j=0;j<size;j++){
                g2d.setColor(Color.black);
                g2d.drawLine(j*200, 0, j*200, size_screen);
                g2d.setColor(Color.green);
                g2d.setFont(new Font("Serif", Font.PLAIN, 150));
                g2d.drawString(board_array[i][j],60+(200*j),150+(200*i));
            }
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        gui_display();
    }
    public static void main(String[] args) {
        new Main();
    }
}
