import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Hero extends animatedThings {
    private int delay;
    private boolean jumpOk;
    private boolean fallOk;
    private int countjump = 0;
    private int countfall = 0;

    public Hero(int x, int y) {
        super(x, y, "heros.png", 20, 8, 75, 100, 1, 1, 1, 0, 0, 0, 0);
        delay = 0;
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
        sprite.setViewport(new Rectangle2D(this.getCropX(), this.getCropY(), this.getl(), this.getL()));
    }


    public void update(long time) {
        delay = delay + 1;
        this.setPx(this.getPx() + 7);
        this.getSprite().setX(this.getPx());
        if (delay == 3) {
            this.setInd2((this.getInd2() + 1) % 7);
            this.SetFrame(this.getInd1(), this.getInd2());
            delay = 0;
        }


    }

    public void jump() {
        if (countjump <= 30) {
            this.setPy(this.getPy() - 6 + 0.2 * countjump);
            this.sprite.setY(getPy() - 6 + 0.2 * countjump);
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

        if(this.getPy()<250 & isJumpOk()==false) {
            this.setPy(this.getPy() + 6 + 0.2 * countfall);
            this.sprite.setY(getPy() + 6 + 0.2 * countfall);
            //System.out.println(getPy());
            countfall = countfall + 1;
            System.out.println(countfall);
        }
        if(this.getPy()>=250){
            this.setPy(250);
            this.sprite.setY(250);
            countfall=0;
        }


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
}







/* Coordonnées des Sprites
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