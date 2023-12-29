package chapter20_TankGame_3.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.util.Vector;

/*
- 坦克大战的绘图区域
- 能监听键盘事件
 */
@SuppressWarnings("all")

public class MyPanel extends JPanel implements KeyListener, Runnable {
    // Hero Tank (player)
    Hero hero = null;

    // Enemy Tanks
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 8;
    Vector<Node> nodes = new Vector<>(); //记录坐标


    // Bombs effeft
    Vector<Bomb> bombs = new Vector();
    Image bomb1 = null;
    Image bomb2 = null;
    Image bomb3 = null;
    Image bomb4 = null;


    // Initalize Panel
    public MyPanel() {
        nodes = Recorder.getNodesAndEnemyTankRec();

        // Initialze Hero information
        hero = new Hero(100,500); // coordinate
        hero.setSpeed(20); // tank speed

        for (int i = 0; i < enemyTankSize; i++) {
            // put one enemy tank each 100 (x)
            EnemyTank enemyTank = new EnemyTank(100*(i+1), 0);
            enemyTank.setDirect(2); // down
            enemyTank.setEnemyTanks(enemyTanks); // Assign information from the
            // enemyTanks collection to each enemy tank
            new Thread(enemyTank).start();

            // Add a bullet to the tank
            Shot shot = new Shot(enemyTank.getX()+20, enemyTank.getY()+60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start(); // Start bullet thread

            enemyTanks.add(enemyTank); // Add this class to the enemyTanks collection
        }
        Recorder.setEnemyTanks(enemyTanks);


        // Initialize explosion effect
        bomb1 = Toolkit.getDefaultToolkit().getImage("C:/Users/Asus/OneDrive/Desktop/JavaLearning/JavaSE_Note/JavaLearning_Basic_Stage02/src/chapter18_TankGame_2/bomb_1.jpg");
        bomb2 = Toolkit.getDefaultToolkit().getImage("C:/Users/Asus/OneDrive/Desktop/JavaLearning/JavaSE_Note/JavaLearning_Basic_Stage02/src/chapter18_TankGame_2/bomb_2.jpg");
        bomb3 = Toolkit.getDefaultToolkit().getImage("C:/Users/Asus/OneDrive/Desktop/JavaLearning/JavaSE_Note/JavaLearning_Basic_Stage02/src/chapter18_TankGame_2/bomb_3.jpg");
        bomb4 = Toolkit.getDefaultToolkit().getImage("C:/Users/Asus/OneDrive/Desktop/JavaLearning/JavaSE_Note/JavaLearning_Basic_Stage02/src/chapter18_TankGame_2/bomb_4.jpg");
    }


    // displays the total number of tanks destroyed
    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 20);
        g.setFont(font);

        // Destroyed tank information
        g.drawString("Total defeated Tank: ", 1020, 30);
        drawTank(1020, 60, g, 0, 0); //画出敌方坦克logo
        g.setColor(Color.black);
        g.drawString(Recorder.getTotal_enemy()+"", 1080, 100);


    }


    // Draw a tank
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Set the background (cannot adjust bgc color directly, can only draw a big box)
        g.fillRect(0,0,1000,750); // x=1000, y=750

        // Grade information
        showInfo(g);

        // draw hero tank
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1); //上
        }

        // Draw the bullet fired by the hero
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);

            if (shot != null && shot.isLive == true) { //子弹有效时
                g.fillOval(shot.x, shot.y, 6, 6);
            } else { // When the bullet expires (destroyed)
                hero.shots.remove(shot);
            }
        }

