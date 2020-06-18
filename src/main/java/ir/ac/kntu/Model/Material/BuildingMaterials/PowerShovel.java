package ir.ac.kntu.Model.Material.BuildingMaterials;

import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Circle;

public class PowerShovel extends Material {
    public PowerShovel() {
        super("Power Shovel", 11000);
        super.setSpot(new Spot(535,90));
        super.setShape(new Circle(535,90,40));
    }
}
