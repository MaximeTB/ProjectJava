import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hero extends animatedThings {
    private int delay,shootDelay=0;
    private boolean jumpOk,SHOOT=false,fallOk, shootOk;
    private int countjump = 0;
    private int countfall = 0;
    private Rectangle2D hitbox;
    private Pane pane;
    private Camera cam;

    public Hero(int x, int y,int off,boolean shooting,Pane pane) {
        super(x, y, "heros.png", 20, 8, 75, 100, 1, 1, 1, off);
        delay = 0;
        shootOk=false;
        this.shootOk = shooting;
        this.pane=pane;
        }

    public void SetFrame(int x, int y) {
        this.ind1 = x;
        this.ind2 = y;

        if (x == 1) {
            this.l = 75;
            if (y == 1) {
                this.cropX = 20;
                this.cropY = 8;
            }
            if (y == 2) {
                this.cropX = 95;
                this.cropY = 4;
            }
            if (y == 3) {
                this.cropX = 174;
                this.cropY = 16;
            }
            if (y == 4) {
                this.cropX = 274;
                this.cropY = 14;
            }
            if (y == 5) {
                this.cropX = 350;
                this.cropY = 5;
            }
            if (y == 6) {
                this.cropX = 428;
                this.cropY = 18;
            }
        }
        if (x == 2) {
            this.l = 75;
            if (y == 1) {
                this.cropX = 20;
                this.cropY = 164;
            }
            if (y == 2) {
                this.cropX = 96;
                this.cropY = 164;
            }
        }
        if (x == 3) {
            this.l = 75;
            if (y == 1) {
                this.cropX = 8;
                this.cropY = 325;
            }
            if (y == 2) {
                this.cropX = 80;
                this.cropY = 325;
                this.l = 80;
            }
            if (y == 3) {
                this.cropX = 163;
                this.cropY = 325;
            }
            if (y == 4) {
                this.cropX = 247;
                this.cropY = 325;
            }
            if (y == 5) {
                this.cropX = 339;
                this.cropY = 325;
            }
            if (y == 6) {
                this.cropX = 425;
                this.cropY = 325;
                this.l = 80;
            }
        }
        if (x == 4) {
            this.l = 75;
            if (y == 1) {
                this.cropX = 10;
                this.cropY = 490;
            }
            if (y == 2) {
                this.cropX = 94;
                this.cropY = 490;

            }
        }
        sprite.setViewport(new Rectangle2D(this.getCropX(), this.getCropY(), this.getl(), this.geth()));
    }

    public void setCam(Camera cam) {
        this.cam = cam;
    }

    public void update(long time) {
        delay = delay + 1;
        if(shootDelay>0 && shootDelay<50){
            this.setInd1(3);
            shootDelay++;
        }
        if(shootDelay==100){
            this.setInd1(1);
            shootDelay=0;
            this.setShootOk(false);
        }
        this.setPx(this.getPx() + this.off); //vitesse hero
        this.getSprite().setX(this.getPx());
        hitbox=new Rectangle2D(this.getPx(),this.getPy(),this.getl(),this.geth());
        if (delay == 5) {
            this.setInd2((this.getInd2() + 1) % 7);
            this.SetFrame(this.getInd1(), this.getInd2());
            delay = 0;
        }
    }

    public void jump() {
        if (countjump <= 30 && isJumpOk()) {
            if (this.shootOk){
                this.setInd1(4);
            }
            else{
                this.setInd1(2);
            }

            this.setInd2(1);
            this.SetFrame(this.getInd1(), this.getInd2());
            this.setPy(this.getPy() - 8 + 0.2 * countjump);
            this.sprite.setY(getPy() - 8 + 0.2 * countjump);
            //System.out.println(getPy());
            countjump = countjump + 1;
        }
        if (countjump > 30) {
            countjump=0;
            setJumpOk(false);
            setFallOk(true);

        }
    }

    public void fall() {

        if(this.getPy()<260 && !isJumpOk()) {
            if (this.shootOk){
                this.setInd1(4);
            };

            if (this.shootOk==false){
                this.setInd1(2);
            };
            this.setInd2(2);
            this.SetFrame(this.getInd1(), this.getInd2());
            this.setPy(this.getPy() + 6 + 0.2 * countfall);
            this.sprite.setY(getPy() + 6 + 0.2 * countfall);
            //System.out.println(getPy());
            countfall = countfall + 1;
            //System.out.println(countfall);
        }
        if(this.getPy()>=260){
            this.setPy(260);
            this.sprite.setY(260);
            countfall=0;
            setFallOk(false);
            this.setShootOk(false);
            this.setInd1(1);
            this.setInd2(1);
        }
    }

    public void shoot(FireBomb bullet) {
        this.setShootOk(true);
        this.shootDelay++;
        this.SHOOT=true;




        if(this.isJumpOk()==false && this.isFallOk()==false) {
            this.setInd1(3);
            this.SetFrame(this.getInd1(), this.getInd2());
        };
        if(this.isJumpOk()==true){
            this.setInd1(4);
            this.setInd2(1);
            this.SetFrame(this.getInd1(), this.getInd2());
        };
        if(this.isFallOk()==true){
            this.setInd1(4);
            this.setInd2(2);
            this.SetFrame(this.getInd1(), this.getInd2());
        };
    }

    public void setJumpOk(boolean jumpOk) {
        this.jumpOk = jumpOk;
    }

    public boolean isJumpOk() {
        return jumpOk;
    }

    public void setFallOk(boolean fallOk) {
        this.fallOk = fallOk;
    }

    public boolean isFallOk() {
        return fallOk;
    }

    public Rectangle2D getHitbox() {
        return hitbox;
    }

    public void ChangeSkin(double x,double y,Pane pane, String filename, int cropX, int cropY, int l, int h){
        pane.getChildren().remove(this.getSprite());
        this.sprite =  new ImageView(new Image(filename));
        this.setCropX(cropX);this.setCropY(cropY);this.setl(l);this.setH(h);
        this.sprite.setViewport(new Rectangle2D(this.getCropX(),this.getCropY(),this.l,this.h));
        this.sprite.setX(x);this.sprite.setY(y);
        pane.getChildren().add(this.getSprite());
    }

    public boolean isShootOk() {
        return shootOk;
    }

    public void setShootOk(boolean shootOk) {
        this.shootOk = shootOk;
    }

    public void setShootDelay(int shootDelay) {
        this.shootDelay = shootDelay;
    }

    public void setSHOOT(boolean SHOOT) {
        this.SHOOT = SHOOT;
    }
    public boolean isSHOOT() {
        return SHOOT;
    }
}







/* Coordonn??es des Sprites
RUN :
S1 : 20 ; 10 ; 60 ; 90
S2 : 95 ; 4 ; 75 ; 95
S3 : 174 ; 16 ; 76 ; 82
S4 : 274 ; 14 ; 55 ; 84
S5 : 350 ; 5 ; 61 ; 93
S6 : 428 ; 18 ; 72 ; 80
JUMP UP AND DOWN :
S1 : 25 ; 164 ; 46 ; 97
S2 : 96 ; 164 ; 62 ; 97
RUN AND SHOOT
S1 : 12 ; 340 ; 65 ; 84
S2 : 80; 325 ; 80 ; 100
S3 : 160 ; 325 ; 90 ; 100
S4 : 240 ; 325 ; 90 ; 100
S5 : 330 ; 325 ; 90 ; 100
S6 : 420 ; 325 ; 170 ; 100
JUMP AND SHOOT :
S1 : 10 ; 490; 80 ; 110
S2 : 90 ; 490 ; 75 ; 100

POW POW : 510 ; 325 ; 80 ; 100

 */