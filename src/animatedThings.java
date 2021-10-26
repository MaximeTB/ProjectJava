import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class animatedThings {
    int px,py;
    protected ImageView sprite;

    public animatedThings(int x, int y, String fileName, int cropX, int cropY, int W, int L ){
        px=x;
        py=y;
        sprite=new ImageView(new Image(fileName));
        sprite.setViewport(new Rectangle2D(cropX,cropY,W,L));

    }
}
