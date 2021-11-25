import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class FireBomb extends animatedThings {
    private int delay;
    private Camera cam;
    static double speed_FireBomb=0.1;
    private double count_FireBomb=0;
    private Rectangle2D hitbox;
    private boolean touche=false,fini=false;
    private Pane pane;

    public FireBomb(double x, double y, String fileName, int cropX, int cropY, int l, int h, int att, int ind1, int ind2, int off) {
        super(x, y, "heros.png", 510, 325, 80, 100, 1, 1, 1, 0);
        delay = 0;

    }
    public void update( Camera cam) {
            hitbox = new Rectangle2D(this.getPx()+20, this.getPy()+20, this.getl()-10, this.geth()-20);

            if(this.getPx()>0){
                delay = delay + 1;
                if(speed_FireBomb<=1) {
                    speed_FireBomb = speed_FireBomb + 0.001;
                    this.setPx(this.getPx() - 10 * speed_FireBomb);
                    this.getSprite().setX(this.getPx());
                    count_FireBomb = this.getPx();
                    if (delay == 3) {
                        delay = 0;
                    }
                }
                if(speed_FireBomb>1){
                    this.setPx(this.getPx() - 10 * speed_FireBomb);
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
    public void ChangeSkin(double x,double y,Pane pane, String filename, int cropX, int cropY, int l, int h){
        pane.getChildren().remove(this.getSprite());
        this.sprite =  new ImageView(new Image(filename));
        this.setCropX(cropX);this.setCropY(cropY);this.setl(l);this.setH(h);
        this.sprite.setViewport(new Rectangle2D(this.getCropX(),this.getCropY(),this.l,this.h));
        this.sprite.setX(x);this.sprite.setY(y);
        pane.getChildren().add(this.getSprite());
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
