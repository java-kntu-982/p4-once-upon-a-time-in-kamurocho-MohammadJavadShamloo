package ir.ac.kntu.Model.Material.BuildingMaterials;

import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Circle;

public class Van extends Material {
    public Van() {
        super("Van", 6000);
        super.setSpot(new Spot(535,515));
        super.setShape(new Circle(535,515,40));
    }
}
