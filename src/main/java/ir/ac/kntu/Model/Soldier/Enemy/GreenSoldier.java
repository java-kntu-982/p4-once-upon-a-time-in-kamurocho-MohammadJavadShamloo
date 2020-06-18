package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GreenSoldier extends Soldier {
    public GreenSoldier() {
        super("Green Soldier", 1500, 700, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.GREEN);
        super.setShape(circle);
    }
}
