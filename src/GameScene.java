import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private Camera cam;
    private Hero hero;
    private staticThing bckgrndLeft,bckgrndRight,heart1,heart2,heart3;
    private int numberOfLives;

    public GameScene(Pane pane,int v,int v1) {
        super(pane,v,v1,true);
        numberOfLives=3;
        cam = new Camera(-400,0);

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

        AnimationTimer timer = new AnimationTimer()
        {public void handle(long time){
            /* hero.update(time);
            camera.update(time);
            GameScene.update(time); */
            System.out.println("Tic");
            hero.SetFrame(2,(hero.getInd2()+1)%7);
            }
        };
        timer.start();
    }

}
