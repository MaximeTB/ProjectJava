import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class Foe extends animatedThings {
    private int delay;
    private Camera cam;
    static double speed_ennemi=0.1;
    private double count_ennemi=0;
    private Rectangle2D hitbox;
    private boolean touche=false,fini=false;
    private Pane pane;
    private ArrayList<Foe> clan_ennemi;

    public Foe(double x, double y,Pane pane,ArrayList<Foe> clan_ennemi,Camera cam) {
        super(x, y, "ennemi_détouré.png", 40, 17, 75, 75, 1, 1, 1, 0, 0, 0, 0);
        delay = 0;
        this.pane=pane;
        this.clan_ennemi=clan_ennemi;
        this.cam=cam;
    }
    public void update(long time,Camera cam) {
        hitbox = new Rectangle2D(this.getPx()+20, this.getPy()+20, this.getl()-10, this.geth()-20);

        if(this.getPx()>0){
            delay = delay + 1;
            if(speed_ennemi<=1) {
                speed_ennemi = speed_ennemi + 0.001;
                this.setPx(this.getPx() - 10 * speed_ennemi);
                this.getSprite().setX(this.getPx());
                //System.out.println(this.getPx());
                count_ennemi = this.getPx();
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

        if((this.getPx()<cam.getX()-50)) {
            this.setFini(true);
            /*this.setPx(this.getPx()+850);
            this.getSprite().setX(this.getPx());*/

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

    public boolean isTouche() {
        return touche;
    }

    public void setFini(boolean fini) {
        this.fini = fini;
    }

    public boolean isFini() {
        return fini;
    }

    public void setTouche(boolean touche) {
        this.touche = touche;
    }
}




