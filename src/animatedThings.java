import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class animatedThings {
    int px,py, att,ind,dur,indmax,sw,off;
    int cropX,cropY,l,L; //Pour sélectionner la frame.
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

        this.cropX=cropX;
        this.cropY=cropY;
        this.l=l;
        this.L=L;


        sprite=new ImageView(new Image(fileName));
        sprite.setViewport(new Rectangle2D(this.getCropX(),this.getCropY(),l,L));

    }

    public ImageView getSprite() {return sprite;}

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public int getAtt() {
        return att;
    }

    public int getInd() {
        return ind;
    }

    public int getDur() {
        return dur;
    }

    public int getIndmax() {
        return indmax;
    }

    public int getSw() {
        return sw;
    }

    public int getOff() {
        return off;
    }

    public int getCropX() {
        return cropX;
    }

    public int getCropY() {
        return cropY;
    }

    public int getl() {
        return l;
    }

    public int getL(){return L;}

}
