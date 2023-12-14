package chapter20_TankGame_3.TankGame;

/*
    射子弹：
    1. 发射一颗子弹 = 启动一个线程
    2. Hero 有子弹属性，按下 J 就发射，让子弹不停移动(while(true))，形成射击效果
    3. MyPanel 需要不断重绘
    4. 子弹碰到东西时，该线程应该销毁 (取消无限循环)
 */

@SuppressWarnings("all")
public class Shot implements Runnable {
    int x;
    int y;
    int direct = 0;
    int speed = 20;
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;

        // 速度可以另外调整
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Change coordinates according to direction (up, right, bottom, left)
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }

            // If the bullet is not within the panel range and is dead, enter the statement
            if (!(x > 0 && x < 1000) || !(y > 0 && y < 750) && isLive == true) {
//                System.out.println("超出边界-子弹销毁");
                isLive = false;
                break; // quit while
            }
        }
    }
}