//        if (hero.shot != null && hero.shot.isLive) {
//            g.fillOval(hero.shot.x, hero.shot.y, 6, 6);
//        }


        // If there is an object in the bombs collection, draw it
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);

            if (bomb.life > 12) {
                g.drawImage(bomb4, bomb.x, bomb.y, 60,60, this);
            } else if (bomb.life > 8) {
                g.drawImage(bomb3, bomb.x+5, bomb.y+5, 50,50, this);
            } else if (bomb.life > 4) {
                g.drawImage(bomb2, bomb.x+10, bomb.y+10, 40,40, this);
            } else {
                g.drawImage(bomb1, bomb.x+15, bomb.y+15, 30,30, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

            // If the tank is hit, a bomb object will be created
            // Use bombs collection to save those bombs
            // Because there may be multiple explosions happening at the same time?
            // Then take out the bombs in bombs, traverse the pictures and reduce the explosion period (lifespan)
            // When the explosion lifespan reaches 0, remove it from bombs

        }


        // Draw enemy tanks (need to be based on the contents of the Vector,
        // not the initial number of tanks, because the tanks will be destroyed/deleted)
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank et = enemyTanks.get(i);

            if (et.isLive) { // if the enemy tank is still alive(true)
                drawTank(et.getX(), et.getY(), g, et.getDirect(), 0);
                for (int j = 0; j < et.shots.size(); j++) { // bulletes numbers
                    // take out the bullet
                    Shot shot = et.shots.get(j);

                    if (shot.isLive) { // if true
                        g.fill3DRect(shot.x, shot.y, 6, 6, false);
                    } else { // If false, remove the bullet
                        et.shots.remove(shot);
                    }
                }

            }
        }
    }

    /*
        x = 横坐标
        y = 竖坐标
        g = 画笔
        direct = 方向
        type = 坦克类型(敌/我)
     */

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        // Set color according to tank camp
        switch (type) {
            case 0: // enemy
                g.setColor(Color.orange);
                break;
            case 1: // hero
                g.setColor(Color.cyan);
                break;
        }

        //
        switch (direct) {
            case 0: // 向上
                x+=10;
                g.fill3DRect(x, y, 10, 60, false); //左轮子
                g.fill3DRect(x+30, y, 10, 60, false); //右轮子
                g.fill3DRect(x+10, y+10, 20,40,false); //身体
                g.fillOval(x+10, y+20, 20, 20); //小圆盖
                g.fill3DRect(x+19, y, 2, 30,true); //炮管子
                break;

            case 1: // 右
                g.fill3DRect(x, y+40, 60, 10, false); //右轮子
                g.fill3DRect(x, y+10, 60, 10, false); //左轮子
                g.fill3DRect(x+10, y+20, 40,20,false); //身体
                g.fillOval(x+20, y+20, 20, 20); //小圆盖
                g.fill3DRect(x+30, y+29, 30, 2,true); //炮管子
                break;

            case 2: // 下
                x+=10;
                g.fill3DRect(x, y, 10, 60, false); //左轮子
                g.fill3DRect(x+30, y, 10, 60, false); //右轮子
                g.fill3DRect(x+10, y+10, 20,40,false); //身体
                g.fillOval(x+10, y+20, 20, 20); //小圆盖
                g.fill3DRect(x+19, y+30, 2, 30,true); //炮管子
                break;

            case 3: // 左
                g.fill3DRect(x, y+40, 60, 10, false); //左轮子
                g.fill3DRect(x, y+10, 60, 10, false); //右轮子
                g.fill3DRect(x+10, y+20, 40,20,false); //身体
                g.fillOval(x+20, y+20, 20, 20); //小圆盖
                g.fill3DRect(x, y+29, 30, 2,true); //炮管子
                break;

            default:
                System.out.println("暂时没有处理");
        }

    }

    // Whether the bullet hits the tank or not, it will be destroyed if it hits.
    public void hitTank(Shot s, Tank tank) {
        switch (tank.getDirect()) { // Determine the direction of enemy tanks
            case 0: // 上
            case 2: // 下
                if (s.x > tank.getX() && s.x < tank.getX()+40
                        && s.y > tank.getY() && s.y < tank.getY()+60) {
                    System.out.println("hit tank funcion (if 0, 2)");
                    s.isLive = false; // bullet destruction
                    tank.isLive = false; // Enemy tanks destroyed

                    if (tank instanceof EnemyTank && !tank.isLive) { // Avoid counting hero defeats
                        Recorder.addTotal_enemy();
                    }

                    System.out.println("Hit the tank - bullet destroyed");
                    enemyTanks.remove(tank); // Move out of the collection to prevent it from still being displayed

                    // Create a Bombs object and add it to the bombs collection
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());// Explodes at the location of the tank
                    bombs.add(bomb);
                }

            case 1:
            case 3:
                if (s.x > tank.getX() && s.x < tank.getX()+60
                        && s.y > tank.getY()+10 && s.y < tank.getY()+50) {
                    System.out.println("hit tank funcion (if 1, 3)");

                    s.isLive = false; // bullet destruction
                    tank.isLive = false; // Enemy tanks destroyed


                    if (tank instanceof EnemyTank && !tank.isLive) { // Avoid counting hero defeats
                        Recorder.addTotal_enemy();
                    }

                    System.out.println("Hit the tank - bullet destroyed");
                    enemyTanks.remove(tank); // Move out of the collection to prevent it from still being displayed

                    // Create a Bombs object and add it to the bombs collection
                    Bomb bomb = new Bomb(tank.getX(), tank.getY()); // Explodes at the location of the tank
                    bombs.add(bomb);
                }
        }

    }


    public void isHitEnemy() {
//        System.out.println("isHitEnemy function...");
        for (int j = 0; j < hero.shots.size(); j++) { // Take the bullet out from the set and judge
            Shot shot = hero.shots.get(j);

            if (shot != null && shot.isLive == true) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(shot, enemyTank);
//                    System.out.println("x=" + shot.x + ", y=" + shot.y);
                }
            }
        }
    }

    public void isHitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);

            for (int j = 0; j < enemyTank.shots.size(); j++) { // Take the bullet out from the set and judge
                Shot shot = enemyTank.shots.get(j);
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // We control the direction of the tank, so it is hero (wdsa up, right, down, left)
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0) { // If it is smaller than y/exceeds the upper boundary, it cannot move anymore.
                hero.moveUp();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX()+60 < 1000) { // If it is smaller than y/exceeds the upper boundary, it cannot move anymore.
                hero.moveRight();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY()+60 < 750) { // If it is smaller than y/exceeds the upper boundary, it cannot move anymore.
                hero.moveDown();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) { // If it is smaller than y/exceeds the upper boundary, it cannot move anymore.
                hero.moveLeft();
            }

        }

        // J，发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {
//            // case of a bullet
//            if (hero.shot == null || hero.shot.isLive == false) {
//                hero.shootEnemyTank();
//            }

            // multiple bullets
            if (hero.isLive) {
                hero.shootEnemyTank();
            }

        }

        this.repaint(); // repaint the panel
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        int millis = 0;

        while (true) {
            try {
                Thread.sleep(10); // Redraw every 10 milliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // judge whether the bullet hits the enemy tank
            isHitEnemy();

            // Determine whether the bullet hits the hero tank
//            isHitHero();

            this.repaint();
            millis += 10;

            if (millis%1000 == 0) {
                System.out.println("milliseconds: " + millis/1000 );
            }

        }
    }
}
