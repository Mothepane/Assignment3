package com.example.demogame;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
public class HelloApplication extends Application {
    ImageView coin1 = new ImageView(new Image("coin.png"));
    ImageView coin2 = new ImageView(new Image("coin.png"));
    ImageView coin = new ImageView(new Image("coin1.png"));
    ImageView image = new ImageView(new Image("air.jpg"));
    ImageView cloud3 = new ImageView(new Image("cloud 2.png"));
    ImageView cloud2 = new ImageView(new Image("cloud 2.png"));
    ImageView cloud1 = new ImageView(new Image("cloud.png"));
    ImageView aeroplane = new ImageView(new Image("cloud 2.png"));
    TranslateTransition tranCoin2 = new TranslateTransition(Duration.millis(9000));
    TranslateTransition tranCoin3 = new TranslateTransition(Duration.millis(15000));
    TranslateTransition tranCoin = new TranslateTransition(Duration.millis(10000));
    TranslateTransition tranCloud3 = new TranslateTransition(Duration.millis(20000));
    TranslateTransition tranCloud2 = new TranslateTransition(Duration.millis(18000));
    TranslateTransition transCloud1 = new TranslateTransition(Duration.millis(14000));
    TranslateTransition tranAero = new TranslateTransition(Duration.millis(12000));

    Label label = new Label();
    Label label1 = new Label();
    int score;
    AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
        }
    };
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 900, 500);
        stage.setTitle("AEROPLANE GAME");
        stage.setScene(scene);

        label.setTextFill(Color.RED);
        label = new Label("SCORE:00");
        label.setFont(new Font("Tahoma",100));
        label.setLayoutX(500);
        label.setLayoutY(20);
        root.getChildren().add(label);

        animationTimer.start();

        ImageView ship = createShip(scene);
        ImageView earth = createEarth(scene);
        ImageView aeroplane = createAeroplane(scene);
        ImageView cloud1 = createCloud1(scene);
        ImageView cloud2 = createCloud2(scene);
        ImageView cloud3 = createCloud3();
        ImageView coin = createCoin(scene);
        ImageView coin1 = createCoin1(scene);
        ImageView coin2 = createCoin2(scene);

        TranslateTransition transAero = new TranslateTransition();
        TranslateTransition transCloud1 = new TranslateTransition();
        TranslateTransition transCloud2 = new TranslateTransition();
        TranslateTransition transCloud3 = new TranslateTransition();

        root.getChildren().addAll(earth,aeroplane,cloud1,cloud2,cloud3,ship,coin,coin1,label1);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = ship.getX();
            double y = ship.getY();

            switch (event.getCode()) {
                case LEFT -> ship.setX(x -10);
                case RIGHT -> ship.setX(x +10);
                case UP -> ship.setY(y - 10);
                case DOWN -> ship.setY(y + 10);
            }

                if (ship.getBoundsInParent().intersects(cloud1.getBoundsInParent()) ||
                        ship.getBoundsInParent().intersects(cloud2.getBoundsInParent()) ||
                        ship.getBoundsInParent().intersects(cloud3.getBoundsInParent()) ||
                        ship.getBoundsInParent().intersects(aeroplane.getBoundsInParent())) {
                    label1.setText("GAME OVER");
                    label1.setFont(new Font("Arial",50));
                    label1.setTextFill(Color.RED);
                    ship.setImage(new Image("gameOver.jpg"));

                    transAero.stop();
                    transCloud1.stop();
                    transCloud2.stop();
                    transCloud3.stop();
                } else {
                    if (ship.getBoundsInParent().intersects(coin.getBoundsInParent())) {
                        score = score + 1;
                        label.setText("Score : " + (score));
                        root.getChildren().remove(coin);
                    }
                    if (ship.getBoundsInParent().intersects(coin1.getBoundsInParent())) {
                        score = score + 1;
                        label.setText("Score : " + (score));
                        root.getChildren().remove(coin1);
                    }
                    if (ship.getBoundsInParent().intersects(coin2.getBoundsInParent())) {
                        score = score + 1;
                        label.setText("Score : " + (score));
                        root.getChildren().remove(coin2);
                    }
                }
                    });

        stage.show();
    }
    private ImageView createCoin1(Scene scene) {
        coin1.setFitWidth(100);
        coin1.setFitHeight(100);
        coin1.setY(80);
        coin1.setX(1100);
        tranCoin2.setNode(coin1);
        tranCoin2.setByX(-1700);
        tranCoin2.setCycleCount(Integer.MAX_VALUE);
        tranCoin2.play();
        return  coin1;
    }
    private ImageView createCoin2(Scene scene) {
        coin2.setFitWidth(100);
        coin2.setFitHeight(100);
        coin2.setY(80);
        coin2.setX(1100);
        tranCoin3.setNode(coin2);
        tranCoin3.setByX(-1700);
        tranCoin3.setCycleCount(Integer.MAX_VALUE);
        tranCoin3.play();
        return  coin2;
    }
    private ImageView createCoin(Scene scene) {
        coin.setFitWidth(100);
        coin.setFitHeight(100);
        coin.setY(150);
        coin.setX(1500);
        tranCoin.setNode(coin);
        tranCoin.setByX(-1700);
        tranCoin.setCycleCount(Integer.MAX_VALUE);
        tranCoin.play();
        return  coin;
    }
    private ImageView createShip(Scene scene) {
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());
        return image;
    }
    private ImageView createCloud3() {
        cloud3.setFitWidth(100);
        cloud3.setFitHeight(100);
        cloud3.setY(150);
        cloud3.setX(1000);
        tranCloud3.setNode( cloud3);
        tranCloud3.setByX(-1700);
        tranCloud3.setCycleCount(Integer.MAX_VALUE);
        tranCloud3.play();
        return cloud3;
    }
    private ImageView createCloud2(Scene scene) {
        cloud2.setFitWidth(100);
        cloud2.setFitHeight(100);
        cloud2.setY(100);
        cloud2.setX(1300);
        tranCloud2.setNode( cloud2);
        tranCloud2.setByX(-1700);
        tranCloud2.setCycleCount(Integer.MAX_VALUE);
        tranCloud2.play();
        return cloud2;
    }
    private ImageView createCloud1(Scene scene) {
        cloud1.setFitWidth(100);
        cloud1.setFitHeight(100);
        cloud1.setY(40);
        cloud1.setX(1200);
        transCloud1.setNode(cloud1);
        transCloud1.setByX(-1700);
        transCloud1.setCycleCount(Integer.MAX_VALUE);
        transCloud1.play();
        return cloud1;
    }
    private ImageView createEarth(Scene scene) {
        ImageView earth = new ImageView(new Image("homePage.jpg"));
        earth.setFitWidth(900);
        earth.setFitHeight(1000);
        return earth;
    }
    private ImageView createAeroplane(Scene scene) {
        aeroplane.setFitWidth(100);
        aeroplane.setFitHeight(100);
        aeroplane.setY(30);
        aeroplane.setX(1000);
        tranAero.setNode(aeroplane);
        tranAero.setByX(-1700);
        tranAero.setCycleCount(Integer.MAX_VALUE);
        tranAero.play();
        return aeroplane;
    }
    public static void main(String[] args) {
        launch();
    }
    }