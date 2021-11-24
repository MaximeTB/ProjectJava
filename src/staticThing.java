import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class staticThing {
    private double x,y,cx1,cy1,cx2,cy2,off;
    private ImageView image;

    public staticThing(double x, double y, String fileName,double cx1, double cy1 ,double cx2,double cy2) {
        this.x=x;
        this.y=y;
        this.cx1=cx1;
        this.cy1=cy1;
        this.cx2=cx2;
        this.cy2=cy2;
        this.off=off;
        image = new ImageView(new Image(fileName));
        this.image.setViewport(new Rectangle2D(cx1,cy1,cx2,cy2));

    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image){this.image=image;}

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}
