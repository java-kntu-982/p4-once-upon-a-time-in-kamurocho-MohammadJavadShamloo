package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class YellowSoldier extends Soldier {
    public YellowSoldier() {
        super("Yellow Soldier", 800, 1800, 2, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.YELLOW);
        super.setShape(circle);
    }
}
