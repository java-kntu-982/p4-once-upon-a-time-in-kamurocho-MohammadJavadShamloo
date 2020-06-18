package ir.ac.kntu.Model.Soldier.TeamMate;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TaigaSaejima extends Soldier {
    public TaigaSaejima() {
        super("Taiga Saejima", 7000, 5000, 1, 1);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.BLUE);
        super.setShape(circle);
    }
}
