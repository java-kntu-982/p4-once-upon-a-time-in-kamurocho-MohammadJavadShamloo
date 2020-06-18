package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RedSoldier  extends Soldier {
    public RedSoldier() {
        super("Red Soldier", 1000, 500, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.RED);
        super.setShape(circle);
    }
}
