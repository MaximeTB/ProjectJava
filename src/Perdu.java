import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Perdu extends animatedThings{
    private int delay;
    public Perdu(int x, int y) {
        super(x, y, "perdu_détouré.png", 10, 10, 1000,1000, 1, 1, 1, 1, 0, 0, 0);
    }
    public void update(long time, Hero hero,Foe ennemi) {
        delay = delay + 1;
        this.setPx(this.getPx() + 5);
        this.getSprite().setX(this.getPx());
        //System.out.println(this.getPx());
        if (delay == 3) {delay = 0;}
        if(ennemi.getPx()-(hero.l+hero.getPx())<=1){System.out.println("PERDU");}
        }
}
