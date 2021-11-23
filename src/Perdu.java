import java.awt.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Perdu extends staticThing {
    private int delay;
    private Heart heart;
    private Hero hero;
    private Pane pane;
    private ArrayList<Foe> clan_alien;
    private Camera cam;

    public Perdu(double x, double y,Hero hero,Pane pane,ArrayList<Foe> clan_alien,Camera cam) {
        super(x, y, "perdu_détouré.png", 0, 0, 800, 400);
        this.hero=hero;
        this.pane=pane;
        this.clan_alien=clan_alien;
        this.cam=cam;
    }

    private boolean invincible=false;
    private long captureTime;

    public void update(long time,  ArrayList<Heart> list_heart,int nbLife) {

        if (invincible && ((time - captureTime) > 500000000)) {
            invincible = false;
        }

        if (!invincible) {
            for (Foe f : clan_alien) {
                if (hero.getHitbox().intersects(f.getHitbox())) {
                    captureTime = time;
                    invincible = true;
                    nbLife = list_heart.size() - 1;
                    if (nbLife >= 0) {
                        //heart = list_heart.get(nbLife-1);
                        this.pane.getChildren().remove(list_heart.get(nbLife).getImage());
                        list_heart.remove(nbLife);

                        f.setTouche(true);


                        if (nbLife > 0) {
                            System.out.println(list_heart.size());
                            System.out.println("PERDU");
                        }
                        if (nbLife == 0) {
                            System.out.println("0");
                            System.out.println("PERDU FIN");
                        }
                    }
                }

            }
        }
    }


    public void GameOver(){
        this.getImage().setX(this.getX());
        this.getImage().setY(this.getY());
    }
}

