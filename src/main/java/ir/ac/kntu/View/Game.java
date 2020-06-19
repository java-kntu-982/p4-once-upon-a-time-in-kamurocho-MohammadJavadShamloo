package ir.ac.kntu.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage){
        Pane root = new Pane();
        Scene scene = new Scene(root,1200,800);
        Rectangle enemyZone = new Rectangle(15,15,200,770);
        enemyZone.setArcHeight(20);
        enemyZone.setArcWidth(20);
        enemyZone.setFill(Color.GRAY);
        Rectangle material1 = new Rectangle(985,15,200,250);
        material1.setFill(Color.ORANGE);
        material1.setArcHeight(20);
        material1.setArcWidth(20);
        Rectangle material2 = new Rectangle(985,535,200,250);
        material2.setFill(Color.ORANGE);
        material2.setArcHeight(20);
        material2.setArcWidth(20);
        Line line = new Line(600,0,600,100);
        line.setStrokeWidth(20);
        Line line1 = new Line(600,160,600,260);
        line1.setStrokeWidth(20);
        Line line2 = new Line(600,320,600,420);
        line2.setStrokeWidth(20);
        Line line3 = new Line(600,480,600,580);
        line3.setStrokeWidth(20);
        Line line4 = new Line(600,640,600,740);
        line4.setStrokeWidth(20);
        root.getChildren().addAll(enemyZone,material1,material2,line,line1,line2,line3,line4);
        Circle circle = new Circle(600,400,40);
        circle.setFill(Color.BLUE);
        circle.addEventFilter(MouseEvent.MOUSE_MOVED,mouseEvent -> {
            circle.setCenterX(mouseEvent.getX());
            circle.setCenterY(mouseEvent.getY());
        });
        root.getChildren().add(circle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
