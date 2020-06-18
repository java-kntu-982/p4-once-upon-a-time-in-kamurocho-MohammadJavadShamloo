package ir.ac.kntu.Model.Soldier.TeamMate;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RyoTakashima extends Soldier {
    public RyoTakashima() {
        super("Ryo Takashima", 3600, 3800, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.BLUE);
        super.setShape(circle);
    }
}
