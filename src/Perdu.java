import java.awt.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Perdu extends staticThing{
    private int delay;
    public Perdu(double x, double y) {
        super(x, y, "ennemi_détouré.png", 0, 0, 800, 400);

    }

    public void update(long time, Hero hero, Foe ennemi) {
        if(ennemi.getPx()-(hero.getl()+hero.getPx())<=1 && ennemi.getPy()-(hero.getPy()+hero.getL())>=1){System.out.println("PERDU");}
        }
}
