import javafx.geometry.Rectangle2D;

public class Foe extends animatedThings {
    private int delay;
    private double speed_ennemi=0.1;
    private double count_ennemi=0;
    private Rectangle2D hitbox;
    public Foe(int x, int y) {
        super(x, y, "ennemi_détouré.png", 40, 17, 75, 75, 1, 1, 1, 0, 0, 0, 0);
        delay = 0;
    }
    public void update(long time,Camera cam) {
        if(this.getPx()>0){
            delay = delay + 1;
            if(speed_ennemi<=1) {
                speed_ennemi = speed_ennemi + 0.001;
                this.setPx(this.getPx() - 10 * speed_ennemi);
                this.getSprite().setX(this.getPx());
                //System.out.println(this.getPx());
                count_ennemi = this.getPx();
                hitbox = new Rectangle2D(this.getPx(), this.getPy(), this.getl(), this.geth());
                if (delay == 3) {
                    delay = 0;
                }
            }
            if(speed_ennemi>1){
                this.setPx(this.getPx() - 10 * speed_ennemi);
                this.getSprite().setX(this.getPx());
                //System.out.println(this.getPx());

            }
        }

        if(this.getPx()<cam.getX()-100) {
            this.setPx(this.getPx()+1600);
            this.getSprite().setX(this.getPx());
        }

        }
    public Rectangle2D getHitbox() {
        return hitbox;
        }
    public void Up(){
        this.setPy(100);
        this.getSprite().setY(this.getPy());
    }
    public void Down(){
        this.setPy(275);
        this.getSprite().setY(this.getPy());
    }
    }



