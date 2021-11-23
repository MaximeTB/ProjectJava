import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.util.Random;

import java.awt.*;
import java.util.ArrayList;

public class GameScene extends Scene {
    private Camera cam;
    private Pane pane;
    private Hero hero;
    private BackGround bckgrndLeft,bckgrndRight;
    private Perdu perdu;
    //code afficher ennemi
    private ArrayList<Foe> clan_alien; //tableau des differents ennemis
    private double lastPosition;
    //Perte de coeur
    private ArrayList<Heart> list_heart;
    private int nbLife;
    //fin de jeu
    private boolean endgame=false,pause=false;

    AnimationTimer timer;


    public GameScene(Pane pane,int v,int v1) {
        super(pane,v,v1,true);
        this.pane=pane;
        int nbLife=3;
        this.cam = new Camera(0,0);
        this.clan_alien= new ArrayList<Foe>();
        this.list_heart=new ArrayList<Heart>();

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
        lastPosition=800;
        //Mise en place des coeurs

        this.list_heart.add(new Heart(10-(int)pane.getLayoutX(),10-(int)pane.getLayoutY()));
        this.list_heart.add(new Heart(33-(int)pane.getLayoutX(),10-(int)pane.getLayoutY()));
        this.list_heart.add(new Heart(56-(int)pane.getLayoutX(),10-(int)pane.getLayoutY()));

        for (Heart h : this.list_heart){
            h.getImage().setX(h.getX());
            h.getImage().setY(h.getY());
            pane.getChildren().add(h.getImage());
        }

        //Mise en place Hero

        hero = new Hero(100,260);
        pane.getChildren().add(hero.getSprite());
        hero.getSprite().setX(hero.getPx()-(int)pane.getLayoutX());
        hero.getSprite().setY(hero.getPy());


//code afficher ennemi

        clan_alien.add(new Foe(800,275,pane,clan_alien,cam)); //permet de se passer des noms
        pane.getChildren().add(clan_alien.get(0).getSprite());
        clan_alien.get(0).getSprite().setX(clan_alien.get(0).getPx()-(int)pane.getLayoutX());
        clan_alien.get(0).getSprite().setY(clan_alien.get(0).getPy());


        clan_alien.add(new Foe(1200,150,pane,clan_alien,cam));
        pane.getChildren().add(clan_alien.get(1).getSprite());
        clan_alien.get(1).getSprite().setX(clan_alien.get(1).getPx()-(int)pane.getLayoutX());
        clan_alien.get(1).getSprite().setY(clan_alien.get(1).getPy());



//afficher perdu
        this.perdu= new Perdu(-600,-600,hero,pane,clan_alien,cam);
        perdu.getImage().setX(perdu.getX());
        perdu.getImage().setY(perdu.getY());
        pane.getChildren().add(perdu.getImage());
//afficher perdu

        timer = new AnimationTimer()
        {public void handle(long time){

            Foe deadEnnemi=null;
            boolean EnnemiIsDead=false;
            if (!endgame){
                hero.update(time,clan_alien.get(0));}
            for(Foe ennemi : clan_alien) {
                ennemi.update(time, cam);
                if (ennemi.isTouche()|ennemi.isFini()){
                    EnnemiIsDead=true;
                    deadEnnemi=ennemi;
                    pane.getChildren().remove(ennemi.getSprite());
                }
            }
            if(EnnemiIsDead){
                clan_alien.remove(deadEnnemi);
                lastPosition=clan_alien.get(0).getPy();
                double r=Math.random();
                System.out.println(r);
                Foe newEnnemi=new Foe(lastPosition+r*800+800,deadEnnemi.getPy(),pane,clan_alien,cam) ;
                clan_alien.add(newEnnemi);
                newEnnemi.getSprite().setX(newEnnemi.getPx());
                if ((r-0.5)>0){
                    newEnnemi.Up();
                }
                else {
                    newEnnemi.Down();
                }
                //newEnnemi.getSprite().setY(newEnnemi.getPy());
                pane.getChildren().add(newEnnemi.getSprite());
            }
            cam.update(time,hero);
            perdu.update(time,list_heart,nbLife);
            if(list_heart.size()==0){
                /*perdu.GameOver(pane);*/
                endgame=true;
                perdu.getImage().setX(33-pane.getLayoutX());
                perdu.getImage().setY(10-pane.getLayoutY());
                hero.ChangeSkin(pane,"tombe.png",0,0,206,206);
            }
            updateGS(time,perdu);


            if(hero.isJumpOk()){hero.jump();}
            if(hero.isFallOk()){ hero.fall();}

            }
        };
        timer.start();

        /*this.setOnKeyTyped( (event)->{ //jump quand on presse la barre espace
            //System.out.println("Jump");
            if (hero.getPy()>259){
                hero.setJumpOk(true);}

        });*/

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode()== KeyCode.P){
                    pause=!pause;
                    if (pause){
                        timer.stop();
                    }
                    else if (!pause){
                        timer.start();
                    }
                }
                if (t.getCode()==KeyCode.SPACE){
                    if (hero.getPy()>259){
                        hero.setJumpOk(true);}
                }
            }
        });

    }

    public void updateGS(long time,Perdu perdu){
        int i=0;
        this.pane.setLayoutX(-cam.getX());
        if (endgame){
            timer.stop();
        }
        for(Heart h : list_heart) {
            h.setX(10+i*23 + this.cam.getX());
            h.getImage().setX(h.getX());
            i++;
        }
        if (cam.getX()-this.bckgrndLeft.getX()>=800){
            this.bckgrndLeft.setX(cam.getX()+795);
            this.bckgrndLeft.getImage().setX(795+cam.getX());
        }
        if (cam.getX()-this.bckgrndRight.getX()>=800){
            this.bckgrndRight.setX(cam.getX()+795);
            this.bckgrndRight.getImage().setX(795+cam.getX());
        }
    }
}
