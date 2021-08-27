package com.work;

import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame implements MouseListener{
    int size = 4;
    int size_screen = 200*size;
    int turn_count;
    String mode = "Play";
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
    public boolean[] check_winner() {
        boolean[] result = {false,false};
        String[] check_list2 = new String[size]; // แนวตั้ง
        String[] check_list3 = new String[size]; // แนวแทยงซ้าย
        String[] check_list4 = new String[size]; // แนวแทยงขวา
        String [] check_player = new String[size];
        for (int i = 0;i<size;i++){
            check_player[i] = this.player[1];
        }
        for (int i = 0;i<size;i++) {
            check_list3[i] = this.board_array[i][i];
            check_list4[i] = this.board_array[i][size-i-1];
            for (int j = 0;j<size;j++){
                check_list2[j] = this.board_array[j][i];
                if (Arrays.deepEquals(board_array[j],check_player)){
                    result[0] = true;
                    return result;
                }
                if (Arrays.deepEquals(check_list2,check_player)){
                    result[0] = true;
                    return result;
                }
            }
            if (Arrays.deepEquals(check_list3,check_player)){
                result[0] = true;
                return result;
            }
            if (Arrays.deepEquals(check_list4,check_player)){
                result[0] = true;
                return result;
            }
        }

        if (this.turn_count == size * size){
            result[0] = true;
            result[1] = true;
        }
        return result;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (check_winner()[0]){
            return;
        }
        int x = e.getX()/200;
        int y = e.getY()/200;
        add_position(x, y);
        if (check_winner()[0]){
            mode = "Win";
            this.repaint();
        }
        this.repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    void gui_play(){
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
    void gui_win(){
        Graphics2D g2d = (Graphics2D) screen.getGraphics();
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Serif", Font.PLAIN, 120));
        if (check_winner()[1]){
            g2d.drawString("DRAW",size_screen / 5,size_screen / 2);
        }
        else
            g2d.drawString(player[1] + " WIN",size_screen / 5,size_screen / 2);
    }
    public void paint(Graphics g){
        super.paint(g);
        switch (mode){
            case "Play":
                gui_play();
                break;
            case "Win":
                gui_win();
                break;
            default:
                break;
        }
    }
    public static void main(String[] args){
        new Main();
    }
}
