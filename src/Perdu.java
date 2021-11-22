import java.awt.*;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Perdu extends staticThing {
    private int delay;
    private ImageView heart;
    private boolean touche;

    public Perdu(double x, double y) {
        super(x, y, "ennemi_détouré.png", 0, 0, 800, 400);

    }

    public void update(long time, Hero hero, Foe ennemi, Pane pane, ArrayList<ImageView> list_heart) {
        if (hero.getHitbox().intersects(ennemi.getHitbox()) && !this.touche) {
            if (ennemi.getPx() - (hero.getPx() + hero.getl()) < -15) {
                if (ennemi.getPy() - (hero.getPy() + hero.geth()) < -15) {
                    this.touche(true);
                    if (list_heart.size() != 0) {

                        heart = list_heart.get(list_heart.size() - 1);
                        list_heart.remove(list_heart.size() - 1);
                        pane.getChildren().remove(heart);
                    }
                    if (list_heart.size() == 0) {
                        System.out.println("PERDU FIN");
                    }

                    System.out.println("PERDU");
                }
            }
        } else if (!(hero.getHitbox().intersects(ennemi.getHitbox()))&&this.touche) {
            this.touche(false);
        }
    }

    public void touche(boolean touche){this.touche=touche;}
}

