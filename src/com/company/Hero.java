package com.company;

import javafx.scene.image.ImageView;

public class Hero extends animatedThings{
    public Hero(){
        super(200,150,"com/company/heros.png",20,10,60,85);
    }
    ImageView getSprite(){return sprite;}

}
