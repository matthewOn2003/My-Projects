/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author Trainee1
 */
public class TileManager {
    
    GamePanel gp;
    Tile[] tiles;
    int mapTileNum[][];
    
    public TileManager(GamePanel gp) {
        
        this.gp = gp;
        tiles = new Tile[10]; // 16*12=192
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("C:\\Users\\Asus\\OneDrive\\Desktop\\My-Projects\\Projects\\" +
                "Project_Treasure Hunting Game\\TreasureHuntingGame\\res\\map\\world.txt");
    }
    
    
    public void getTileImage() {
        
        // Specify the file path
        String directoryPath = "C:\\Users\\Asus\\OneDrive\\Desktop\\My-Projects\\" +
                "Projects\\Project_Treasure Hunting Game\\TreasureHuntingGame\\res\\components\\";
        
        String grassFilePath = directoryPath + "grass.png";
        String wallFilePath = directoryPath + "wall.png";
        String waterFilePath = directoryPath + "water.png";
        String sandFilePath = directoryPath + "sand.png";
        String treeFilePath = directoryPath + "tree.png";
        
        // Declare FileInputStream and BufferedImage
        FileInputStream fis = null;

        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new FileInputStream(grassFilePath));
            
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new FileInputStream(wallFilePath));
            
            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(new FileInputStream(waterFilePath));
            
            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(new FileInputStream(sandFilePath));
            
            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(new FileInputStream(treeFilePath));
            
            
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
    
    
    public void loadMap(String mapPath) {
        
        InputStream is = null;
        BufferedReader br = null;
        
        try {
            is = new FileInputStream(mapPath);
            br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                
                String line = br.readLine();
                
                while (col < gp.maxWorldCol) {
                    
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                    
                }
                
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
             try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                // Handle IO exceptions that may occur while closing the streams
                e.printStackTrace();
            }
        }
        
        for (int i = 0; i < mapTileNum.length; i++) {
            for (int j = 0; j < mapTileNum[i].length; j++) {
                System.out.print(mapTileNum[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
       
    }
    
    
    public void draw(Graphics2D g2) {
        
        int worldCol = 0;
        int worldRow = 0;
        int x = 0;
        int y = 0;
        

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            
           int tileNum = mapTileNum[worldCol][worldRow];
           
           int worldX = worldCol * gp.tileSize;
           int worldY = worldRow * gp.tileSize;
           int screenX = worldX - gp.player.worldX + gp.player.screenX;
           int screenY = worldY - gp.player.worldY + gp.player.screenY;
           

           if (
                   worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
                   worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
                   worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
                   worldY < gp.player.worldY + gp.player.screenY + gp.tileSize) {

               g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

           }



           worldCol++;
           
           if (worldCol == gp.maxWorldCol) {
               worldCol = 0;
               worldRow++;
           }
           
        }
        
                
    }
}
