public class Camera {
    private double x,xinit=150,vx,ax;
    private double y,yinit=200,vy,ay;
    private Hero hero;
    private double dt=0.54;

    //Constructor

    public Camera(int x , int y,Hero hero) {
        this.x=x;
        this.y=y;
        this.hero=hero;
    }
    //Getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

        @Override
    public String toString(){
        return x+","+y;
    }

    public void update(long time){
        //vitesse cam
        this.setX(this.getX()+hero.getOff());
        /*ax=hero.getPx()-x - 1.2*vx;
        vx=ax*dt;
        x=vx*dt+xinit;
        System.out.println(x);

        ay=hero.getPy()-getY()+1.2*vy;
        vy=ay*dt;
        y=vy*dt+yinit;
        y=vy*dt+yinit;*/

    }

//Setter
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
