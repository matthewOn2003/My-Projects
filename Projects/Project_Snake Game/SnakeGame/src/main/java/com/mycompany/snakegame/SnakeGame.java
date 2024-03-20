/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.snakegame;
import javax.swing.JFrame;

/**
 *
 * @author Trainee1
 */
public class SnakeGame {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panel panel = new Panel(600, 600);
        frame.add(panel);
        frame.pack();
        panel.requestFocus();
        

        
        
    }
}
