package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraySoldier extends Soldier {
    public GraySoldier() {
        super("Gray Soldier", 1000, 800, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.GRAY);
        super.setShape(circle);
    }
}
