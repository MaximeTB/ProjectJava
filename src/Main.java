import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception{

        primaryStage.setTitle("Runner");
        Group parent =new Group();
        Pane pane= new Pane(parent);
        GameScene theScene = new GameScene(pane,600,400);
        primaryStage.setScene(theScene);

        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
