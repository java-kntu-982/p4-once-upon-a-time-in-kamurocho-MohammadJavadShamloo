package ir.ac.kntu.Model.Soldier.TeamMate;

import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TetsuTachibana extends Soldier {
    public TetsuTachibana() {
        super("Tetsu Tachibana", 5600, 4000, 1, 2);
        Circle circle = new Circle(getSpot().getX(),getSpot().getY(),5);
        circle.setFill(Color.BLUE);
        super.setShape(circle);
    }
}
