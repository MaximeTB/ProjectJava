import java.awt.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Perdu extends staticThing{
    private int delay;
    public Perdu(int x, int y, String fileName, double cx1, double cy1, double cx2, double cy2) {
        super(x, y, "perdu_détouré.png", 0, 0, 800, 400);

    }

    public void update(long time, Hero hero, Foe ennemi) {
        if(ennemi.getPx()-(hero.l+hero.getPx())<=1){System.out.println("PERDU");}
        }
}
