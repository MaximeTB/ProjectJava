public class Camera {
    private int x;
    private int y;

    //Constructor


    public Camera(int x , int y) {
        this.x=x;
        this.y=y;
    }

    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void updateCam(long time) {
            this.x=x-5;
        }
    @Override
    public String toString(){
        return x+","+y;
    }

    public void update(long time,Hero hero){
        /*Integer k= new Integer(1);
        Integer m = new Integer(5);
        Integer f= new Integer(6);*/

        this.setX(this.getX()+5); //vitesse cam



    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
