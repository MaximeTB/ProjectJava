import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class animatedThings {
    int px,py, att,ind1,ind2,dur,indmax,sw,off;
    int cropX,cropY,l,L; //Pour sélectionner la frame.
    protected ImageView sprite;

    public animatedThings(int x, int y, String fileName, int cropX, int cropY, int l, int L,int att,int ind1,int ind2,int dur,int indmax,int sw,int off){
        this.px=x;
        this.py=y;
        this.att=att;
        this.ind1=ind1;
        this.ind2=ind2;
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

    public void setPx(int i) { px=i;}

    public int getPy() {
        return py;
    }

    public int getAtt() {
        return att;
    }

    public int getInd1() {
        return ind1;
    }

    public int getInd2() {
        return ind2;
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

    public void setPy(int py) {
        this.py = py;
    }

    public void setAtt(int att) {
        this.att = att;
    }

    public void setInd1(int ind1) {
        this.ind1 = ind1;
    }

    public void setInd2(int ind2) {
        this.ind2 = ind2;
    }

    public void setDur(int dur) {
        this.dur = dur;
    }

    public void setIndmax(int indmax) {
        this.indmax = indmax;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public void setOff(int off) {
        this.off = off;
    }

    public void setCropX(int cropX) {
        this.cropX = cropX;
    }

    public void setCropY(int cropY) {
        this.cropY = cropY;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
}
