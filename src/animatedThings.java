import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class animatedThings {
    int px,py,att,ind,dur,indmax,sw,off;
    protected ImageView sprite;

    public animatedThings(int x, int y, String fileName, int cropX, int cropY, int l, int L,int att,int ind,int dur,int indmax,int sw,int off){
        this.px=x;
        this.py=y;
        this.att=att;
        this.ind=ind;
        this.dur=dur;
        this.indmax=indmax;
        this.sw=sw;
        this.off=off;


        sprite=new ImageView(new Image(fileName));
        sprite.setViewport(new Rectangle2D(cropX,cropY,l,L));

    }

    public ImageView getSprite() {return sprite;}
}
