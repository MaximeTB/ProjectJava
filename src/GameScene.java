import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;

public class GameScene extends Scene {
    private Camera cam;
    private Hero hero;
    private BackGround bckgrndLeft,bckgrndRight;
    private Perdu perdu;
    //code afficher ennemi
    private ArrayList<Foe> clan_alien; //tableau des differents ennemis

    //Perte de coeur
    private Heart heart1,heart2,heart3;
    private ArrayList<ImageView> list_heart;
    //fin de jeu
    private boolean endgame;


    public GameScene(Pane pane,int v,int v1) {
        super(pane,v,v1,true);
        this.cam = new Camera(0,0);
        //this.perdu=new Perdu(0,0,pane) ;
        this.clan_alien= new ArrayList<Foe>();
        this.list_heart=new ArrayList<ImageView>();

        pane.setLayoutX(cam.getX());
        pane.setLayoutY(cam.getY());

        //pane.setLayoutX(perdu.getX());
        //pane.setLayoutY(perdu.getY());



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
        list_heart.add(heart1.getImage());

        heart2= new Heart(33-(int)pane.getLayoutX(),10-(int)pane.getLayoutY());
        heart2.getImage().setX(heart2.getX());
        heart2.getImage().setY(heart2.getY());
        pane.getChildren().add(heart2.getImage());
        list_heart.add(heart2.getImage());

        heart3= new Heart(56-(int)pane.getLayoutX(),10-(int)pane.getLayoutY());
        heart3.getImage().setX(heart3.getX());
        heart3.getImage().setY(heart3.getY());
        pane.getChildren().add(heart3.getImage());
        list_heart.add(heart3.getImage());

        hero = new Hero(100,260);
        pane.getChildren().add(hero.getSprite());
        hero.getSprite().setX(hero.getPx()-(int)pane.getLayoutX());
        hero.getSprite().setY(hero.getPy());


//code afficher ennemi
        /*ennemi1 = new Foe(800,275);
        ennemi2 = new Foe(1600,100);*/
        clan_alien.add(new Foe(800,275)); //permet de se passer des noms
        pane.getChildren().add(clan_alien.get(0).getSprite());
        clan_alien.get(0).getSprite().setX(clan_alien.get(0).getPx()-(int)pane.getLayoutX());
        clan_alien.get(0).getSprite().setY(clan_alien.get(0).getPy());


        clan_alien.add(new Foe(1200,150));
        pane.getChildren().add(clan_alien.get(1).getSprite());
        clan_alien.get(1).getSprite().setX(clan_alien.get(1).getPx()-(int)pane.getLayoutX());
        clan_alien.get(1).getSprite().setY(clan_alien.get(1).getPy());



//code afficher ennemi

//afficher perdu
        this.perdu= new Perdu(33-pane.getLayoutX(),10-pane.getLayoutY());
        //perdu.getImage().setX(perdu.getX());
        //perdu.getImage().setY(perdu.getY());
        perdu.getImage().setX(-600);
        perdu.getImage().setY(-600);
        pane.getChildren().add(perdu.getImage());
//afficher perdu

        AnimationTimer timer = new AnimationTimer()
        {public void handle(long time){
            if (!endgame){
                hero.update(time,clan_alien.get(0));}
            clan_alien.get(0).update(time,cam);
            clan_alien.get(1).update(time,cam);
            cam.update(time,hero);
            perdu.update(time,hero,clan_alien,pane,list_heart);
            if(list_heart.size()==0){
                /*perdu.GameOver(pane);*/
                endgame=true;
                perdu.getImage().setX(33-pane.getLayoutX());
                perdu.getImage().setY(10-pane.getLayoutY());
                hero.ChangeSkin(pane,"tombe.png",0,0,206,206);
            }
            GameScene.update(time,pane,cam,heart1,heart2,heart3,bckgrndLeft,bckgrndRight,perdu);


            if(hero.isJumpOk()){hero.jump();}
            if(hero.isFallOk()){ hero.fall();}

            }
        };
        timer.start();

        this.setOnKeyTyped( (event)->{ //jump quand on presse la barre espace
            //System.out.println("Jump");
            if (hero.getPy()>259){
                hero.setJumpOk(true);}

        });

    }

    public static void update(long time, Pane pane,Camera cam,Heart heart1,Heart heart2,Heart heart3,BackGround bckgrndLeft,BackGround bckgrndRight, Perdu perdu){
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
        }

        if (cam.getX()-bckgrndRight.getX()>=800){
            bckgrndRight.setX(cam.getX()+795);
            bckgrndRight.getImage().setX(795-pane.getLayoutX());
        }

    }

}
