package ir.ac.kntu.Model.Material.BuildingMaterials;

import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Circle;

public class SteelFramework extends Material {
    public SteelFramework() {
        super("Steel Framework", 8500);
        super.setSpot(new Spot(535,90));
        super.setShape(new Circle(535,90,40));
    }
}
