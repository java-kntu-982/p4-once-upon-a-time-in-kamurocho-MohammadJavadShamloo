package ir.ac.kntu.Model.Material;

import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.Objects;

public class Material implements MaterialSupplies {
    protected String name;
    protected double health;
    protected int level;
    protected Spot spot;
    protected Shape shape;

    public Material(String name, double health) {
        this.name = name;
        this.health = health;
        this.spot = new Spot(0,0);
        this.shape = null;
        this.level = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return Double.compare(material.getHealth(), getHealth()) == 0 &&
                getLevel() == material.getLevel() &&
                Objects.equals(getName(), material.getName()) &&
                Objects.equals(getSpot(), material.getSpot()) &&
                Objects.equals(getShape(), material.getShape());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth(), getLevel(), getSpot(), getShape());
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", level=" + level +
                ", spot=" + spot +
                ", shape=" + shape +
                '}';
    }

    @Override
    public void levelUp() {
        setHealth(getHealth() * 1.5);
        setLevel(getLevel() + 1);
    }
}
