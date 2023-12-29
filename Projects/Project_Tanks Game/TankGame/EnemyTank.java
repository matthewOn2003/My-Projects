package chapter20_TankGame_3.TankGame;

import java.util.Vector;

@SuppressWarnings("all")
public class EnemyTank extends Tank implements Runnable {
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>(); //每个敌人坦克，都能获取所有敌人坦克的信息

    public EnemyTank(int x, int y) {
        super(x, y);
        setSpeed(10);
    }

    // 提供一个方法，让MyPanel的enemyTanks赋值 本类的enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }


    // 判断当前坦克是否和其他坦克发生重叠
    public boolean isTouchEnemyTank() {
        switch (this.getDirect()) { //this的方向在
            case 0: //上
                // this坦克左上角坐标 [this.getX(), this.getY()]
                // this坦克右上角坐标 [this.getX()+40, this.getY()]

                // 让this敌人坦克和其他坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank et = enemyTanks.get(i);
                    int etDirect = et.getDirect();

                    if (et != this) { //不和自己比较, 和其他坦克比较
                        switch (etDirect) { //敌人的方向在
                            case 0, 2: //上，下
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+40]
                                // 敌人坦克 y范围: [et.getY() ~ et.getY()+60]

                                // 1. 判断this左上角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+40
                                        && this.getY() >= et.getY()
                                        && this.getY() <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右上角是否进入坦克范围
                                if (this.getX()+40 >= et.getX()
                                        && this.getX()+40 <= et.getX()+40
                                        && this.getY() >= et.getY()
                                        && this.getY() <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return



                            case 1, 3: //左，右
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+60]
                                // 敌人坦克 y范围: [et.getY()+10 ~ et.getY()+50]

                                // 1. 判断this左上角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+60
                                        && this.getY() >= et.getY()+10
                                        && this.getY() <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右上角是否进入坦克范围
                                if (this.getX()+40 >= et.getX()
                                        && this.getX()+40 <= et.getX()+60
                                        && this.getY() >= et.getY()+10
                                        && this.getY() <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return
                        }
                    }

                } //for结束

            case 1: //右
                // this坦克右上角坐标 [this.getX()+60, this.getY()+10]
                // this坦克右下角坐标 [this.getX()+60, this.getY()+50]

                // 让this敌人坦克和其他坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank et = enemyTanks.get(i);
                    int etDirect = et.getDirect();

                    if (et != this) {//不和自己比较, 和其他坦克比较
                        switch (etDirect) { //敌人的方向在
                            case 0, 2: //上，下
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+40]
                                // 敌人坦克 y范围: [et.getY() ~ et.getY()+60]

                                // 1. 判断this右上角是否进入坦克范围
                                if (this.getX()+60 >= et.getX()
                                        && this.getX()+60 <= et.getX()+40
                                        && this.getY()+10 >= et.getY()
                                        && this.getY()+10 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右下角是否进入坦克范围
                                if (this.getX()+60 >= et.getX()
                                        && this.getX()+60 <= et.getX()+40
                                        && this.getY()+50 >= et.getY()
                                        && this.getY()+50 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return



                            case 1, 3: //左，右
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+60]
                                // 敌人坦克 y范围: [et.getY()+10 ~ et.getY()+50]

                                // 1. 判断this右上角是否进入坦克范围
                                if (this.getX()+60 >= et.getX()
                                        && this.getX()+60 <= et.getX()+60
                                        && this.getY()+10 >= et.getY()+10
                                        && this.getY()+10 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右下角是否进入坦克范围
                                if (this.getX()+60 >= et.getX()
                                        && this.getX()+60 <= et.getX()+60
                                        && this.getY()+50 >= et.getY()+10
                                        && this.getY()+50 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return
                        }

                    }

                } //for结束


            case 2: //下
                // this坦克左下角坐标 [this.getX(), this.getY()+60]
                // this坦克右下角坐标 [this.getX()+40, this.getY()+60]

                // 让this敌人坦克和其他坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank et = enemyTanks.get(i);
                    int etDirect = et.getDirect();

                    if (et != this) {//不和自己比较, 和其他坦克比较
                        switch (etDirect) { //敌人的方向在
                            case 0, 2: //上，下
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+40]
                                // 敌人坦克 y范围: [et.getY() ~ et.getY()+60]

                                // 1. 判断this左下角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+40
                                        && this.getY()+60 >= et.getY()
                                        && this.getY()+60 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右下角是否进入坦克范围
                                if (this.getX()+40 >= et.getX()
                                        && this.getX()+40 <= et.getX()+40
                                        && this.getY()+60 >= et.getY()
                                        && this.getY()+60 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return


                            case 1, 3: //左，右
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+60]
                                // 敌人坦克 y范围: [et.getY()+10 ~ et.getY()+50]

                                // 1. 判断this左下角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+60
                                        && this.getY()+60 >= et.getY()+10
                                        && this.getY()+60 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this右下角是否进入坦克范围
                                if (this.getX()+40 >= et.getX()
                                        && this.getX()+40 <= et.getX()+60
                                        && this.getY()+60 >= et.getY()+10
                                        && this.getY()+60 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return
                        }

                    }

                } //for结束


            case 3: //左
                // this坦克左上角坐标 [this.getX(), this.getY()+10]
                // this坦克左下角坐标 [this.getX(), this.getY()+50]

                // 让this敌人坦克和其他坦克比较
                for (int i = 0; i < enemyTanks.size(); i++) {
                    //取出敌人坦克
                    EnemyTank et = enemyTanks.get(i);
                    int etDirect = et.getDirect();

                    if (et != this) {//不和自己比较, 和其他坦克比较
                        switch (etDirect) { //敌人的方向在
                            case 0, 2: //上，下
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+40]
                                // 敌人坦克 y范围: [et.getY() ~ et.getY()+60]

                                // 1. 判断this左上角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+40
                                        && this.getY()+10 >= et.getY()
                                        && this.getY()+10 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this左下角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+40
                                        && this.getY()+50 >= et.getY()
                                        && this.getY()+50 <= et.getY()+60) {
                                    return true;
                                } //不需要break了因为有return



                            case 1, 3: //左，右
                                // 敌人坦克 x范围: [et.getX() ~ et.getX()+60]
                                // 敌人坦克 y范围: [et.getY()+10 ~ et.getY()+50]

                                // 1. 判断this左上角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+60
                                        && this.getY()+10 >= et.getY()+10
                                        && this.getY()+10 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return

                                // 2. 判断this左下角是否进入坦克范围
                                if (this.getX() >= et.getX()
                                        && this.getX() <= et.getX()+60
                                        && this.getY()+50 >= et.getY()+10
                                        && this.getY()+50 <= et.getY()+50) {
                                    return true;
                                } //不需要break了因为有return
                        }

                    }

                } //for结束

        }

        return false; //没碰撞
    }


    @Override
    public void run() {
        // Multi-thread life cycle (start-run-close)
        while (true) { //运行
            double random = Math.random();
            double shotRate = 0.8; // more near to 0 or 1, less rate of shot


            // enemyTank is live, shots have run out, random match shotRate
            if (isLive && shots.size() == 0 && random > shotRate) {
                switch (getDirect()) {
                    case 0:
                        shot = new Shot(getX()+27, getY(), 0);
                        break;
                    case 1:
                        shot = new Shot(getX()+60, getY()+27, 1);
                        break;
                    case 2:
                        shot = new Shot(getX()+27, getY()+60, 2);
                        break;
                    case 3:
                        shot = new Shot(getX(), getY()+27, 3);
                        break;
                }
                // 添加进集合，并启动线程
                shots.add(shot);
                new Thread(shot).start();

            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 10; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {
                            //如果小过y/超过上面边界 就不能再动，且没发生碰撞
                            moveUp();
                        }

                        try { //动一下停一下
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 1:
                    for (int i = 0; i < 10; i++) {
                        if (getX()+60 < 1000 && !isTouchEnemyTank()) {
                            //如果小过y/超过上面边界 就不能再动，且没发生碰撞
                            moveRight();
                        }
                        try { //动一下停一下
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < 10; i++) {
                        if (getY()+60 < 750 && !isTouchEnemyTank()) {
                            //如果小过y/超过上面边界 就不能再动，且没发生碰撞
                            moveDown();
                        }
                        try { //动一下停一下
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 3:
                    for (int i = 0; i < 10; i++) {
                        if (getX() > 0 && !isTouchEnemyTank()) {
                            //如果小过y/超过上面边界 就不能再动，且没发生碰撞
                            moveLeft();
                        }
                        try { //动一下停一下
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

            }

            try { //动一下停一下
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 然后随机改变方向(0-3), 再回到上面循环
            setDirect((int)(Math.random()*4));


            if (!isLive) {
                break; //销毁线程(退出无限while，让线程运行完)
            }
        }
    }
}
