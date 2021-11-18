public class Foe extends animatedThings {
    private int delay;
    private double speed_ennemi=0.1;
    private double count_ennemi=0;
    public Foe(int x, int y) {
        super(x, y, "ennemi_détouré.png", 15, 10, 100, 100, 1, 1, 1, 0, 0, 0, 0);
        delay = 0;
    }
    public void update(long time,Camera cam) {
        if(this.getPx()>0){
            delay = delay + 1;
            speed_ennemi=speed_ennemi+0.001;
            this.setPx(this.getPx() -10*speed_ennemi);
            this.getSprite().setX(this.getPx());
            //System.out.println(this.getPx());
            count_ennemi=this.getPx();
            if (delay == 3) {delay = 0;}
        }

        if(this.getPx()<cam.getX()-100) {
            this.setPx(this.getPx()+1000);
            this.getSprite().setX(this.getPx());
        }
        }
    }



