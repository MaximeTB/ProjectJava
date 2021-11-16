import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameScene extends Scene {
    private Camera cam;
    private Hero hero;
    //code afficher ennemi
    private Foe ennemi;
    //code afficher ennemi
    private BackGround bckgrndLeft,bckgrndRight;
    private Heart heart1,heart2,heart3;
    private int numberOfLives;
    private ArrayList<Foe> clan_alien; //tableau des differents ennemis


    public GameScene(Pane pane,int v,int v1) {
        super(pane,v,v1,true);
        numberOfLives=3;
        cam = new Camera(0,0);

        pane.setLayoutX(cam.getX());
        pane.setLayoutY(cam.getY());



        //Mise en place de l'arrière plan
        bckgrndLeft= new BackGround(0,0,0,0,800,400);
        bckgrndLeft.getImage().setX(bckgrndLeft.getX());
        pane.getChildren().add(bckgrndLeft.getImage());

        bckgrndRight = new BackGround(800,0,0,0,800,400);
        bckgrndRight.getImage().setX(bckgrndRight.getX());
        bckgrndRight.getImage().setY(bckgrndRight.getY());
        pane.getChildren().add(bckgrndRight.getImage());

        //Mise en place des coeurs
        heart1= new Heart(10-(int)pane.getLayoutX(),10-(int)pane.getLayoutY());
        heart1.getImage().setX(heart1.getX());
        heart1.getImage().setY(heart1.getY());
        pane.getChildren().add(heart1.getImage());

        heart2= new Heart(33-(int)pane.getLayoutX(),10-(int)pane.getLayoutY());
        heart2.getImage().setX(heart2.getX());
        heart2.getImage().setY(heart2.getY());
        pane.getChildren().add(heart2.getImage());

        heart3= new Heart(56-(int)pane.getLayoutX(),10-(int)pane.getLayoutY());
        heart3.getImage().setX(heart3.getX());
        heart3.getImage().setY(heart3.getY());
        pane.getChildren().add(heart3.getImage());

        hero = new Hero(300,260);
        pane.getChildren().add(hero.getSprite());
        hero.getSprite().setX(hero.getPx()-(int)pane.getLayoutX());
        hero.getSprite().setY(hero.getPy());
        //hero.SetFrame(4,2);
//code afficher ennemi
        ennemi = new Foe(800,260);
        pane.getChildren().add(ennemi.getSprite());
        ennemi.getSprite().setX(ennemi.getPx()-(int)pane.getLayoutX());
        ennemi.getSprite().setY(ennemi.getPy());
        //hero.SetFrame(4,2);
//code afficher ennemi

        AnimationTimer timer = new AnimationTimer()
        {public void handle(long time){
            hero.update(time);
            ennemi.update(time);
            cam.update(time,hero);
            GameScene.update(time,pane,cam,heart1,heart2,heart3,bckgrndLeft,bckgrndRight);
            System.out.println(hero.getPy());



            if(hero.isJumpOk()==true){hero.jump();}
            if(hero.isFallOk()==true){ hero.fall();}



            /*bckgrndLeft.getImage().setX(bckgrndLeft.getX()-20);
            bckgrndLeft.setX(bckgrndLeft.getX()-20);
            bckgrndRight.getImage().setX((bckgrndRight.getX()-20)%-800);
            bckgrndRight.setX((bckgrndRight.getX()-20)%-800);*/
            }

        };
        timer.start();

        this.setOnKeyTyped( (event)->{
            System.out.println("Jump");
            if (hero.getPy()>259){
                hero.setJumpOk(true);}

        });

    }

    public static void update(long time, Pane pane,Camera cam,Heart heart1,Heart heart2,Heart heart3,BackGround bckgrndLeft,BackGround bckgrndRight){
        pane.setLayoutX(-cam.getX());
        heart1.setX(10-pane.getLayoutX());
        heart1.getImage().setX(10-pane.getLayoutX());
        heart2.setX(33-pane.getLayoutX());
        heart2.getImage().setX(33-pane.getLayoutX());
        heart3.setX(56-pane.getLayoutX());
        heart3.getImage().setX(56-pane.getLayoutX());

        if (cam.getX()-bckgrndLeft.getX()>=800){
            bckgrndLeft.setX(cam.getX()+795);
            bckgrndLeft.getImage().setX(795-pane.getLayoutX());
            System.out.println("Tic");
        }



        if (cam.getX()-bckgrndRight.getX()>=800){
            bckgrndRight.setX(cam.getX()+795);
            bckgrndRight.getImage().setX(795-pane.getLayoutX());
            System.out.println("Tac");

        }

    }

}
