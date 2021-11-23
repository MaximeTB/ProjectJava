import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class animatedThings {
    double px,py;
    int att,ind1,ind2,dur,indmax,sw,off;
    int cropX,cropY,l,h; //Pour sélectionner la frame.
    protected ImageView sprite;
    //code afficher ennemi
    protected ImageView ennemi;
    //code afficher ennemi

    public animatedThings(int x, int y, String fileName, int cropX, int cropY, int l, int h,int att,int ind1,int ind2,int dur,int indmax,int sw,int off){
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
        this.h=h;


        sprite=new ImageView(new Image(fileName));
        sprite.setViewport(new Rectangle2D(this.getCropX(),this.getCropY(),l,h));
        //affichage du héro


//code afficher ennemi
        /*ennemi=new ImageView(new Image(fileName));
        ennemi.setViewport(new Rectangle2D(this.getCropX(),this.getCropY(),l,L));*/
//code afficher ennemi

    }

    public ImageView getSprite() {return sprite;}

    public double getPx() {
        return px;
    }

    public void setPx(double i) { px=i;}

    public double getPy() {
        return py;
    }

    public double getAtt() {
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

    public int geth(){return h;}

    public void setPy(double py) {
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

    public void setl(int l) {
        this.l = l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }
}
