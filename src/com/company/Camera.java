package com.company;

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



    @Override
    public String toString(){
        return x+","+y;
    }
}
