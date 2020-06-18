package ir.ac.kntu.View;

import ir.ac.kntu.Controller.Controller;
import ir.ac.kntu.Model.Game.Game;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StartGame extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root,600,600);
        Controller controller = new Controller();
        Game frsGame = new Game();
        Game secGame = new Game();
        controller.placeSoldiers(frsGame);
        controller.placeSoldiers(secGame);
        backGroundInit(root);
        initPointer(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initPointer(Pane root){
        Circle circle = new Circle(30);
        circle.setFill(Color.SILVER);
        circle.addEventFilter(MouseEvent.MOUSE_MOVED,mouseEvent -> {
            circle.setCenterX(mouseEvent.getX());
            circle.setCenterY(mouseEvent.getY());
        });
        root.getChildren().add(circle);
    }

    private void backGroundInit(Pane root) {
        Line line1 = new Line(300,0,300,60);
        line1.setStrokeWidth(20);
        Line line2 = new Line(300,120,300,180);
        line2.setStrokeWidth(20);
        Line line3 = new Line(300,240,300,300);
        line3.setStrokeWidth(20);
        Line line4 = new Line(300,360,300,420);
        line4.setStrokeWidth(20);
        Line line5 = new Line(300,480,300,540);
        line5.setStrokeWidth(20);
        root.getChildren().addAll(line1,line2,line3,line4,line5);
        //////////////////////////////////////////////////////////////////////
        Rectangle enemyZone = new Rectangle(15,15,100,570);
        enemyZone.setFill(Color.GRAY);
        enemyZone.setArcWidth(20);
        enemyZone.setArcHeight(20);
        //////////////////////////////////////////////////////////////////////
        Rectangle materialZone1 = new Rectangle(485,15,100,150);
        materialZone1.setArcWidth(20);
        materialZone1.setArcHeight(20);
        materialZone1.setFill(Color.ORANGE);
        Rectangle materialZone2 = new Rectangle(485,440,100,150);
        materialZone2.setArcWidth(20);
        materialZone2.setArcHeight(20);
        materialZone2.setFill(Color.ORANGE);
        //////////////////////////////////////////////////////////////////////
        root.getChildren().addAll(enemyZone,materialZone1,materialZone2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
