package ir.ac.kntu.Model.Soldier.TeamMate;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class JiroKawara extends Soldier {
    public JiroKawara() {
        super("Jiro Kawara", 5500, 3200, 3, 3);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.BLUE);
        super.setShape(circle);
    }
}
