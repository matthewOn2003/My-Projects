package chapter20_TankGame_3.TankGame;

import java.io.*;
import java.util.Vector;

@SuppressWarnings("all")
public class Recorder {
    // 记录成绩
    // 将成绩写入文件
    // 记录游戏进度
    // 记录到 myRecord.txt (有输入流和输出流)
    private static int total_enemy = 0; //敌方坦克数量

    // 定义IO对象
    public static BufferedWriter bw = null; //操作 字符输出流
    public static BufferedReader br = null; //操作 字符输入流
    private static String recordFile = "C:\\Users\\Asus\\OneDrive\\Desktop" +
            "\\JavaLearning\\JavaSE_Note\\JavaLearning_Basic_Stage02\\" +
            "src\\chapter20_TankGame_3\\myRecord.txt";

    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>(); //之后要把多个node放进去，每个node代表一组坐标



    // getter，setter
    public static int getTotal_enemy() {
        return total_enemy;
    }
    public static void setTotal_enemy(int total_enemy) {
        Recorder.total_enemy = total_enemy;
    }

    // Collection of enemy tanks
    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }


    // read recordFile and restore related information
    public static Vector<Node> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(recordFile));

            // Read the number of destroyed tanks
            total_enemy = Integer.parseInt(br.readLine());

            // Loop reading and generate node collection
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]),
                        Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes; //返回一个坐标队列
    }


    // Save results to the specified file, which needs to be called when exiting the game
    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(total_enemy + "\r\n");

            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank et = enemyTanks.get(i);
                if (et.isLive) {
                    // record xyd (x, y, direct)
                    String record = et.getX()+" "+et.getY()+" "+et.getDirect();

                    // write to document
                    bw.write(record + "\r\n");
                }
            }
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    // When our tanks destroy enemy tanks
    public static void addTotal_enemy() {
        Recorder.total_enemy++;
    }
}
