package com.example.nthatilucas901011820game;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    Pane root = new Pane();
    Scene scene = new Scene(root, 600, 500);

    ImageView image0 = new ImageView(new Image("nclouds.png"));

Label gover=new Label();
    ImageView image1 = new ImageView(new Image("nclouds.png"));

    ImageView imag = new ImageView(new Image("nclouds.png"));
    ImageView coin1 = new ImageView(new Image("bitcoin.png"));

    ImageView image = new ImageView(new Image("aero.png"));

    TranslateTransition moveCloud = new TranslateTransition(Duration.millis(4000), image0);
    TranslateTransition moveClou = new TranslateTransition(Duration.millis(3000), imag);

    TranslateTransition moveClo = new TranslateTransition(Duration.millis(6000), image1);
    TranslateTransition moveCoin = new TranslateTransition(Duration.millis(3000), coin1);

    AnimationTimer collision=new AnimationTimer() {
        @Override
        public void handle(long l) {
            Collision(scene);
        }
    };

    @Override
    public void start(Stage stage) {


        Image star=new Image("star.jpg");
        ImageView starr = new ImageView(star);
        starr.setFitWidth(600);
        starr.setFitHeight(500);

        ImageView clouds= createCloud(scene);
        ImageView cloud= createClou(scene);
        ImageView clou=createclo(scene);
        ImageView aero = createAero(scene);
        ImageView coin=createCoin (scene);

        collision.start();
        root.getChildren().addAll(starr,aero, cloud,clouds,clou,coin,gover);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = aero.getX();
            double y = aero.getY();


            switch (event.getCode()){

                case UP -> aero.setY(y - 10);
                case DOWN -> aero.setY(y + 10);
                case LEFT-> aero.setY(x + 10);
                case RIGHT -> aero.setY(x - 10);
            }


        });

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private ImageView createCoin(Scene scene) {
        coin1.setLayoutX(600);
        coin1.setFitWidth(100);
        coin1.setFitHeight(100);
        coin1.setX(scene.getHeight() - coin1.getFitHeight());

        moveCoin.setByX(-1100);
        moveCoin.setCycleCount(Integer.MAX_VALUE);
        moveCoin.play();
        return coin1;
    }

    private ImageView createclo(Scene scene) {

        image0.setLayoutX(600);
        image0.setFitWidth(100);
        image0.setFitHeight(100);
        image0.setX(scene.getHeight() - image0.getFitHeight());

        moveCloud.setByX(-1100);
        moveCloud.setCycleCount(Integer.MAX_VALUE);
        moveCloud.play();




        return image0;
    }


    private ImageView createCloud(Scene scene) {

        image1.setLayoutX(600);
        image1.setLayoutY(-10);

        image1.setFitWidth(100);
        image1.setFitHeight(100);
        image1.setY(scene.getHeight() - image1.getFitHeight());

        moveClou.setByX(-800);
        moveClou.setCycleCount(Integer.MAX_VALUE);
        moveClou.play();




        return image1;
    }
    private ImageView createClou(Scene scene) {

        imag.setLayoutX(600);
        imag.setFitWidth(100);
        imag.setFitHeight(100);
        imag.setY(scene.getHeight() - imag.getFitHeight());

        moveClo.setByX(-800);
        moveClo.setCycleCount(Integer.MAX_VALUE);
        moveClo.play();


        return imag;
    }

    private ImageView createAero(Scene scene) {

        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }
    private void Collision(Scene scene){
        if(image.getBoundsInParent().intersects(imag.getBoundsInParent())||
                image.getBoundsInParent().intersects(image0.getBoundsInParent())||
                image.getBoundsInParent().intersects(image1.getBoundsInParent())){
            moveClou.stop();
            moveCloud.stop();
            moveClo.stop();
            moveCoin.stop();
            gover.setText("GAMEOVER");
            gover.setFont(Font.font(18));
            gover.setTextFill(Color.WHITE);
           System.out.println("Game OVER");







        }

    }

    public static void main(String[] args) {
        launch();
    }
}