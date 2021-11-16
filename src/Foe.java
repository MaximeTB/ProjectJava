public class Foe extends animatedThings {
    private int delay;
    public Foe(int x, int y) {
        super(x, y, "ennemi_détouré.png", 15, 10, 100, 100, 1, 1, 1, 0, 0, 0, 0);
        delay = 0;
    }
    public void update(long time) {
        delay = delay + 1;
        this.setPx(this.getPx() -1);
        this.getSprite().setX(this.getPx());
        if (delay == 3) {
            //this.setInd2((this.getInd2() + 1) % 7);
            //this.SetFrame(this.getInd1(), this.getInd2());
            delay = 0;
        }
    }
}


