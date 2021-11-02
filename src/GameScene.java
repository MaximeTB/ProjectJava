import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {
    private Camera cam;
    private Hero hero;
    private staticThing bckgrndLeft,bckgrndRight,heart1,heart2,heart3;
    private int numberOfLives;

    public GameScene(Group parent) {
        super(parent,800,400);
        numberOfLives=3;
        cam = new Camera(0,0);

        //Mise en place de l'arrière plan
        bckgrndLeft= new staticThing(0,0,"desert.png",0,0,400,400);
        bckgrndLeft.getImage().setX(bckgrndLeft.getX());
        parent.getChildren().add(bckgrndLeft.getImage());

        bckgrndRight = new staticThing(400,0,"desert.png",400,0,800,400);
        bckgrndRight.getImage().setX(bckgrndRight.getX());
        bckgrndRight.getImage().setY(bckgrndRight.getY());
        parent.getChildren().add(bckgrndRight.getImage());

        //Mise en place des coeurs
        heart1= new Heart(10,10);
        heart1.getImage().setX(heart1.getX());
        heart1.getImage().setY(heart1.getY());
        parent.getChildren().add(heart1.getImage());

        heart2= new Heart(33,10);
        heart2.getImage().setX(heart2.getX());
        heart2.getImage().setY(heart2.getY());
        parent.getChildren().add(heart2.getImage());

        heart3= new Heart(56,10);
        heart3.getImage().setX(heart3.getX());
        heart3.getImage().setY(heart3.getY());
        parent.getChildren().add(heart3.getImage());

        hero = new Hero();
        parent.getChildren().add(hero.getSprite());
        hero.getSprite().setX(350);
        hero.getSprite().setY(200);
    }

}
