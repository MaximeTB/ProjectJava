package com.company;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {
    private Camera cam;
    private Hero hero;
    private staticThing bckgrndLeft,bckgrndRight ;

    public GameScene(Group parent) {
        super(parent,800,400);
        cam = new Camera(0,0);
        bckgrndLeft= new staticThing(0,0,"com/company/desert.png",0,0,400,400);
        bckgrndLeft.getImage().setX(bckgrndLeft.getX());
        parent.getChildren().add(bckgrndLeft.getImage());

        bckgrndRight = new staticThing(400,0,"com/company/desert.png",400,0,800,400);
        bckgrndRight.getImage().setX(bckgrndRight.getX());
        bckgrndRight.getImage().setY(bckgrndRight.getY());
        parent.getChildren().add(bckgrndRight.getImage());


        hero = new Hero();
        parent.getChildren().add(hero.getSprite());
        hero.getSprite().setX(350);
        hero.getSprite().setY(200);
    }

}
