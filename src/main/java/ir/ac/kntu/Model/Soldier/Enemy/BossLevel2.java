package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLevel2 extends Soldier {
    public BossLevel2() {
        super("Boss Level 2", 12000, 20000, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.RED);
        super.setShape(circle);
    }
}
