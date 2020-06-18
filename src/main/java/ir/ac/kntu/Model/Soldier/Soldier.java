package ir.ac.kntu.Model.Soldier;

import ir.ac.kntu.Model.Spot.Spot;
import javafx.scene.shape.Shape;

import java.util.LinkedList;
import java.util.Objects;

public class Soldier implements Update{
    private String name;
    private double health;
    private double attack;
    private double attackRange;
    private double fieldOfView;
    private Spot spot;
    private double velocity;
    private Shape shape;
    private int level;
    private LinkedList<Spot> path;

    public Soldier(String name, double health, double attack, double attackRange, double fieldOfView) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.attackRange = attackRange;
        this.fieldOfView = fieldOfView;
        this.spot = new Spot(0,0);
        this.velocity = 1;
        this.shape = null;
        this.level = 0;
    }

    public LinkedList<Spot> getPath() {
        return path;
    }

    public void setPath(LinkedList<Spot> path) {
        this.path = path;
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

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    public double getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(double fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Soldier)) {
            return false;
        }
        Soldier soldier = (Soldier) o;
        return Double.compare(soldier.getHealth(), getHealth()) == 0 &&
                Double.compare(soldier.getAttack(), getAttack()) == 0 &&
                Double.compare(soldier.getAttackRange(), getAttackRange()) == 0 &&
                Double.compare(soldier.getFieldOfView(), getFieldOfView()) == 0 &&
                Double.compare(soldier.getVelocity(), getVelocity()) == 0 &&
                Objects.equals(getName(), soldier.getName()) &&
                Objects.equals(getSpot(), soldier.getSpot()) &&
                Objects.equals(getShape(), soldier.getShape());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth(), getAttack(), getAttackRange(), getFieldOfView(), getSpot(), getVelocity(), getShape());
    }

    @Override
    public String toString() {
        return  "Name = " + name +
                "|| Health = " + health +
                "|| Attack = " + attack +
                "|| Attack Range = " + attackRange +
                "|| Field Of View = " + fieldOfView + '\n';
    }

    @Override
    public void updatePath() {
        if(path.size() > 0){
            setSpot(path.getLast());
            shape.setLayoutX(path.getLast().getX());
            shape.setLayoutY(path.getLast().getY());
            path.removeLast();
        }
    }

    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getHealth() * 1.1);
        setAttack(getAttack() * 1.1);
        setAttackRange(getAttackRange() * 1.1);
        setFieldOfView(getFieldOfView() * 1.1);
    }
}
