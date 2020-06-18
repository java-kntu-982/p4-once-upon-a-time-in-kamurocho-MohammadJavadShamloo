package ir.ac.kntu.Model.Material.BuildingMaterials;

import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Circle;

public class Container extends Material {
    public Container() {
        super("Container", 3000);
        super.setSpot(new Spot(535,90));
        super.setShape(new Circle(535,90,40));
    }
}
