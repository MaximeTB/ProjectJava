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
}
