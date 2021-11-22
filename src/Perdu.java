import java.awt.*;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Perdu extends staticThing{
    private int delay;
    private ImageView heart;
    public Perdu(double x, double y) {
        super(x, y, "ennemi_détouré.png", 0, 0, 800, 400);

    }

    public void update(long time, Hero hero, Foe ennemi, Pane pane,ArrayList<ImageView> list_heart) {
        if(hero.getHitbox().intersects(ennemi.getPx(),ennemi.getPy(),ennemi.getl(),ennemi.getL())==true){
            System.out.println("PERDU");
            //heart = list_heart.get(list_heart.size() - 1);
            //pane.getChildren().remove(heart);
        }
        //else if (list_heart.size() != 0) {
            //list_heart.remove(list_heart.size() - 1);
        //}
        //else if (list_heart.size() == 0){
            //System.out.println("PERDU FIN");
        //}
        }
}
