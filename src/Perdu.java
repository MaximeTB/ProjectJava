import java.awt.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Perdu extends staticThing {
    private int delay;
    private ImageView heart;
    private boolean touche1,touche2;

    public Perdu(double x, double y) {
        super(x, y, "perdu_détouré.png", 0, 0, 800, 400);

    }
    private boolean invincible=false;
    private long captureTime;

    public void update(long time, Hero hero, ArrayList<Foe> clan_alien, Pane pane, ArrayList<ImageView> list_heart) {
        if (invincible&&((time-captureTime)>500000000))
            {  invincible=false;}

        if (!invincible){
            for (Foe f : clan_alien){
                if (hero.getHitbox().intersects(f.getHitbox())){
                    captureTime=time;
                    invincible=true;
                }
            }
        }
                if (hero.getHitbox().intersects(clan_alien.get(0).getHitbox()) && !this.touche1) {
                    if (clan_alien.get(0).getPx() - (hero.getPx() + hero.getl()) < -15) {
                        if (clan_alien.get(0).getPy() - (hero.getPy() + hero.geth()) < -15) {
                            this.touche(true, 1);
                            if (list_heart.size() != 0) {
                                heart = list_heart.get(list_heart.size() - 1);
                                list_heart.remove(list_heart.size() - 1);
                                pane.getChildren().remove(heart);

                                if (list_heart.size()>0){
                                    System.out.println(list_heart.size());
                                    System.out.println("PERDU");}
                                if (list_heart.size() == 0) {System.out.println("0");
                                    System.out.println("PERDU FIN");}
                            }
                        }
                    }

                } else if (!(hero.getHitbox().intersects(clan_alien.get(0).getHitbox())) && this.touche1) {
                    this.touche(false, 1);
                }


        if (hero.getHitbox().intersects(clan_alien.get(1).getHitbox()) && !this.touche2) {
            if (clan_alien.get(1).getPx() - (hero.getPx() + hero.getl()) < -15) {
                if (clan_alien.get(1).getPy() - (hero.getPy() + hero.geth()) < -15) {
                    this.touche(true, 2);
                    if (list_heart.size() != 0) {
                        heart = list_heart.get(list_heart.size() - 1);
                        list_heart.remove(list_heart.size() - 1);
                        pane.getChildren().remove(heart);
                        if (list_heart.size()>0){
                            System.out.println(list_heart.size());
                            System.out.println("PERDU");}
                        if (list_heart.size() == 0) {
                            System.out.println("0");
                            System.out.println("PERDU FIN");}
                    }
                }
            }

        } else if (!(hero.getHitbox().intersects(clan_alien.get(1).getHitbox())) && this.touche2) {
            this.touche(false, 2);
        }
    }

    public void touche(boolean touche,int num) {
        if (num == 1) {
            this.touche1 = touche;
        }
        if (num == 2) {
            this.touche2 = touche;
        }
    }

    public void GameOver(Pane pane){
        this.getImage().setX(this.getX());
        this.getImage().setY(this.getY());
        //pane.getChildren().add(this.getImage());
    }
}

