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
    private double Score;
    private Pane pane;

    private boolean SHOOT=false,shootOk=false;

    private Hero hero = new Hero(100,260,5,shootOk,pane);

    private Camera cam = new Camera(0,0,hero);
    private BackGround bckgrndLeft,bckgrndRight;
    private Perdu perdu;
    //code afficher ennemi
    private ArrayList<Foe> clan_alien; //tableau des differents ennemis
    private double lastPosition;
    //Perte de coeur
    private ArrayList<Heart> list_heart;
    private int nbLife;
    //fin de jeu
    private boolean endgame=false,pause=true;
    private FireBomb bullet;
    AnimationTimer timer;
    private int cmptShoot=0;
    private boolean shootReady=true;


    public GameScene(Pane pane,int v,int v1) {
        super(pane,v,v1,true);
        this.pane=pane;
        hero.setCam(cam);
        int nbLife=3;
        this.clan_alien= new ArrayList<Foe>();
        this.list_heart=new ArrayList<Heart>();
        bullet=new FireBomb(hero,pane,cam,false);
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


            Score++;
            hero.update(time);
            updateGS(time,perdu);
            if(SHOOT){
                bullet=new FireBomb(hero,pane,cam,true);
                SHOOT=false;
                shootReady=false;
            }

            if (shootOk){
                bullet.update();
                cmptShoot++;
                if (cmptShoot>100){
                    cmptShoot=0;
                    shootReady=true;
                }
                for (Foe f: clan_alien){
                    if(f.getHitbox()!=null) {
                        if (f.getHitbox().intersects(bullet.getHitbox())) {
                            f.setFini(true);
                        }
                    }
                }
            }

            //Update des ennemis
            for(Foe ennemi : clan_alien) {
                ennemi.update(time, cam);
                if (ennemi.isFini()){
                    EnnemiIsDead=true;
                    deadEnnemi=ennemi;
                    pane.getChildren().remove(ennemi.getSprite());
                }
            }

            //Renouvellement des ennemis
            if(EnnemiIsDead){
                clan_alien.remove(deadEnnemi);
                double lastPosition=clan_alien.get(0).getPx();
                double r=Math.random();
                double newPosition=lastPosition+r*1000+400;
                Foe newEnnemi=new Foe(newPosition,deadEnnemi.getPy(),pane,clan_alien,cam) ;
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


            cam.update(time);
            perdu.update(time,list_heart,nbLife);

            //Game Over
            if(list_heart.size()==0){
                /*perdu.GameOver(pane);*/
                endgame=true;
                perdu.getImage().setX(33-pane.getLayoutX());
                perdu.getImage().setY(10-pane.getLayoutY());
                hero.ChangeSkin(hero.getPx(),270,pane,"tombe.png",0,0,206,206);
                hero.getSprite().setFitWidth(100);hero.getSprite().setPreserveRatio(true);
                System.out.println(Score);

            }



            //Jump
            if(hero.isJumpOk()){hero.jump();}
            if(hero.isFallOk()){ hero.fall();}
            if(hero.isShootOk()){
                hero.shoot(bullet);
            }
            }
        };

        //Détection des touches
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                //Pause
                if (t.getCode()== KeyCode.P){
                    pause=!pause;
                    if (pause){
                        timer.stop();
                    }
                    else if (!pause){
                        timer.start();
                    }
                }
                //Jump
                if (t.getCode()==KeyCode.UP){
                    if (hero.getPy()>259){
                        hero.setJumpOk(true);}
                }
                //Shoot
                if (t.getCode()==KeyCode.SPACE){
                    if(shootReady) {
                        SHOOT = true;
                        shootOk = true;
                        hero.shoot(bullet);
                        //bomb.update(); //modifié par elea pour firebomb
                    }
                }
                //Controle de la vitesse
                if (t.getCode()==KeyCode.RIGHT){
                    hero.setOff(hero.getOff()+2);
                }
                if(t.getCode()==KeyCode.LEFT){
                    hero.setOff(hero.getOff()-2);
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

        /*double position = cam.getX()%800;
        bckgrndLeft.getImage().setX(0-position);
        bckgrndRight.getImage().setX(800-position);*/
    }
}
