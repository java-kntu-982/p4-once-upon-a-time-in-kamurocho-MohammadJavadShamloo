package ir.ac.kntu.Model.Soldier.TeamMate;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class KaoruSayama extends Soldier {
    public KaoruSayama() {
        super("Kaoru Sayama", 4500, 4500, 4, 2);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.BLUE);
        super.setShape(circle);
    }
}
