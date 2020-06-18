package ir.ac.kntu.Model.Soldier.Enemy;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GoldSoldier extends Soldier {
    public GoldSoldier() {
        super("Gold Soldier", 800, 2000, 5, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.GOLD);
        super.setShape(circle);
    }
}
