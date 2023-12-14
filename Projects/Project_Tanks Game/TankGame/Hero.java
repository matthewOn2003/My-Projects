package chapter20_TankGame_3.TankGame;


import java.util.Vector;

@SuppressWarnings("all")
public class Hero extends Tank {
    // Declare shot
    Shot shot = null;

    // Declare shots
    Vector<Shot> shots = new Vector<>();



    // initialize hero tank's location
    public Hero(int x, int y) {
        super(x, y);
        setDirect(0); //向上
    }

    // Shot Enemy Tank
    public void shootEnemyTank() {
//        if (shots.size() == 5) { // When there are 5 bullets on the field
//            return; // no more bullets will be created until the original ones are destroyed.
//        }

        // bullet's direction
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
        shots.add(shot);

        // Start shot's thread
        new Thread(shot).start();


    }

}
