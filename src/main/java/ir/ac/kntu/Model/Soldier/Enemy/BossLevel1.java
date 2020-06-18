package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLevel1 extends Soldier {
    public BossLevel1() {
        super("Yellow Soldier", 8000, 5000, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.RED);
        super.setShape(circle);
    }
}
