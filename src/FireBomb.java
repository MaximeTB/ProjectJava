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
    public void update(long time, Hero hero) {
        delay = delay + 1;
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

}
