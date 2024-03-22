/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Trainee1
 */

public class Player extends Entity {
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    
    public Player(GamePanel gp, KeyHandler keyH) {
        
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        
        setDefaultValues();
        
    }
    
    
    public void setDefaultValues() {
    
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 10;
        direction = "down";
        
    }
    
    
    public void getPlayerImage() {
        
        // Specify the file path
        String directoryPath = "C:\\Users\\Trainee1\\Desktop\\"
                + "TestApp05\\java projects\\Project_Treasure Hunting Game\\"
                + "TreasureHuntingGame\\res\\player\\";
        
        String up1FilePath = directoryPath + "boy_up1.png";
        String up2FilePath = directoryPath + "boy_up2.png";
        String down1FilePath = directoryPath + "boy_down1.png";
        String down2FilePath = directoryPath + "boy_down2.png";
        String left1FilePath = directoryPath + "boy_left1.png";
        String left2FilePath = directoryPath + "boy_left2.png";
        String right1FilePath = directoryPath + "boy_right1.png";
        String right2FilePath = directoryPath + "boy_right2.png";

        
        // Declare FileInputStream and BufferedImage
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(up1FilePath);
            up1 = ImageIO.read(fis);
            
            fis = new FileInputStream(up2FilePath);
            up2 = ImageIO.read(fis);
            
            fis = new FileInputStream(down1FilePath);
            down1 = ImageIO.read(fis);
            
            fis = new FileInputStream(down2FilePath);
            down2 = ImageIO.read(fis);
            
            fis = new FileInputStream(left1FilePath);
            left1 = ImageIO.read(fis);
            
            fis = new FileInputStream(left2FilePath);
            left2 = ImageIO.read(fis);
            
            fis = new FileInputStream(right1FilePath);
            right1 = ImageIO.read(fis);
            
            fis = new FileInputStream(right2FilePath);
            right2 = ImageIO.read(fis);
            
            
        } catch (IOException e) {
            e.printStackTrace();
            
        } finally {
            // Close the FileInputStream
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        
    }
    
    
    public void update() {
        
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            }

            else if (keyH.downPressed) {
                direction = "down";
                worldY += speed;
            }

            else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            }

            else if (keyH.rightPressed) {
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;

            if (spriteCounter > 8) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        
    }
    
    
    public void draw(Graphics2D g2) {
        
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        
        switch (direction) {
            case "up":
                image = (spriteNum == 1) ? up1 : up2;
                break;
            case "down":
                image = (spriteNum == 1) ? down1 : down2;
                break;
            case "left":
                image = (spriteNum == 1) ? left1 : left2;
                break;
            case "right":
                image = (spriteNum == 1) ? right1 : right2;
                break;
        }
        
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        
    }
    
}




