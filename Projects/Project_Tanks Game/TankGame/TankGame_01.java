package chapter20_TankGame_3.TankGame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

@SuppressWarnings("all")

/*
    未解决的bug:
    1. Hero can shot even it was dead
    2. Enemy Tanks shot too fast
    3. Enemy tanks will gradually gather in the lower left corner and cannot disperse.
        It is already quite serious at about 120 seconds.

    New Feature need to add:
    1. Prevent tanks from overlapping
     - When the enemy tank moves randomly, if there are people a few squares in front of it, you need to switch to another direct
     - Up, right, bottom, left, each detection coordinate is different

     2. Record player results, save and exit
     - [Create a collection of "destroyed tanks"] or [Use count to count, when enemy tanks are destroyed then count++]
     - When the player is hit, the game ends, save [player's last coordinates, output count or size of "destroyed tank"]
     - Customize the game ending according to the number of counts

     3. Record the coordinates of enemy tanks
     - Moment when coordinates need to be saved: When the enemy tank is destroyed, ask when exiting the game
     - Save these things into a properties file
     - When you return to the game later, use the properties file information to initialize the tank
     - Save: coordinates of enemy and friendly tanks

     4. You can choose to continue the previous game or start a new one

 */


public class TankGame_01 extends JFrame {
    private MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TankGame_01 tankGame01 = new TankGame_01();
    }

    public TankGame_01(){
//        System.out.println("是否要继续上局游戏？(1=新游戏，2=继续上局)");
//        String key = scanner.next();
        mp = new MyPanel();

        // add MyPanel to "this" ("this" class has extend JFrame)
        this.add(mp);

        // set the frame size (x, y)
        this.setSize(1400,750);

        // click X can close frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set Frame to visible
        this.setVisible(true);

        // add Listener on mp
        this.addKeyListener(mp);

        // make mp as a thread and start it
        Thread thread = new Thread(mp);
        thread.start();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("-------- Listen to the window being closed, and exit normally --------");
//                Recorder.keepRecord();
                System.exit(0);
            }
        });

    }

}
